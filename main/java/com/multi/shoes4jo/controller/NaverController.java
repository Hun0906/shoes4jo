package com.multi.shoes4jo.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multi.shoes4jo.service.sns.NaverLoginService;
import com.multi.shoes4jo.vo.SnsVO;

@Controller
public class NaverController {

	@Autowired
	private NaverLoginService service;

	@GetMapping("/naver_callback")
	public String callback(HttpServletRequest request) {
		String state = request.getParameter("state");
		HttpSession session = request.getSession();
		String storedState = (String) session.getAttribute("state");

		System.out.println("Received state: " + state);
		System.out.println("Stored state: " + storedState);

		if (!state.equals(storedState)) {
			return "redirect:/login?res=-1";
		} else {
			String code = request.getParameter("code");

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();

			String tokenRequestUrl = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id=N9xv13b4_0J3uwaUMfnw&client_secret=zygo4StTkQ&code="
					+ code + "&state=" + state;

			HttpEntity<String> entity = new HttpEntity<>(headers);

			ResponseEntity<String> responseEntity = restTemplate.exchange(tokenRequestUrl, HttpMethod.POST, entity,
					String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode;

			try {
				rootNode = objectMapper.readTree(responseEntity.getBody());

				System.out.println("Root node: " + rootNode);

			} catch (IOException e) {
				e.printStackTrace();
				return "redirect:/login?res=-1";
			}

			JsonNode accessTokenNode = rootNode.get("access_token");

			if (accessTokenNode == null) {
				return "redirect:/login?res=-1";
			}

			String accessTokenValue = accessTokenNode.asText();

			System.out.println("액세스 토큰 값: " + accessTokenValue);

			headers.add("Authorization", "Bearer " + accessTokenValue);

			HttpEntity<String> profileRequest = new HttpEntity<>(headers);

			ResponseEntity<String> profileResponse = restTemplate.exchange("https://openapi.naver.com/v1/nid/me",
					HttpMethod.GET, profileRequest, String.class);

			System.out.println("Profile response status code: " + profileResponse.getStatusCode());

			System.out.println("Profile response body: " + profileResponse.getBody());

			try {
				JsonNode userInfoRootNode = objectMapper.readTree(profileResponse.getBody());

				System.out.println("User info root node: " + userInfoRootNode);

				if (userInfoRootNode.hasNonNull("response")) {
					JsonNode responseInfo = userInfoRootNode.get("response");

					if (responseInfo.hasNonNull("id") && responseInfo.hasNonNull("email")
							&& responseInfo.hasNonNull("name") && responseInfo.hasNonNull("profile_image")) {
						String userId = responseInfo.get("id").asText();
						String userEmail = responseInfo.get("email").asText();
						String userName = responseInfo.get("name").asText();
						String userProfileImage = responseInfo.get("profile_image").asText();

						System.out.println(String.format("User info - ID: %s, Email: %s, Name: %s, Profile Image: %s",
								userId, userEmail, userName, userProfileImage));

						// 세션에 sns로그인 정보 저장
						session.setAttribute("sns_id", userId);
						session.setAttribute("sns_type", userEmail);
						session.setAttribute("sns_name", userName);
						session.setAttribute("sns_profile", userProfileImage);

						// SNS 회원 가입 처리 (DB에 사용자 정보 저장)
						String now = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
						SnsVO vo = new SnsVO(userId, "naver", userName, userProfileImage, now);
						service.login(vo, session);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				return "redirect:/login?res=-1";
			}

			return "main";
		}
	}

	@GetMapping("/naver_login")
	public String login(HttpSession session) {
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString(32);

		System.out.println(String.format("로그인 세션 값: %s", state));

		session.setAttribute("state", state);

		String clientId = "N9xv13b4_0J3uwaUMfnw";
		String redirectURI = URLEncoder.encode("http://localhost:8084/naver_callback", StandardCharsets.UTF_8);

		return "redirect:https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=" + clientId
				+ "&redirect_uri=" + redirectURI + "&state=" + state;
	}

	@GetMapping("/naver_logout")
	public String logout(HttpSession session) {
		// 모든 세션 정보 삭제
		session.invalidate();

		System.out.println("Logged out - invalidated the current user's session");

		return "redirect:/login";
	}
}