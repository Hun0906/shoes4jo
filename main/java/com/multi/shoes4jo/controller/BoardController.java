package com.multi.shoes4jo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.service.BoardService;
import com.multi.shoes4jo.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@Autowired
	HttpServletRequest request;

	private boolean admin_check() {
		HttpSession session = request.getSession();
		Integer adminCheck = (Integer) session.getAttribute("admin_check");

		if (adminCheck != null && adminCheck == 1) {
			return true;
		}
		return false;
	}


	@RequestMapping(value = "/list.do")
	public String list(Model model) {
		List<BoardVO> list = boardService.selectList();
		model.addAttribute("list", list);
		return "board/board_list";

	}

	@RequestMapping(value = "/view.do")
	public ModelAndView view(@RequestParam String bno) {
		boardService.updateviewcnt(bno);
		BoardVO board = boardService.selectOne(bno);
		return new ModelAndView("board/board_view", "board", board);

	}

	@RequestMapping(value = "/write.do")
	public String write() {
		return "board/board_write";

	}

	@RequestMapping("/writeOk.do")
	public String writeOk(@ModelAttribute BoardVO board) {
		boardService.insertOne(board);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("/update.do")
	public ModelAndView update(@RequestParam String bno) {
		BoardVO board = boardService.selectOne(bno);
		return new ModelAndView("board/board_update", "board", board);

	}
	
	@RequestMapping("/updateOk.do")
	public String updateOk(@ModelAttribute BoardVO board) {
		boardService.updateOne(board);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("/delete.do")
	public String deleteOk(@RequestParam String bno) {
	    boardService.deleteOne(bno);
	    return "redirect:/board/list.do";
	}
	
}

	
	
	