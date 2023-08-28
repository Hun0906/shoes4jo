package com.multi.shoes4jo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.shoes4jo.service.bookmark.BookmarkService;
import com.multi.shoes4jo.vo.BookmarkVO;

@Controller
@RequestMapping("/bookmarkcon")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @RequestMapping(value = "/list.do") //북마크 전체 목록 조회
    public String showList(Model model) {
        List<BookmarkVO> bookmark_list = bookmarkService.getselectAll();
        model.addAttribute("bookmark_list", bookmark_list);
        return "/admin/bookmark_list";
    }


    @RequestMapping(value = "/view.do") //특정 북마크 조회
    public String view(@RequestParam("bookmark_no") int bookmark_no, Model model) {
    	BookmarkVO vo = bookmarkService.getselectOne(bookmark_no);
    	model.addAttribute("bookmarkInfo", vo);
    	return "bookmark/bookmark_detail";
    }

    @RequestMapping(value = "/insert.do")
    public String insert(BookmarkVO vo) {
        bookmarkService.insert(vo);
        return "redirect:/bookmarkcon/view.do?bookmark_no=" + vo.getBookmark_no(); 
       
    }

   @RequestMapping(value = "/delete.do")
   public String delete(@RequestParam("bookmark_no") int bookmark_no) {
       bookmarkService.delete(bookmark_no);
       return "redirect:/bookmarkcon/list.do"; 
   }
}
