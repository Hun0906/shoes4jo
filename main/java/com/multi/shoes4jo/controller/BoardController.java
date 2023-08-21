package com.multi.shoes4jo.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
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
import com.multi.shoes4jo.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@Autowired
	HttpServletRequest request;

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
		List<BoardVO> newslist = boardService.selectNews();
		List<BoardVO> eventslist = boardService.selectEvents();
		List<BoardVO> columnslist = boardService.selectColumns();
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
			@RequestParam(name = "file", required = false) MultipartFile file) throws IOException {

		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			String newFileName = System.currentTimeMillis() + "." + extension;
			board.setFile_path(newFileName);
			String realPath = request.getSession().getServletContext().getRealPath("/") + "/assets/img";

			File newFile = new File(realPath, newFileName);
			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
//이미지 크기 지정
			resizeImage(newFile, newFile, 512, 512);
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
			@RequestParam(name = "file", required = false) MultipartFile file) throws IOException {

		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			String newFileName = System.currentTimeMillis() + "." + extension;
			board.setFile_path(newFileName);
			String realPath = request.getSession().getServletContext().getRealPath("/") + "/assets/img";

			File newFile = new File(realPath, newFileName);

			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);

			resizeImage(newFile, newFile, 512, 512);
		}

		boardService.updateOne(board);
		return "redirect:/board/list.do";
	}

	private void resizeImage(File inputFile, File outputFile, int newWidth, int newHeight) throws IOException {
		BufferedImage originalImage = ImageIO.read(inputFile);
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
		g.dispose();

		ImageIO.write(resizedImage, "JPEG", outputFile);
	}

	@RequestMapping("/delete.do")
	public String deleteOk(@RequestParam String bno) {
		boardService.deleteOne(bno);
		return "redirect:/board/list.do";
	}
}
