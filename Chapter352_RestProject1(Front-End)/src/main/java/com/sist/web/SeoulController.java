package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeoulController {
  @GetMapping("vuejs/vue4.do")
  public String vuejs_vue3()
  {
	  return "vuejs/vue4";
  }
}
