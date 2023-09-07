package com.multi.shoes4jo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.service.freeboard.FreeBoardService;
import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.util.PageMaker;
import com.multi.shoes4jo.vo.CommentVO;
import com.multi.shoes4jo.vo.FreeBoardVO;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {

	@Autowired
	FreeBoardService service;

	@RequestMapping(value = "/list.do")
	public String list(Model model, Criteria cri) throws Exception {
		List<FreeBoardVO> list = service.listPage(cri);
		model.addAttribute("list", list);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());

		model.addAttribute("pageMaker", pageMaker);

		return "freeboard/freeboard_list";
	}

	@RequestMapping(value = "/category.do")
	public String category(@RequestParam("category") String category, Model model) {
		List<FreeBoardVO> list = service.selectCat(category);
		model.addAttribute("list", list);
		model.addAttribute("selectedCategory", category);
		return "freeboard/freeboard_list";
	}

	@RequestMapping(value = "/view.do")
	public ModelAndView view(@RequestParam int fno) {
		service.updateviewcnt(fno);
		FreeBoardVO vo = service.select(fno);
		List<CommentVO> commentList = service.selectComment(fno); // 댓글 목록 가져오기
		ModelAndView mav = new ModelAndView("freeboard/freeboard_view");
		mav.addObject("freeboard", vo);
		mav.addObject("commentList", commentList); // 모델에 댓글 목록 추가
		return mav;
	}

	@RequestMapping(value = "/CommentView.do")
	public ModelAndView CommentView(@RequestParam int fno) {
		List<CommentVO> commentList = service.selectComment(fno);
		int commentCount = commentList.size();
		ModelAndView mav = new ModelAndView("freeboard/freeboard_view");
		mav.addObject("commentCount", commentCount);
		return mav;
	}

	@RequestMapping(value = "/MyCommentView.do")
	public String myComment(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("memberInfo");

		List<CommentVO> commentList = service.selectByIdComment(member_id);
		model.addAttribute("commentList", commentList);
		return "member/my_comment_list";
	}

	@RequestMapping(value = "/MyBoardView.do")
	public String myBoard(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("memberInfo");

		List<FreeBoardVO> freeboardList = service.FreeListById(member_id);
		model.addAttribute("freeboardList", freeboardList);

		return "member/my_board_list";
	}

	@RequestMapping(value = "/write.do")
	public String write(HttpSession session) {
		String member_id = (String) session.getAttribute("memberInfo");
		if (member_id == null) {
			return "redirect:/login"; // 로그인 안하면 글 못쓰게 하고 로그인 페이지로 보내기
		}
		return "freeboard/freeboard_write";
	}

	@RequestMapping("/writeOk.do")
	public String writeOk(@ModelAttribute FreeBoardVO vo,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session) throws Exception {
		String member_id = (String) session.getAttribute("memberInfo");
		if (member_id == null || !member_id.equals(vo.getMember_id())) {
			return "redirect:/freeborad/list.do";
		}

		handleFile(vo, file, session);
		service.insert(vo);

		return "redirect:/freeboard/list.do";
	}

	@RequestMapping("/update.do")
	public ModelAndView update(@RequestParam int fno) {
		FreeBoardVO vo = service.select(fno);
		return new ModelAndView("freeboard/freeboard_update", "vo", vo);
	}

	@RequestMapping("/updateOk.do")
	public String updateOk(@ModelAttribute FreeBoardVO vo,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session) throws Exception {
		String member_id = (String) session.getAttribute("memberInfo");

		FreeBoardVO originalPost = service.select(vo.getFno());
		if (!originalPost.getMember_id().equals(member_id)) {
			return "redirect:/freeborad/list.do";
		}

		handleFile(vo, file, session);

		service.update(vo);

		return "redirect:/freeboard/list.do";
	}

	private void handleFile(FreeBoardVO vo, MultipartFile file, HttpSession session) throws IOException {
		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			String newFileName = System.currentTimeMillis() + "." + extension;

			vo.setFile_name(originalFilename);
			vo.setFile_path(newFileName);

			File newFile = new File(session.getServletContext().getRealPath("assets/img/"), newFileName);

			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
		}
	}

	@RequestMapping("/delete.do")
	public String deleteOk(@RequestParam int fno, HttpSession session) {

		String member_id = (String) session.getAttribute("memberInfo");

		FreeBoardVO vo = service.select(fno);

		if (!vo.getMember_id().equals(member_id)) {

			return "redirect:/freeboard/list.do";

		}

		service.delete(fno);

		return "redirect:/freeboard/list.do";

	}

	@RequestMapping("/writeComment.do")
	public String writeComment(CommentVO comment, HttpSession session) {

		String member_id = (String) session.getAttribute("memberInfo");
		if (member_id == null || !member_id.equals(comment.getMember_id())) {
			return "redirect:/freeboard/list.do";
		}

		System.out.println(comment);
		int result = service.insertComment(comment);

		System.out.println("insertComment result: " + result);

		if (result > 0) {
			return "redirect:/freeboard/view.do?fno=" + comment.getFno();
		} else {
			return "freeboard/freeboard_list";
		}
	}

	@RequestMapping("/deleteComment.do")
	public String deleteReply(@RequestParam int cno, @RequestParam int fno, HttpSession session) {

		CommentVO vo = (CommentVO) service.selectComment(cno);
		String member_id = (String) session.getAttribute("memberInfo");

		if (!vo.getMember_id().equals(member_id)) {
			return "redirect:/freeboard/list.do";
		}

		int result = service.deleteComment(cno);

		if (result > 0) {
			return "redirect:/freeboard/view.do?fno=" + fno;
		} else {
			return "redirect:/freeboard/list.do";
		}
	}
}