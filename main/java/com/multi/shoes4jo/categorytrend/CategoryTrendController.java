package com.multi.shoes4jo.categorytrend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/category_trend")
public class CategoryTrendController {

	@Autowired
	CategoryTrendService service;
	
	@Autowired
	CategoryClickAPI api;

	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value = "/get_data", method = { RequestMethod.GET, RequestMethod.POST } )
	public String get_data(String catId, Model model) {
		System.out.println("get_data() 호출됨");
		
		List<CategoryTrendVO> data = service.select(catId);
		model.addAttribute("data"+catId, data);
		
		return "trend/category_trend";
	}
	
	@RequestMapping(value = "/model", method = { RequestMethod.GET, RequestMethod.POST } )
	public String model(Model model) {
		System.out.println("model() 호출됨");
		
		List<CategoryTrendVO> catList = service.selectCatInfo();
		model.addAttribute("catList", catList);
		
		List<CategoryTrendVO> data = service.select("50000000"); //카테고리별로 검색해 모델에 추가
		model.addAttribute("data50000000", data);
		
		return "trend/category_trend";
	}
}
