package com.multi.shoes4jo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.service.goods.GoodsDetailService;
import com.multi.shoes4jo.vo.GoodsDetailVO;

@Controller
@RequestMapping("/goodscon")
public class GoodsDetailController {

    @Autowired
    private GoodsDetailService service;

    @RequestMapping(value = "/list.do") //상품 전체 목록 조회
    public String showList(Model model) {
        List<GoodsDetailVO> goods_list = service.selectAllGoods();
        model.addAttribute("goods_list", goods_list);
        return "/admin/goods_list";
    }


    @RequestMapping(value = "/view.do") //특정 상품 조회
    public ModelAndView view(String goods_id) {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("goods/goods_detail");
    	mv.addObject("goodsInfo", service.selectOneGoods(goods_id));
    	return mv;
    }

    @RequestMapping(value = "/insert.do")
    public String insert(GoodsDetailVO vo) {
        service.insertGoods(vo);
        return "redirect:/goodscon/view.do"; 
        
    }

    @RequestMapping(value = "/update.do")
    public String update(GoodsDetailVO vo) {
        service.updateGoods(vo);
        return "redirect:goods/goods_detail?goods_id=" + vo.getGoods_id();
    }

    @RequestMapping(value = "/delete.do")
    public String delete(String goods_id) {
        service.deleteGoods(goods_id);
        return "redirect:/goodscon/view.do"; 
    }
}
