package com.multi.shoes4jo.api;

import java.io.BufferedReader;


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NaverShoppingInsight {
	public static void main(String[] args) {
		String clientId = "Client ID : JzcrBZHimsCICRuNqbzk"; // ���ø����̼��� Client ID
		String clientSecret = "secret : 9fgwNuy1pM"; // ���ø����̼��� Client Secret
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
