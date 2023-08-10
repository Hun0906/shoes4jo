package com.multi.shoes4jo.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.service.MemberService;
import com.multi.shoes4jo.vo.MemberVO;

@Controller
public class MemberControllerImpl implements MemberController {

	@Autowired
	private MemberService memberService;

	@Override
	@RequestMapping(value = "/insertMember", method = { RequestMethod.POST, RequestMethod.GET })
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
	@RequestMapping(value = "/controller/login", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String memberID = request.getParameter("member_id");
		String memberPW = request.getParameter("member_pw");

		System.out.printf("member_id: %s, member_pw: %s\n", memberID, memberPW);

		MemberVO member = new MemberVO();
		member.setmember_id(memberID);
		member.setmember_pw(memberPW);
		Integer loginRes = memberService.loginMember(member);

		ModelAndView mav = new ModelAndView();
		if (loginRes == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("memberInfo", memberID);

			System.out.println(memberID + " 로그인 성공");

			mav.setViewName("redirect:/login"); // alert를 띄우기 위해 main이 아니라 login으로 보내게 되어 있습니다.
			mav.addObject("res", 1); // 성공 코드
		} else if (loginRes == 0) {
			mav.setViewName("redirect:/login");
			mav.addObject("res", 0); // 비밀번호 오류 코드
		} else {
			mav.setViewName("redirect:/login");
			mav.addObject("res", -1); // 없는 아이디 코드
		}
		return mav;
	}

	@RequestMapping(value = "/controller/logout", method = { RequestMethod.POST, RequestMethod.GET })
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.invalidate();
		model.addAttribute("res", 109);
		return "redirect:/login";
	}

	@Override
	@RequestMapping(value = "/controller/memberInfo", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("memberInfo");

		MemberVO memberInfo = memberService.memberInfo(member_id);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/my_page");
		mav.addObject("memberInfo", memberInfo);

		return mav;
	}

	
	@Override
	@RequestMapping(value = "/controller/my_edit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String member_name = request.getParameter("member_name");
		String member_id = (String) session.getAttribute("memberInfo");
	    String member_pw = request.getParameter("member_pw");
	    String member_email = request.getParameter("member_email");
	    String member_phone = request.getParameter("member_phone");
	    
	    MemberVO updatedMember = new MemberVO();
	    updatedMember.setmember_name(member_name);
	    updatedMember.setmember_id(member_id);
	    updatedMember.setmember_pw(member_pw);
	    updatedMember.setmember_email(member_email);
	    updatedMember.setmember_phone(member_phone);
	    
	    memberService.updateMember(updatedMember);
	    
		MemberVO updatedMemberInfo = memberService.memberInfo(member_id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/my_edit");
		mav.addObject("memberInfo",updatedMemberInfo);
		mav.addObject("updateSucess", true);
		
		return mav;
	}

	@Override
	@ResponseBody
	@RequestMapping(value = "/controller/member_delete", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		String member_id = request.getParameter("member_id");

		int result = memberService.deleteMember(member_id);

		ModelAndView mav = new ModelAndView();
		if (result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("memberInfo", member_id);
			mav.setViewName("redirect:/login");
		} else {
			mav.setViewName("member/member_delete");
		}
		return mav;
	}

	@Override
	@RequestMapping("/duplicationId")
	@ResponseBody
	public ResponseEntity duplicationId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
		String id = request.getParameter("member_id");
		memberVO.setmember_id(id);
		int cnt = memberService.duplicationId(id);
		ResponseEntity resEntity = null;
		resEntity = new ResponseEntity(cnt, HttpStatus.OK);
		return resEntity;
	}
}
