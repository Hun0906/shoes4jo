package com.multi.shoes4jo;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		logger.info("index() called");

		return "index";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		logger.info("main() called");

		return "main";
	}

	@RequestMapping(value = "/keyword_trend", method = { RequestMethod.GET, RequestMethod.POST })
	public String keyword_trend() {
		logger.info("keyword_trend() called");

		return "keyword_trend";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("login() called");

		return "login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		logger.info("signup() called");

		return "signup";
	}	
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		logger.info("about() called");
		
		return "about";
	}
	
	@RequestMapping(value = "/my_page", method = RequestMethod.GET)
	public String my_page() {
		logger.info("my_page() called");

		return "my_page";
	}
	
	@RequestMapping(value = "/my_edit", method = RequestMethod.GET)
	public String my_edit() {
		logger.info("my_edit() called");

		return "my_edit";
	}
	
	@RequestMapping(value = "/acknowledgement", method = RequestMethod.GET)
	public String acknowledgement() {
		logger.info("acknowledgement() called");
		
		return "acknowledgement";
	}
	
	@RequestMapping(value = "/member_update", method = RequestMethod.GET)
	public String member_update() {
		logger.info("member_update() called");

		return "member_update";
	}
	
	@RequestMapping(value = "/member_delete", method = RequestMethod.GET)
	public String member_delete() {
		logger.info("member_delete() called");

		return "member_delete";
	}
}
