package com.multi.shoes4jo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.board.BoardService;
import com.multi.shoes4jo.board.BoardVO;
import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.util.FileUtil;
import com.multi.shoes4jo.util.PageMaker;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService service;

	@RequestMapping(value = "/list.do")
	public String list(Model model, Criteria cri) throws Exception {
		List<BoardVO> list = service.listPage(cri);
		model.addAttribute("list", list);
		// 페이지 정보와 게시글 목록을 가져옴

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());
		// 총 게시글 개수를 가져와 페이지 메이커에 설정

		model.addAttribute("pageMaker", pageMaker);
		// 페이지메이커 객체를 모델에 추가해서 뷰로 실어보내줌

		return "board/board_list";
	}

	@RequestMapping(value = "/category.do")
	public String category(@RequestParam("category") String category, Model model) {
		List<BoardVO> list = service.selectOneCat(category);
		model.addAttribute("list", list);
		model.addAttribute("selectedCategory", category);
		return "board/board_list";
	}

	@RequestMapping(value = "/magazine")
	public String magazine(Model model) {
		List<BoardVO> newslist = service.selectForMagazine("news");
		List<BoardVO> eventslist = service.selectForMagazine("events");
		List<BoardVO> columnslist = service.selectForMagazine("columns");
		model.addAttribute("newslist", newslist);
		model.addAttribute("eventslist", eventslist);
		model.addAttribute("columnslist", columnslist);
		return "board/magazine";
	}

	@RequestMapping(value = "/view.do")
	public ModelAndView view(@RequestParam String bno) {
		service.updateviewcnt(bno);
		BoardVO board = service.selectOne(bno);
		return new ModelAndView("board/board_view", "board", board);
	}

	@RequestMapping(value = "/write.do")
	public String write() {
		return "board/board_write";
	}

	@RequestMapping("/writeOk.do")
	public String writeOk(@ModelAttribute BoardVO board,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session) throws Exception {

		FileUtil.FileUpload(board, file, session);
		service.insertOne(board);

		return "redirect:/board/list.do";
	}

	@RequestMapping("/update.do")
	public ModelAndView update(@RequestParam String bno) {
		BoardVO board = service.selectOne(bno);
		return new ModelAndView("board/board_update", "board", board);
	}

	@RequestMapping("/updateOk.do")
	public String updateOk(@ModelAttribute BoardVO board,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session) throws Exception {

		FileUtil.FileUpload(board, file, session);
		service.updateOne(board);

		return "redirect:/board/list.do";
	}

	@RequestMapping("/delete.do")
	public String deleteOk(@RequestParam String bno) {
		service.deleteOne(bno);
		return "redirect:/board/list.do";
	}
}
