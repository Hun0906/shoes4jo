package com.multi.shoes4jo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.multi.shoes4jo.util.FileUtil;
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

	@RequestMapping(value = "/myBoardList.do")
	public String myBoard(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("memberInfo");

		List<FreeBoardVO> freeboardList = service.myBoardList(member_id);
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

		FileUtil.FileUpload(vo, file, session);
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
		FreeBoardVO vo = service.select(fno);
		request.setAttribute("freeboard", vo);
		return "freeboard/freeboard_update";
	}

	@RequestMapping("/updateOk.do")
	public String updateOk(@ModelAttribute FreeBoardVO vo,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session,
			HttpServletRequest request) throws Exception {

		FileUtil.FileUpload(vo, file, session);
		service.update(vo);

		request.setAttribute("msg", "글 수정에 성공하였습니다.");
		request.setAttribute("url", "/freeboard/list.do");

		return "msg";
	}

	@RequestMapping("/delete.do")
	public String deleteOk(@RequestParam int fno) {
		service.delete(fno);
		return "redirect:/freeboard/list.do";
	}

}