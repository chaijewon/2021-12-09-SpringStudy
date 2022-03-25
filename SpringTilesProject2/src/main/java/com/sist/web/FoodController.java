package com.sist.web;

import org.springframework.stereotype.Controller;
// 화면 이동 => 데이터제어 (자바스크립트에서 제어)
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FoodController {
    @GetMapping("food/search.do")
    public String food_search()
    {
    	return "food/search";
    }
}
