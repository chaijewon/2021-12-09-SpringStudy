package com.sist.last.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.last.dao.*;
import com.sist.last.entity.*;
@Controller
public class MainController {
  @Autowired
  private MusicDAO dao;
  @GetMapping("/main")
  public String main_page(String cno,String page,Model model)
  {
	  String[] title= {"Top200","가요","POP","OST","트롯","JAZZ"};
	  if(page==null)
		  page="1";
	  if(cno==null)
		  cno="1";
	  int curpage=Integer.parseInt(page);
	  int rowSize=12;
	  int start=(rowSize*curpage)-rowSize; //0 (rownum=1,limit=0)
	  List<MusicEntity> list=dao.musicListData(Integer.parseInt(cno), start);
	  int totalpage=dao.musicTotalPage(Integer.parseInt(cno));
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
	  model.addAttribute("title", title[Integer.parseInt(cno)-1]);
	  model.addAttribute("list", list);
	  model.addAttribute("main_content", "music/list");
	  return "main";
  }
}
