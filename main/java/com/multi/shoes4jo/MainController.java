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
	// (메서드 단위)@RequestMapping을 이용해 첫 번째 단계의 url요청이 /이면(클래스 단위에서 @RequestMapping안해서)
	// index()메서드에게 요청함 get방식으로 요청 시 해당 메서드 호출
	// mav.addObject에서 addObject는 최종 view를 만드는데 필요한 실제 정보이고(정보 추가(바인딩)하는 역할)
	// 뒤에 msg,index는 담긴 정보

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
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("login() called");
		return "login";
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