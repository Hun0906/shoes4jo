package com.multi.shoes4jo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multi.shoes4jo.dao.LoginDAO;
import com.multi.shoes4jo.vo.MemberVO;

@Controller
@RequestMapping("/controller")
public class LoginController {
    
    private final LoginDAO dao;

    @Autowired
    public LoginController(LoginDAO dao) {
        this.dao = dao;
    }

	@RequestMapping(value = "/login", method = { RequestMethod.POST } )
	public String login(MemberVO vo, Model model, HttpServletRequest request) {
		String MemberID = request.getParameter("MEMBER_ID");
		String MemberPW = request.getParameter("MEMBER_PW");

        Integer loginRes = dao.login(MemberID,MemberPW);

        if (loginRes == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("MemberID", MemberID);
            
            System.out.println(MemberID + " 계정 로그인 성공");

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
