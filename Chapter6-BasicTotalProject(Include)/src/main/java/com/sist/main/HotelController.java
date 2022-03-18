package com.sist.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelController {
  @GetMapping("seoul/hotel/list.do")
  public String seoul_hotel_list(Model model)
  {
	  model.addAttribute("main_jsp", "../seoul/hotel/list.jsp");
	  return "main/main";
  }
}
