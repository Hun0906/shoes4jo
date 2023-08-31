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
        // 키워드 리스트를 정의합니다.
        List<String> keywords = new ArrayList<String>();
        keywords.add("알파바운스");

        // 결과 리스트를 초기화합니다.
        List<List<String>> result = new ArrayList<List<String>>();

        for (String keyword : keywords) {

            // 정해진 키워드로 검색을 진행합니다.
            //String targetUrl = "https://www.coupang.com/np/search?component=&q=" + keyword + "&channel=user";
            //String targetUrl = "http://localhost:8083/Shoes4Jo/coupang_dummy";
        	//String targetUrl = "https://trends.google.com/trends/embed/explore/RELATED_QUERIES?req=%7B%22comparisonItem%22%3A%5B%7B%22keyword%22%3A%22%2Fm%2F06rrc%22%2C%22geo%22%3A%22KR%22%2C%22time%22%3A%22now%207-d%22%7D%5D%2C%22category%22%3A18%2C%22property%22%3A%22%22%7D&tz=-540&eq=cat%3D18%26date%3Dnow%25201-d%26geo%3DKR%26q%3D%252Fm%252F06rrc%26hl%3Dko";
        	String targetUrl = "http://localhost:8083/Shoes4Jo/keyword_trend";

        	Document doc = null;
            try {
            	System.out.println(targetUrl); //작동 테스트용
            	 doc = Jsoup.connect(targetUrl).timeout(10000).get();
            	 System.out.println("Jsoup connect 끝"); //작동 테스트용
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 검색 결과 페이지에서 필요한 정보를 추출합니다.
            Element container = doc.select("div.fe-related-queries").get(0);
            List<String> keywordsList = new ArrayList<String>();
            List<String> keywordsVal = new ArrayList<String>();

            Element span = container.selectFirst("span[ng-bind=bidiText]");

            keywordsList.add(span.text().replaceAll(",", ""));

            // 결과를 리스트에 추가합니다.
            result.add(keywordsList);

        }

        // 결과를 콘솔에 출력합니다.
        for (List<String> productList : result) {
            for (String product : productList) {
                System.out.print(product + ",");
            }
            System.out.println();
        }
    }
}
