package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.manager.*;
import com.sist.vo.NewsVO;
@Controller
public class MainController {
  @Autowired //스프링에서 생성된 객체주소를 얻어 온다(자동처리)
  private NewsManager mgr;
  
  @RequestMapping("news/find.do")
  public String news_find(String ss,Model model)
  {
	  if(ss==null)
		  ss="영화";
	  List<NewsVO> list=mgr.newsFindData(ss);
	  model.addAttribute("ss", ss);
	  model.addAttribute("list", list);
	  return "news/find";
  }
  
  
}
