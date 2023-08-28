package com.multi.shoes4jo.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.shoes4jo.service.ranking.RankingService;
import com.multi.shoes4jo.service.trend.GoodsTrendService;
import com.multi.shoes4jo.vo.GoodsTrendVO;

@Controller
@RequestMapping("/goods_trend")
public class GoodsTrendController {

	@Autowired
	GoodsTrendService goodsTrendService;
	
	@Autowired
	RankingService rankingService;

	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value = "/get_data", method = { RequestMethod.GET, RequestMethod.POST } )
	public String drawchart(@RequestParam String keyword, Model model) {
		System.out.println("get_data() 호출됨");
		String clean_keyword = keyword.replace(" ", "");
		System.out.println(clean_keyword);
        String encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        
		/* 랭킹 테이블에 값 추가 */
		Date dateObj = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(dateObj);

		if (rankingService.isExists(clean_keyword, date)) {
			System.out.println(date + " / " + clean_keyword + " count on Ranking updated");
			rankingService.update(clean_keyword, date);
		} else {
			System.out.println(date + " / " + clean_keyword + " added to Ranking");
			rankingService.insert(clean_keyword, keyword);
		}
		/* 랭킹 테이블에 값 추가 */

		if (goodsTrendService.isExists("2023-07-01", clean_keyword)) {
			List<GoodsTrendVO> selectAll = goodsTrendService.selectAll(clean_keyword);
			model.addAttribute("selectAll", selectAll);
			
			List<GoodsTrendVO> search = goodsTrendService.selectSearch(clean_keyword);
			model.addAttribute("search", search);
			
			List<GoodsTrendVO> selectFemale = goodsTrendService.selectGen(clean_keyword, "f");
			List<GoodsTrendVO> selectMale = goodsTrendService.selectGen(clean_keyword, "m");
			model.addAttribute("selectFemale", selectFemale);
			model.addAttribute("selectMale", selectMale);
			
			List<GoodsTrendVO> selectPC = goodsTrendService.selectDev(clean_keyword, "pc");
			List<GoodsTrendVO> selectMobile = goodsTrendService.selectDev(clean_keyword, "mo");
			model.addAttribute("selectPC", selectPC);
			model.addAttribute("selectMobile", selectMobile);
			
			int[] ages = {10,20,30,40,50,60};
			for (int age:ages) {
				List<GoodsTrendVO> selectAge = goodsTrendService.selectAge(clean_keyword, age);
				model.addAttribute("selectAge"+age, selectAge);
			}
			
			return "trend/goods_trend";
			
		} else {
			return "redirect:/goods_trend?msg=err&keyword="+encodedKeyword;
		}
	}
}
