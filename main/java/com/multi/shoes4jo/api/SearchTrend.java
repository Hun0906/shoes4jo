package com.multi.shoes4jo.api;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api")
public class SearchTrend {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchTrend.class);

	@RequestMapping(value = "/searchtrend", method = { RequestMethod.GET, RequestMethod.POST } )
	@ResponseBody
    public String getSearchData(@RequestParam String keyword) throws Exception {
		logger.info("getSearchData() called");
		
<<<<<<< HEAD
    	String clientId = "JzcrBZHimsCICRuNqbzk"; // ¾ÖÇÃ¸®ÄÉÀÌ¼ÇÀÇ Client ID
		String clientSecret = "9fgwNuy1pM"; // ¾ÖÇÃ¸®ÄÉÀÌ¼ÇÀÇ Client Secret
=======
    	String clientId = "JzcrBZHimsCICRuNqbzk"; // ì• í”Œë¦¬ì¼€ì´ì…˜ì˜ Client ID
		String clientSecret = "9fgwNuy1pM"; // ì• í”Œë¦¬ì¼€ì´ì…˜ì˜ Client Secret
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132

        String apiUrl = "https://openapi.naver.com/v1/datalab/search";

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        requestHeaders.put("Content-Type", "application/json");
        
        String today = LocalDate.now().toString();
        System.out.println("keyword: " + keyword);

        String requestBody = 
        "{\"startDate\":\"2017-01-01\"," +
        "\"endDate\": \"" + today + "\"," +
        "\"timeUnit\":\"month\"," +
<<<<<<< HEAD
        "\"keywordGroups\":[{\"groupName\":\"ÇÑ±Û\"," + "\"keywords\":[\"ÇÑ±Û\",\"korean\"]}," +
        "{\"groupName\":\"¿µ¾î\"," + "\"keywords\":[\"¿µ¾î\",\"english\"]}]," +
=======
        "\"keywordGroups\":[{\"groupName\":\"í•œê¸€\"," + "\"keywords\":[\"í•œê¸€\",\"korean\"]}," +
        "{\"groupName\":\"ì˜ì–´\"," + "\"keywords\":[\"ì˜ì–´\",\"english\"]}]," +
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
        "\"device\":\"pc\"," +
        "\"ages\":[\"1\",\"2\"]," +
        "\"gender\":\"f\"}";
        
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
<<<<<<< HEAD
            if (responseCode == HttpURLConnection.HTTP_OK) { // Á¤»ó ÀÀ´ä
                return readBody(con.getInputStream());
            } else {  // ¿¡·¯ ÀÀ´ä
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API ¿äÃ»°ú ÀÀ´ä ½ÇÆÐ", e);
        } finally {
            con.disconnect(); // ConnectionÀ» ÀçÈ°¿ëÇÒ ÇÊ¿ä°¡ ¾ø´Â ÇÁ·Î¼¼½ºÀÏ °æ¿ì
=======
            if (responseCode == HttpURLConnection.HTTP_OK) { // ì •ìƒ ì‘ë‹µ
                return readBody(con.getInputStream());
            } else {  // ì—ëŸ¬ ì‘ë‹µ
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API ìš”ì²­ê³¼ ì‘ë‹µ ì‹¤íŒ¨", e);
        } finally {
            con.disconnect(); // Connectionì„ ìž¬í™œìš©í•  í•„ìš”ê°€ ì—†ëŠ” í”„ë¡œì„¸ìŠ¤ì¼ ê²½ìš°
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
        }
    }

    private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
<<<<<<< HEAD
            throw new RuntimeException("API URLÀÌ Àß¸øµÇ¾ú½À´Ï´Ù. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("¿¬°áÀÌ ½ÇÆÐÇß½À´Ï´Ù. : " + apiUrl, e);
=======
            throw new RuntimeException("API URLì´ ìž˜ëª»ë˜ì—ˆìŠµë‹ˆë‹¤. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("ì—°ê²°ì´ ì‹¤íŒ¨í–ˆìŠµë‹ˆë‹¤. : " + apiUrl, e);
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
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
<<<<<<< HEAD
            throw new RuntimeException("API ÀÀ´äÀ» ÀÐ´Âµ¥ ½ÇÆÐÇß½À´Ï´Ù.", e);
=======
            throw new RuntimeException("API ì‘ë‹µì„ ì½ëŠ”ë° ì‹¤íŒ¨í–ˆìŠµë‹ˆë‹¤.", e);
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
        }
    }
}