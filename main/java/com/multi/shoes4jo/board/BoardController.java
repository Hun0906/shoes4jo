package com.multi.shoes4jo.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.util.PageMaker;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService service;

	@RequestMapping(value = "/list.do")
	public String list(Model model, Criteria cri, HttpServletRequest request) throws Exception {

		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");

		if (searchType == null || searchType.isEmpty()) {
			cri.setSearchType("title");
		} else {
			cri.setSearchType(searchType);
		}

		if (keyword != null && !keyword.isEmpty()) {
			cri.setKeyword(keyword);
		}

		List<BoardVO> list = service.listPage(cri);
		model.addAttribute("list", list);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount(cri.getSearchType(), cri.getKeyword()));

		model.addAttribute("pageMaker", pageMaker);

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
	public ModelAndView view(@RequestParam int bno) {
		service.updateviewcnt(bno);
		BoardVO board = service.selectOne(bno);
		return new ModelAndView("board/board_view", "board", board);
	}

	@RequestMapping(value = "/write.do")
	public String write() {
		return "board/board_write";
	}

	@RequestMapping("/writeOk.do")
	public String writeOk(@ModelAttribute BoardVO vo, @RequestParam(name = "file", required = false) MultipartFile file,
			HttpSession session) throws Exception {

		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			String newFileName = System.currentTimeMillis() + "." + extension;

			vo.setFile_name(originalFilename);
			vo.setFile_path(newFileName);

			java.io.File newFile = new java.io.File(session.getServletContext().getRealPath("assets/img/"),
					newFileName);

			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
			System.out.println("파일 저장 성공: " + newFile.getAbsolutePath());
		}

		service.insertOne(vo);

		return "redirect:/board/list.do";
	}

	@RequestMapping("/update.do")
	public ModelAndView update(@RequestParam int bno) {
		BoardVO vo = service.selectOne(bno);
		return new ModelAndView("board/board_update", "board", vo);
	}

	@RequestMapping("/updateOk.do")
	public String updateOk(@ModelAttribute BoardVO vo,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session) throws Exception {

		if (file != null && !file.isEmpty()) {
			// 기존 파일이 있으면 삭제
			BoardVO oldBoardData = service.selectOne(vo.getBno());
			if (oldBoardData.getFile_path() != null) {
				java.io.File oldFile = new java.io.File(session.getServletContext().getRealPath("assets/img/"),
						oldBoardData.getFile_path());
				if (oldFile.exists()) {
					oldFile.delete();
				}
			}

			// 새로운 파일 업로드
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			String newFileName = System.currentTimeMillis() + "." + extension;

			vo.setFile_name(originalFilename);
			vo.setFile_path(newFileName);

			java.io.File newFile = new java.io.File(session.getServletContext().getRealPath("assets/img/"),
					newFileName);

			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
			System.out.println("파일 저장 성공: " + newFile.getAbsolutePath());

		} else {
			BoardVO oldBoardData = service.selectOne(vo.getBno());
			vo.setFile_name(oldBoardData.getFile_name());
			vo.setFile_path(oldBoardData.getFile_path());
		}

		service.updateOne(vo);

		return "redirect:/board/list.do";
	}

	@RequestMapping("/delete.do")
	public String deleteOk(@RequestParam int bno, HttpSession session) {
		BoardVO vo = service.selectOne(bno);
		if (vo.getFile_path() != null) {
			java.io.File file = new java.io.File(session.getServletContext().getRealPath("assets/img/"),
					vo.getFile_path());
			if (file.exists()) {
				file.delete();
			}
		}

		service.deleteOne(bno);
		return "redirect:/board/list.do";
	}
}
