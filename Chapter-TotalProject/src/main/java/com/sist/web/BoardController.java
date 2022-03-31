package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// DispatcherServlet => @Controller,@RestController
// 전송 : @Controller , => HandlerMapping =>   
import com.sist.vo.*;
import com.sist.dao.*;
import java.util.*;
@Controller
public class BoardController {
   // 멤버변수 => 스프링에 등록된 클래스중에 필요한 객체주소를 받아서 처리 
   // Autowired => 지역변수는 주소값을 받을 수 없다 (매개변수)
   @Autowired
   private BoardDAO dao;
   /*
    *   @Autowired
    *   public void display(BoardDAO dao)
    *   {
    *      @Autowired (X)
    *      BoardDAO dao;
    *   }
    */
   // @Autowired를 사용할때는 스프링에서 메모리 할당된 클래스에서만 사용이 가능 
   // 요청 처리 
   @GetMapping("food/board.do")
   public String food_board(String page,Model model)
   {
	   return "food/board";
   }
   
}











