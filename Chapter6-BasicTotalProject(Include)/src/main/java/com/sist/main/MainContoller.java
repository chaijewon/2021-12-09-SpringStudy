package com.sist.main;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.sist.dao.*;
@Controller
public class MainContoller {
   @Autowired
   private MemberDAO dao;
   @GetMapping("main/main.do")
   public String main_main(Model model)
   {
	   model.addAttribute("main_jsp", "../main/home.jsp");
	   return "main/main";
   }
   @GetMapping("etc/news/list.do")
   public String news_list(Model model)
   {
	   model.addAttribute("main_jsp", "../etc/news/list.jsp");
	   return "main/main";
   }
   @PostMapping("main/login.do")
   // 요청을 받아서 오라클 연결후에 요청을 처리 = 결과값을 전송  : Model
   public String main_login(String id,String pwd,HttpSession session,Model model)
   {
	   /*
	    *   session: 서버에 사용자의 일부 정보 저장 => 모든 JSP에서 사용이 가능하게 만든다 
	    *   session을 받는 방법 
	    *     1) 매개변수로 DispatcherServlet으로부터 받는다 (*****)
	    *     main_login(HttpSession session)
	    *     2) HttpServletRequest를 이용해서 생성해서 사용하는 방법 
	    *     main_login(HttpServletRequest request)
	    *       => HttpSession session=request.getSession()
	    *       => 매개변수 => 내장 객체는 DispatcherServlet에서 전송이 가능 
	    *          ------ HttpServletRequest,HttpServletResponse,HttpSession
	    *          ------ RedirectAttributes , Model 
	    *          ------ 사용자가 전송한 값 
	    *   session 주요기능 
	    *   1. 저장  : session.setAttribute(키,값)
	    *   2. 데이터 읽기 : session.getAttribute(키)
	    *   3. 삭제 : invalidate()
	    *   4. 저장 기간 : setMaxactiveInterval(초) => 기본 단위는 1800초 (30분)
	    *   5. 일부 삭제 : session.removeAttribute("키")
	    */
	   int count=dao.idCount(id);
	   String result="";
	   if(count==0) // ID가 없는 상태
	   {
		   result="NOID";
	   }
	   else
	   {
		   String db_pwd=dao.getPassword(id);
		   if(db_pwd.equals(pwd))//로그인 
		   {
			   String name=dao.memberGetName(id);
			   // session에 저장 
			   session.setAttribute("id", id);
			   session.setAttribute("name", name);
			   result="OK";
		   }
		   else //비밀번호가 틀린 상태 
		   {
			   result="NOPWD";
		   }
	   }
	   
	   model.addAttribute("result", result);
	   // Model => request대신사용하는 전송 객체
	   return "main/login";
   }
   @PostMapping("main/logout.do")
   public String main_logout(String id,String pwd,HttpSession session)
   {
	   session.invalidate();// 로그아웃 (session에 있는 모든 데이터를 메모리에서 삭제
	   return "redirect:main.do";
   }
}
