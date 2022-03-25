package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// 화면 이동 => 데이터제어 (자바스크립트에서 제어)
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FoodController {
    @GetMapping("food/search.do")
    public String food_search()
    {
    	return "food/search";
    }
    @GetMapping("food/detail.do")
    public String food_detail(int no,Model model)
    {
    	model.addAttribute("no", no);
    	return "food/detail";
    }
}
