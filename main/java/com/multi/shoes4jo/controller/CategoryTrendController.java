package com.multi.shoes4jo.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multi.shoes4jo.service.trend.CategoryTrendService;
import com.multi.shoes4jo.util.GoodsList;
import com.multi.shoes4jo.vo.CategoryTrendVO;

@Controller
@RequestMapping("/category_trend")
public class CategoryTrendController {

	@Autowired
	CategoryTrendService service;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/get_data", method = { RequestMethod.GET, RequestMethod.POST })
	public String drawchart(String keyword, Model model) {
	    System.out.println("drawchart() called");

	    String clean_keyword = (keyword != null) ? keyword.replace(" ", "") : "";

	    System.out.println(clean_keyword);

	    List<CategoryTrendVO> trendList = service.selectAll(clean_keyword);

	    if (trendList.isEmpty()) {
	        return "redirect:/category_trend?msg=err&keyword=" + URLEncoder.encode(keyword, StandardCharsets.UTF_8);
	    }

	    List<String> labels = new ArrayList<>();
	    List<Integer> data = new ArrayList<>();

	    for (CategoryTrendVO vo : trendList) {
	        labels.add(vo.getKeyword());
	        data.add(vo.getRatio_cnt());
	    }

	    model.addAttribute("labels", labels);
	    model.addAttribute("data", data);

		return "trend/category_trend";
	}

	
	
	@RequestMapping(value = "/model", method = { RequestMethod.GET, RequestMethod.POST })
	public String category_trend(Model model) {
		System.out.println("category_trend() called");

		List<String> arrayList = new ArrayList<>();
		String[] list = GoodsList.list();

		for (String goods : list) {
			arrayList.add(goods);
		}

		Collections.shuffle(arrayList);

		List<String> shoes4jo = arrayList.subList(0, 10);

		model.addAttribute("shoes4jo", shoes4jo);

		return "trend/category_trend";
	}
}
