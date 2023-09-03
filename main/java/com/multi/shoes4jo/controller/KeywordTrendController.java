package com.multi.shoes4jo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multi.shoes4jo.service.trend.KeywordTrendService;
import com.multi.shoes4jo.vo.KeywordTrendVO;

@Controller
@RequestMapping(value = "/keyword_trend", method = { RequestMethod.GET, RequestMethod.POST })
public class KeywordTrendController {

	@Autowired
	KeywordTrendService service;

	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value = "/get_model", method = { RequestMethod.GET, RequestMethod.POST })
	public String keyword_trend(Model model) {
		System.out.println("keyword_trend() called");
		
		List<KeywordTrendVO> shoes = service.selectKeyword("shoes");
		
		List<String> kind = service.selectGroup("kind");
			List<KeywordTrendVO> runningshoes = service.selectKeyword("runningshoes");
			List<KeywordTrendVO> slipper = service.selectKeyword("slipper");
			List<KeywordTrendVO> sneakers = service.selectKeyword("sneakers");
			List<KeywordTrendVO> slipon = service.selectKeyword("slipon");
			List<KeywordTrendVO> trakingshoes = service.selectKeyword("trakingshoes");
			List<KeywordTrendVO> sandal = service.selectKeyword("sandal");
			List<KeywordTrendVO> boots = service.selectKeyword("boots");
		
		List<String> brand = service.selectGroup("brand");
			List<KeywordTrendVO> nike = service.selectKeyword("nike");
			List<KeywordTrendVO> adidas = service.selectKeyword("adidas");
			List<KeywordTrendVO> newbalance = service.selectKeyword("newbalance");
			List<KeywordTrendVO> drmartin = service.selectKeyword("drmartin");
			List<KeywordTrendVO> asics = service.selectKeyword("asics");
			List<KeywordTrendVO> leebok = service.selectKeyword("leebok");
			List<KeywordTrendVO> crocs = service.selectKeyword("crocs");
			List<KeywordTrendVO> canvas = service.selectKeyword("canvas");
			List<KeywordTrendVO> vans = service.selectKeyword("vans");
			List<KeywordTrendVO> sketchers = service.selectKeyword("sketchers");


		model.addAttribute("shoes", shoes);

		model.addAttribute("kind", kind);
			model.addAttribute("runningshoes", runningshoes);
			model.addAttribute("slipper", slipper);
			model.addAttribute("sneakers", sneakers);
			model.addAttribute("slipon", slipon);
			model.addAttribute("trakingshoes", trakingshoes);
			model.addAttribute("sandal", sandal);
			model.addAttribute("boots", boots);

		model.addAttribute("brand", brand);
			model.addAttribute("nike", nike);
			model.addAttribute("adidas", adidas);
			model.addAttribute("newbalance", newbalance);
			model.addAttribute("drmartin", drmartin);
			model.addAttribute("asics", asics);
			model.addAttribute("leebok", leebok);
			model.addAttribute("crocs", crocs);
			model.addAttribute("canvas", canvas);
			model.addAttribute("vans", vans);
			model.addAttribute("sketchers", sketchers);
		
		return "trend/keyword_trend";
	}
	
	
	@RequestMapping(value = "/google", method = { RequestMethod.GET, RequestMethod.POST })
	public String google_trend() {
		System.out.println("google_trend() called");
		return "trend/google_trend";
	}
}
