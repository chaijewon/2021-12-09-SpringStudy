package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.vo.MemberVO;

@Controller
public class MainController2 {
  @GetMapping("main/input.do") // 폼 보여준다 , <a> , location.href...
  public String main_input()
  {
	  return "main/input";
  }
  @PostMapping("main/output.do")
  public String main_output(MemberVO vo,Model model)
  {
	  model.addAttribute("vo", vo);
	  return "main/output";
  }
}
