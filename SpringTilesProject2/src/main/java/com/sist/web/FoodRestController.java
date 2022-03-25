package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//vueJs => List,Object는 인식할 수 없다 
//JSON 
// javascript => List<FoodVO> => [] (JSONArray)
// FoodVO => {} (JSONObject)
// 호환 => 다른언어 (jsp => php , asp) 모바일 , Javascript => JSON,XML
// RestFul
// Front / Back 
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
   
   @GetMapping(value="food/find_vue.do",produces = "text/plain;charset=utf-8")
   public String food_find(String page,String addr)
   {
	   String result="";
	   try
	   {
		   if(page==null)
			   page="1";
		   if(addr==null)
			   addr="강남";
		   int curpage=Integer.parseInt(page);
		   int rowSize=12;
		   int start=(rowSize*curpage)-(rowSize-1);
		   int end=rowSize*curpage;
		   Map map=new HashMap();
		   map.put("start", start);
		   map.put("end", end);
		   map.put("address", addr);
		   List<FoodVO> list=dao.foodFindData(map);
		   int totalpage=dao.foodFindTotalPage(addr);
		   
		   JSONArray arr=new JSONArray();//List매칭
		   int i=0;
		   //[{no:1,name:'',score:0.0,poster:''},{},{},{},{}...]
		   /*
		    *  let a=[] => Array
		    *  let a={no:1} => Object 
		    *      a.no
		    */
		   for(FoodVO vo:list)
		   {
			   JSONObject obj=new JSONObject();//vo의 값을 담아준다 
			   obj.put("no", vo.getNo());
			   obj.put("name", vo.getName());
			   obj.put("score", vo.getScore());
			   String poster=vo.getPoster();
			   poster=poster.substring(0,poster.indexOf("^"));
			   obj.put("poster", poster);
			   if(i==0)
			   {
				   obj.put("curpage", curpage);
				   obj.put("totalpage", totalpage);
			   }
			   
			   arr.add(obj);
			   i++;
			   
		   }
		   result=arr.toJSONString();
	   }catch(Exception ex){}
	   return result;
   }
}












