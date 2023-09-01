package com.multi.shoes4jo.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.shoes4jo.vo.KeywordTrendVO;

@Controller
@RestController
public class KeywordTrendCrawling {

	KeywordTrendVO vo;

	@GetMapping("/test")
	@CrossOrigin(origins = { "http://localhost:8084",
			"https://surveys.google.com/async_survey?site=ynkoxcwrpztmeiz7uor4o7bd54",
			"https://csp.withgoogle.com/csp/2be55311e645b93f165b75b98d852d9a",
			"https://trends.google.com",
			"https://www.google.com",
			"https://ssl.gstatic.com"})
	public void test() {
		String targetUrl = "https://trends.google.com/trends/embed/explore/RELATED_QUERIES?req=%7B%22comparisonItem%22%3A%5B%7B%22keyword%22%3A%22%EC%8A%A4%EC%BC%80%EC%B3%90%EC%8A%A4%22%2C%22geo%22%3A%22KR%22%2C%22time%22%3A%22today%203-m%22%7D%5D%2C%22category%22%3A0%2C%22property%22%3A%22%22%7D&tz=-540&eq=date%3Dtoday%25203-m%26geo%3DKR%26q%3D%25EB%2589%25B4%25EB%25B0%259C%25EB%259E%2580%25EC%258A%25A4";
		System.out.println(targetUrl);

		try {
			Document doc = null;

			doc = Jsoup.connect(targetUrl).timeout(10000).get();
			System.out.println("Jsoup connect"); // 작동 테스트용
			Elements spans = doc.select("div");
			String check = "spans:" + spans + ":";

			if (check.equals("spans::")) {
				System.out.println("불러올 데이터 없음");
			} else {
				for (Element span : spans) {
					System.out.println(span + "에 대해 for문 도는 중"); // 작동 테스트용
					String text = span.text().replaceAll(",", "");
					System.out.println(text);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/readjson")
    public void bufferread() {
        try {
            // URL 객체 생성
        	String trendUrl = "https://trends.google.com/trends/api/widgetdata/relatedsearches?req=%7B%22restriction%22:%7B%22geo%22:%7B%22country%22:%22KR%22%7D,%22time%22:%222023-05-31+2023-08-31%22,%22originalTimeRangeForExploreUrl%22:%22today+3-m%22,%22complexKeywordsRestriction%22:%7B%22keyword%22:%5B%7B%22type%22:%22BROAD%22,%22";

        	URL url_shoes		=	new URL(trendUrl + "value%22:%22%EC%8B%A0%EB%B0%9C%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGkeiKRXz3Iy3JWAPPVHC2BioraAA7S");
        	
        	URL url_runningshoes=	new URL(trendUrl + "value%22:%22%EC%9A%B4%EB%8F%99%ED%99%94%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGlTyLZEE3PZWz6FxMBimXeXw8RrGpX");
        	URL url_slipper		=	new URL(trendUrl + "value%22:%22%EC%8A%AC%EB%A6%AC%ED%8D%BC%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGlZakOixzBK4ufGoRyqDqRo2nTdZpy");
        	URL url_sneakers	=	new URL(trendUrl + "value%22:%22%EC%8A%A4%EB%8B%88%EC%BB%A4%EC%A6%88%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGleexnXmJNbmhlbRwN1oBRuh42YKB8");
        	URL url_slipon		=	new URL(trendUrl + "value%22:%22%EC%8A%AC%EB%A6%BD%EC%98%A8%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGllPTkMXRufHByZBo3YXp7Aid0g7Oo");
        	URL url_trakingshoes=	new URL(trendUrl + "value%22:%22%EB%93%B1%EC%82%B0%ED%99%94%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGlq5_9YBx_q590MPAOdw11VaQ2fRQb");
        	URL url_sandal		=	new URL(trendUrl + "value%22:%22%EC%83%8C%EB%93%A4%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGlzsamZT8eo3hxGHDSE3DA9dhW9LNm");
        	URL url_boots		=	new URL(trendUrl + "value%22:%22%EB%B6%80%EC%B8%A0%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGmARA_5y98RuCplncMdnHpQOBaDPFw");
        	
        	URL url_nike		=	new URL(trendUrl + "value%22:%22%EB%82%98%EC%9D%B4%ED%82%A4%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGmN3x4pPQ3nTcNiMKsc0J8U-IMu9vh");
        	URL url_adidas		=	new URL(trendUrl + "value%22:%22%EC%95%84%EB%94%94%EB%8B%A4%EC%8A%A4%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGmTKDZOeOLugvLyRlOtSwN9uytg9MA");
        	URL url_newbalance	=	new URL(trendUrl + "value%22:%22%EB%89%B4%EB%B0%9C%EB%9E%80%EC%8A%A4%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGmYgA74LOWkOISfDuAr8F27szOW9wC");
        	URL url_drmartin	=	new URL(trendUrl + "value%22:%22%EB%8B%A5%ED%84%B0%EB%A7%88%ED%8B%B4%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGmiSh9hc5CpbqVd2JPz-qNbiG3FmNr");
        	URL url_asics		=	new URL(trendUrl + "value%22:%22%EC%95%84%EC%8B%9D%EC%8A%A4%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGmnQCAt0mCxi8H5XPshHvkqCPC1-8c");
        	URL url_leebok		=	new URL(trendUrl + "value%22:%22%EB%A6%AC%EB%B3%B5%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGmsVxRZqfTjALCahJl0qF5h0jvMR1_");
        	URL url_crocs		=	new URL(trendUrl + "value%22:%22%ED%81%AC%EB%A1%9D%EC%8A%A4%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGmyKv-ffBy4KZtBAnZIZUWBm0iwMhO");
        	URL url_canvas		=	new URL(trendUrl + "value%22:%22%EC%BB%A8%EB%B2%84%EC%8A%A4%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGm2SRiZntI8QUBqEcCt_pRDI4xE_PP");
        	URL url_vans		=	new URL(trendUrl + "value%22:%22%EB%B0%98%EC%8A%A4%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGm7L8ASmAMLgdArlbcqnYDWtutqWbO");
        	URL url_sketchers	=	new URL(trendUrl + "value%22:%22%EC%8A%A4%EC%BC%80%EC%B3%90%EC%8A%A4%22%7D%5D%7D%7D,%22keywordType%22:%22QUERY%22,%22metric%22:%5B%22TOP%22,%22RISING%22%5D,%22trendinessSettings%22:%7B%22compareTime%22:%222023-02-27+2023-05-30%22%7D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D,%22language%22:%22ko%22,%22userCountryCode%22:%22KR%22,%22userConfig%22:%7B%22userType%22:%22USER_TYPE_SCRAPER%22%7D%7D&token=APP6_UEAAAAAZPGnBqs-n3nGAHNXGRq7pWDk_iWnLOQK");

			Map<String, URL> urlMap = new HashMap<>();
			
			urlMap.put("url_shoes", 	url_shoes);
			
			urlMap.put("url_runningshoes", 	url_runningshoes);
			urlMap.put("url_slipper", 	url_slipper);
			urlMap.put("url_sneakers", 	url_sneakers);
			urlMap.put("url_slipon", 	url_slipon);
			urlMap.put("url_trakingshoes", 	url_trakingshoes);
			urlMap.put("url_sandal", 	url_sandal);
			urlMap.put("url_boots", 	url_boots);
			
			urlMap.put("url_nike", 	url_nike);
			urlMap.put("url_adidas", 	url_adidas);
			urlMap.put("url_newbalance",    url_newbalance);
			urlMap.put("url_drmartin",      url_drmartin);
			urlMap.put("url_asics",         url_asics);
			urlMap.put("url_leebok",        url_leebok);
			urlMap.put("url_crocs",         url_crocs);
			urlMap.put("url_canvas",       	url_canvas);
			urlMap.put("url_vans",         	url_vans);
			urlMap.put("url_sketchers",    	url_sketchers);
			  
			  
        	// URL 연결 및 데이터 읽기
    		JSONParser parser = new JSONParser();
        	for (URL url: urlArray) { //해시맵으로 바꿔야 됨
        		switch (url) {
        		case "url_shoes":
        			vo.setGroup("general");
        			vo.setKeyword("shoes");
        			break;
        		}
        		
        		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            reader.readLine(); //첫 번째 줄 버림
	            String line = reader.readLine();
	            
	            // JSON 데이터 파싱
				try {
		    		JSONObject jsonObj = (JSONObject) parser.parse(line);
		    		
		    		JSONArray rankedList = (JSONArray) ((JSONObject) jsonObj.get("default")).get("rankedList");
		    		JSONObject rankedKeyword = (JSONObject) rankedList.get(0);
		    		JSONObject[] data = ((JSONObject[]) ((JSONArray) rankedKeyword.get("rankedKeyword")).get(0)); //0: 인기 검색어, 1: 급상승 검색어
		    		System.out.println(data);
		    		
		    		// 선택된 값을 사용하여 작업 수행
		    		for (int i=0; i<data.length; i++) {
		    			String query = (String) data[i].get("query");
		    			vo.setQuery(query);
		    			long value = (long) data[i].get("value");
		    			vo.setValue(value);
		    		}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
	            // 리소스 정리
	            reader.close();
        	}
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
