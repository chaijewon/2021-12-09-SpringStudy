package com.sist.last.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.last.dao.*;
import com.sist.last.entity.*;
@Controller
public class MovieController {
   @Autowired
   private MovieDAO dao;
   
   @GetMapping("/movie/list")
   public String movie_list(String page,String cno,Model model,HttpServletRequest request)
   {
	      if(page==null)
			  page="1";
		  if(cno==null)
			  cno="1";
		  int curpage=Integer.parseInt(page);
		  int rowSize=12;
		  int start=(rowSize*curpage)-rowSize; //0 (rownum=1,limit=0)
		  List<MovieEntity> list=dao.movieListData(Integer.parseInt(cno), start);
		  int totalpage=dao.movieTotalPage(Integer.parseInt(cno));
		  final int BLOCK=5;
		  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		  /* 1~5 page   startPage=1 , endPage=5  
		   * 6~10 page            6           10
		   * 
		   * */
		  if(endPage>totalpage)
			  endPage=totalpage;
		  
		  // 데이터 전송 
		  model.addAttribute("curpage", curpage);
		  model.addAttribute("totalpage", totalpage);
		  model.addAttribute("startPage", startPage);
		  model.addAttribute("endPage", endPage);
		  model.addAttribute("title", Integer.parseInt(cno)==1?"현재상영영화":"개봉예정영화");
		  model.addAttribute("list", list);
		  model.addAttribute("cno", cno);
	   model.addAttribute("main_content", "movie/list");
	   
	   // 쿠키 처리 
	   Cookie[] cookies=request.getCookies();
	   List<MovieEntity> cList=new ArrayList<MovieEntity>();
	   if(cookies!=null)
	   {
		   for(int i=cookies.length-1;i>=0;i--)
		   {
			   if(cookies[i].getName().startsWith("m"))
			   {
				   cookies[i].setPath("/");
				   String mno=cookies[i].getValue();
				   MovieEntity mm=dao.findByMno(Integer.parseInt(mno));
				   cList.add(mm);
			   }
		   }
	   }
	   model.addAttribute("cList", cList);
	   return "main";
   }
   @GetMapping("/movie/detail_before")
   public String movie_detail_before(int mno,
		   HttpServletResponse response)
   {
	    Cookie cookie=new Cookie("m"+mno, String.valueOf(mno));
	    // 쿠키의 단점 => 저장할 수 있는 데이터 (String만 가능)
	    cookie.setPath("/");
	    cookie.setMaxAge(60*60*24);
	    // 클라이언트로 전송 
	    response.addCookie(cookie);
	     
	    return "redirect:/movie/detail?mno="+mno;
   }
   @GetMapping("/movie/detail")
   public String movie_detail(int mno,Model model)
   {
	   // request가 공유 => include / forward 
	   MovieEntity vo=dao.findByMno(mno);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_content", "movie/detail");
	   return "main";
   }
}






