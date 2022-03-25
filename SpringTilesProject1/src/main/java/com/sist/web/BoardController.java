package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
  @GetMapping("board/list.do")
  public String board_list()
  {
	  return "board/list";
  }
}
