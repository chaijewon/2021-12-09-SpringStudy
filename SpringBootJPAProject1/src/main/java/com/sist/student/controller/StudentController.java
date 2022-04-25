package com.sist.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import com.sist.student.dao.*;
import com.sist.student.entity.*;
@Controller
public class StudentController {
   @Autowired
   private StudentDAO dao;
   
   @GetMapping("/list")
   public String student_list(String page,Model model)
   {
	   //List<StudentEntity> list=dao.findAll();
	   // select * from student
	   //model.addAttribute("list", list);
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int start=(2*curpage)-2;
	   //int end=2*curpage;
	   List<StudentEntity> list=dao.studentListData(start);
	   int totalpage=dao.studentTotalPage();
	   
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   return "list";
   }
   @GetMapping("/delete/{hakbun}")
   public String student_delete(@PathVariable int hakbun)
   {
	   StudentEntity sn=dao.findByHakbun(hakbun);
	   dao.delete(sn);
	   return "redirect:/list";
   }
   @GetMapping("/update/{hakbun}")
   public String student_update(@PathVariable int hakbun,Model model)
   {
	   StudentEntity vo=dao.findByHakbun(hakbun);
	   model.addAttribute("vo", vo);
	   return "update";
   }
   @PostMapping("/update_ok")
   public String student_update_ok(StudentEntity entity)
   {
	   dao.save(entity);
	   return "redirect:/list";
   }
   
   @PostMapping("/find")
   public String student_find(String ss,Model model)
   {
	   List<StudentEntity> list=dao.studentNameFind(ss);
	   model.addAttribute("list", list);
	   return "find";
   }
}
