package com.multi.shoes4jo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.multi.shoes4jo.service.board.BoardService;
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
		// 페이지 정보와 게시글 목록을 가져옴

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.listCount());
		// 총 게시글 개수를 가져와 페이지 메이커에 설정

		model.addAttribute("pageMaker", pageMaker);
		// 페이지메이커 객체를 모델에 추가해서 뷰로 실어보내줌

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
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session) throws Exception {

		// 사용자가 파일 첨부하지 않고 글을 쓸 경우를 처리하기 위한 코드
		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename(); // 원본 파일 이름을 가져옴
			String extension = FilenameUtils.getExtension(originalFilename); // 원본 파일의 확장자를 가져옴
			String newFileName = System.currentTimeMillis() + "." + extension; // 시스템 현재시간과 확장자를 이용하여 새로운 파일 이름 생성

			board.setFile_name(originalFilename); // 게시글 정보에 원본 파일 이름 설정
			board.setFile_path(newFileName);// 게시글 정보에 파일 경로를 새로 설정

			String realPath = session.getServletContext().getRealPath("assets/img/");// 실제 저장 경로 설정
			System.out.println("파일 저장 성공: " + realPath);// 저장 경로 어디로 해놨는지 출력해봄

			File newFile = new File(realPath, newFileName);

			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile); // 업로드된 이미지를 실제 저장 경로에 복사
		}

		boardService.insertOne(board); // BoardServiceImpl에 만들어놨던 새 게시글 DB에 저장하는 insertOne 메서드 호출

		return "redirect:/board/list.do"; // 목록 페이지로 리다이렉트
	}

	@RequestMapping("/update.do")
	public ModelAndView update(@RequestParam String bno) {
		BoardVO board = boardService.selectOne(bno);
		return new ModelAndView("board/board_update", "board", board);
	}

	@RequestMapping("/updateOk.do") // HTTP 요청 경로 설정
	public String updateOk(@ModelAttribute BoardVO board,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session) throws Exception {

		if (file != null && !file.isEmpty()) { // 만약 업로드된 파일이 존재하면
			String originalFilename = file.getOriginalFilename();// 원본 파일 이름을 가져옴
			String extension = FilenameUtils.getExtension(originalFilename);// 원본 파일의 확장자를 가져옴
			String newFileName = System.currentTimeMillis() + "." + extension; // 새로운 파일 이름을 생성 (현재 시간.확장자)

			board.setFile_name(originalFilename);
			board.setFile_path(newFileName);
			// 위에서 생성한 새로운 파일명과 원본파일명을 BoardVO 객체(board)에 설정

			BoardVO oldBoardData = boardService.selectOne(String.valueOf(board.getBno()));
			if (oldBoardData != null && oldBoardData.getFile_path() != null) {
				File oldFile = new File(session.getServletContext().getRealPath("assets/img/"),
						oldBoardData.getFile_path());
				if (oldFile.exists()) {
					oldFile.delete();
				}
			}
			String realPath = session.getServletContext().getRealPath("assets/img/");
			System.out.println("파일 저장 성공: " + realPath);
			// boardService에 있는 selectOne메서드로 번호에 해당하는 거 조회하고
			// 원래 데이터가 null이 아닐때 예전 파일을 새로운 파일로 교체하고(원래꺼 삭제) 파일 저장됐으면 realPath에 설정한 저장 경로
			// 콘솔창에 나오게 함

			File newFile = new File(realPath, newFileName);

			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
			} catch (IOException e) {
				e.printStackTrace();
			} // MultipartFile 객체에서 InputStream을 얻어와서 실제 경로에 해당 InputStream으로부터 읽은 데이터를 저장함
		} else {
			// 사용자가 이미지 업데이트 없이 다른 정보만 수정한거면 기존 이미지 정보 유지하게 함
			BoardVO oldBoardData = boardService.selectOne(String.valueOf(board.getBno()));
			if (oldBoardData != null) {

				board.setFile_name(oldBoardData.getFile_name());
				board.setFile_path(oldBoardData.getFile_path());
			}
		}

		// BoardService의 updateOne메서드 사용해서 DB에 수정한 정보 저장
		boardService.updateOne(board);

		return "redirect:/board/list.do";
	} // 게시글 목록 페이지로 리다이렉트

	@RequestMapping("/delete.do")
	public String deleteOk(@RequestParam String bno) {
		boardService.deleteOne(bno);
		return "redirect:/board/list.do";
	}
}
