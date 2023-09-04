package com.multi.shoes4jo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.shoes4jo.service.ranking.RankingService;
import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.vo.RankingVO;

@Controller
@RequestMapping
public class RankingController {

	@Autowired
	private RankingService service;

	@RequestMapping(value = "/ranking.do")
	public String list(Model model, Criteria cri) throws Exception {

		List<RankingVO> list;
		list = service.searchRanking();

		model.addAttribute("list", list);

		return "trend/ranking";
	}

}
