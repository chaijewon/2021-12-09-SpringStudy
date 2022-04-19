package com.sist.last.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*
 *    데이터베이스만 관리  ===> Repostory => DAO 
 *    웹 프로그램 관리(JSP) ==> 브라우저로 데이터 전송 = Controller , RestController
 *    
 */
import java.util.*;
import com.sist.last.dao.*;
import com.sist.last.entity.*;
@Controller
/*
 *    스프링에서 메모리 할당 : 패키지단위로 메모리 할당 (선택적으로) => 스프링에서 관리 
 *    @Controller
 *    @RestController
 *    @Repostory
 *    @Service
 *    @Component
 *    @ControllerAdvice 
 */
public class BoardController {
    @Autowired // 주입 => @Resource (1.8에서 종료) : 특정 객체 지정 
    // 자동 주입 => 특정 객체로 변환  @Qualifier("id명")
    private BoardDAO dao;
    
    // 요청 처리  ==> @RequestMapping , @GetMapping , @PostMapping
    // HandleMapping => 메소드 실행  HandlerAdapter
    /*
     *   브라우저 ====== 서버 통신 
     *          주소란 
     */
    @GetMapping("/board/list") //URI주소 (사용자 브라우저에 있는 주소)
    public String board_list(String page,Model model)
    {
    	  if(page==null)
			  page="1";
		  int curpage=Integer.parseInt(page);
		  int rowSize=10;
		  int start=(rowSize*curpage)-rowSize; //0 (rownum=1,limit=0)
		  List<BoardEntity> list=dao.boardListData(start);
		  
		  int totalpage=dao.boardTotalPage();
		  
		  // 데이터 전송 
		  model.addAttribute("curpage", curpage);
		  model.addAttribute("totalpage", totalpage);
		  model.addAttribute("list", list);
    	  model.addAttribute("main_content", "board/list");
    	  return "main";
    }
    @GetMapping("/board/insert")
    public String board_insert(Model model)
    {
    	model.addAttribute("main_content", "board/insert");
    	return "main";
    }
    @PostMapping("/board/insert_ok")
    public String board_insert_ok(BoardEntity vo)
    {
    	//dao.boardInsert(vo);//Insert SQL문장아 첨부 ==> update사용이 가능 
    	// hibernate기반 => DataSet 
    	dao.save(vo);
    	return "redirect:/board/list";
    }
    
    @GetMapping("/board/detail")
    // SpringFramework 
    public String board_detail(int no,Model model)
    {
    	// => Service를 제작 
    	//dao.hitIncrement(no);
    	BoardEntity vo=dao.findByNo(no);
    	vo.setHit(vo.getHit()+1);
    	dao.save(vo);// 수정 
    	vo=dao.findByNo(no);
    	model.addAttribute("vo", vo);
    	model.addAttribute("main_content", "board/detail");
    	return "main";
    }
    
    @GetMapping("/board/update")
    public String board_update(int no,Model model)
    {
    	BoardEntity vo=dao.findByNo(no);
    	model.addAttribute("vo", vo);
    	model.addAttribute("main_content", "board/update");
    	return "main";
    }
    
    @PostMapping("/board/update_ok")
    public String board_update_ok(BoardEntity vo)
    {
    	dao.save(vo);
    	return "redirect:/board/detail?no="+vo.getNo();
    }
    
    @GetMapping("/board/delete")
    public String board_delete(int no)
    {
    	BoardEntity vo=dao.findByNo(no);
    	dao.delete(vo);
    	return "redirect:/board/list";
    }
}
















