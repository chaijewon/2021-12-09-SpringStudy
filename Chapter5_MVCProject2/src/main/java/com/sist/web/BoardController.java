package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;
@Controller
@RequestMapping("board/")
public class BoardController {
   @Autowired
   private BoardDAO dao;
   
   @GetMapping("list.do")
   // 모든 데이터는 필요에 따라 String으로 받을 수 있다 
   public String board_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   //int curpage=page;
	   int rowSize=10;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   Map map=new HashMap();
	   map.put("start",start);
	   map.put("end",end);
	   List<BoardVO> list=dao.boardListData(map);
	   int totalpage=dao.boardTotalPage();
	   
	   model.addAttribute("totalpage", totalpage);
	   // request.setAttribute("totalpage", totalpage)
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   return "board/list";//forward() => request를 전송 
   }
   @GetMapping("insert.do")
   public String board_insert()
   {
	   return "board/insert";
   }
   /*
    *   1. 일반 변수 : int,double .... String 
    *   2. VO객체 (객체단위)
    *   3. 배열 (String[] hobby)
    *   4. List로 값을 받는다
    *      <input type=file name=file[0]>
    *      <input type=file name=file[1]>
    *      <input type=file name=file[2]>
    */
   @PostMapping("insert_ok.do")
   public String board_insert_ok(BoardVO vo)//커맨드 객체 => 
   // 회원가입 , 글쓰기 , 수정 , 답변 => name="" vo에 있는 변수명이 동일 
   {
	   // redirect => request전송이 가능 => RedirectAttributes 
	   // PathValiable 
	   dao.boardInsert(vo);
	   return "redirect:list.do";//sendRedirect() => request전송이 없는 경우
   }
   // detail.do?no=${vo.no }
   @GetMapping("detail.do")
   // request.getParameter("no") => X , DispatcherServlet => 받아서 매개변수로 주입
   // 데이터형을 맞게 설정 , String 
   public String board_detail(int no,Model model)
   {
	   BoardVO vo=dao.boardDetailData(no);
	   model.addAttribute("vo", vo);// 전송 객체 => 해당 JSP 값울 전송 
	   return "board/detail";
   }
   // update.do?no=${vo.no }
   @GetMapping("update.do")
   public String board_update(int no,Model model)
   {
	   //model => request대신 데이터 전송하는 객체 
	   BoardVO vo=dao.boardUpdateData(no);
	   model.addAttribute("vo", vo);
	   // jsp.forward(request,response)
	   return "board/update";
   }
   
   @GetMapping("delete.do")
   public String board_delete(int no,Model model)
   {
	   // delete.do를 요청 => delete.jsp (no값을 포함)
	   model.addAttribute("no", no);
	   return "board/delete";
   }
   
}










