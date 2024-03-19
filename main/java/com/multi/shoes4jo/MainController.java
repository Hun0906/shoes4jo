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

	@RequestMapping(value = "/goods_trend", method = { RequestMethod.GET, RequestMethod.POST })
	public String goods_trend() {
		logger.info("goods_trend() called");
		return "trend/goods_trend";
	}
	
	@RequestMapping(value = "/category_trend", method = { RequestMethod.GET, RequestMethod.POST })
	public String category_trend() {
		logger.info("category_trend() called");
		return "trend/category_trend";
	}

	@RequestMapping(value = "/ranking", method = { RequestMethod.GET, RequestMethod.POST })
	public String ranking() {
		logger.info("ranking() called");
		return "trend/ranking";
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
	
}