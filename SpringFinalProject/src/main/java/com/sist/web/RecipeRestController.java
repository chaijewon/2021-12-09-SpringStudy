package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class RecipeRestController {
      @Autowired
      private RecipeDAO dao;
      
      @RequestMapping(value="recipe/recipe_find_vue.do",produces="text/plain;charset=utf-8")
      public String recipe_find(String fd,int page)
      {
    	  String result="";
    	  // DAO => List => [](Array) => JavaScript 
    	  try
    	  {
    		 int curpage=page;
    		 int rowSize=12;
    		 int start=(rowSize*curpage)-(rowSize-1);
    		 int end=rowSize*curpage;
    		 Map map=new HashMap();
    		 map.put("start", start);
    		 map.put("end", end);
    		 map.put("fd", fd);
    		 List<RecipeVO> list=dao.recipeFindData(map);
    		 int totalpage=dao.recipeFindTotalPage(fd);
    		 
    		 //JSON으로 변경 
    		 //list = JSONArray
    		 JSONArray arr=new JSONArray();
    		 int i=0;
    		 for(RecipeVO vo:list)
    		 {
    			 JSONObject obj=new JSONObject();//VO가 가지고 있는 데이터 첨부
    			 obj.put("no", vo.getNo()); //{"no":1}
    			 obj.put("title", vo.getTitle());
    			 obj.put("chef", vo.getChef());
    			 obj.put("poster", vo.getPoster());
    			 if(i==0)
    			 {
    				 obj.put("curpage", curpage);
    				 obj.put("totalpage", totalpage);
    			 }
    			 arr.add(obj);
    			 i++;
    			 /*
    			  *   [
    			  *      {no:1,title:"",chef:"",poster:"",curpage:1,totalpage:20},
    			  *      {no:1,title:"",poster:""},
    			  *      {no:1,title:"",chef:"",poster:""},
    			  *   ]
    			  *   JSON => 데이터갯수는 무시 (가변형) => DB (NoSQL:몽고디비,카산드라)
    			  */
    		 }
    		 result=arr.toJSONString();
    	  }catch(Exception ex){}
    	  return result;
      }
}





