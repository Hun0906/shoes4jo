package com.multi.shoes4jo.freeboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/freeboard")
public class FreeBoardController {

	@Autowired
	FreeBoardService service;

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

		List<FreeBoardVO> list = service.listPage(cri);
		model.addAttribute("list", list);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount(cri.getSearchType(), cri.getKeyword()));

		model.addAttribute("pageMaker", pageMaker);

		return "freeboard/freeboard_list";
	}

	@RequestMapping(value = "/category.do")
	public String category(@RequestParam("category") String category, Model model) {
		List<FreeBoardVO> list = service.selectCat(category);
		model.addAttribute("list", list);
		model.addAttribute("selectedCategory", category);
		return "freeboard/freeboard_list";
	}

	@RequestMapping(value = "/myBoardList.do")
	public String myBoard(HttpServletRequest request, HttpServletResponse response, Model model, Criteria cri)
			throws Exception {

		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("memberInfo");

		List<FreeBoardVO> freeboardList = service.myBoardList(member_id, cri);
		model.addAttribute("freeboardList", freeboardList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountMember(member_id));

		model.addAttribute("pageMaker", pageMaker);

		return "member/my_board_list";
	}

	@RequestMapping(value = "/write.do")
	public String write(HttpSession session, HttpServletRequest request) {
		String member_id = (String) session.getAttribute("memberInfo");
		if (member_id == null) {
			request.setAttribute("msg", "로그인이 필요한 기능입니다.");
			request.setAttribute("url", "../login");
			return "msg";
		}
		return "freeboard/freeboard_write";
	}

	@RequestMapping("/writeOk.do")
	public String writeOk(@ModelAttribute FreeBoardVO vo,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session,
			HttpServletRequest request) throws Exception {

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

		service.insert(vo);

		request.setAttribute("msg", "새 글 등록에 성공하였습니다.");
		request.setAttribute("url", "../freeboard/list.do");

		return "msg";
	}

	@RequestMapping(value = "/view.do")
	public ModelAndView view(@RequestParam int fno) {
		service.updateviewcnt(fno);
		FreeBoardVO vo = service.select(fno);
		ModelAndView mav = new ModelAndView("freeboard/freeboard_view");
		mav.addObject("freeboard", vo);
		return mav;
	}

	@RequestMapping("/update.do")
	public String update(@RequestParam int fno, HttpSession session, HttpServletRequest request) {
		FreeBoardVO vo = service.select(fno);
		request.setAttribute("freeboard", vo);
		return "freeboard/freeboard_update";
	}

	@RequestMapping("/updateOk.do")
	public String updateOk(@ModelAttribute FreeBoardVO vo,
			@RequestParam(name = "file", required = false) MultipartFile file, HttpSession session,
			HttpServletRequest request) throws Exception {

		if (file != null && !file.isEmpty()) {
			// 기존 파일이 있으면 삭제
			FreeBoardVO oldBoardData = service.select(vo.getFno());
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
			FreeBoardVO oldBoardData = service.select(vo.getFno());
			vo.setFile_name(oldBoardData.getFile_name());
			vo.setFile_path(oldBoardData.getFile_path());
		}

		service.update(vo);

		request.setAttribute("msg", "글 수정에 성공하였습니다.");
		request.setAttribute("url", "../freeboard/list.do");

		return "msg";
	}

	@RequestMapping("/delete.do")
	public String deleteOk(@RequestParam int fno, HttpSession session) {
		FreeBoardVO vo = service.select(fno);
		if (vo.getFile_path() != null) {
			java.io.File file = new java.io.File(session.getServletContext().getRealPath("assets/img/"),
					vo.getFile_path());
			if (file.exists()) {
				file.delete();
			}
		}

		service.delete(fno);
		return "redirect:/freeboard/list.do";
	}
}