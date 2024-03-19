package com.multi.shoes4jo.goodstrend;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodsClickAPI {
	private static final Logger logger = LoggerFactory.getLogger(GoodsClickAPI.class);
	
	// getTrend 공통변수 선언
	String clientId = "JzcrBZHimsCICRuNqbzk"; // 애플리케이션의 Client ID
	String clientSecret = "9fgwNuy1pM"; // 애플리케이션의 Client Secret

	String today = LocalDate.now().toString();
	String twoWeeksBefore = LocalDate.now().minusWeeks(2).toString();
	String oneMonthBefore = LocalDate.now().minusMonths(1).toString();
	
	String apiUrl = "https://openapi.naver.com/v1/datalab/shopping/category/keywords";
	
	Map<String, String> requestHeaders = new HashMap<>();

	
	@ResponseBody
    public String getTrendData(@RequestParam String keyword) throws Exception {
		logger.info("getTrendData() called");
        System.out.println("검색어 (=title): " + keyword);

        String requestBody = "{"
                + "   \"startDate\": \"" + "2023-07-01" + "\"," //가장 빠른 날: 2017-08-01
                + "   \"endDate\": \"" + today + "\","
                + "   \"timeUnit\": \"date\","
                + "   \"category\": \"50000001\","
                + "   \"keyword\": [{\"name\":\"" + keyword + "\", \"param\": [\"" + keyword + "\"] }]"
                + "}";

        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        requestHeaders.put("Content-Type", "application/json");
        
        String responseBody = post(apiUrl, requestHeaders, requestBody);
        System.out.println(responseBody);
		return responseBody;
	}
	
	@ResponseBody
	public String getGenderTrend(@RequestParam String keyword, @RequestParam String gender) throws Exception {
		logger.info("getGenderTrend() called");
		
		String requestBody = "{"
				+ "   \"startDate\": \"" + "2023-07-01" + "\"," //가장 빠른 날: 2017-08-01
				+ "   \"endDate\": \"" + today + "\","
				+ "   \"timeUnit\": \"date\","
				+ "   \"gender\": \""+gender+"\"," // m || t
				+ "   \"category\": \"50000001\","
				+ "   \"keyword\": [{\"name\":\"" + keyword + "\", \"param\": [\"" + keyword + "\"] }]"
				+ "}";
		
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		requestHeaders.put("Content-Type", "application/json");
		
		String responseBody = post(apiUrl, requestHeaders, requestBody);
		System.out.println(responseBody);
		return responseBody;
	}
	
	@ResponseBody
	public String getDeviceTrend(@RequestParam String keyword, @RequestParam String device) throws Exception {
		logger.info("getDeviceTrend() called");
		
		String requestBody = "{"
				+ "   \"startDate\": \"" + "2023-07-01" + "\"," //가장 빠른 날: 2017-08-01
				+ "   \"endDate\": \"" + today + "\","
				+ "   \"timeUnit\": \"date\","
				+ "   \"device\": \""+device+"\"," // pc || mo
				+ "   \"category\": \"50000001\","
				+ "   \"keyword\": [{\"name\":\"" + keyword + "\", \"param\": [\"" + keyword + "\"] }]"
				+ "}";
		
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		requestHeaders.put("Content-Type", "application/json");
		
		String responseBody = post(apiUrl, requestHeaders, requestBody);
		System.out.println(responseBody);
		return responseBody;
	}
	
	@ResponseBody
	public String getAgeTrend(@RequestParam String keyword, @RequestParam int age) throws Exception {
		logger.info("getAgeTrend() called");
		
		String requestBody = "{"
				+ "   \"startDate\": \"" + "2023-07-01" + "\"," //가장 빠른 날: 2017-08-01
				+ "   \"endDate\": \"" + today + "\","
				+ "   \"timeUnit\": \"date\","
		        + "   \"ages\": [\""+age+"\"]," //10~60
				+ "   \"category\": \"50000001\","
				+ "   \"keyword\": [{\"name\":\"" + keyword + "\", \"param\": [\"" + keyword + "\"] }]"
				+ "}";
		
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		requestHeaders.put("Content-Type", "application/json");
		
		String responseBody = post(apiUrl, requestHeaders, requestBody);
		System.out.println(responseBody);
		return responseBody;
	}
	

    private static String post(String apiUrl, Map<String, String> requestHeaders, String requestBody) {
        HttpURLConnection con = connect(apiUrl);

        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(requestBody.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect(); // Connection을 재활용할 필요가 없는 프로세스일 경우
        }
    }
    
	private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body, StandardCharsets.UTF_8);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }

}