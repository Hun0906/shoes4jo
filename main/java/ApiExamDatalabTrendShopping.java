

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ApiExamDatalabTrendShopping {

    public static void main(String[] args) {
		String clientId = "JzcrBZHimsCICRuNqbzk"; // 애플리케이션의 Client ID
		String clientSecret = "9fgwNuy1pM"; // 애플리케이션의 Client Secret

        String apiUrl = "https://openapi.naver.com/v1/datalab/shopping/categories";

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        requestHeaders.put("Content-Type", "application/json");

        String requestBody = "{  \"startDate\": \"2017-08-01\",\r\n"
        		+ "  \"endDate\": \"2017-09-30\",\r\n"
        		+ "  \"timeUnit\": \"month\",\r\n"
                + "\"category\":[{\"name\":\"패션의류\",\"param\":[\"50000000\"]}," 
        		+ "{\"name\":\"화장품/미용\",\"param\":[\"50000002\"]}],"
        		+ "  \"keyword\": [\r\n"
        		+ "      {\"name\": \"패션의류/정장\", \"param\": [ \"정장\"]},\r\n"
        		+ "      {\"name\": \"패션의류/비지니스 캐주얼\", \"param\": [ \"비지니스 캐주얼\"]}\r\n"
        		+ "  ],\r\n"
        		+ "  \"device\": \"\",\r\n"
        		+ "  \"gender\": \"\",\r\n"
        		+ "  \"ages\": [ ]}";

        String responseBody = post(apiUrl, requestHeaders, requestBody);
        System.out.println(responseBody);
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
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}