package com.multi.shoes4jo.keywordtrend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/word_cloud", method = { RequestMethod.GET, RequestMethod.POST })
public class WordCloudController {

	@Autowired
	KeywordTrendService service;

	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value = "/model", method = { RequestMethod.GET, RequestMethod.POST })
	public String word_cloud(Model model) {
		System.out.println("word_cloud() called");
		
		List<KeywordTrendVO> list = service.selectAll();
		model.addAttribute("list", list);

		return "trend/word_cloud";
	}
	
}
