package com.sist.web;
// JSP에 요청 결과값 전송 
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.*;
/*
 *   Spring - Boot 
 *   1. 설정 (체크박스)
 *   2. application.properties 
 *   3. th(html,xml)
 *   4. jpa사용법 
 */
@Controller
public class StudentController {
   @Autowired
   private StudentDAO dao;
   // http://localhost:8080/web/std/list.do
   @GetMapping("std/list.do")
   public String std_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int size=10;
	   int start=(curpage*size)-size; // 0번부터 시작한다 
	   map.put("size", size);
	   map.put("start", start);
	   List<StudentVO> list=dao.stdListData(map);
	   int totalpage=dao.studentTotalPage();
	   
	   model.addAttribute("curpage",curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   return "std/list";
   }
   
   @GetMapping("std/insert.do")
   public String std_insert()
   {
	   return "std/insert";
   }
   // https://sports.v.daum.net/v/20220411144735807
   // .do/admin/1234/홍길동
   @PostMapping("std/insert_ok.do")
   public String std_insert_ok(@ModelAttribute @Valid StudentVO studentVO,Errors result)
   {
	   if(result.hasErrors())
		   return "std/insert";
	   
	   dao.stdInsert(studentVO);
	   return "redirect:list.do";
   }
   
   @GetMapping("std/delete.do")
   public String std_delete(int hakbun)
   {
	   dao.stdDelete(hakbun);
	   return "redirect:list.do";
   }
   
   @GetMapping("std/update.do")
   public String std_update(int hakbun,Model model)
   {
	   StudentVO vo=dao.stdUpdateData(hakbun);
	   model.addAttribute("vo", vo);
	   return "std/update";
   }
   
   @PostMapping("std/update_ok.do")
   public String std_update_ok(@ModelAttribute @Valid StudentVO studentVO,Errors result)
   {
	    
	   dao.stdUpdate(studentVO);
	   return "redirect:list.do";
   }
  
}










