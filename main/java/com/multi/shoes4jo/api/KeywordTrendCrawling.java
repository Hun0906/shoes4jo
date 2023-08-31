package com.multi.shoes4jo.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KeywordTrendCrawling {

	public static void main(String[] args) {
		System.out.println("KeywordTrendCrawling main 호출됨");
		String targetUrl = "http://localhost:8084/Shoes4Jo/google_trend";

		Document doc = null;
		try {
			System.out.println(targetUrl); // 작동 테스트용
			doc = Jsoup.connect(targetUrl).timeout(10000).get();
			System.out.println("Jsoup connect 끝"); // 작동 테스트용
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 검색 결과 페이지에서 필요한 정보를 추출합니다.
        Elements spans = doc.select("div#tlsqkf span[ng-bind=bidiText]");
        List<String> keywordsList = new ArrayList<String>();
        for (Element span : spans) {
            keywordsList.add(span.text().replaceAll(",", ""));
        }

        System.out.println(keywordsList);
    }
}
