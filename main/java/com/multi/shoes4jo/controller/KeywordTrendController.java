package com.multi.shoes4jo.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.multi.shoes4jo.api.KeywordTrendAPI;
import com.multi.shoes4jo.service.keyword.KeywordTrendService;
import com.multi.shoes4jo.service.ranking.RankingService;
import com.multi.shoes4jo.vo.KeywordTrendVO;

@Controller
@RequestMapping("/keyword_trend/con")
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
			int ratio_cnt;

			// 첫날 값에 대해 정규화하여 저장 (api가 주어진 기간 내 최댓값을 100으로 하여 데이터를 제공하기 때문)
			Number first_ratio_num = (Number)((JSONObject)data.get(0)).get("ratio");
			double first_ratio = first_ratio_num.doubleValue();
			for (int i = 0; i < data.size(); i++) {
				period_sdata = (String) ((JSONObject) data.get(i)).get("period");
				vo.setPeriod_sdata(period_sdata);
				
				// double 변환해 계산 후 int 변경 시 값이 100일 때 오류가 나기 때문에 단계적으로 변환
				Number ratioNumber = (Number)((JSONObject)data.get(i)).get("ratio");
				double ratioDouble = ratioNumber.doubleValue();
				ratio_cnt = (int)((ratioDouble / first_ratio)*100);
				vo.setRatio_cnt(ratio_cnt);
				
				if (keywordTrendService.isExists(period_sdata, keyword)) { //사용한 검색어가 해당 날짜에 값이 있고
					if (ratio_cnt != keywordTrendService.oldRatio(period_sdata, keyword)) { //ratio 값이 다르다면
						keywordTrendService.update(vo); //업데이트
						System.out.println(period_sdata+" 데이터 업데이트됨");
					}
				} else { //사용한 검색어가 해당 날짜에 값이 없다면
					keywordTrendService.insert(vo); //추가
					System.out.println(period_sdata+" 데이터 추가됨");
				}
			}
		} else {
			return "redirect:/main?err=nodata";
		}

        String encodedKeyword = URLEncoder.encode(title, StandardCharsets.UTF_8);
		return "redirect:/keyword_trend?show=f&keyword="+encodedKeyword;
	}
	
	@RequestMapping(value = "/drawchart", method = { RequestMethod.GET, RequestMethod.POST } )
	public String drawchart(@RequestParam String keyword, Model model) {
		System.out.println("drawchart() 호출됨");
		String clean_keyword = keyword.replace(" ", "");
		
		List<KeywordTrendVO> selectAll = keywordTrendService.selectAll(clean_keyword);
		//List<KeywordTrendVO> selectGen = keywordTrendService.selectGen(clean_keyword);
		//List<KeywordTrendVO> selectAge = keywordTrendService.selectAge(clean_keyword);
		
		model.addAttribute("selectAll", selectAll);
		//model.addAttribute("selectGen", selectGen);
		//model.addAttribute("selectAge", selectAge);
		
		model.addAttribute("show", "t");
		model.addAttribute("keyword", keyword);

		return "trend/keyword_trend";
	}
}
