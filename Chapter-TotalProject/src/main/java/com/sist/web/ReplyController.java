package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class ReplyController {
   @Autowired
   private FoodReplyDAO dao;
   
   @GetMapping("food/login.do")
   public String food_login()
   {
	   return "food/login";
   }
   
   @GetMapping("food/logout.do")
   public String food_logout(HttpSession session)
   {
	   session.invalidate();
	   return "redirect:login.do";
   }
   
   @PostMapping("food/reply_insert.do")
   public String food_reply_insert(int fno,String msg,
		   RedirectAttributes ra,HttpSession session)
   {
	   System.out.println("fno="+fno);
	   /* 
	    * RedirectAttributes => redirect:a.do => a.do에 전송시에 사용
	    *                       sendRedirect => 데이터만 전송 
	    * Model => "food/main" (forward => request를 전송)
	    *   
	    */
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   FoodReplyVO vo=new FoodReplyVO();
	   vo.setFno(fno);
	   vo.setId(id);
	   vo.setName(name);
	   vo.setMsg(msg);
	   
	   dao.replyInsert(vo);
	   ra.addAttribute("no", fno);
	   return "redirect:detail.do";
   }
   
   @PostMapping("food/reply_update.do")
   public String food_reply_update(FoodReplyVO vo,String msg,
		   RedirectAttributes ra)
   {
	   //DAO만 연결 
	   dao.replyUpdate(vo);
	   ra.addAttribute("no", vo.getFno());
	   return "redirect:detail.do";
   }
   /*
    *   1. GET / POST (@PostMapping) => 데이터가 많은 경우 (<form>)
    *     =====
    *     @GetMapping (화면 이동 ,단순한 데이터 => page , no = <a>)
    *   2. 메소드명은 어떤 이름이든 상관없다 (식별자)
    *   3. 매개변수 
    *      일반 변수 
    *      ?no=1  => (int no)
    *      ?title=aaa => (String title)
    *      => (~VO vo) => 컨맨드 객체 
    *      스프린에서 제공하는 객체 
    *      RedirectAttributes : redirect => 사용시에 전송
    *      Model : foreward => request에 값을 담아서 JSP로 전송 
    *      HttpServletRequest => Cookie값 읽는 경우 
    *        Cookie[] cook=request.getCookies()
    *      HttpServletResponse => Cookie를 클라이언트 전송 
    *                             파일업로드시 
    *         Cookie cookie=new Cookie("key","value")
    *         response.addCookie(cookie)
    *      HttpSession : id,name...
    *      ============================ 
    *         매개변수로 설정 => DisaptcherServlet에 의해 매개변수값이 채워진다 
    *         매개변수는 순서가 없다 
    *         ====== 메소드 수행에 필요한 모든 데이터를 설정 
    */
   @PostMapping("food/reply_reply_insert.do")
   public String food_reply_reply_insert(int pno,FoodReplyVO vo,
		   RedirectAttributes ra,HttpSession session)
   {
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   vo.setId(id);
	   vo.setName(name);
	   dao.replyReplyInsert(pno, vo);
	   ra.addAttribute("no", vo.getFno());
	   return "redirect:detail.do";
   }
   @GetMapping("food/reply_delete.do")
   public String food_reply_delete(int no,int fno,RedirectAttributes ra)
   {
	   // 웹 => 접속자 전체 같은 데이터를 보고 있어야 된다 
	   // 데이터베이스 (공유된 데이터) => 데이터베이스 80~90% 스프링 가능자 , 데이터베이스 가능자
	   // 60% => MySQL , MariaDB => 데이터형 , 함수 , 사용방법이 다르다  
	   // MySQL => 약간 (3차) NVL => ifnull 
	   // 삭제처리 
	   dao.replyDelete(no);
	   // 이동 
	   ra.addAttribute("no", fno); //fno => 맛집 번호 
	   return "redirect:detail.do";
   }
}









