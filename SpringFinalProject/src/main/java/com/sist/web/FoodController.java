package com.sist.web;
// HandlerMapping이 찾기가 가능 => @Controller,@RestController

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 기능별 => 찾기가 가능하게 다시 만든다 => @RequestMapping (GetMapping,PostMapping)
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class FoodController {
   // 필요한 객체를 스프링으로부터 주입 요청 
   @Autowired
   private FoodDAO dao;
   
   // 기능별 처리 => if역할 (if문 한개를 추가하는 것같 같은 기능) 
   // 어노테이션을 조건문이라고 한다 
   // ==> URI주소 
   @GetMapping("food/list.do") // 사용자가 food/list => 맛집 목록을 요청 했다면 
   public String food_list(String page,Model model)
   {
	   // String s=request.getParameter("page")
	   // 웹에서 나오는 모든 데이터형은 String
	   // Integer.parseInt(null) => 오류
	   // 사용자 보내준 데이터 => 매개변수 (DispatcherServlet)
	   // Model은 전송할 데이터가 있는 경우에만 사용 (전송객체) => request,response사용하지 않는다 
       if(page==null)
    	   page="1";  // 매개변수 => 모든 데이터는 String으로 받을 수 있다 
       // 데이터형 변경 => int,double....
       // 사용자가 첫페이지에서는 보내주지 않는 값이 있다 (page) => null (String)
       int curpage=Integer.parseInt(page);
       Map map=new HashMap();
       // #{start} , #{end} 
       int rowSize=12;
       int start=(rowSize*curpage)-(rowSize-1); //rownum은 1번부터 시작 
       int end=rowSize*curpage; // rownum => 중간에서 데이터를 추출 할 수 없다 (Top-N)
       // MySQL => limit 1,10 , 11,10... limit ?,? 
       map.put("start", start);
       map.put("end", end);
       List<FoodVO> fList=dao.foodListData(map);
       for(FoodVO vo:fList)
       {
    	   String poster=vo.getPoster();
    	   poster=poster.substring(0,poster.indexOf("^"));
    	   vo.setPoster(poster);
       }
       int totalpage=dao.foodTotalPage();
       
       // 블록별 처리 
       final int BLOCK=10;
       int startPage=((curpage-1)/BLOCK*BLOCK)+1;
       // curpage => 1,10  ==> startPage=1
       // curpage => 11,20 ==> startPage=11
       int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
       // curpage => 1,10  ==> endPage=10
       // curpage => 11,20 ==> endPage=20
       
       if(endPage>totalpage)
    	   endPage=totalpage; // 마지막 페이지 
       
       // 화면 출력한 데이터 => 모아서 => list.jsp로 전송 
       model.addAttribute("fList", fList);
       model.addAttribute("curpage", curpage);
       model.addAttribute("totalpage", totalpage);
       model.addAttribute("startPage", startPage);
       model.addAttribute("endPage", endPage);
       // 프로그램 => 책읽기 => 반복 , 숙달 (1~3년 누적 => 발전없어 보인다 => 3년)
       // 5년 => 초급 , 6년 => 중급 ...
       return "food/list";
   }
   @GetMapping("food/detail.do")
   public String food_detail(int no,Model model)
   {
	   // no에 해당하는 데이터를 오라클로부터 읽어 온다 
	   // mapper => dao => controller => jsp
	   FoodVO vo=dao.foodDetailData(no);
	   String addr=vo.getAddress();
	   String addr1=addr.substring(0,addr.lastIndexOf("지"));
	   String addr2=addr.substring(addr.lastIndexOf("지"));
	   model.addAttribute("addr1", addr1.trim());
	   model.addAttribute("addr2", addr2);
	   // 지도 출력 
	   model.addAttribute("vo", vo);
	   return "food/detail";
   }
   @GetMapping("food/food_find.do")
   public String food_find()
   {
	   return "food/food_find";
   }
   @GetMapping("food/food_find_result.do")
   public String find_result(int gu,Model model)
   {
	   String[] guList_1 = { "전체", "강서구", "양천구", "구로구", "마포구", "영등포구", "금천구",
			    "은평구", "서대문구", "동작구", "관악구", "종로구", "중구", "용산구", "서초구", "강북구",
			    "성북구", "도봉구", "동대문구", "성동구", "강남구", "노원구", "중랑구", "광진구", "송파구",
			    "강동구" };
	   //DB 연동 
	   List<FoodVO> list=dao.foodFindData(guList_1[gu]);
	   model.addAttribute("list", list);
	   model.addAttribute("gu", guList_1[gu]);
	   return "food/food_find_result/ajax";
   }
   
   @GetMapping("food/food_recommand.do")
   public String food_recommand()
   {
	   return "food/food_recommand";
   }
}






