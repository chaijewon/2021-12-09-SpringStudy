package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
import com.sist.vo.*;
/*
 *   Autowired : 스프링에 의한 자동 주입 
 *   ANNOTATION_TYPE, 
 *   CONSTRUCTOR, 
 *   FIELD, 
 *   METHOD, 
 *   PARAMETER
 *   
 *   public class ClsName
 *   {
 *       @Autowired : FIELD
 *       private BoardDAO dao;
 *       
 *       @Autowired : CONSTRUCTOR
 *       public ClsName(BoardDAO dao)
 *       {
 *          // 어노테이션은 지역변수에서는 사용이 불가능 
 *          this.dao=dao;
 *       }
 *       @Autowired : METHOD
 *       public void setBoardDAO(BoardDAO dao)
 *       {
 *       }
 *       public void display(@Autowired BoardDAO dao)
 *       {                  ------------
 *                           PARAMETER
 *       }
 *   }
 *   
 *   Controller 
 *   TYPE : 클래스 위에만 사용이 가능 (클래스 구분)
 *   
 *   GetMapping
 *   METHOD : 메소드 위에만 사용이 가능 (메소드 구분)
 */
@Controller
public class HotelController {
  // DAO , Manager
  @Autowired
  private HotelDAO dao; // 멤버 => 모든 메소드에서 사용 
  @GetMapping("seoul/hotel/list.do")
  public String seoul_hotel_list(HttpServletRequest request,String page,Model model)
  {
	  // request,response는 거의 사용하지 않기 때문에 매개변수로 요청값을 받아 온다
	  /*
	   *   request => Cookie 
	   *   response => 다운로드 
	   *   매개변수로 받을 수 있는 클래스 
	   *   ----------------------
	   *    서블릿이 가지고 있는 내장 객체 : 9가지 
	   *    => HttpServletRequest,HttpServletResponse
	   *       HttpSession 
	   *       list(HttpServletRequest request,HttpSession session)
	   *    => 사용자가 요청한 데이터 
	   *       list(String ss) => getParameter()
	   *       list(String[] ss) => getParamterValues()
	   *       list(List<String> list)
	   *         => ?list[0]=""&list[2]=""
	   *         =>  [ (%5B) ] (%5D)
	   *             list%5B0%5D ==> bad request 
	   */
	  // Spring에서 지원하는 데이터 전달객체를 이용해서 JSP로 전송 : Model
	  //DB연동 
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);//현재페이지 
	  int rowSize=20;
	  int start=(rowSize*curpage)-(rowSize-1);// 1~20 , 21~40
	  int end=rowSize*curpage;
	  Map map=new HashMap();
	  map.put("start",start);
	  map.put("end", end);
	  
	  List<HotelVO> list=dao.hotelListData(map);
	  for(HotelVO vo:list)
	  {
		  String name=vo.getName();
		  if(name.length()>10)
		  {
			  name=name.substring(0,10)+"...";  
		  }
		  vo.setName(name);
	  }
	  // WHERE num BETWEEN #{start} AND #{end}
	  // 1page                 1          20
	  // 2page                 21         40
	  // 총페이지 구하기 
	  int totalpage=dao.hotelTotalPage();
	  
	  // 블록별 처리 
	  final int BLOCK=5;
	  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	  //     (5-1)/5*5 => 0  4/5
	  //             (6-1)/5*5 => 5+1 => 6
	  //             (10-1)/5*5 => 5+1 => 6
	  // curpage=> 1~5  => startPage=1 
	  // [1][2][3][4][5]
	  // curpage=> 6~10  => startPage=6
	  // [6][7][8][9][10]
	  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	  
	  if(endPage>totalpage)
	  {
		  endPage=totalpage;
	  }
	  
	  // JSP에서 출력하는 데이터를 전송 
	  model.addAttribute("list", list);
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  model.addAttribute("startPage", startPage);
	  model.addAttribute("endPage", endPage);
	  model.addAttribute("main_jsp", "../seoul/hotel/list.jsp");
	  //                      출력 
	  // 쿠키 출력 
	  Cookie[] cookies=request.getCookies();
	  List<HotelVO> cList=new ArrayList<HotelVO>();
	  if(cookies!=null) // 쿠키가 존재할때 
	  {
		  for(int i=cookies.length-1;i>=0;i--)//최신 등록된 데이터부터 읽기 시작
		  {
			  // 키 => getName() 
			  // 값 => getValue()
			  if(cookies[i].getName().startsWith("h"))
			  {
				  String no=cookies[i].getValue();
				  HotelVO vo=dao.hotelDetailData(Integer.parseInt(no));
				  cList.add(vo);
			  }
		  }
		  model.addAttribute("cList", cList);
	  }
	  return "main/main"; // 출력된 list.jsp => include
  }
  // 쿠키 설정 
  @GetMapping("seoul/hotel/detail_before.do")
  public String seoul_hotel_detail_before(int no,RedirectAttributes ra,
		  HttpServletResponse response)
  {
	  // Cookie이용 => 내장 객체가 아니다 , response로 클라이언트 로 전송 
	  // sendRedirect를 이용해서 화면 변경시 데이터 전송 => RedirectAttributes
	  // 매개변수는 순서가 존재하지 않는다 (원하는 데이터형으로 DispatcherServlet으로 받을 수 있다)
	  /*
	   *   매개변수를 이용해서 객체단위 
	   *   =====================
	   *   HttpSevletRequest : Cookie읽기  
	   *   HttpServletResponse : Cookie전송 , 다운로드시에 주로 사용 
	   *   HttpSession : 로그인 , 로그아웃 ..
	   *   커맨드 객체 : ~VO : insert,update시에 단위 VO단위로 받을 수 있다
	   *   일반 데이터형 => int , double , boolean , String 
	   *                <a => ?> , axios , ajax
	   *   RedirectAttributes : 전송객체 (sendRedirect())
	   *                        GET방식 => detail.do?no=1
	   *                                           ------ 별도로 생성이 가능 
	   *   Model : 전송 객체 (forward()) : 데이터를 전송 (request.setAttribute()대신 사용)
	   *   
	   *   response를 이용해서 브라우저에 값을 전송(한개의 기능에서 메소드에서 
	   *            HTML/Cookie를 동시에 전송 할 수 없다) 
	   *   -------- 각 JSP에서 한번만 사용이 가능 
	   *            = HTML (JSP를 번역한 HTML)
	   *            = Cookie 
	   *   Cookie사용 
	   *   1) Cookie 생성 
	   *      Cookie cookie=new Cookie(키 , 값) => map방식 
	   *                          키는 중복이 불가능(덮어쓴다)
	   *                          값 : String만 저장이 가능 
	   *   2) 저장위치 설정 
	   *      setPath("/") 
	   *   3) 저장기간 설정 
	   *      setMaxAge(초) => 60*60*24 ==> 0이면 삭제
	   *   4) 클라이언트로 전송 
	   *      쿠키는 클라이언트에 저장 
	   *      => 방문기록 / 자동 로그인 (보안)
	   */
	  // Cookie(String name, String value)
	  Cookie cookie=new Cookie("h"+no, String.valueOf(no));
	  //  키는 중복이 있으면 안된다    -------- no(PK)
	  //  path설정 
	  cookie.setPath("/");
	  //  기간설정
	  cookie.setMaxAge(60*60*24);
	  //  클라이언트로 전송 
	  response.addCookie(cookie);
	  ra.addAttribute("no", no);
	  // redirect:/main/seoul/hotel/detail.do?no=1
	  return "redirect:http://localhost:8080/main/seoul/hotel/detail.do";
  }
  @GetMapping("seoul/hotel/detail.do")
  public String seoul_hotel_detail(int no,Model model)
  {
	  // 오라클로부터 데이터 읽기 
	  HotelVO vo=dao.hotelDetailData(no);
	  model.addAttribute("vo", vo);
	  // vo를 받아서 출력하는 JSP가 존재 
	  model.addAttribute("main_jsp", "../seoul/hotel/detail.jsp");
	  // main에서 incude를 사용해서 화면을 조립 
	  return "main/main";
  }
}







