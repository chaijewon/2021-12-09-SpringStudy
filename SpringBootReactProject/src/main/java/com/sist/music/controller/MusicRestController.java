package com.sist.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.music.dao.*;
import com.sist.music.entity.*;
@RestController
@CrossOrigin("http://localhost:3000")
// React => port = 3000 , Spring 8080
public class MusicRestController {
   @Autowired
   private MusicDAO dao;
   
   @GetMapping("/music/list")
   public List<MusicEntity> music_list(String page,String cno,Model model)
   {
	   System.out.println("page="+page+"cno="+cno);
	   // []
	   List<MusicEntity> list=new ArrayList<MusicEntity>();
	   if(page==null)
			page="1";
	   if(cno==null)
		   cno="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-rowSize; // oracle(1) , mysql(0)
		list=dao.musicListData(Integer.parseInt(cno),start);
		for(MusicEntity m:list)
		{
			String title=m.getTitle();
			if(title.length()>20)
			{
				title=title.substring(0,20)+"...";
			}
			m.setTitle(title);
		}
	    return list; //JSON
   }
   @GetMapping("/music/totalpage")
   public PageVO music_totalpage(String page,String cno)
   {
	   // {} 
	   PageVO vo=new PageVO();
	   if(page==null)
		   page="1";
	   if(cno==null)
		   cno="1";
	   int curpage=Integer.parseInt(page);
	   int totalpage=dao.musicTop200TotalPage(Integer.parseInt(cno));
	   final int BLOCK=5;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   vo.setCurpage(curpage);
	   vo.setEndPage(endPage);
	   vo.setStartPage(startPage);
	   vo.setTotalpage(totalpage);
	   
	   return vo;
   }
}








