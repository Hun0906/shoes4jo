package com.multi.shoes4jo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.shoes4jo.service.goods.GoodsDetailService;
import com.multi.shoes4jo.vo.GoodsDetailVO;

@Controller
@RequestMapping("/goodscon")
public class GoodsDetailController {

	@Autowired
	private GoodsDetailService service;

	@RequestMapping(value = "/list.do") // 상품 전체 목록 조회
	public String showList(Model model) {
		List<GoodsDetailVO> goods_list = service.selectAllGoods();
		model.addAttribute("goods_list", goods_list);
		return "/admin/goods_list";
	}

	@RequestMapping(value = "/view.do") // 특정 상품 조회
	public String view(String keyword, Model model) {
	    List<GoodsDetailVO> goodsList = service.selectOne(keyword);
	    model.addAttribute("goods_list", goodsList);
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
}
