package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SeoulController {
  @RequestMapping("seoul/seoul_make.do")
  public String seoul_make()
  {
	  return "seoul/seoul_make";
  }
}
