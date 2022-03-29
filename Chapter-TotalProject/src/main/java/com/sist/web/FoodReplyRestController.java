package com.sist.web;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;
@RestController
public class FoodReplyRestController {
   // 문제 => Singleton에 대한 설명 => 스프링에서 사용하고 있는 패턴을 종류 
   // 싱글턴 , 팩토리 , 어뎁터패턴 (형변환 통일)=> HandlerAdapter , 프록시(대리자) : 위빙, 옵버저(이벤트발생 서버에 알려주는)....
   @Autowired
   private FoodReplyDAO dao;
   
   @Autowired
   private FoodService service;// FoodController에도 존재 (같은 객체)
   // 싱글턴  => 싱글턴 패턴 (static)
   // 결과값만 보내는 상태 => Rest , 객체(JSON)
   // Spring-Boot => 자동으로 JSON처리 (jackson-bind) => react/redux , vuejs => 웹스톰(nodejs)
   // 스프링 => 자바 (jdk)
   @PostMapping("food/login_ok.do")
   public String food_login_ok(String id,String pwd,HttpSession session)
   {
	   //1. 정보받기 
	   String result=dao.isLogin(id, pwd);
	   if(!(result.equals("NOID")&& result.equals("NOPWD")))
	   {
		   // 로그인이 된 상태 
		   session.setAttribute("id", id);
		   session.setAttribute("name", result);
	   }
	   return result;
	   
   }
   
   // axios.get , axios.post => find_vue/1/강남 => PathValiable 
   @GetMapping(value="food/find_vue.do",produces = "text/plain;charset=utf-8")
   public String find_vue(int page,String ss)
   {
	   int curpage=page;
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1); // rownum = 1
	   // MySql => 0    limit ?,?  => JPA => 0, 갯수
	   int end=(rowSize*curpage);
	   map.put("start", start);
	   map.put("end", end);
	   map.put("address", ss);
	   List<FoodVO> list=service.foodFindData(map);
	   int totalpage=service.foodFindTotalpage(ss);
	   //JSON => Spring-Boot => return list => 자동으로 JSON변경 
	   JSONArray arr=new JSONArray(); //[]
	   int i=0;
	   for(FoodVO vo:list)
	   {
		   JSONObject obj=new JSONObject();
		   obj.put("no", vo.getNo()); // link => 상세보기 
		   obj.put("name", vo.getName());
		   String poster=vo.getPoster();
		   poster=poster.substring(0,poster.indexOf("^"));
		   obj.put("poster", poster);
		   if(i==0)
		   {
			   obj.put("curpage", curpage);
			   obj.put("totalpage", totalpage);
		   }
		   arr.add(obj); // 배열에 추가 [{},{},{},{}....]
		   i++;
	   }
	   return arr.toJSONString();
   }
   // 상세보기 정보 전송 
   @GetMapping(value="food/detail_vue.do",produces ="text/plain;charset=utf-8")
   public String food_detail(int no)
   {
	   // 오라클에 읽기 => JSON변경 => 자바와 자바스크립트 매칭 
	   Map map=new HashMap();
	   map.put("no", no);
	   map.put("table_name","food_location");
	   FoodVO vo=service.foodDetailData(map);
	   /*
	    *   no,poster,name,tel,type,address,score,
		    time,parking,menu
	    */
	   JSONObject obj=new JSONObject();
	   obj.put("no", vo.getNo());//obj.put("no", 1); {no:1 ,name:''....
	   obj.put("poster", vo.getPoster());
	   obj.put("name", vo.getName());
	   obj.put("tel", vo.getTel());
	   obj.put("type", vo.getType());
	   obj.put("address", vo.getAddress());
	   obj.put("score", vo.getScore());
	   obj.put("time", vo.getTime());
	   obj.put("parking", vo.getParking());
	   obj.put("menu", vo.getMenu());
	   return obj.toJSONString();
   }
}








