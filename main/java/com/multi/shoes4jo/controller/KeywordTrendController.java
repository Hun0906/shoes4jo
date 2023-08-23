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

import com.multi.shoes4jo.api.KeywordTrendAPI;
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
	KeywordTrendAPI keywordTrend;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/insert.do")
	public String insert(KeywordTrendVO vo) throws Exception {
		String title = request.getParameter("keyword");
		String naverApiRes = keywordTrend.getTrendData(title);

		// json parsing
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(naverApiRes);
		String startDate = (String) jsonObj.get("startDate");
		String endDate = (String) jsonObj.get("endDate");
		String timeUnit = (String) jsonObj.get("timeUnit");

		JSONObject results = (JSONObject) ((JSONArray) jsonObj.get("results")).get(0);
		String keyword = (String) ((JSONArray) results.get("keyword")).get(0);
		JSONArray data = (JSONArray) results.get("data");

		if (data.size() != 0) {
			// 랭킹 테이블에 값 추가
			Date dateObj = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String date = simpleDateFormat.format(dateObj);

			boolean isExists = rankingService.isExists(keyword, date);
			if (isExists) {
				System.out.println(date + " / " + keyword + " count on Ranking updated");
				rankingService.update(keyword, date);
			} else {
				System.out.println(date + " / " + keyword + " added to Ranking");
				rankingService.insert(keyword, title);
			}

			// api_search_all에 데이터 추가
			String period_sdata;
			vo.setKeyword(keyword);
			long ratio_cnt;

			// ratio값이 0이 아닌 가장 빠른 날에 대해 정규화하여 저장 (api가 주어진 기간 내 최댓값을 100으로 하여 데이터를 제공하기 때문)
			long first_ratio = (long) ((JSONObject) data.get(0)).get("ratio");
			for (int i = 0; i < data.size(); i++) {
				period_sdata = (String) ((JSONObject) data.get(i)).get("period");
				vo.setPeriod_sdata(period_sdata);
				
				ratio_cnt = ((long) ((JSONObject) data.get(i)).get("ratio")) / first_ratio; // 유효숫자는 맞추지 않음
				vo.setRatio_cnt(ratio_cnt);
				
				if (keywordTrendService.isExists(period_sdata, keyword)) { //사용한 검색어가 해당 날짜에 값이 있고
					if (ratio_cnt != keywordTrendService.oldRatio(period_sdata, keyword)) { //ratio 값이 다르다면
						keywordTrendService.update(vo); //업데이트
						System.out.println(period_sdata+" 날짜 데이터 업데이트됨");
					}
				} else { //사용한 검색어가 해당 날짜에 값이 없다면
					keywordTrendService.insert(vo); //추가
					System.out.println(period_sdata+" 날짜 데이터 추가됨");
				}
			}
		} else {
			return "redirect:/main?err=nodata";
		}

		return "redirect:/main?err=no&keyword="+title;
	}

}
