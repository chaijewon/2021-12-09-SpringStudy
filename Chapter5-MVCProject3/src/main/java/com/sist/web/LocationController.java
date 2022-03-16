package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class LocationController {
   // DAO의 주소값 얻기 
   @Autowired
   private LocationDAO dao;
   
   //요청에 대한 처리 
   @GetMapping("location/list.do")
   public String location_list(String page, Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=20;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start",start);
	   map.put("end", end);
	   List<LocationVO> list=dao.locationListData(map);
	   int totalpage=dao.locationTotalPage();
	   
	   final int BLOCK=5;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
	   {
		   endPage=totalpage;
	   }
	   
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("BLOCK", BLOCK);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   return "location/list";
   }
   @GetMapping("location/detail.do")
   public String location_detail(int no,Model model)
   {
	   LocationVO vo=dao.locationDetailData(no);
	   model.addAttribute("vo", vo);
	   return "location/detail";
   }
}





