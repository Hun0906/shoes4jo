package com.multi.shoes4jo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

public interface MemberController {

	public ModelAndView insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView loginMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ResponseEntity<?> duplicationId(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
