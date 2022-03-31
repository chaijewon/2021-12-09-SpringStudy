package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.dao.FoodReplyDAO;
import com.sist.service.*;
// 오라클 데이터를 읽어서 => 요청 처리 => 결과값 전송 
// JSP
@Controller // HandlerMapping => 반드시 
// @Controller / @RestController 
// @RequestMapping , @GetMapping , @PostMapping 
// 어노테이션 => 구분자 (if) => 2문제
@RequestMapping("food/")
/*
 *   GET , POST => @RequestMapping => 로그인 (유효성검사) => GET(로그인창)
 *                                                      
 *                                                      POST(정상)
 *   ===   ==== 개발자 요청에 의해 4.3버전
 *   @GetMapping , @PostMapping
 */
public class FoodController {
   @Autowired
   private FoodService service;
   
   @Autowired
   private FoodReplyDAO dao;
   
   //private String today;
   private HttpSession session;
   // 사용자 요청한 주소를 확인 (사용자(브라우저) => 서버(주소))
   // http://localhost:8080/web/food/main.do?no=1 => uri은 ?를 포함하지 않는다 
   @GetMapping("main.do")
   public String food_main(Model model,HttpSession session)
   {
	  this.session=session;
	   // request,response는 사용하지 않고 동작이 가능 
	   // 사용자가 보내준 값은 : 매개변수를 이용한다 
	   // 전송 : 전송객체 (Model)
	   List<CategoryVO> list=service.categoryListData();
	   model.addAttribute("list", list); //model => request가 포함 
	   
	   
	   /*JobKey jobKey = new JobKey("wordCloudJob");
	   Scheduled scheduler = schedulerBean.getScheduler();
	   scheduler.triggerJob(jobKey);*/
	   /*
	    *   
	    */
	   // request.setAttribute()
	   return "food/main"; //jsp는 포함하면 안된다 => ViewName
   }
   // 중복이 있는 경우에는 제거가 가능 ...
   
   @GetMapping("list.do")
   public String food_list(int cno,Model model)
   {
	   CategoryVO vo=service.categoryInfoData(cno);
	   List<FoodVO> list=service.categoryFoodListData(cno);
	   for(FoodVO fvo:list)
	   {
		   String poster=fvo.getPoster();
		   poster=poster.substring(0,poster.indexOf("^"));
		   fvo.setPoster(poster);
		   
		   String address=fvo.getAddress();
		   address=address.substring(0,address.lastIndexOf("지"));
		   fvo.setAddress(address);
	   }
	   model.addAttribute("vo", vo);
	   model.addAttribute("list", list);
	   return "food/list";
   }
   
   @GetMapping("detail_before.do")
   /*
    *   DispatcherServlet (Front Controller)
    *   클라이언트 = 요청 = DispatcherServlet => HandlerMapping => 
    *   @Controller
    *   = ViewResolver = JSP
    *   
    *   *** 중요
    *   DispatcherServlet을 통해서 요청값을 받거나 내장객체 
    *   => 매개변수를 이용한다 
    *      1) 사용자 요청값 => 일반 데이터(int , String ...)
    *      2) 커맨드 객체 => ~VO (insert,update,join...)
    *      3) List (파일업로드 여러개), [](checkbox)로 받을 수 있다
    *      4) 내장 객체, 스프링에서 제공하는 클래스 
    *         HttpServletRequest : cookie값을 읽기 
    *         HttpServletResponse :  cookie전송 
    *         RediectAttributes 
    *         HttpSession 
    *         Model 
    *         ***Errors
    */
   public String detail_before(int no,HttpServletResponse response,RedirectAttributes ra)
   {
	   // request는 Cookie생성시에 사용
	   
	   //1. Cookie 생성 => 문자열만 저장이 가능 
	   Cookie cookie=new Cookie("f"+no,String.valueOf(no));
	   //2. path지정 
	   cookie.setPath("/");
	   //3. 기간 
	   cookie.setMaxAge(60*60*24);
	   //4. 클라이언트로 전송 
	   response.addCookie(cookie);
	   
	   ra.addAttribute("no", no);
	   /*
	    *   model => forward일때 전송 (데이터) 
	    *   ra    => sendRedirect() 데이터 전송 
	    */
	   return "redirect:detail.do";
   }
   /*
    *   GetMapping => <a> ,location.href="" , sendRedirect():redirect:detail.do
    *   PostMaping => <form> , ajax({type:'POST'}
    *                 axios.post() => @PostMapping
    *                 axios.get() => @GetMapping
    *   default : GET
    */
   @GetMapping("detail.do")
   public String food_detail(int no,Model model)
   {
	   //1.  데이터 읽기 => 오라클 
	   Map map=new HashMap();
	   map.put("no", no);
	   map.put("table_name", "food_house");
	   FoodVO vo=service.foodDetailData(map);
	   // 카페 / 디저트  => 카페|디저트
	   List<RecipeVO> list=service.recipeTypeData(vo.getType().replace("/", "|").replace(" ", "").replace("기타", ""));
	   List<FoodReplyVO> rList=dao.replyListData(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("list", list);
	   model.addAttribute("rList", rList);
	   model.addAttribute("msg", "관리자가 삭제한 댓글입니다");
	   return "food/detail";
   }
   
   @GetMapping("find.do")
   public String food_find()
   {
	   return "food/find";
   }
   
  /* @Scheduled(cron="0/3 * * * * *")
   public void myScheduled() throws Exception
   {
	   
	   String today=new SimpleDateFormat("hh:mm:ss").format(new Date());
	   System.out.println(today+":Hello Spring!!");
	   session.setAttribute("today", today);
	   
   }*/
   /*
    *  스케쥴링 할 메소드위에 @scheduled 어노테이션을 입력한 후에 시간설정하면 끝
		시간 설정 @scheduled(cron=" ")  * 리눅스 crontab 과 같은 설정방법
		<예제>
		   @Scheduled(cron="0 0 05 * * ?") = 매일 5시에 실행
		   @Scheduled(cron="0 0 02 2,20 * ?") = 매월 2일,20일 새벽2시에 실행
		***********************************************************************
		 ---  cron 양식 ---
		 -초 0-59 , - * / 
		 -분 0-59 , - * / 
		 -시 0-23 , - * / 
		 -일 1-31 , - * ? / L W
		 -월 1-12 or JAN-DEC , - * / 
		 -요일 1-7 or SUN-SAT , - * ? / L # 
		 -년(옵션) 1970-2099 , - * /
		
		* : 모든 값
		? : 특정 값 없음
		- : 범위 지정에 사용
		, : 여러 값 지정 구분에 사용
		/ : 초기값과 증가치 설정에 사용
		L : 지정할 수 있는 범위의 마지막 값
		W : 월~금요일 또는 가장 가까운 월/금요일
		# : 몇 번째 무슨 요일 2#1 => 첫 번째 월요일
		
		초 분 시 일 월 주(년)
		 "0 0 12 * * ?" : 아무 요일, 매월, 매일 12:00:00
		 "0 15 10 ? * *" : 모든 요일, 매월, 아무 날이나 10:15:00 
		 "0 15 10 * * ?" : 아무 요일, 매월, 매일 10:15:00 
		 "0 15 10 * * ? *" : 모든 연도, 아무 요일, 매월, 매일 10:15 
		 "0 15 10 * * ? : 2005" 2005년 아무 요일이나 매월, 매일 10:15 
		 "0 * 14 * * ?" : 아무 요일, 매월, 매일, 14시 매분 0초 
		 "0 0/5 14 * * ?" : 아무 요일, 매월, 매일, 14시 매 5분마다 0초 
		 "0 0/5 14,18 * * ?" : 아무 요일, 매월, 매일, 14시, 18시 매 5분마다 0초 
		 "0 0-5 14 * * ?" : 아무 요일, 매월, 매일, 14:00 부터 매 14:05까지 매 분 0초 
		 "0 10,44 14 ? 3 WED" : 3월의 매 주 수요일, 아무 날짜나 14:10:00, 14:44:00 
		 "0 15 10 ? * MON-FRI" : 월~금, 매월, 아무 날이나 10:15:00 
		 "0 15 10 15 * ?" : 아무 요일, 매월 15일 10:15:00 
		 "0 15 10 L * ?" : 아무 요일, 매월 마지막 날 10:15:00 
		 "0 15 10 ? * 6L" : 매월 마지막 금요일 아무 날이나 10:15:00 
		 "0 15 10 ? * 6L 2002-2005" : 2002년부터 2005년까지 매월 마지막 금요일 아무 날이나 10:15:00 
		 "0 15 10 ? * 6#3" : 매월 3번째 금요일 아무 날이나 10:15:00
		
		리눅스의 Cron 예제
		예) 40 3 * * * root /home/mysql/mysql_backup.sh
		맨 앞의 40은 40분을 의미함 (분을 의미:0~59)
		그 뒤의 3은 03시를 의미함 (시를 의미:0~23)
		그 뒤의 * 은 매일을 의미함 (일을 의미:1~31)
		그 뒤의 * 은 매월을 의미함 (월을 의미:1~12)
		그 뒤의 * 은 매주를 의미함(요일을 의미 1:월요일~7:일용일)
		그 뒤의 root /home/mysql/mysql_backup.sh 는 root  계정으로 mysql_backup.sh을 실행하라는 의미
		문자 : 각 필드에 해당하는 모든 숫자를 의미
		문자 : 각 필드자리에 하이픈 문자가 올수 있음
		ex) 일 필드자리에 11-15 (11,12,13,14,15일을 의미)
		문자 : 각 필드자리에 콤마문자가 올수 있음
		ex) 일 필드자리에 1,11,21 (1일,11일 21일을 의미)
		1/2000 초 설정법
		@Scheduled(fixedDelay=2000)
		
    */
}









