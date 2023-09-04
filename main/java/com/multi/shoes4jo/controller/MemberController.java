package com.multi.shoes4jo.controller;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface MemberController {

    public ModelAndView insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception; 
    
    public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public String deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ResponseEntity<?> duplicationId(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    public String search_id(HttpServletRequest request, Model model) throws Exception;

    public String result_id(HttpServletRequest request, Model model,
      @RequestParam(required = true, value = "member_name") String member_name,
      @RequestParam(required = true, value = "member_phone") String member_phone) throws Exception;
    
    public String search_pw(HttpServletRequest request, Model model) throws Exception;
    
    public String showMember(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception;
 
}

