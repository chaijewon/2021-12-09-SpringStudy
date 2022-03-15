package com.sist.web;
//Model (요청 처리)

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.MemberVO;

//@Controller //Model 클래스 
public class MainController {
   // 요청 => 입력폼 제작 
   @RequestMapping("main/input.do")
   public String main_input(HttpServletRequest request,
		   HttpServletResponse response)
   {
	   return "main/input";
   }
   // 사용자 입력 => 전송 출력 
   // 스프링 
   /*
    *    @RequestMapping (GET+POST)
    *    ---------------
    *      = @GetMapping
    *      = @PostMapping 
    *    HttpServletRequest,HttpServletResponse는 보안상의 문자 
    *    --------------------------------------
    *       접속자의 IP , 브라우저 (가급적이면 사용하지 않는다)
    *    => DispatcherServlet에서 값을 전송 (매개변수) 
    *    => 해당 JSP값을 전송 (Model)
    *    => command객체 => VO단위로 값을 받을 수 있다
    *    => 필요한 내장 객체 , 사용자가 요청한 값은 매개변수로 받는다 
    *    
    *    예) page ==> list.do?page=2
    *                        =====
    *       @RequestMapping()
    *       public String list_data(int page)
    *                                   =====
    *       => 데이터형 , 반드시 변수명이 일치 
    *       
    *       login.do?id=aaa&pwd=1234
    *       public String login(String id,String pwd) => DispatcherServlet에서 호출할때 데이터값을 주입 
    *       
    *       session이 필요한 경우
    *       public String login(HttpSession session) 
    *       
    *       커맨드 : 단위 VO 
    *       public String main_output(MemberVO vo)
    *       
    *       전송 객체 : request.setAttribute => model.addAttribute()
    *       class Model
    *       {
    *          HttpServletRequest request;
    *          public void addAttribute(String key,Object obj)
    *          {
    *              request.setAttribute(key,obj)
    *          }
    *       }
    *       
    *       ==> 메소드 : 매개변수 , 리턴형 
    *                          ------ String , void(다운로드)
    */
   @RequestMapping("main/output.do")
   public String main_output(HttpServletRequest request,
		   HttpServletResponse response)
   {
	   String name=request.getParameter("name");
	   String sex=request.getParameter("sex");
	   String addr=request.getParameter("addr");
	   String tel=request.getParameter("tel");
	   
	   MemberVO vo=new MemberVO();
	   vo.setName(name);
	   vo.setSex(sex);
	   vo.setAddr(addr);
	   vo.setTel(tel);
	   
	   request.setAttribute("vo", vo);
	   return "main/output";
   }
}







