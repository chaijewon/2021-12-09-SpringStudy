package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Controller
// 요청 => 처리 => JSP전송 (jsp파일명 지정)
/*
 *   forward(파일명)
 *   sendRedirect(재전송: .do)
 */
/*
 *   1. Controller (Model) 
 *   1) class위에 반드시 @Controller 설정 
 *   2) 필요한 객체를 스프링으로부터 자동 설정 
 *      @Autowired
        private FoodService service;
     3) 기능별 분리 
        @RequestMapping, @GetMapping , @PostMapping 
                  String 메소드()
                  {
                     1. 데이터베이스 연결 => 데이터 읽기
                     2. model을 통해서 JSP전송 
                     3. 데이터받는 JSP을 지정 
                  }
                  void 메소드()
                  
 */
public class FoodController {
   // 필요한 객체 선언 => 자동 주입 
   @Autowired
   private FoodService service;
   
   @GetMapping("food/category.do")
   public String food_category(Model model)
   {
	   //1.dao연동 
	   List<CategoryVO> list=service.categoryAllData();
	   //2.category.jsp에 데이터를 전송 
	   model.addAttribute("list", list);
	   return "food/category";
   }
   
   @GetMapping("food/food_list.do")
   public String food_list(int cno,Model model)
   {
	   model.addAttribute("cno", cno);
	   return "food/food_list";
   }
   
   @GetMapping("food/food_find.do")
   public String food_find()
   {
	   return "food/food_find";
   }
}











