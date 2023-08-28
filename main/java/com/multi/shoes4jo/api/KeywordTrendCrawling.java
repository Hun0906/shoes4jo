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
            String targetUrl = "http://localhost:8083/Shoes4Jo/coupang_dummy";
        	Document doc = null;
            try {
            	System.out.println(targetUrl); //작동 테스트용
            	 doc = Jsoup.connect(targetUrl).timeout(10000).get();
            	 System.out.println("Jsoup connect 끝"); //작동 테스트용
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 검색 결과 페이지에서 필요한 정보를 추출합니다.
            Elements products = doc.select("li.search-product");
            List<String> productNames = new ArrayList<String>();
            List<String> productPrices = new ArrayList<String>();
            List<String> productReviews = new ArrayList<String>();
            List<String> productImages = new ArrayList<String>();

            for (int i = 0; i < 10; i++) { // 검색 상위 10개의 결과만 활용합니다.
                Element product = products.get(i);
                Element name = product.selectFirst("div.name");
                Element price = product.selectFirst("div.price-wrap > div.price > em > strong");
                Element review = product.selectFirst("div.other-info > div > span.rating-total-count");
                Element image = product.selectFirst("dt > img");

                productNames.add(name.text().replaceAll(",", ""));
                productPrices.add(price.text().replaceAll(",", ""));
                productReviews.add(review.text().replaceAll("[()]", ""));
                productImages.add(image.attr("src").replace("//", ""));
            }

            // 결과를 리스트에 추가합니다.
            result.add(productNames);
            result.add(productPrices);
            result.add(productReviews);
            result.add(productImages);

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
