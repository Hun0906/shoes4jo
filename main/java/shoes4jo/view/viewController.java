package shoes4jo.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class viewController {
	
	private static final Logger logger = LoggerFactory.getLogger(viewController.class);

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
	
	@RequestMapping(value = "/keyword_trend", method = {RequestMethod.GET, RequestMethod.POST})
	public String keyword_trend() {
		logger.info("keyword_trend() called");
		
		return "keyword_trend";
	}
	
	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public String chart() {
		logger.info("chart() called");
		
		return "chart";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("login() called");
		
		return "login";
	}
	
}
