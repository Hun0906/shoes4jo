package com.multi.shoes4jo.goodsdetail;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.shoes4jo.bookmark.BookmarkService;
import com.multi.shoes4jo.bookmark.BookmarkVO;
import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.util.PageMaker;

@Controller
@RequestMapping("/goodscon")
public class GoodsDetailController {

	@Autowired
	private GoodsDetailService service;

	@Autowired
	private BookmarkService bookmarkService;

	@RequestMapping(value = "/list.do") // 상품 전체 목록 조회
	public String showList(Model model, Criteria cri) {
		List<GoodsDetailVO> goods_list = service.selectAllGoods(cri);
		model.addAttribute("goods_list", goods_list);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount()); 

		model.addAttribute("pageMaker", pageMaker);

		return "/admin/goods_list";
	}

	@RequestMapping(value = "/view.do") // 특정 상품 조회
	public String view(HttpServletRequest request, String keyword, Model model) {
		List<GoodsDetailVO> goodsList = service.selectOne(keyword);
		model.addAttribute("goods_list", goodsList);

		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("memberInfo");
		List<BookmarkVO> bookmark_list = bookmarkService.getAllBookmarks(member_id);
		if (bookmark_list.size() != 0 && goodsList.size() != 0) {
			for (BookmarkVO bookmark : bookmark_list) {
				if (bookmark.getGno() == goodsList.get(0).getGno()) {
					model.addAttribute("img", "heart");
					return "/goods/goods_detail";
				}
			}
		}

		model.addAttribute("img", "emptyheart");
		return "/goods/goods_detail";
	}

	@RequestMapping(value = "/insert.do")
	public String insert() {
		return "/goods/goods_add";
	}

	@RequestMapping(value = "/insertOk.do")
	public String insertOk(GoodsDetailVO vo) {
		service.insert(vo);
		return "redirect:/goodscon/list.do";
	}

	@RequestMapping(value = "/update.do")
	public String update(String keyword, Model model) {
		List<GoodsDetailVO> goods = service.selectOne(keyword);
		if (!goods.isEmpty()) {
			model.addAttribute("goods", goods.get(0));
		}
		return "goods/goods_update";
	}

	@RequestMapping(value = "/updateOk.do")
	public String updateOk(GoodsDetailVO vo) {
		service.update(vo);
		return "redirect:/goodscon/list.do";
	}

	@RequestMapping(value = "/delete.do")
	public String delete(int gno) {
		service.delete(gno);
		return "redirect:/goodscon/list.do";
	}

	@RequestMapping(value = "/deleteByKeyword.do")
	public String deleteByKeyword(String keyword) {
		service.deleteByKeyword(keyword);
		return "redirect:/goodscon/list.do";
	}
}