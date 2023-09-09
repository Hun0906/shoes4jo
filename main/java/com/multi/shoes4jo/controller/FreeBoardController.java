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

	private void handleFile(FreeBoardVO vo, MultipartFile file, HttpSession session) throws IOException {
		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			String newFileName = System.currentTimeMillis() + "." + extension;

			vo.setFile_name(originalFilename);
			vo.setFile_path(newFileName);

			File newFile = new File(session.getServletContext().getRealPath("assets/img/"), newFileName);

			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);

			System.out.println("파일 저장 성공: " + newFile.getAbsolutePath());

		}
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
	public String write(HttpSession session, HttpServletRequest request) {
		String member_id = (String) session.getAttribute("memberInfo");
		if (member_id == null) {
			request.setAttribute("msg", "로그인이 필요한 기능입니다.");
			request.setAttribute("url", "/login");
			return "msg";
		}
		return "freeboard/freeboard_write";
	}

	@RequestMapping("/writeOk.do")
	public String writeOk(@ModelAttribute FreeBoardVO vo,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session,
			HttpServletRequest request) throws Exception {

		String member_id = (String) session.getAttribute("memberInfo");
		if (member_id == null || !member_id.equals(vo.getMember_id())) {
			request.setAttribute("msg", "로그인이 필요한 기능입니다.");
			request.setAttribute("url", "/freeboard/list.do");
			return "msg";
		}

		handleFile(vo, file, session);
		service.insert(vo);

		request.setAttribute("msg", "새 글 등록에 성공하였습니다.");
		request.setAttribute("url", "/freeboard/list.do");

		return "msg";
	}

	@RequestMapping(value = "/view.do")
	public ModelAndView view(@RequestParam int fno) {
		service.updateviewcnt(fno);
		FreeBoardVO vo = service.select(fno);
		ModelAndView mav = new ModelAndView("freeboard/freeboard_view");
		mav.addObject("freeboard", vo);
		return mav;
	}

	@RequestMapping("/update.do")
	public String update(@RequestParam int fno, HttpSession session, HttpServletRequest request) {
		String member_id = (String) session.getAttribute("memberInfo");
		if (member_id == null) {
			request.setAttribute("msg", "로그인이 필요한 기능입니다.");
			request.setAttribute("url", "/login");
			return "msg";
		}

		FreeBoardVO vo = service.select(fno);

		if (!vo.getMember_id().equals(member_id)) {
			request.setAttribute("msg", "작성자만 글 수정이 가능합니다.");
			request.setAttribute("url", "/freeboard/list.do");
			return "msg";
		}

		request.setAttribute("freeboard", vo);

		return "freeboard/freeboard_update";
	}

	@RequestMapping("/updateOk.do")
	public String updateOk(@ModelAttribute FreeBoardVO vo,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session,
			HttpServletRequest request) throws Exception {

		String member_id = (String) session.getAttribute("memberInfo");

		FreeBoardVO originalPost = service.select(vo.getFno());
		if (!originalPost.getMember_id().equals(member_id)) {
			request.setAttribute("msg", "작성자만 글 수정이 가능합니다.");
			request.setAttribute("url", "/freeboard/list.do");
			return "msg";
		}

		handleFile(vo, file, session);

		service.update(vo);

		request.setAttribute("msg", "글 수정에 성공하였습니다.");
		request.setAttribute("url", "/freeboard/list.do");

		return "msg";
	}

	@RequestMapping("/delete.do")
	public String deleteOk(@RequestParam int fno, HttpSession session, HttpServletRequest request) {
		String member_id = (String) session.getAttribute("memberInfo");
		FreeBoardVO vo = service.select(fno);

		if (!vo.getMember_id().equals(member_id)) {
			request.setAttribute("msg", "글 작성자만 삭제가 가능합니다.");
			request.setAttribute("url", "/freeboard/list.do");
			return "msg";
		}

		service.delete(fno);

		request.setAttribute("msg", "글 삭제에 성공하였습니다.");
		request.setAttribute("url", "/freeboard/list.do");

		return "redirect:/freeboard/list.do";
	}

}