package com.multi.shoes4jo;

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

	@RequestMapping(value = "/", method = RequestMethod.GET)
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

	@RequestMapping(value = "/keyword_trend", method = { RequestMethod.GET, RequestMethod.POST })
	public String keyword_trend() {
		logger.info("keyword_trend() called");
		return "trend/keyword_trend";
	}
	
	@RequestMapping(value = "/keyword_trend2", method = { RequestMethod.GET, RequestMethod.POST })
	public String keyword_trend2() {
		logger.info("keyword_trend2() called");
		return "trend/keyword_trend2";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		logger.info("signup() called");
		return "member/signup";
	}	
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		logger.info("about() called");
		
		return "common/about";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("login() called");
		return "member/login";
	}

	@RequestMapping(value = "/my_page", method = RequestMethod.GET)
	public String my_page() {
		logger.info("my_page() called");

		return "member/my_page";
	}

	@RequestMapping(value = "/my_edit", method = RequestMethod.GET)
	public String my_edit() {
		logger.info("my_edit() called");

		return "member/my_edit";
	}
	
	@RequestMapping(value = "/acknowledgement", method = RequestMethod.GET)
	public String acknowledgement() {
		logger.info("acknowledgement() called");
		
		return "common/acknowledgement";
	}

	@RequestMapping(value = "/member_delete", method = RequestMethod.GET)
	public String member_delete() {
		logger.info("member_delete() called");

		return "member/member_delete";
	}
	
	@RequestMapping(value = "/coupang_dummy", method = RequestMethod.GET)
	public String coupang_dummy() {
		logger.info("coupang_dummy() called");
		
		return "test/coupang_dummy";
	}
}