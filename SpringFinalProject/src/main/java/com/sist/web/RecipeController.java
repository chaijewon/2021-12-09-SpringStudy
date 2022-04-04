package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class RecipeController {
  @Autowired
  private RecipeDAO dao;
  @GetMapping("recipe/list.do")
  // 메소드는 리턴형 => 특별한 경우가 아니면 => String , void(화면 변경이 없는 경우, 다운로드)
  public String recipe_list(String page,Model model)
  {
	  //Model => request,response사용을 권장하지 않는다 => 전송객체 (Model)
	  //사용자가 보내준 값 , 내장객체 => DispatcherServlet을 통해서 받아 온다 
	  //매개변수를 통해서 받는다 (순서는 상관없다)
	  // 리턴값은 2개중에 한개 선택 
	  // model값을 전송 => forward  ==> return "경로/파일명"
	  // 재전송 => sendRedirect()  ==> return "redirect:~~.do"
	  // 대부분은 해당 데이터형으로 받는다 
	  // 처음 실행시에 사용자가 page를 선택할 수 없다 
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  Map map=new HashMap();
	  int rowSize=12;
	  int start=(rowSize*curpage)-(rowSize-1);
	  int end=rowSize*curpage;
	  
	  map.put("start", start);
	  map.put("end", end);
	  
	  List<RecipeVO> rList=dao.recipeListData(map);
	  int totalpage=dao.recipeTotalPage();
	  
	  final int BLOCK=10;
	  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	  //                (10-1)/10*10 => 0+1  ==> 1
	  // 1(curpage=1,10) ,  11(curpage=11~20) , 21 , 31
	  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK; //10,20....
	  
	  if(endPage>totalpage)
		  endPage=totalpage;
	  
	  // list.jsp에서 출력에 필요한 데이터 전송
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  model.addAttribute("rList", rList);
	  model.addAttribute("startPage", startPage);
	  model.addAttribute("endPage", endPage);
	  // Cookie값 전송 
	  return "recipe/list";
  }
  // 조건 ==> 라이브러리 => 안에 코딩이 불가능 (컴파일된 파일만 보내준다) 
  // 읽어 갈 수 있는 소스 코딩 => 형식 => String
  @GetMapping("recipe/detail.do")
  public String recipe_detail(int no,Model model)
  {
	  // */* => /WEB-INF/recipe/detail.jsp => include (tiles는 include를 포함한다)
	  RecipeDetailVO vo=dao.recipeDetailData(no);
	  List<String> mList=new ArrayList<String>();
	  List<String> pList=new ArrayList<String>();
	  String[] data=vo.getFoodmake().split("\n");
	  for(String s:data)
	  {
		  StringTokenizer st=new StringTokenizer(s,"^");
		  mList.add(st.nextToken());
		  pList.add(st.nextToken());
	  }
	  
	  model.addAttribute("mList", mList);
	  model.addAttribute("pList", pList);
	  model.addAttribute("vo", vo);
	  return "recipe/detail";
  }
}








