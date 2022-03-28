package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
@RestController
public class FoodReplyRestController {
   // 문제 => Singleton에 대한 설명 => 스프링에서 사용하고 있는 패턴을 종류 
   // 싱글턴 , 팩토리 , 어뎁터패턴 (형변환 통일)=> HandlerAdapter , 프록시(대리자) : 위빙, 옵버저(이벤트발생 서버에 알려주는)....
   @Autowired
   private FoodReplyDAO dao;
   
   // 결과값만 보내는 상태 => Rest , 객체(JSON)
   // Spring-Boot => 자동으로 JSON처리 (jackson-bind) => react/redux , vuejs => 웹스톰(nodejs)
   // 스프링 => 자바 (jdk)
   @PostMapping("food/login_ok.do")
   public String food_login_ok(String id,String pwd,HttpSession session)
   {
	   //1. 정보받기 
	   String result=dao.isLogin(id, pwd);
	   if(!(result.equals("NOID")&& result.equals("NOPWD")))
	   {
		   // 로그인이 된 상태 
		   session.setAttribute("id", id);
		   session.setAttribute("name", result);
	   }
	   return result;
	   
   }
}








