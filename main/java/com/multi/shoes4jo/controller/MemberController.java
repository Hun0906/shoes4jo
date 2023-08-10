package com.multi.shoes4jo.controller;
<<<<<<< HEAD
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
=======

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
import org.springframework.web.servlet.ModelAndView;

public interface MemberController {

<<<<<<< HEAD
    public ModelAndView insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception; 
    
    public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ResponseEntity<?> duplicationId(HttpServletRequest request, HttpServletResponse response) throws Exception;

}

=======
	public ModelAndView insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView loginMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
