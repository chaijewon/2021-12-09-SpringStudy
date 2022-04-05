package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// feeboard폴더에 있는 jsp와 연결 
// @Controller, @RestController => 유일하게 DispatcherServlet (웹)
// DispatcherServlet : 1. 요청받기 , 2. 요청 결과값을 전송 
// 요청 결과를 읽어 온다 => Manager,DAO 
// 스프링에서 조립기 (기능) => 자바 (main())
// ========================================= Model
// Model => 스프링에서는 처리하는 모든 권한을 위임 => Controller
// DispatcherServlet
// ---------- 배달부 
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Controller
@RequestMapping("freeboard/")
public class FreeBoardController {
   @Autowired
   private BoardDAO dao;
   
   // 기능 처리 => 요청  => @RequestMapping , @GetMapping , @PostMapping
   @GetMapping("list.do")
   public String freeboard_list(String page,Model model)
   {
	// String s=request.getParameter("page")
	   // 웹에서 나오는 모든 데이터형은 String
	   // Integer.parseInt(null) => 오류
	   // 사용자 보내준 데이터 => 매개변수 (DispatcherServlet)
	   // Model은 전송할 데이터가 있는 경우에만 사용 (전송객체) => request,response사용하지 않는다 
       if(page==null)
    	   page="1";  // 매개변수 => 모든 데이터는 String으로 받을 수 있다 
       // 데이터형 변경 => int,double....
       // 사용자가 첫페이지에서는 보내주지 않는 값이 있다 (page) => null (String)
       int curpage=Integer.parseInt(page);
       Map map=new HashMap();
       // #{start} , #{end} 
       int rowSize=10;
       int start=(rowSize*curpage)-(rowSize-1); //rownum은 1번부터 시작 
       int end=rowSize*curpage; // rownum => 중간에서 데이터를 추출 할 수 없다 (Top-N)
       // MySQL => limit 1,10 , 11,10... limit ?,? 
       map.put("start", start);
       map.put("end", end);
       List<BoardVO> list=dao.boardListData(map);
      
       int totalpage=dao.boardTotalPage();
       
       int count=dao.boardRowCount();
       count=count-((curpage*rowSize)-rowSize);// 일괄처리 (번호 순서대로 수행)
       // 블록별 처리 
       final int BLOCK=3;
       int startPage=((curpage-1)/BLOCK*BLOCK)+1;
       // curpage => 1,10  ==> startPage=1
       // curpage => 11,20 ==> startPage=11
       int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
       // curpage => 1,10  ==> endPage=10
       // curpage => 11,20 ==> endPage=20
       
       if(endPage>totalpage)
    	   endPage=totalpage; // 마지막 페이지 
       
       // 화면 출력한 데이터 => 모아서 => list.jsp로 전송 
       model.addAttribute("list", list);
       model.addAttribute("curpage", curpage);
       model.addAttribute("totalpage", totalpage);
       model.addAttribute("startPage", startPage);
       model.addAttribute("endPage", endPage);
       model.addAttribute("count", count);
       // 프로그램 => 책읽기 => 반복 , 숙달 (1~3년 누적 => 발전없어 보인다 => 3년)
       // 5년 => 초급 , 6년 => 중급 ...
	   return "freeboard/list";
   }
   
   @GetMapping("insert.do")
   public String freeboard_insert()
   {
	   return "freeboard/insert"; // forward => request를 전송할 목적 
   }
   @PostMapping("insert_ok.do")
   public String freeboard_insert_ok(BoardVO vo)
   {
	   dao.boardInsert(vo);
	   return "redirect:list.do"; // request를 초기화 => 화면 재전송 
   }
   // ?no=10 => 사용자가 보내는 값 => 매개변수로 받는다 
   @GetMapping("detail.do")
   public String freeboard_detail(int no,Model model)
   {
	   //DAO연동 
	   BoardVO vo=dao.boardDetailData(no);
	   model.addAttribute("vo", vo);
	   return "freeboard/detail";
   }
   
   @GetMapping("update.do")
   public String freeboard_update(int no,Model model)
   {
	   //DAO연동 
	   BoardVO vo=dao.boardUpdateData(no);
	   model.addAttribute("vo", vo);
	   return "freeboard/update";
   }
   
   @GetMapping("delete.do")
   public String freeboard_delete(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "freeboard/delete";
   }
   
}










