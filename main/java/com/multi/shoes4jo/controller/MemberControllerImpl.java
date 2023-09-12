package com.multi.shoes4jo.controller;

import java.security.SecureRandom;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.member.MemberService;
import com.multi.shoes4jo.member.MemberVO;

@Controller
@RequestMapping("/controller")
public class MemberControllerImpl implements MemberController {

	@Autowired
	private MemberService service;

	@Override
	@RequestMapping(value = "/insertMember")
	public ModelAndView insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO vo = new MemberVO();

		String member_id = request.getParameter("member_id");
		String member_name = request.getParameter("member_name");
		String member_pw = request.getParameter("member_pw");
		String signup_date = request.getParameter("signup_date");
		String member_email = request.getParameter("member_email");
		String member_phone = request.getParameter("member_phone");

		vo.setMember_id(member_id);
		vo.setMember_name(member_name);
		vo.setMember_pw(member_pw);
		vo.setSignup_date(signup_date);
		vo.setMember_email(member_email);
		vo.setMember_phone(member_phone);

		service.insertMember(vo);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/signup");

		return mav;
	}

	@Override
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");

		System.out.printf("member_id: %s, member_pw: %s\n", member_id, member_pw);

		MemberVO vo = new MemberVO();
		vo.setMember_id(member_id);
		vo.setMember_pw(member_pw);

		Integer loginRes = service.loginMember(vo);

		ModelAndView mav = new ModelAndView();

		if (loginRes == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("memberInfo", member_id);

			System.out.println(member_id + " 로그인 성공");

			mav.setViewName("redirect:/login"); // 메세지창 띄우기 위해 login페이지로
			mav.addObject("res", 1); // 로그인 성공
		} else if (loginRes == 0) {
			mav.setViewName("redirect:/login");
			mav.addObject("res", 0); // 비밀번호 오류 코드
		} else {
			mav.setViewName("redirect:/login");
			mav.addObject("res", -1); // 없는 아이디 코드
		}
		return mav;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null) {
			session.invalidate();
		}
		mav.setViewName("redirect:/login");
		mav.addObject("res", 109); // 로그아웃 성공 코드
		return mav;
	}

	@Override
	@RequestMapping(value = "/memberInfo")
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("memberInfo");

		MemberVO memberInfo = service.memberInfo(member_id);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/my_page");
		mav.addObject("memberInfo", memberInfo);

		return mav;
	}

	@Override
	@RequestMapping(value = "/my_edit")
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		String member_name = request.getParameter("member_name");
		String member_id = (String) session.getAttribute("memberInfo");
		String member_pw = request.getParameter("member_pw");
		String member_email = request.getParameter("member_email");
		String member_phone = request.getParameter("member_phone");

		// request 잘 됐는지 검사용
		System.out.println("name: " + member_name);
		System.out.println("id: " + member_id);
		System.out.println("pw: " + member_pw);
		System.out.println("email: " + member_email);
		System.out.println("phone: " + member_phone);

		MemberVO member = new MemberVO();
		member.setMember_id(member_id);
		member.setMember_pw(member_pw);
		Integer loginRes = service.loginMember(member);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:memberInfo");

		if (loginRes == 0) {
			mav.addObject("res", 0); // 비밀번호 오류
			return mav;
		} else if (loginRes == 1) {
			member.setMember_name(member_name);
			member.setMember_id(member_id);
			member.setMember_pw(member_pw);
			member.setMember_email(member_email);
			member.setMember_phone(member_phone);

			service.updateMember(member);

			mav.addObject("res", 1); // 성공
		}
		return mav;

	}

	@Override
	@RequestMapping(value = "/deleteMember", method = RequestMethod.POST)
	public String deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String member_id = request.getParameter("member_id");

		int result = service.deleteMember(member_id);

		if (result > 0) {
			HttpSession session = request.getSession();
			session.invalidate(); // 회원탈퇴 성공시 현재 세션 가져와서 무효화(로그아웃)

			return "redirect:/login";

		} else {

			return "redirect:/member/my_page";

		}
	}

	@Override
	@ResponseBody
	@RequestMapping(value = "/duplicationId", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> duplicationId(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO MemberVO = new MemberVO();
		String id = request.getParameter("member_id");
		MemberVO.setMember_id(id);
		int cnt = service.duplicationId(id);

		return ResponseEntity.ok(Integer.toString(cnt));
	}

	@RequestMapping(value = "/search_id", method = RequestMethod.GET)
	public String search_id(HttpServletRequest request, Model model) {
		return "service/search_id";
	}

	@Override
	@RequestMapping(value = "/result_id", method = RequestMethod.POST)
	public String result_id(HttpServletRequest request, Model model,
			@RequestParam(required = true, value = "member_name") String member_name,
			@RequestParam(required = true, value = "member_phone") String member_phone) {

		MemberVO searchVO = new MemberVO();

		try {
			searchVO.setMember_name(member_name);
			searchVO.setMember_phone(member_phone);
			List<MemberVO> memberSearchList = service.memberIdSearch(searchVO);

			if (!memberSearchList.isEmpty()) {
				model.addAttribute("searchVO", memberSearchList.get(0));
			} else {
				model.addAttribute("msg", "입력한 정보로 가입된 정보가 없습니다.");
				return "/service/search_id";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			model.addAttribute("msg", "error.");
		}
		return "service/result_id";
	}

	@RequestMapping(value = "/search_pw", method = RequestMethod.GET)
	public String search_pw(HttpServletRequest request, Model model) {
		return "service/search_pw";
	}

	@RequestMapping(value = "/result_pw", method = RequestMethod.POST)
	public String result_pw(HttpServletRequest request, Model model,
			@RequestParam(required = true, value = "member_name") String member_name,
			@RequestParam(required = true, value = "member_phone") String member_phone,
			@RequestParam(required = true, value = "member_id") String member_id, MemberVO searchVO) {

		try {

			searchVO.setMember_name(member_name);
			searchVO.setMember_phone(member_phone);
			searchVO.setMember_id(member_id);
			int memberSearch = service.pwCheck(searchVO);

			if (memberSearch == 0) {
				model.addAttribute("msg", "입력한 정보로 가입된 정보가 없습니다.");
				return "/service/search_pw";
			}

			String newPw = generateRandomNumerString(10);
			searchVO.setMember_pw(newPw);

			service.pwUpdate(searchVO);

			model.addAttribute("newPw", newPw);

		} catch (Exception e) {
			System.out.println(e.toString());
			model.addAttribute("msg", "error.");
		}

		return "/service/result_pw";
	}

	public String generateRandomNumerString(int length) {
		StringBuilder randomStringBuilder = new StringBuilder();
		SecureRandom random = new SecureRandom();

		for (int i = 0; i < length; i++) {
			randomStringBuilder.append(Integer.toString(random.nextInt(10)));
		}

		return randomStringBuilder.toString();
	}

	@RequestMapping(value = "/showMember")
	public String showMember(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		List<MemberVO> member_list = service.listMembers();
		model.addAttribute("member_list", member_list);
		return "/admin/member_list";
	}

}
