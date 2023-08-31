package com.multi.shoes4jo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.service.bookmark.BookmarkService;
import com.multi.shoes4jo.vo.BookmarkVO;

@Controller
@RequestMapping("/bookmarkcon")
public class BookmarkController {

	@Autowired
	private BookmarkService service;

	

	@RequestMapping(value = "/list.do") // 본인 아이디의 북마크 전체 목록 조회
	public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    HttpSession session = request.getSession();
	    String member_id = (String) session.getAttribute("memberInfo");
	    
	    List<BookmarkVO> bookmark_list = service.BookmarkList(member_id);
	    
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("bookmark/bookmark_list");
	    mav.addObject("bookmark_list", bookmark_list);

	    return mav;
	}


	@RequestMapping(value = "/check.do") // 북마크 여부 조회
	public String check(@RequestParam("bookmark_no") int bookmark_no, @RequestParam("member_id") String member_id,
			Model model) {
		BookmarkVO vo = service.check(bookmark_no, member_id);
		model.addAttribute("bookmarks", vo);
		return "/bookmark/bookmark_list";
	}

	@RequestMapping(value = "/insert.do")
	public String insert(BookmarkVO vo) {
	    service.insert(vo);
	    return "redirect:/bookmarkcon/view.do?bookmark_no=" + vo.getBookmark_no() + "&member_id=" + vo.getMember_id();
	}

	@RequestMapping(value = "/delete.do")
	public String delete(@RequestParam("bookmark_no") int bookmark_no, @RequestParam("member_id") String member_id) {
		service.delete(bookmark_no, member_id);
		return "redirect:/bookmarkcon/list.do";
	}
}