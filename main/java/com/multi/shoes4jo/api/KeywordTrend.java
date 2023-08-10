<<<<<<< HEAD
<<<<<<<< HEAD:main/java/com/multi/shoes4jo/api/KeywordTrend.java
=======
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
package com.multi.shoes4jo.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
<<<<<<< HEAD
========
package com.multi.shoes4jo.common;

import java.io.*;

>>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132:main/java/com/multi/shoes4jo/common/DatalabTrendShopping.java
=======
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

<<<<<<< HEAD
<<<<<<<< HEAD:main/java/com/multi/shoes4jo/api/KeywordTrend.java
=======
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api")
public class KeywordTrend {
	
	private static final Logger logger = LoggerFactory.getLogger(KeywordTrend.class);

	@RequestMapping(value = "/keywordtrend", method = { RequestMethod.GET, RequestMethod.POST } )
	@ResponseBody
    public String getTrendData(@RequestParam String keyword) throws Exception {
<<<<<<< HEAD
		logger.info("getTrendData() called");
		
    	String clientId = "JzcrBZHimsCICRuNqbzk"; // 애플리케이션의 Client ID
========
public class DatalabTrendShopping {

    public static void main(String[] args) {
		String clientId = "JzcrBZHimsCICRuNqbzk"; // 애플리케이션의 Client ID
>>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132:main/java/com/multi/shoes4jo/common/DatalabTrendShopping.java
		String clientSecret = "9fgwNuy1pM"; // 애플리케이션의 Client Secret
=======
		logger.info("getTrendData() called");  
		
    	String clientId = "JzcrBZHimsCICRuNqbzk"; // �븷�뵆由ъ��씠�뀡�쓽 Client ID
		String clientSecret = "9fgwNuy1pM"; // �븷�뵆由ъ��씠�뀡�쓽 Client Secret
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132

        String apiUrl = "https://openapi.naver.com/v1/datalab/shopping/category/keywords";

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        requestHeaders.put("Content-Type", "application/json");
        
        String today = LocalDate.now().toString();
<<<<<<< HEAD
<<<<<<<< HEAD:main/java/com/multi/shoes4jo/api/KeywordTrend.java
        String oneMonthAgo = LocalDate.now().minusMonths(1).toString();
        System.out.println("keyword: " + keyword);
========
        String keyword = "아디다스"; //request.getParameter("keyword");
>>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132:main/java/com/multi/shoes4jo/common/DatalabTrendShopping.java

        String requestBody = "{"
                + "   \"startDate\": \"" + oneMonthAgo + "\"," //가장 빠른 날: 2017-08-01
                + "   \"endDate\": \"" + today + "\","
                + "   \"timeUnit\": \"date\","
=======
        System.out.println("keyword: " + keyword);

        String requestBody = "{"
                + "   \"startDate\": \"2017-08-01\","
                + "   \"endDate\": \"" + today + "\","
                + "   \"timeUnit\": \"month\","
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
                + "   \"category\": \"50000001\","
                + "   \"keyword\": [{\"name\":\"" + keyword + "\", \"param\": [\"" + keyword + "\"] }]"
                + "}";

        String responseBody = post(apiUrl, requestHeaders, requestBody);
        System.out.println(responseBody);
<<<<<<< HEAD
    }
=======
		return responseBody;
	}
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132

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
=======
            if (responseCode == HttpURLConnection.HTTP_OK) { // �젙�긽 �쓳�떟
                return readBody(con.getInputStream());
            } else {  // �뿉�윭 �쓳�떟
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API �슂泥�怨� �쓳�떟 �떎�뙣", e);
        } finally {
            con.disconnect(); // Connection�쓣 �옱�솢�슜�븷 �븘�슂媛� �뾾�뒗 �봽濡쒖꽭�뒪�씪 寃쎌슦
        }
    }
    
	private static HttpURLConnection connect(String apiUrl) {
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
<<<<<<< HEAD
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
=======
            throw new RuntimeException("API URL�씠 �옒紐삳릺�뿀�뒿�땲�떎. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("�뿰寃곗씠 �떎�뙣�뻽�뒿�땲�떎. : " + apiUrl, e);
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
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }
<<<<<<<< HEAD:main/java/com/multi/shoes4jo/api/KeywordTrend.java
	

========
>>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132:main/java/com/multi/shoes4jo/common/DatalabTrendShopping.java
}
=======
            throw new RuntimeException("API �쓳�떟�쓣 �씫�뒗 �뜲 �떎�뙣�뻽�뒿�땲�떎.", e);
        }
    }
	

}
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
