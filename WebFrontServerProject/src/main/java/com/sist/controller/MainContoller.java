package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainContoller {
   @GetMapping("/main")
   public String main_main(Model model)
   {
	   model.addAttribute("msg", "main");
	   return "main";
   }
   @GetMapping("/detail")
   public String main_detail(Model model)
   {
	   model.addAttribute("msg", "detail");
	   return "detail";
   }
}
