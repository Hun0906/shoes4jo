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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multi.shoes4jo.api.GoodsClickAPI;
import com.multi.shoes4jo.api.GoodsSearchAPI;
import com.multi.shoes4jo.api.KeywordTrendCrawling;
import com.multi.shoes4jo.service.ranking.RankingService;
import com.multi.shoes4jo.service.trend.GoodsTrendService;
import com.multi.shoes4jo.util.GoodsList;
import com.multi.shoes4jo.vo.GoodsTrendVO;

@Controller
@RequestMapping("/save")
public class SaveController {

	@Autowired
	GoodsTrendService goodsTrendService;

	@Autowired
	RankingService rankingService;
	
	@Autowired
	KeywordTrendCrawling keywordTrendCrawling;

	@Autowired
	GoodsClickAPI goodsClick;
	
	@Autowired
	GoodsSearchAPI goodsSearch;

	@Autowired
	HttpServletRequest request;

	
	@RequestMapping(value = "/trend_save", method = { RequestMethod.GET, RequestMethod.POST })
	public String trend_save(Model model) {
		System.out.println("trend_save() called");
		model.addAttribute("goodsList", GoodsList.list());
		return "trend/trend_save";
	}
	
	
	@RequestMapping(value = "/goods_trend")
	public String goods_trend(GoodsTrendVO vo) throws Exception {
		String title = request.getParameter("keyword");
		String clickAll = goodsClick.getTrendData(title);

		// json parsing
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(clickAll);

		JSONObject results = (JSONObject) ((JSONArray) jsonObj.get("results")).get(0);
		String keyword = (String) ((JSONArray) results.get("keyword")).get(0);
		JSONArray data = (JSONArray) results.get("data");
		

		if (data.size() != 0) {
			//api_search DB들에 저장하기 위한 공통 선언부
			String period_sdata;
			vo.setKeyword(keyword);
			int ratio_cnt;

			/* api_click_all에 데이터 추가 */
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
			
			//api 결과에 없는 날짜에 대해 0값 추가
			String[] periodArr = {"2023-07-01","2023-07-02","2023-07-03","2023-07-04","2023-07-05","2023-07-06","2023-07-07","2023-07-08","2023-07-09","2023-07-10","2023-07-11","2023-07-12","2023-07-13","2023-07-14","2023-07-15","2023-07-16","2023-07-17","2023-07-18","2023-07-19","2023-07-20","2023-07-21","2023-07-22","2023-07-23","2023-07-24","2023-07-25","2023-07-26","2023-07-27","2023-07-28","2023-07-29","2023-07-30","2023-07-31","2023-08-01","2023-08-02","2023-08-03","2023-08-04","2023-08-05","2023-08-06","2023-08-07","2023-08-08","2023-08-09","2023-08-10","2023-08-11","2023-08-12","2023-08-13","2023-08-14","2023-08-15","2023-08-16","2023-08-17","2023-08-18","2023-08-19","2023-08-20","2023-08-21","2023-08-22","2023-08-23","2023-08-24","2023-08-25","2023-08-26","2023-08-27","2023-08-28","2023-08-29","2023-08-30","2023-08-31"};
			vo.setRatio_cnt(0);
			for (String period: periodArr) {
				if (!goodsTrendService.isExists(period, keyword)) { //사용한 검색어가 해당 날짜에 값이 없으면
					vo.setPeriod_sdata(period);
					goodsTrendService.insert(vo); //추가
					System.out.println(period+" 데이터 0 추가됨");
				}
			}
			/* api_click_all에 데이터 추가 */
			
			
			/* api_click_gender에 데이터 추가 */
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
			/* api_click_gender에 데이터 추가 */
			
			
			/* api_click_device에 데이터 추가 */
			String[] devices = {"pc","mo"};
			for (String dev:devices) {
				String search = goodsClick.getDeviceTrend(title,dev);
				vo.setDevice(dev);
				
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
						
						if (goodsTrendService.isExistsDev(period_sdata, keyword, dev)) { //사용한 검색어가 해당 날짜에 값이 있고
							if (ratio_cnt != goodsTrendService.oldRatioDev(period_sdata, keyword, dev)) { //ratio 값이 다르다면
								goodsTrendService.updateDev(vo); //업데이트
								System.out.println(period_sdata+" ("+dev+") 데이터 업데이트됨");
							}
						} else { //사용한 검색어가 해당 날짜에 값이 없다면
							goodsTrendService.insertDev(vo); //추가
							System.out.println(period_sdata+" ("+dev+") 데이터 추가됨");
						}
					}
				}
			}
			/* api_click_device에 데이터 추가 */
			
			
			/* api_click_ages에 데이터 추가 */
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
			/* api_click_ages에 데이터 추가 */
			
			
			/* api_search에 데이터 추가 */
			String search = goodsSearch.getTrendData(title);

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
					
					if (goodsTrendService.isExistsSearch(period_sdata, keyword)) { //사용한 검색어가 해당 날짜에 값이 있고
						if (ratio_cnt != goodsTrendService.oldRatioSearch(period_sdata, keyword)) { //ratio 값이 다르다면
							goodsTrendService.updateSearch(vo); //업데이트
							System.out.println(period_sdata+" 데이터 업데이트됨");
						}
					} else { //사용한 검색어가 해당 날짜에 값이 없다면
						goodsTrendService.insertSearch(vo); //추가
						System.out.println(period_sdata+" 데이터 추가됨");
					}
				}
			}
			
			//api 결과에 없는 날짜에 대해 0값 추가
			vo.setRatio_cnt(0);
			for (String period: periodArr) {
				if (!goodsTrendService.isExistsSearch(period, keyword)) { //사용한 검색어가 해당 날짜에 값이 없으면
					vo.setPeriod_sdata(period);
					goodsTrendService.insertSearch(vo); //추가
					System.out.println(period+" 데이터 0 추가됨");
				}
			}
			/* api_search에 데이터 추가 */
			
		} else {
			return "redirect:/main?err=nodata";
		}

        String encodedKeyword = URLEncoder.encode(title, StandardCharsets.UTF_8);
		return "redirect:/goods_trend?msg=get&keyword="+encodedKeyword;
	}

	@RequestMapping(value = "/all_ranking")
	public String allRanking() throws Exception {
	    String[] list = GoodsList.list();

	    Date dateObj = new Date();
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String date = simpleDateFormat.format(dateObj);

	    for (String goods : list) {
	    	String clean_keyword = goods.replace(" ", "");
	    	
	        /* 랭킹 테이블에 값 추가 */
	        if (!rankingService.isExists(clean_keyword, date)) { // 이미 존재하는 경우 추가하지 않음
	            System.out.println(date + " / " + clean_keyword + " added to Ranking");
	            rankingService.insert(clean_keyword, goods);
	        } else {
	        	System.out.println(date + " / " + clean_keyword + " Ranking에 이미 있음");
	        }
	        /* 랭킹 테이블에 값 추가 */
	    }
	    return "redirect:/save/trend_save";
	}
	
	
	@RequestMapping(value = "/keyword_crawling")
	public String saveKeywordTrend() throws InterruptedException {
		keywordTrendCrawling.saveKeywordTrend();
		
		return "redirect:/save/trend_save";
	}
	
}
