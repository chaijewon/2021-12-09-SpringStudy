package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.manager.*;
@RestController
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
   
   @Autowired
   private RecommandManager rm;
   
   @GetMapping(value="food/food_recommand_vue.do",produces = "text/plain;charset=utf-8")
   public String food_recommand(int no)
   {
	   String result="";
	   if(no==1)
	   {
		   String[] data={"외로움","기분전환", "슬픔", "이별",
				   "지침","힘듦", "설렘" ,"스트레스","짜증", "그리움",
				   "우울", "행복", "불안", "분노", "기쁨" };
		   JSONArray arr=new JSONArray();
		   for(String d:data)
		   {
			   arr.add(d);
		   }
		   result=arr.toJSONString();
	   }
	   else if(no==2)
	   {
		   String[] data={"봄", "여름", "가을", "겨울",
				   "맑은날", "추운날", "흐린날","비오는날", "더운날", "눈오는날"};
		   JSONArray arr=new JSONArray();
		   for(String d:data)
		   {
			   arr.add(d);
		   }
		   result=arr.toJSONString();
	   }
	   return result;
   }
   @GetMapping(value="food/food_find_vue.do",produces = "text/plain;charset=utf-8")
   public String food_find(String fd)
   {
	   String result="";
	   List<String> nList=dao.foodGetNameData();
	   List<String> rList=rm.recommandData(fd);
	   List<String> fList=new ArrayList<String>();
	   
	   Pattern[] p=new Pattern[nList.size()];
	   // 단어 , 정규패턴 
	   // 맛있다 , 맛있고 , 맛있고 .....   => 맛있+ 
	   // *(0이상)  ,  +(1이상)  , ? (0,1이상)  , |(선택) 
	   // [] => 범위 => 숫자[0-9] , 한글[가-힣] , 알파벳[A-Z] [a-z]
	   // [A-Za-z] 
	   // ^[가-힣] => 한글 시작  => ^[0-9] 
	   // [^가-힣] => 한글 제외 
	   // [0-9]$ => 숫자로 종료 
	   // {} => 갯수 {1} , {1,10} 
	   // [0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}
	   for(int i=0;i<p.length;i++)
	   {
		   p[i]=Pattern.compile(nList.get(i));
	   }
	   Matcher[] m=new Matcher[nList.size()];
	   int[] count=new int[nList.size()];
	   for(String s:rList)
	   {
		   for(int i=0;i<m.length;i++)
		   {
			   m[i]=p[i].matcher(s);
			   while(m[i].find())
			   {
				   String ss=m[i].group();
				   if(ss.length()>1)
				   {
				     System.out.println(ss);
				     fList.add(ss);
				     count[i]++;
				   }
			   }
		   }
	   }
	   
	   // 출력 
	   Set set=new HashSet();
	   for(int i=0;i<fList.size();i++)
	   {
		   set.add(fList.get(i));
	   }
	   System.out.println("=========== 중복제거 ============");
	   //fList.clear();
	   List<FoodVO> pList=new ArrayList<FoodVO>();
	   Iterator iter = set.iterator();	// Iterator 사용
	   while(iter.hasNext()) {//값이 있으면 true 없으면 false
	       //System.out.println(iter.next());
		   String ss=iter.next().toString();
		   System.out.println(ss);
	       List<FoodVO> vo=dao.foodNameFindData(ss);
	       pList.add(vo.get(0));
	       
	   }
		
	   JSONArray arr=new JSONArray();
	   for(FoodVO vo:pList)
	   {
		   JSONObject obj=new JSONObject();
		   obj.put("no", vo.getNo());
		   obj.put("poster", vo.getPoster());
		   obj.put("name", vo.getName());
		   arr.add(obj);
	   }
	   result=arr.toJSONString();
	   return result;
   }
}







