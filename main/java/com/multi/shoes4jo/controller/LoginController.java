
package com.multi.shoes4jo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multi.shoes4jo.service.MemberService;
import com.multi.shoes4jo.vo.MemberVO;

@Controller

@RequestMapping("/controller")
public class LoginController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public String login(MemberVO vo, Model model, HttpServletRequest request) {
		String memberID = request.getParameter("member_id");
		String memberPW = request.getParameter("member_pw");

		vo.setmember_id(memberID);
		vo.setmember_pw(memberPW);
		Integer loginRes = memberService.loginMember(vo);

		if (loginRes == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("member_id", memberID);

			System.out.println(memberID + " 로그인 성공");

			model.addAttribute("res", loginRes);
			return "redirect:/login";
		} else {
			model.addAttribute("res", loginRes);
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.invalidate();
		model.addAttribute("res", 109);
		return "redirect:/login";
	}
}
