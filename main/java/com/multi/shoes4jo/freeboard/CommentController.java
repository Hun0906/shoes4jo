package com.multi.shoes4jo.freeboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService service;

	@ResponseBody
	@RequestMapping("/insert.do")
	public String insert(@RequestBody CommentVO vo, HttpServletRequest request, HttpSession session) {
		System.out.println("댓글 등록 요청" + vo.toString());

		String member_id = (String) session.getAttribute("memberInfo");

		System.out.println("아이디 : " + member_id);

		if (member_id == null) {
			System.out.println("로그인이 필요한 기능입니다.");
			request.setAttribute("msg", "로그인이 필요한 기능입니다.");
			request.setAttribute("url", "/login");
			return "redirect:/login";
		}

		service.insert(vo);

		System.out.println("아이디: " + vo.getMember_id() + ", 댓글 내용: " + vo.getContent());
		System.out.println("댓글 등록 성공");

		return "insertOk";
	}

	@ResponseBody
	@RequestMapping("/CommentList/{fno}")
	public Map<String, Object> getList(@PathVariable int fno, Model model) {
		System.out.println("댓글 목록 컨트롤러 동작");
		System.out.println("글 번호: " + fno);

		List<CommentVO> list = service.commentList(fno);
		int total = service.getTotal(fno);

		System.out.println("댓글 수: " + list.size());

		ModelAndView view = new ModelAndView();

		view.setViewName("/freeboard/freeboard_view");
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("total", total);

		return map;
	}

	@RequestMapping("/myCommentList.do")
	public ModelAndView myRecord(HttpSession session) {
	    String member_id = (String) session.getAttribute("memberInfo");
	    List<CommentVO> list = service.myComment(member_id);

	    Map<String, Object> map = new HashMap<>();
	    map.put("list", list);
	    map.put("total", list.size());

	    return new ModelAndView("/member/my_comment_list", map);
	}


	@ResponseBody
	@RequestMapping("/update.do/{cno}")
	public String update(@PathVariable int cno, @RequestBody CommentVO vo) {
		service.update(vo);

		System.out.println("댓글 번호: " + vo.getCno() + ", 수정 내용: " + vo.getContent());
		System.out.println("댓글 수정 성공");

		return "updateOk";
	}

	@ResponseBody
	@RequestMapping("/delete.do/{cno}")
	public String delete(@PathVariable int cno) {
		service.delete(cno);

		return "deleteOk";
	}
}
