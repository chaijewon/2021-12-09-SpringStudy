package com.sist.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import com.sist.student.dao.*;
import com.sist.student.entity.*;
@Controller
public class StudentController {
   @Autowired
   private StudentDAO dao;
   
   @GetMapping("/list")
   public String student_list(Model model)
   {
	   List<StudentEntity> list=dao.findAll();
	   // select * from student
	   model.addAttribute("list", list);
	   return "list";
   }
   @GetMapping("/delete/{hakbun}")
   public String student_delete(@PathVariable int hakbun)
   {
	   StudentEntity sn=dao.findByHakbun(hakbun);
	   dao.delete(sn);
	   return "redirect:/list";
   }
}
