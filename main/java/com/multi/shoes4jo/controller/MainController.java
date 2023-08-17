package com.multi.shoes4jo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "index");
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		logger.info("main() called");
		return "main";
	}

	@RequestMapping(value = "/naver_keyword_trend", method = { RequestMethod.GET, RequestMethod.POST })
	public String naver_keyword_trend() {
		logger.info("naver_keyword_trend() called");
		return "trend/naver_keyword_trend";
	}
	
	@RequestMapping(value = "/google_trend", method = { RequestMethod.GET, RequestMethod.POST })
	public String google_trend() {
		logger.info("google_trend() called");
		return "trend/google_trend";
	}

	@RequestMapping(value = "/signup", method = { RequestMethod.GET, RequestMethod.POST })
	public String signup() {
		logger.info("signup() called");
		return "member/signup";
	}	
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		logger.info("about() called");
		
		return "common/about";
	}
	

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login() {
		logger.info("login() called");
		return "member/login";
	}
	
	@RequestMapping(value = "/my_edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String my_edit() {
		logger.info("my_edit() called");

		return "member/my_edit";
	}


	@RequestMapping(value = "/acknowledgement", method = RequestMethod.GET)
	public String acknowledgement() {
		logger.info("acknowledgement() called");
		
		return "common/acknowledgement";
	}

	
	@RequestMapping(value = "/coupang_dummy", method = RequestMethod.GET)
	public String coupang_dummy() {
		logger.info("coupang_dummy() called");
		
		return "test/coupang_dummy";
	}
	
	
}