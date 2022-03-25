package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
  @GetMapping("notice/list.do")
  public String notice_list()
  {
	  return "notice/list";
  }
} 
