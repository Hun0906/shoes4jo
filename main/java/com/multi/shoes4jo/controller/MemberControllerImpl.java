package com.multi.shoes4jo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.service.MemberService;
import com.multi.shoes4jo.vo.MemberVO;

@Controller
public class MemberControllerImpl implements MemberController {

	@Autowired
	private MemberService memberService;
	private MemberVO member_id;

  
  @Override
  @PostMapping("/insertMember") public ModelAndView
  insertMember(HttpServletRequest request, HttpServletResponse response) throws
  Exception { request.setCharacterEncoding("utf-8"); MemberVO memberVO = new
  MemberVO();
  
  String id = request.getParameter("member_id"); String name =
  request.getParameter("member_name"); String pw =
  request.getParameter("member_pw"); String signup =
  request.getParameter("signup_date");
  
  memberVO.setmember_id(id); memberVO.setmember_name(name);
  memberVO.setmember_pw(pw); memberVO.setsignup_date(signup);
  
  int result = memberService.insertMember(memberVO); ModelAndView mav = new
  ModelAndView("redirect:/signup"); return mav; }

  
  
  @Override
  @PostMapping("/loginMember")
  public ModelAndView loginMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
      request.setCharacterEncoding("utf-8");
      MemberVO memberVO = new MemberVO();

      String id = request.getParameter("member_id");
      String pw = request.getParameter("member_pw");

      memberVO.setmember_id(id);
      memberVO.setmember_pw(pw);

      int result = memberService.loginMember(memberVO);
      ModelAndView mav;

      if (result == 1) {
          mav = new ModelAndView("redirect:/main");
      } else {
          mav = new ModelAndView("redirect:/login");
      }

      return mav;
  }

	@Override
	@PostMapping("/memberInfo")
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("member_id");
		memberService.memberInfo(member_id);
		ModelAndView mav = new ModelAndView("redirect:/my_page");
		return mav;
	}


  
	@Override
	@PostMapping("/updateMember")
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();

		String name = request.getParameter("member_name");
		String pw = request.getParameter("member_pw");

		memberVO.setmember_name(name);
		memberVO.setmember_pw(pw);

		int result = memberService.updateMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/my_edit");
		return mav;
	}

	@Override
	@PostMapping("/deleteMember")
	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("member_id");
		memberService.deleteMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member_delete");
		return mav;
	}

}