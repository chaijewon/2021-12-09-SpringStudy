package com.sist.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NatureController {
	  @GetMapping("seoul/nature/list.do")
	  public String seoul_nature_list(Model model)
	  {
		  model.addAttribute("main_jsp", "../seoul/nature/list.jsp");
		  return "main/main";
	  }
}
