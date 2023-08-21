package com.multi.shoes4jo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.shoes4jo.api.KeywordTrend;
import com.multi.shoes4jo.service.KeywordTrendService;
import com.multi.shoes4jo.service.RankingService;
import com.multi.shoes4jo.vo.KeywordTrendVO;

@Controller
@RequestMapping("/keytrendcon")
public class KeywordTrendController {

	@Autowired
	KeywordTrendService keywordTrendService;
	
	@Autowired
	RankingService rankingService;
	
	@Autowired
	KeywordTrend keywordTrend;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/insert.do")
	public String insert(KeywordTrendVO vo) throws Exception {
		String title = request.getParameter("keyword");
		String naverApiRes = keywordTrend.getTrendData(title);
		
		//json parsing
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject) parser.parse(naverApiRes);
        String startDate = (String) jsonObj.get("startDate");
        String endDate = (String) jsonObj.get("endDate");
        String timeUnit = (String) jsonObj.get("timeUnit");
        
        JSONObject results = (JSONObject) ((JSONArray) jsonObj.get("results")).get(0);
        String keyword = (String) ((JSONArray) results.get("keyword")).get(0);
        
        JSONArray data = (JSONArray) results.get("data");
        //이제 data에 대해 .get(int) 해가지고 for문 돌려서 .get("period")랑 .get("ratio")에 대해 insert하면 됨
 		
        //랭킹 추가 옵션 체크
		Date dateObj = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String date = simpleDateFormat.format(dateObj);
		System.out.println("date: "+date+"keyword: "+keyword);
		
		boolean isExists = rankingService.isExists(keyword, date); //이렇게넣어주면안되는건가..?
		System.out.println(isExists);
		//왜 이런 오류가 뜰까?
		//org.apache.ibatis.binding.BindingException: Parameter 'keyword' not found. Available parameters are [arg1, arg0, param1, param2]
		if (isExists) {
			rankingService.update(keyword, date);
		} else {
			rankingService.insert(keyword, title);
		}
		
		//그리고 for문 돌려서 api_search_all의 period -> period_sdata, keyword -> keyword, cnt -> ratio_cnt 에 집어넣어야 됨
		//아 이것도.. period_sdata 겹치면 cnt를 업데이트할건데, 음.... 이거 아마 무조건 이 데이터셋의 최댓값이 100일텐데.... 역시 첫날부터 쫙 돌려서 업데이트하는 무식한 방법을 써야 하나ㅋㅋ
		keywordTrendService.insert(vo);
		return "redirect:/main";
	}

}

	