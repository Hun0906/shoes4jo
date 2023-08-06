package com.multi.shoes4jo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.service.MemberService;
import com.multi.shoes4jo.vo.MemberVO;

@Controller
public class MemberControllerImpl implements MemberController {

	@Autowired
	private MemberService memberService;

	@Override
	@RequestMapping(value = "/insertMember")
	public ModelAndView insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();

		String member_id = request.getParameter("member_id");
		String member_name = request.getParameter("member_name");
		String member_pw = request.getParameter("member_pw");
		String signup_date = request.getParameter("signup_date");
		String member_email = request.getParameter("member_email");
		String member_phone = request.getParameter("member_phone");

		memberVO.setmember_id(member_id);
		memberVO.setmember_name(member_name);
		memberVO.setmember_pw(member_pw);
		memberVO.setsignup_date(signup_date);
		memberVO.setmember_email(member_email);
		memberVO.setmember_phone(member_phone);

		int result = memberService.insertMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/signup");
		return mav;
	}

	@Override
	@RequestMapping(value = "/loginMember")
	public ModelAndView loginMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();

		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");

		memberVO.setmember_id(member_id);
		memberVO.setmember_pw(member_pw);

		int result = memberService.loginMember(memberVO);
		ModelAndView mav;

		if (result == 1) {
		    HttpSession session = request.getSession();
		    MemberVO memberInfo = memberService.memberInfo(member_id);
		    session.setAttribute("memberInfo", memberInfo);
		    mav = new ModelAndView("redirect:/main");
		} else {
		    mav = new ModelAndView("redirect:/login");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/controller/memberInfo")
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("member_id");

		MemberVO memberInfo = memberService.memberInfo(member_id);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/my_page");
		mav.addObject("memberInfo", memberInfo);

		return mav;
	}

	 @Override
	    @RequestMapping(value = "/controller/my_edit")
	    public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        MemberVO member = new MemberVO();

	        String member_id = request.getParameter("member_id");
	        String member_name = request.getParameter("member_name");
	        String member_pw = request.getParameter("member_pw");
	        String member_email = request.getParameter("member_email");
	        String member_phone = request.getParameter("member_phone");

	        member.setmember_id(member_id);
	        member.setmember_name(member_name);
	        member.setmember_pw(member_pw);
	        member.setmember_email(member_email);
	        member.setmember_phone(member_phone);

	        memberService.updateMember(member);

	        HttpSession session = request.getSession();
	        session.invalidate();

	        return new ModelAndView("redirect:/my_edit");
	    }
	 
	 
	@Override
	@RequestMapping(value = "/controller/member_delete")
	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		String member_id = request.getParameter("member_id");

		int result = memberService.deleteMember(member_id);

		ModelAndView mav = new ModelAndView();
		if (result > 0) {
		    HttpSession session = request.getSession();
		    session.invalidate();
		    mav.setViewName("redirect:/login");
		} else {
		    mav.setViewName("member/member_delete");
		}
		return mav;
	}
}
