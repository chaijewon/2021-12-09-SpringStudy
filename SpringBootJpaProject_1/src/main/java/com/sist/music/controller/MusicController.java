package com.sist.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// MyBatis(기본) => JPA , Hibernate  => ORM 
// JPA => Hibernate를 이용하는 프로그램 (DataSet)
/*
 *   method => findAll() => 전체 데이터 읽기
 *             findOne() => 수행된 SQL의 첫번째 데이터 읽기
 *             save()    => insert,update
 *             delete()  => delete
 *             기타 => WHERE문장 (조건 검색) => 사용자 정의 
 *                   사용자 정의 
 *                   SQL문장 사용 방법 (60%)
 *                     =@Query
 *                     =@JPQL 
 *                   메소드명으로 처리 (30%)
 */
import java.util.*;
import com.sist.music.dao.*;
import com.sist.music.entity.*;
// SpringFramework => JSP => MyBatis (JSTL,EL)
// Spring-Boot     => html => JPA 
//                    thymeleaf (th , EL)
// Spring-BOOT(서버) , Front ==> 가장 최근 
// ---------------- AI
@Controller
public class MusicController {
   // DAO
	@Autowired
	private MusicDAO dao;
	
	@GetMapping("/top200")
	public String musicListData(String page,String cno,Model model)
	{
		
		if(page==null)
			page="1";
		if(cno==null)
			cno="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-rowSize; // oracle(1) , mysql(0)
		List<MusicEntity> list=dao.musicListData(Integer.parseInt(cno),start);
		for(MusicEntity m:list)
		{
			String title=m.getTitle();
			if(title.length()>20)
			{
				title=title.substring(0,20)+"...";
			}
			m.setTitle(title);
		}
		int totalpage=dao.musicTotalPage(Integer.parseInt(cno));
		
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		// 전송 
		model.addAttribute("list",list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("tottalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		// include파일에 첨부되는 파일 지정 
		model.addAttribute("main_jsp", "../music/list.jsp");
		return "main/main";
	}
	@GetMapping("/genre_music")
	public String genre_music(String page,String cno,Model model)
	{
		if(page==null)
			page="1";
		if(cno==null)
			cno="2";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-rowSize; // oracle(1) , mysql(0)
		List<MusicEntity> list=dao.musicListData(Integer.parseInt(cno),start);
		for(MusicEntity m:list)
		{
			String title=m.getTitle();
			if(title.length()>20)
			{
				title=title.substring(0,20)+"...";
			}
			m.setTitle(title);
		}
		int totalpage=dao.musicTotalPage(Integer.parseInt(cno));
		
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		// 전송 
		model.addAttribute("list",list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("tottalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("cno", cno);
		// include파일에 첨부되는 파일 지정 
		model.addAttribute("main_jsp", "../music/genre.jsp");
		return "main/main";
	}
	@RequestMapping("/music_find")
	public String music_find(String title,String page,Model model)
	{
		if(title==null)
			title="비";
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-rowSize; // oracle(1) , mysql(0)
		List<MusicEntity> list=dao.musicFindData(title,start);
		for(MusicEntity m:list)
		{
			String title1=m.getTitle();
			if(title1.length()>20)
			{
				title1=title1.substring(0,20)+"...";
			}
			m.setTitle(title1);
		}
		int totalpage=dao.musicFindTotalPage(title);
		
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		// 전송 
		model.addAttribute("list",list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("tottalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("title", title);
		model.addAttribute("main_jsp", "../music/find.jsp");
		return "main/main";
	}
}












