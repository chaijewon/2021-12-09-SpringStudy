package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class SeoulController {
  @Autowired
  private SeoulDAO dao; 
  
  @RequestMapping("seoul/seoul_make.do")
  public String seoul_make()
  {
	  return "seoul/seoul_make";
  }
  
  @GetMapping("seoul/location.do")
  public String seoul_location(String page, Model model)
  {
	  // DAO
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  Map map=new HashMap();
	  int rowSize=12;
	  int start=(rowSize*curpage)-(rowSize-1);
	  int end=rowSize*curpage;
	  
	  map.put("start", start);
	  map.put("end", end);
	  
	  List<SeoulVO> rList=dao.seoulLocationData(map);
	  int totalpage=dao.seoulLocationTotalPage();
	  
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
	  return "seoul/location";
  }
  @GetMapping("seoul/nature.do")
  public String seoul_nature(String page,Model model)
  {
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  Map map=new HashMap();
	  int rowSize=12;
	  int start=(rowSize*curpage)-(rowSize-1);
	  int end=rowSize*curpage;
	  
	  map.put("start", start);
	  map.put("end", end);
	  
	  List<SeoulVO> rList=dao.seoulNatureData(map);
	  int totalpage=dao.seoulNatureTotalPage();
	  
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
	  return "seoul/nature";
  }
  
  @GetMapping("seoul/hotel.do")
  public String seoul_hotel(String page,Model model)
  {
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  Map map=new HashMap();
	  int rowSize=12;
	  int start=(rowSize*curpage)-(rowSize-1);
	  int end=rowSize*curpage;
	  
	  map.put("start", start);
	  map.put("end", end);
	  
	  List<SeoulVO> rList=dao.seoulHotelData(map);
	  int totalpage=dao.seoulHotelTotalPage();
	  
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
	  return "seoul/hotel";
  }
  /*
   *   제어 
   *   ---
   *    클라이언트가 보내준 요청 정보 제어 : Front Controller (DispatcherServlet) 
   *    요청 처리 제어 (@Controller => 사용자 정의)
   *   
   */
  // 요청 처리를 제어하는 클래스 => Controller
  // 1.  요청 데이터  ?변수 
  // 2.  데이터를 받아서 오라클 
  // 3.  출력시에 어떤 데이터 
  // 4.  MyBatis(SQL)
  // 5.  스프링을 정상적으로 작동 (요청 => 클래스 => 메소드 => JSP => 데이터전송)
  // => 라구(업체) => ..라구요   시 , 고  짜* 
  @GetMapping("seoul/location_detail.do")
  public String seoul_location_detail(int no,Model model)
  {
	  //  마포구
	  SeoulVO vo=dao.seoulLocationDetailData(no);
	  String address=vo.getAddress();
	  System.out.println("주소:"+address);
	  address=address.replaceAll("[0-9]", "");// 전체 숫자를 공백으로 변환 
	  address=address.trim();
	  System.out.println("1. address="+address);
	  String addr1=address.substring(address.indexOf(" ")+1);
	  System.out.println("2. addr1="+addr1);
	  String addr2=addr1.trim().substring(0,addr1.indexOf(" "));
	  System.out.println("3. addr2="+addr2);
	  List<FoodVO> fList=dao.seoulLocationFoodHouse(addr2);
	  model.addAttribute("vo", vo);
	  model.addAttribute("fList", fList);
	  model.addAttribute("address", address);
	  return "seoul/location_detail";
  }
}






