package com.multi.shoes4jo.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.service.bookmark.BookmarkService;
import com.multi.shoes4jo.vo.BookmarkVO;

@Controller
@RequestMapping("/bookmark")
public class BookmarkController {

	@Autowired
	private BookmarkService service;

	@RequestMapping(value = "/list.do") // 본인 아이디의 북마크 전체 목록 조회
	public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("memberInfo");

		List<BookmarkVO> bookmark_list = service.BookmarkList(member_id);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/my_bookmark_list");
		mav.addObject("bookmark_list", bookmark_list);

		return mav;
	}

	@RequestMapping(value = "/check.do")
	@ResponseBody
	public int check(HttpSession session, @RequestParam("gno") int gno) {
		String member_id = (String) session.getAttribute("memberInfo");

		BookmarkVO vo = service.check(member_id, gno);

		if (vo != null) {
			return 1; // 이미 북마크에 추가된 경우
		} else {
			return 0; // 아직 북마크에 추가되지 않은 경우
		}
	}

	@PostMapping(value = "/insert.do")
	@ResponseBody
	public ResponseEntity<?> insert(@RequestBody Map<String, Object> bookmarkMap, HttpSession session) {
	    String member_id = (String) session.getAttribute("memberInfo");

	    BookmarkVO vo = new BookmarkVO();
	    vo.setGno(Integer.parseInt(bookmarkMap.get("gno").toString()));
	    vo.setMember_id(member_id);
	    vo.setKeyword((String) bookmarkMap.get("keyword"));

	    int result = service.insert(vo);

	    return new ResponseEntity<>(Collections.singletonMap("result", result), HttpStatus.OK);
	}


	@RequestMapping(value = "/delete.do")
	public String delete(@RequestParam("bookmark_no") int bookmark_no, HttpSession session) {
		String member_id = (String) session.getAttribute("memberInfo");
		service.delete(bookmark_no, member_id);

		return "redirect:/bookmarkcon/list.do";
	}
}
