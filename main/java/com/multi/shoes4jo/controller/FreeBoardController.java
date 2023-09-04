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
		return new ModelAndView("freeboard/freeboard_view", "vo", vo);
	}

	@RequestMapping(value = "/CommentView.do")
	public ModelAndView CommentView(@RequestParam int fno) {
		List<CommentVO> commentList = service.selectComment(fno);
		int commentCount = commentList.size();
		ModelAndView mav = new ModelAndView("freeboard/freeboard_view");
		mav.addObject("commentCount", commentCount);
		return mav;
	}
	// 글에 달린 댓글 수

	@RequestMapping(value = "/MyCommentView.do")
	public String myComment(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("memberInfo");

		List<CommentVO> comments = service.selectByIdComment(member_id);
		model.addAttribute("comments", comments);
		return "member/my_comment_list";
	}

	@RequestMapping(value = "/MyBoardView.do")
	public String myBoard(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("memberInfo");

		List<FreeBoardVO> boards = service.FreeListById(member_id);
		model.addAttribute("boards", boards);

		return "member/my_board_list";
	}

	@RequestMapping(value = "/write.do")
	public String write() {
		return "freeboard/freeboard_write";
	}

	@RequestMapping("/writeOk.do")
	public String writeOk(@ModelAttribute FreeBoardVO vo,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session) throws Exception {

		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			String newFileName = System.currentTimeMillis() + "." + extension;

			vo.setFile_name(originalFilename);
			vo.setFile_path(newFileName);

			String realPath = session.getServletContext().getRealPath("assets/img/");
			System.out.println("파일 저장 성공: " + realPath);

			File newFile = new File(realPath, newFileName);

			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
		}

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

		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			String newFileName = System.currentTimeMillis() + "." + extension;

			vo.setFile_name(originalFilename);
			vo.setFile_path(newFileName);

			FreeBoardVO oldBoardData = service.select(vo.getFno());

			if (oldBoardData != null && oldBoardData.getFile_path() != null) {
				File oldFile = new File(session.getServletContext().getRealPath("assets/img/"),
						oldBoardData.getFile_path());
				if (oldFile.exists()) {
					oldFile.delete();
				}
			}

			String realPath = session.getServletContext().getRealPath("assets/img/");
			System.out.println("파일 저장 성공: " + realPath);

			File newFile = new File(realPath, newFileName);

			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			FreeBoardVO oldBoardData = service.select(vo.getFno());

			if (oldBoardData != null) {

				vo.setFile_name(oldBoardData.getFile_name());
				vo.setFile_path(oldBoardData.getFile_path());
			}
		}

		service.update(vo);

		return "redirect:/freeboard/list.do";
	}

	@RequestMapping("/delete.do")
	public String deleteOk(@RequestParam int fno) {
		service.delete(fno);
		return "redirect:/freeboard/list.do";
	}

	@RequestMapping("/writeComment.do")
	public String writeComment(CommentVO comment) {
		int result = service.insertComment(comment);

		if (result > 0) {
			return "redirect:/freeboard/view.do?fno=" + comment.getFno();
		} else {
			return "freeboard/freeboard_list";
		}
	}

	@RequestMapping("/deleteComment.do")
	public String deleteReply(@RequestParam int cno, @RequestParam int fno) {
		int result = service.deleteComment(cno);

		if (result > 0) {
			return "redirect:/freeboard/view.do?fno=" + fno;
		} else {
			return "freeboard/freeboard_list";
		}
	}
}
