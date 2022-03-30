package com.sist.web;
// 요청 처리 
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.*;

import lombok.Getter;

import com.sist.dao.*;
/*
 *   key   value
 *  ==============
 *    a    aaa
 *  ==============
 *    b    bbb
 *  ==============
 *    c    ccc
 *  ==============
 *    d    ddd
 *  ==============
 *    e    eee
 *  ==============
 *  
 *  ddd => for(int i=0;i<map.size();i++)
 *         {
 *             String value=map.get(i);
 *         }
 *         
 *         map.get("d")
 *  
 *  
 */
@Controller
@RequestMapping("food/") 
public class RecipeController {
  // 필요한 객체 => 스프링에서 생성 객체 => 자동 주입 요청 
  @Autowired // 자동 주입 => 스프링에서 찾아서 주소 주입 
  @Qualifier("recipeDAO") // 사용자(프로그래머가 특정 객체 지정)
  // @Autowired + @Qualifier("recipeDAO") => @Resource (JDK 1.8) => 실무 1.8
  // @Resource(name="recipeDAO")
  private RecipeDAO dao;
  /*
   *   ========================
   *   1. 사용자 요청 => .do 
   *   2. DispatcherServlet
   *   ======================== web.xml
   *   3. DispatcherServlet => 명령 => 요청내용을 찾아라 (HandlerMapping)
   *                       @Controller
   *                       @RestController
   *   4. DispatcherServlet => 찾으면 => 메소드호출 (HandlerAdapter)
   *   5. DispatcherServlet => return을 받아서 JSP찾아라 (ViewResolver)
   *                       경로명 / 확장자 
   *   6. DispatcherServlet => JSP를 화면에 출력 한다 
   *      ================= CPU
   *      스프링 : 메인보드 
   */
  @GetMapping("recipe.do") // HandlerMapping 
  public String food_recipe(String page,Model model)
  {
	  // 메소드 호출 => HandlerAdapter 
	  // 매개변수 => DispatcherServlet  => invoke(page,model)
	  if(page==null)
		  page="1"; //default page 
	  int curpage=Integer.parseInt(page);
	  Map map=new HashMap();
	  int rowSize=20;
	  int start=(rowSize*curpage)-(rowSize-1);
	  int end=rowSize*curpage;
	  map.put("start", start);
	  map.put("end", end);
	  
	  List<RecipeVO> list=dao.recipeListData(map);
	  // 글자수 조절 
	  for(RecipeVO vo:list)
	  {
		  String title=vo.getTitle();
		  if(title.length()>20)
		  {
			  title=title.substring(0,20)+"...";
		  }
		  vo.setTitle(title);
	  }
	  int totalpage=dao.recipeTotalPage();
	  int count=dao.recipeCount();
	  
	  // 블록 
	  final int BLOCK=10;
	  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	  if(endPage>totalpage)
		  endPage=totalpage;
	  
	  // JSP 전송 
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  model.addAttribute("count", count);
	  model.addAttribute("list", list);
	  model.addAttribute("startPage", startPage);
	  model.addAttribute("endPage", endPage);
	  return "food/recipe";//ViewResolver => Tiles(기능 추가 + include)
  }
  
  @GetMapping("chef.do")
  public String food_chef(String page,Model model)
  {
	  if(page==null)
		  page="1"; //default page 
	  int curpage=Integer.parseInt(page);
	  Map map=new HashMap();
	  int rowSize=20;
	  int start=(rowSize*curpage)-(rowSize-1);
	  int end=rowSize*curpage;
	  map.put("start", start);
	  map.put("end", end);
	  
	  List<ChefVO> list=dao.chefListData(map);
	  // 글자수 조절 
	  
	  int totalpage=dao.chefTotalPage();
	  
	  // 블록 
	  final int BLOCK=10;
	  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	  if(endPage>totalpage)
		  endPage=totalpage;
	  
	  // JSP 전송 
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  model.addAttribute("list", list);
	  model.addAttribute("startPage", startPage);
	  model.addAttribute("endPage", endPage);
	  return "food/chef";
  }
  // DAO => 오라클 연동 (데이터를 묶어서 전송 => VO)
  // 데이터 전송 , 요청값 => Controller 
  // 화면 출력 => JSP
  // chef_recipe_list.do?chef=${vo.chef }
  @RequestMapping("chef_recipe_list.do")
  public String chef_recipe_list(String ss,String page,String chef,Model model)
  {
	  if(ss==null)
		  ss="all";
	  if(page==null)
		  page="1"; //default page 
	  int curpage=Integer.parseInt(page);
	  Map map=new HashMap();
	  int rowSize=20;
	  int start=(rowSize*curpage)-(rowSize-1);
	  int end=rowSize*curpage;
	  map.put("start", start);
	  map.put("end", end);
	  map.put("chef", chef);
	  map.put("ss",ss);
	  List<RecipeVO> list=new ArrayList<RecipeVO>();
	  
	  if(ss.equals("all"))
	  {
	     list=dao.chefRecipeListDataAll(map);
	  }
	  else
	  {
		 list=dao.chefRecipeListData(map);
	  }
	  // 글자수 조절 
	  for(RecipeVO vo:list)
	  {
		  String title=vo.getTitle();
		  if(title.length()>20)
		  {
			  title=title.substring(0,20)+"...";
		  }
		  vo.setTitle(title);
	  }
	  int totalpage=0;
	  if(ss.equals("all"))
	  {
	     totalpage=dao.chefRecipeCountAll(chef);
	  }
	  else
	  {
		 totalpage=dao.chefRecipeCount(map);
	  }
	  
	  // 블록 
	  final int BLOCK=10;
	  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	  if(endPage>totalpage)
		  endPage=totalpage;
	  
	  // JSP 전송 
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  model.addAttribute("list", list);
	  model.addAttribute("startPage", startPage);
	  model.addAttribute("endPage", endPage);
	  model.addAttribute("chef", chef);
	  return "food/chef_recipe_list";
  }
  
	/*
	 * @PostMapping("chef_find.do") public String chef_find(String chef,String ss,
	 * Model model) { return "food/chef_recipe_list"; }
	 */
  @GetMapping("recipe_detail.do")
  public String recipe_detail(int no,Model model)
  {
	  RecipeDetailVO vo=dao.recipeDetailData(no);
	  String[] make=vo.getFoodmake().split("\n");
	  for(String s:make)
	  {
		  StringTokenizer st=new StringTokenizer(s,"^");
		  vo.getFList().add(st.nextToken());// 조리법(문자열)
		  vo.getIList().add(st.nextToken());// 조리법 (이미지)
	  }
	  model.addAttribute("vo", vo);
	  model.addAttribute("fList", vo.getFList());
	  model.addAttribute("iList", vo.getIList());
	  return "food/recipe_detail";
  }
}





















