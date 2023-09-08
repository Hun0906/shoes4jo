package com.multi.shoes4jo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.service.comment.CommentService;
import com.multi.shoes4jo.vo.CommentVO;

@Controller
@RequestMapping("/CoCon")
public class CommentController {

	@Autowired
	CommentService service;

	@RequestMapping(value = "/viewCo.do")
	public ModelAndView viewCo(@RequestParam int fno) {
		List<CommentVO> commentList = service.selectCo(fno);
		int commentCount = commentList.size();
		ModelAndView mav = new ModelAndView("freeboard/freeboard_view");
		mav.addObject("commentCount", commentCount);
		return mav;
	}

	@RequestMapping(value = "/MyCommentView.do")
	public String MyCommentView(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("memberInfo");

		List<CommentVO> vo = service.selectByIdCo(member_id);
		model.addAttribute("commentList", vo);
		return "member/my_comment_list";
	}

	@RequestMapping("/insertCo.do")
	public String insertCo(CommentVO vo, HttpSession session) {

		String member_id = (String) session.getAttribute("memberInfo");
		if (member_id == null || !member_id.equals(vo.getMember_id())) {
			return "redirect:/freeboard/list.do";
		}

		System.out.println(vo);
		int result = service.insertCo(vo);

		System.out.println("insertComment result: " + result);
		return member_id;
	}

	@RequestMapping("/deleteCo.do")
	public String deleteCo(@RequestParam int cno, @RequestParam int fno, HttpSession session) {

		CommentVO vo = (CommentVO) service.selectCo(cno);
		String member_id = (String) session.getAttribute("memberInfo");

		if (!vo.getMember_id().equals(member_id)) {
			return "redirect:/freeboard/list.do";
		}

		int result = service.deleteCo(cno);

		if (result > 0) {
			return "redirect:/freeboard/view.do?fno=" + fno;
		} else {
			return "redirect:/freeboard/list.do";
		}
	}
}