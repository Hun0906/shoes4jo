package com.multi.shoes4jo.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.command.PageInfo;
import com.multi.shoes4jo.service.BoardService;
import com.multi.shoes4jo.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/list.do")
	public String list(Model model, @RequestParam Map<String, String> param) {
		int page = 1;
		if (param.get("page") != null) {
			page = Integer.parseInt(param.get("page"));
		}

		String searchValue = param.get("searchValue");

		int boardsPerPage = 10;

		Map<String, String> searchMap = new HashMap<String, String>();
		if (searchValue != null && searchValue.length() > 0) {
			String type = param.get("searchType") == null ? "title" : param.get("searchType");
			if (type.equals("title")) {
				searchMap.put("titleKeyword", searchValue);
			} else if (type.equals("content")) {
				searchMap.put("contentKeyword", searchValue);
			} else if (type.equals("writer")) {
				searchMap.put("writerKeyword", searchValue);
			}
		}

		String category = param.get("category");
		if (category != null && !category.isEmpty()) {
			searchMap.put("category", category);
		}

		PageInfo pageInfo = new PageInfo(page, boardsPerPage, boardService.selectBoardCount(searchMap), 10);
		List<BoardVO> list = boardService.selectBoardList(pageInfo, searchMap);

		model.addAttribute("list", list);
		model.addAttribute("param", param);
		model.addAttribute("pageInfo", pageInfo);

		return "board/board_list";
	}

	@RequestMapping(value = "/magazine")
	public String magazine(Model model) {
		List<BoardVO> newslist = boardService.selectForMagazine("news");
		List<BoardVO> eventslist = boardService.selectForMagazine("events");
		List<BoardVO> columnslist = boardService.selectForMagazine("columns");
		model.addAttribute("newslist", newslist);
		model.addAttribute("eventslist", eventslist);
		model.addAttribute("columnslist", columnslist);
		return "board/magazine";
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
	public String writeOk(@ModelAttribute BoardVO board,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpServletRequest request)
			throws Exception {

		if (file != null && !file.isEmpty()) {
			String basePath = request.getServletContext().getRealPath("/assets/img/");
			File currentDirPath = new File(basePath);

			if (!currentDirPath.exists()) {
				currentDirPath.mkdirs();
			}

			UUID uuid = UUID.randomUUID();
			String fileName = uuid + "_" + file.getOriginalFilename();
			File saveFile = new File(currentDirPath, fileName);

			file.transferTo(saveFile);

			board.setFile_name(fileName);
			board.setFile_path("/assets/img/" + fileName);
		}

		boardService.insertOne(board);
		return "redirect:/board/list.do";
	}

	@RequestMapping("/update.do")
	public ModelAndView update(@RequestParam String bno) {
		BoardVO board = boardService.selectOne(bno);
		return new ModelAndView("board/board_update", "board", board);
	}

	@RequestMapping("/updateOk.do")
	public String updateOk(@ModelAttribute BoardVO board,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpServletRequest request)
			throws Exception {

		if (!file.isEmpty()) {
			// 파일 삭제
			if (board.getFile_path() != null) {
				File oldFile = new File(board.getFile_path());
				if (oldFile.exists()) {
					oldFile.delete();
				}
			}
			String basePath = request.getServletContext().getRealPath("/assets/img/");
			File currentDirPath = new File(basePath);
			if (!currentDirPath.exists()) {
				currentDirPath.mkdirs();
			}

			UUID uuid = UUID.randomUUID();
			String fileName = uuid + "_" + file.getOriginalFilename();
			File saveFile = new File(currentDirPath, fileName);
			file.transferTo(saveFile);
			board.setFile_name(fileName);
			board.setFile_path("/assets/img/" + fileName);
		}

		boardService.updateOne(board);
		return "redirect:/board/list.do";
	}

	@RequestMapping("/delete.do")
	public String deleteOk(@RequestParam String bno) {
		boardService.deleteOne(bno);
		return "redirect:/board/list.do";
	}
}
