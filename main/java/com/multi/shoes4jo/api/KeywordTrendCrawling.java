package com.multi.shoes4jo.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.multi.shoes4jo.service.trend.KeywordTrendService;
import com.multi.shoes4jo.vo.KeywordTrendVO;

@Controller
public class KeywordTrendCrawling {

	@Autowired
	KeywordTrendService service;
	
	public void jsoup() {
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
					String text = span.text().replaceAll(",", "C:/Shoes4Jo/json/__.txt");
					System.out.println(text);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
    public void saveKeywordTrend() throws InterruptedException {
		KeywordTrendVO vo = new KeywordTrendVO();
		
        try {
            // JSON 파일 경로
        	String url_shoes		=	"C:/Shoes4Jo/json/1_shoes_shoes.txt";

        	String url_runningshoes	=	"C:/Shoes4Jo/json/2_kind_runningshoes.txt";
        	String url_slipper		=	"C:/Shoes4Jo/json/2_kind_slipper.txt";
        	String url_sneakers		=	"C:/Shoes4Jo/json/2_kind_sneakers.txt";
        	String url_slipon		=	"C:/Shoes4Jo/json/2_kind_slipon.txt";
        	String url_trakingshoes	=	"C:/Shoes4Jo/json/2_kind_trakingshoes.txt";
        	String url_sandal		=	"C:/Shoes4Jo/json/2_kind_sandal.txt";
        	String url_boots		=	"C:/Shoes4Jo/json/2_kind_boots.txt";

        	String url_nike			=	"C:/Shoes4Jo/json/3_brand_nike.txt";
        	String url_adidas		=	"C:/Shoes4Jo/json/3_brand_adidas.txt";
        	String url_newbalance	=	"C:/Shoes4Jo/json/3_brand_newbalance.txt";
        	String url_drmartin		=	"C:/Shoes4Jo/json/3_brand_drmartin.txt";
        	String url_asics		=	"C:/Shoes4Jo/json/3_brand_asics.txt";
        	String url_leebok		=	"C:/Shoes4Jo/json/3_brand_leebok.txt";
        	String url_crocs		=	"C:/Shoes4Jo/json/3_brand_crocs.txt";
        	String url_canvas		=	"C:/Shoes4Jo/json/3_brand_canvas.txt";
        	String url_vans			=	"C:/Shoes4Jo/json/3_brand_vans.txt";
        	String url_sketchers	=	"C:/Shoes4Jo/json/3_brand_sketchers.txt";

			Map<String, String> urlMap = new HashMap<>();
			
			urlMap.put("url_shoes",        url_shoes);

			urlMap.put("url_runningshoes", url_runningshoes);
			urlMap.put("url_slipper",      url_slipper);
			urlMap.put("url_sneakers",     url_sneakers);
			urlMap.put("url_slipon",       url_slipon);
			urlMap.put("url_trakingshoes", url_trakingshoes);
			urlMap.put("url_sandal",       url_sandal);
			urlMap.put("url_boots",        url_boots);

			urlMap.put("url_nike",         url_nike);
			urlMap.put("url_adidas",       url_adidas);
			urlMap.put("url_newbalance",   url_newbalance);
			urlMap.put("url_drmartin",     url_drmartin);
			urlMap.put("url_asics",        url_asics);
			urlMap.put("url_leebok",       url_leebok);
			urlMap.put("url_crocs",        url_crocs);
			urlMap.put("url_canvas",       url_canvas);
			urlMap.put("url_vans",         url_vans);
			urlMap.put("url_sketchers",    url_sketchers);
			
			String[] urlKeyArray = {"url_shoes"
					, "url_runningshoes", "url_slipper",     
					"url_sneakers",  "url_slipon",   "url_trakingshoes",
					"url_sandal",  "url_boots",     "url_nike",        
					"url_adidas", "url_newbalance", "url_drmartin",    
					"url_asics", "url_leebok", "url_crocs",       
					"url_canvas", "url_vans", "url_sketchers"   
					};
			  
        	// URL 연결 및 데이터 읽기
    		JSONParser parser = new JSONParser();
        	for (String urlKey: urlKeyArray) {
        		switch (urlKey) {
	        		case "url_shoes":
	        			vo.setKeyword_group("shoes");
	        			vo.setKeyword(urlKey.substring(4));
	        			break;
	        		case "url_runningshoes"	:
					case "url_slipper"		:
					case "url_sneakers"		:
					case "url_slipon"		:
					case "url_trakingshoes"	:
					case "url_sandal"		:
					case "url_boots"		:
	        			vo.setKeyword_group("kind");
	        			vo.setKeyword(urlKey.substring(4));
	        			break;
					case "url_nike"			:
					case "url_adidas"		:
					case "url_newbalance"	:
					case "url_drmartin"		:
					case "url_asics"		:
					case "url_leebok"       :
					case "url_crocs"		:
					case "url_canvas"		:
					case "url_vans"			:
					case "url_sketchers"	:
						vo.setKeyword_group("brand");
						vo.setKeyword(urlKey.substring(4));
						break;
        		}
        		
        		BufferedReader reader = new BufferedReader(new FileReader(urlMap.get(urlKey)));
        		
	            reader.readLine(); //첫 번째 줄 버림
	            String line = reader.readLine();
	            
	            // JSON 데이터 파싱
				try {
		    		JSONObject jsonObj = (JSONObject) parser.parse(line);
//		    		System.out.println(jsonObj);
		    		JSONArray rankedList = (JSONArray) ((JSONObject) jsonObj.get("default")).get("rankedList");
		    		JSONArray rankedKeyword = (JSONArray) ((JSONObject) rankedList.get(0)).get("rankedKeyword"); //0: 인기 검색어, 1: 급상승 검색어
//		    		System.out.println(rankedKeyword);
		    		
		    		// 선택된 값을 사용하여 작업 수행
		    		for (int i=0; i<rankedKeyword.size(); i++) {
		    			String query = (String) ((JSONObject) rankedKeyword.get(i)).get("query");
		    			query = cleanUpQuery(query, urlKey);
		    			if (!containsWrongWord(query) && query.split(" ").length > 1) {
		    				vo.setQuery(query);
		    				long value = (long) ((JSONObject) rankedKeyword.get(i)).get("value");
		    				vo.setQuery_value(value);
		    				
		    				if (service.isExists(urlKey.substring(4), query)) {
		    					if (service.oldValue(urlKey.substring(4), query) != value) {
			    					service.update(vo);
			    					System.out.println(urlKey.substring(4)+"의 "+query+" / "+value+" 업데이트됨");
		    					}
		    				} else {
		    					service.insert(vo);
		    					System.out.println(urlKey.substring(4)+"의 "+query+" / "+value+" 추가됨");
		    				}
		    			}
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
	
	
	public URL JsonUrlExtractor(String target) {
        // ChromeDriver 경로 설정 (본인 환경에 맞게 수정)
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chrome-win64/chrome.exe");

        // Chrome 옵션 설정 (Headless 모드 등)
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");  // 필요에 따라 Headless 모드 설정

        // Selenium WebDriver 실행
        WebDriver driver = new ChromeDriver(chromeOptions);

        try {
            // 대상 페이지 로드
            String targetPageUrl = target;
            driver.get(targetPageUrl);

            // Network 탭에서 JSON 파일의 다운로드 URL 추출
            String jsonFileUrl = null;

            Thread.sleep(3000);  // 페이지 로딩을 기다리기 위한 대기 시간 (필요에 따라 조정)

            // Network 탭에서 로딩된 리소스 추출 (JSON 파일이 포함된 요청 찾기)
            String performanceEntriesScript =
                    "return window.performance.getEntries().filter(entry => entry.initiatorType === 'xmlhttprequest' && entry.response.url.endsWith('.json'))";
            
            Object entriesObj = ((JavascriptExecutor) driver).executeScript(performanceEntriesScript);
            
            if (entriesObj instanceof List<?>) {
                List<?> entriesList = (List<?>) entriesObj;
                
                if (!entriesList.isEmpty()) {
                    Map<?, ?> entryMap = (Map<?, ?>) entriesList.get(0);
                    jsonFileUrl = entryMap.get("response").toString();
                }
            }

            if (jsonFileUrl != null) {
                System.out.println("JSON File URL: " + jsonFileUrl);
                return new URL (jsonFileUrl);
            } else {
                System.out.println("No JSON file URL found in the Network tab.");
            }
        } catch (Exception e) {
             e.printStackTrace();
         } finally {
             // WebDriver 종료
             driver.quit();
         }
        
        return null;
	}
	
	public boolean containsWrongWord(String input) {
	    String[] wrongWords = {"포켓몬", "메이플", "토드", "추옵", "90", "100", "110", "120", "130", "140", "150"};
	    
	    for (String word : wrongWords) {
	        if (input.contains(word)) {
	            return true;
	        }
	    }
	    
	    return false;
	}
	
	public String cleanUpQuery(String query, String urlKey) {
		String keyword = "";
		switch (urlKey) {
			case "url_shoes":
				keyword = "신발";
				break;
			case "url_runningshoes"	:
				keyword = "운동화";
				break;
			case "url_slipper"		:
				keyword = "슬리퍼";
				break;
			case "url_sneakers"		:
				keyword = "스니커즈";
				break;
			case "url_slipon"		:
				keyword = "슬립온";
				break;
			case "url_trakingshoes"	:
				keyword = "등산화";
				break;
			case "url_sandal"		:
				keyword = "샌들";
				break;
			case "url_boots"		:
				keyword = "부츠";
				break;
			case "url_nike"			:
				keyword = "나이키";
				break;
			case "url_adidas"		:
				keyword = "아디다스";
				break;
			case "url_newbalance"	:
				keyword = "뉴발란스";
				break;
			case "url_drmartin"		:
				keyword = "닥터마틴";
				break;
			case "url_asics"		:
				keyword = "아식스";
				break;
			case "url_leebok"       :
				keyword = "리복";
				break;
			case "url_crocs"		:
				keyword = "크록스";
				break;
			case "url_canvas"		:
				keyword = "캔버스";
				break;
			case "url_vans"			:
				keyword = "반스";
				break;
			case "url_sketchers"	:
				keyword = "스케쳐스";
				break;
		}

		query = query.replace(" ","").replace(keyword, " "+keyword+" ").trim();
		return query;
	}
}
