package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class EmpController {
   @Autowired
   private EmpDAO dao;
   
   @RequestMapping("emp/list.do") // jsp (폴더는 emp => list.jsp)
   public String emp_list(Model model)
   {
	   List<String> list=dao.empGetNameData();
	   model.addAttribute("list",list);
	   return "emp/list";
   }
   
   @RequestMapping("emp/find.do")
   public String emp_find(String[] names,Model model)
   {
	   // checkbox => String[]
	   Map map=new HashMap();
	   map.put("names", names);
	   List<EmpVO> list=dao.empFindData(map);
	   model.addAttribute("list", list);
	   return "emp/find";
   }
}
