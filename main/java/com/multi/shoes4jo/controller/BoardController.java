package com.multi.shoes4jo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
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
import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.util.PageMaker;
import com.multi.shoes4jo.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/list.do")
	public String list(Model model, Criteria cri) throws Exception {
		List<BoardVO> list = boardService.listPage(cri);
		model.addAttribute("list", list);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.listCount());

		model.addAttribute("pageMaker", pageMaker);

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

		// 파일이 비어있지 않은 경우
		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename(); // 원본 파일 이름을 가져옴
			String extension = FilenameUtils.getExtension(originalFilename); // 원본 파일의 확장자를 가져옴
			String newFileName = System.currentTimeMillis() + "." + extension; // 새로운 파일 이름 생성

			board.setFile_name(originalFilename); // 보드의 파일 이름을 새로운 파일 이름으로 설정
			board.setFile_path(newFileName); // 보드의 파일 경로를 새로운 파일 경로로 설정

			String realPath = request.getServletContext().getRealPath("assets/img/");
			System.out.println("파일 저장 성공: " + realPath);

			File newFile = new File(realPath, newFileName);

			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile); // 새로 업로드된 이미지 경로에 저장
		}

		boardService.insertOne(board); // 게시글 DB에 저장하는 메서드 호출

		return "redirect:/board/list.do"; // 목록 페이지로 리다이렉트
	}

	@RequestMapping("/update.do")
	public ModelAndView update(@RequestParam String bno) {
		BoardVO board = boardService.selectOne(bno);
		return new ModelAndView("board/board_update", "board", board);
	}

	@RequestMapping("/updateOk.do")
	public String updateOk(@ModelAttribute BoardVO board,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpServletRequest request) {

		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			String newFileName = System.currentTimeMillis() + "." + extension;

			board.setFile_name(originalFilename);
			board.setFile_path(newFileName);
			// 파일이 비어있지 않으면 원본 파일명,확장자 가져오고 새 파일 이름 생성->보드에 새 파일명,파일 경로로 설정

			BoardVO oldBoardData = boardService.selectOne(String.valueOf(board.getBno()));
			if (oldBoardData != null && oldBoardData.getFile_path() != null) {
				File oldFile = new File(request.getServletContext().getRealPath("assets/img/"),
						oldBoardData.getFile_path());
				if (oldFile.exists()) {
					oldFile.delete();
				}
			}
			// 이전 파일이 null값이 아니면 삭제하기
			String realPath = request.getServletContext().getRealPath("assets/img/");
			System.out.println("파일 저장 성공: " + realPath);
			// boardService에 있는 selectOne메서드로 번호에 해당하는 거 조회하고
			// 원래 데이터가 null이 아닐때 예전 파일을 새로운 파일로 교체하고(원래꺼 삭제) 파일 저장됐으면 realPath에 설정한 저장 경로
			// 콘솔창에 나오게 함

			File newFile = new File(realPath, newFileName);

			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			BoardVO oldBoardData = boardService.selectOne(String.valueOf(board.getBno()));
			if (oldBoardData != null) {
				// 새로 업로드 한 이미지를 경로에 저장. 이미지 업데이트 안했으면 기존 이미지 정보 유지함
				board.setFile_name(oldBoardData.getFile_name());
				board.setFile_path(oldBoardData.getFile_path());
			}
		}

		// BoardService의 selectOne메서드(게시물 번호에 해당하는거 가져오는거)사용해서 DB에 업데이트 된 정보 저장
		boardService.updateOne(board);

		return "redirect:/board/list.do";
	} // 게시글 목록 페이지로 리다이렉트

	@RequestMapping("/delete.do")
	public String deleteOk(@RequestParam String bno) {
		boardService.deleteOne(bno);
		return "redirect:/board/list.do";
	}
}
