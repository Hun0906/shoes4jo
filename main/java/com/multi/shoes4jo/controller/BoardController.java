package com.multi.shoes4jo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.service.BoardService;
import com.multi.shoes4jo.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/list.do")
	public String list(Model model, @RequestParam(required = false) String category) {
		List<BoardVO> list;
		if (category != null && !category.isEmpty()) {
			list = boardService.selectOneCat(category);
		} else {
			list = boardService.selectList();
		}
		model.addAttribute("list", list);
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
			throws IOException {

		ServletContext context = request.getSession().getServletContext();
		String basePath = context.getRealPath("/assets/img");
		File currentDirPath = new File(basePath);

		String fileName = "";

		if (file != null && !file.isEmpty()) {
			fileName = file.getOriginalFilename();
			File uploadFile = new File(currentDirPath, fileName);
			file.transferTo(uploadFile);
		}

		board.setFile_path(fileName);

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
			throws IOException {

		if (file != null && !file.isEmpty()) {
			// 기존 이미지 삭제 로직 추가
			if (board.getFile_path() != null) {
				String realPath = request.getSession().getServletContext().getRealPath("/assets/img");
				File oldFile = new File(realPath, board.getFile_path());
				if (oldFile.exists()) {
					oldFile.delete();
				}
			}
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			String newFileName = System.currentTimeMillis() + "." + extension;

			// 파일 이름 및 확장자 설정 (newFileName)
			File currentDirPath = new File(request.getSession().getServletContext().getRealPath("/assets/img"));

			// 새로운 파일 업로드 (newFileName)
			File uploadFile = new File(currentDirPath, newFileName);
			file.transferTo(uploadFile);

			// 파일 경로를 VO에 설정 (newFileName)
			board.setFile_path(newFileName);
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
