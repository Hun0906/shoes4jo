package com.multi.shoes4jo.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.shoes4jo.api.GoodsClickAPI;
import com.multi.shoes4jo.service.ranking.RankingService;
import com.multi.shoes4jo.service.trend.GoodsTrendService;
import com.multi.shoes4jo.vo.GoodsTrendVO;

@Controller
@RequestMapping("/save")
public class SaveController {

	@Autowired
	GoodsTrendService goodsTrendService;

	@Autowired
	RankingService rankingService;

	@Autowired
	GoodsClickAPI goodsClick;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/goods_trend")
	public String goods_trend(GoodsTrendVO vo) throws Exception {
		String title = request.getParameter("keyword");
		String searchAll = goodsClick.getTrendData(title);

		// json parsing
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(searchAll);

		JSONObject results = (JSONObject) ((JSONArray) jsonObj.get("results")).get(0);
		String keyword = (String) ((JSONArray) results.get("keyword")).get(0);
		JSONArray data = (JSONArray) results.get("data");
		

		if (data.size() != 0) {
			//api_search DB들에 저장하기 위한 공통 선언부
			String period_sdata;
			vo.setKeyword(keyword);
			int ratio_cnt;

			/* api_search_all에 데이터 추가 */
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
				
				if (goodsTrendService.isExists(period_sdata, keyword)) { //사용한 검색어가 해당 날짜에 값이 있고
					if (ratio_cnt != goodsTrendService.oldRatio(period_sdata, keyword)) { //ratio 값이 다르다면
						goodsTrendService.update(vo); //업데이트
						System.out.println(period_sdata+" 데이터 업데이트됨");
					}
				} else { //사용한 검색어가 해당 날짜에 값이 없다면
					goodsTrendService.insert(vo); //추가
					System.out.println(period_sdata+" 데이터 추가됨");
				}
			}
			/* api_search_all에 데이터 추가 */
			
			
			/* api_search_gender에 데이터 추가 */
			String[] genders = {"f","m"};
			for (String gen:genders) {
				String search = goodsClick.getGenderTrend(title,gen);
				vo.setGender(gen);

				// json parsing
				jsonObj = (JSONObject) parser.parse(search);
				results = (JSONObject) ((JSONArray) jsonObj.get("results")).get(0);
				data = (JSONArray) results.get("data");
				if (data.size() != 0) {
					// 첫날 값에 대해 정규화하여 저장 (api가 주어진 기간 내 최댓값을 100으로 하여 데이터를 제공하기 때문)
					first_ratio_num = (Number)((JSONObject)data.get(0)).get("ratio");
					first_ratio = first_ratio_num.doubleValue();
					for (int i = 0; i < data.size(); i++) {
						period_sdata = (String) ((JSONObject) data.get(i)).get("period");
						vo.setPeriod_sdata(period_sdata);
						
						// double 변환해 계산 후 int 변경 시 값이 100일 때 오류가 나기 때문에 단계적으로 변환
						Number ratioNumber = (Number)((JSONObject)data.get(i)).get("ratio");
						double ratioDouble = ratioNumber.doubleValue();
						ratio_cnt = (int)((ratioDouble / first_ratio)*100);
						vo.setRatio_cnt(ratio_cnt);
						
						if (goodsTrendService.isExistsGen(period_sdata, keyword, gen)) { //사용한 검색어가 해당 날짜에 값이 있고
							if (ratio_cnt != goodsTrendService.oldRatioGen(period_sdata, keyword, gen)) { //ratio 값이 다르다면
								goodsTrendService.updateGen(vo); //업데이트
								System.out.println(period_sdata+" ("+gen+") 데이터 업데이트됨");
							}
						} else { //사용한 검색어가 해당 날짜에 값이 없다면
							goodsTrendService.insertGen(vo); //추가
							System.out.println(period_sdata+" ("+gen+") 데이터 추가됨");
						}
					}
				}
			}
			/* api_search_gender에 데이터 추가 */
			
			
			/* api_search_ages에 데이터 추가 */
			int[] ages = {10,20,30,40,50,60};
			for (int age:ages) {
				String search = goodsClick.getAgeTrend(title,age);
				vo.setAge(age);

				// json parsing
				jsonObj = (JSONObject) parser.parse(search);
				results = (JSONObject) ((JSONArray) jsonObj.get("results")).get(0);
				data = (JSONArray) results.get("data");
				
				if (data.size() != 0) {
					// 첫날 값에 대해 정규화하여 저장 (api가 주어진 기간 내 최댓값을 100으로 하여 데이터를 제공하기 때문)
					first_ratio_num = (Number)((JSONObject)data.get(0)).get("ratio");
					first_ratio = first_ratio_num.doubleValue();
					for (int i = 0; i < data.size(); i++) {
						period_sdata = (String) ((JSONObject) data.get(i)).get("period");
						vo.setPeriod_sdata(period_sdata);
						
						// double 변환해 계산 후 int 변경 시 값이 100일 때 오류가 나기 때문에 단계적으로 변환
						Number ratioNumber = (Number)((JSONObject)data.get(i)).get("ratio");
						double ratioDouble = ratioNumber.doubleValue();
						ratio_cnt = (int)((ratioDouble / first_ratio)*100);
						vo.setRatio_cnt(ratio_cnt);
						
						if (goodsTrendService.isExistsAge(period_sdata, keyword, age)) { //사용한 검색어가 해당 날짜에 값이 있고
							if (ratio_cnt != goodsTrendService.oldRatioAge(period_sdata, keyword, age)) { //ratio 값이 다르다면
								goodsTrendService.updateAge(vo); //업데이트
								System.out.println(period_sdata+" ("+age+"대) 데이터 업데이트됨");
							}
						} else { //사용한 검색어가 해당 날짜에 값이 없다면
							goodsTrendService.insertAge(vo); //추가
							System.out.println(period_sdata+" ("+age+"대) 데이터 추가됨");
						}
					}
				}
			}
			/* api_search_ages에 데이터 추가 */
			
		} else {
			return "redirect:/main?err=nodata";
		}

        String encodedKeyword = URLEncoder.encode(title, StandardCharsets.UTF_8);
		return "redirect:/goods_trend?msg=show&keyword="+encodedKeyword;
	}
}
