package com.multi.shoes4jo.ranking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.shoes4jo.util.Criteria;

@Controller
@RequestMapping
public class RankingController {

	@Autowired
	private RankingService service;

	@RequestMapping(value = "/ranking.do")
	public String list(Model model, Criteria cri) throws Exception {

		List<RankingVO> dayRank;
		List<RankingVO> weekRank;
		List<RankingVO> monthRank;
		
		LocalDate today = LocalDate.now();
		dayRank = service.selectTopTen(today.toString(), 10);
		weekRank = service.selectTopTen(today.minusWeeks(1).toString(), 10);
		monthRank = service.selectTopTen(today.minusMonths(1).toString(), 10);

		model.addAttribute("dayRank", dayRank);
		model.addAttribute("weekRank", weekRank);
		model.addAttribute("monthRank", monthRank);
		
		Map<String, String> dateMap = new HashMap<>();
		dateMap.put("today", today.toString().replaceAll("-", "/"));
		dateMap.put("week", today.minusWeeks(1).toString().replaceAll("-", "/"));
		dateMap.put("month", today.minusMonths(1).toString().replaceAll("-", "/"));

		model.addAttribute("dateMap", dateMap);

		return "trend/ranking";
	}

}
