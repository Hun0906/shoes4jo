package com.multi.shoes4jo.common;

import java.io.BufferedReader;


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NaverShoppingInsight {
	public static void main(String[] args) {
<<<<<<< HEAD
		String clientId = "Client ID : JzcrBZHimsCICRuNqbzk"; // ¾ÖÇÃ¸®ÄÉÀÌ¼ÇÀÇ Client ID
		String clientSecret = "secret : 9fgwNuy1pM"; // ¾ÖÇÃ¸®ÄÉÀÌ¼ÇÀÇ Client Secret
=======
		String clientId = "Client ID : JzcrBZHimsCICRuNqbzk"; // ì• í”Œë¦¬ì¼€ì´ì…˜ì˜ Client ID
		String clientSecret = "secret : 9fgwNuy1pM"; // ì• í”Œë¦¬ì¼€ì´ì…˜ì˜ Client Secret
>>>>>>> 92d651ae45846ea42a9f4420d8d0f7ae6df88132
		try {
			String apiURL = "https://openapi.naver.com/v1/datalab/shopping/top100";
			URL url = new URL(apiURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("X-Naver-Client-Id", clientId);
			connection.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = connection.getResponseCode();
			BufferedReader bufferedReader;
			if (responseCode == 200) {
				bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			} else {
				bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = bufferedReader.readLine()) != null) {
				response.append(inputLine);
			}
			bufferedReader.close();
			System.out.println(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
