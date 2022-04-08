package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
      /*
       *    전체밑반찬메인반찬국/탕찌개디저트면/만두밥/죽/떡퓨전김치/젓갈/장류양념/소스/잼양식샐러드스프빵과자차/음료/술기타
			전체일상초스피드손님접대술안주다이어트도시락영양식간식야식푸드스타일링해장명절이유식기타
			전체소고기돼지고기닭고기육류채소류해물류달걀/유제품가공식품류쌀밀가루건어물류버섯류과일류콩/견과류곡류기타
			전체볶음끓이기부침조림무침비빔찜절임튀김삶기굽기데치기회기타
			테마별
			여성/뷰티 엄마/아기 건강/질병 제철요리 추천
       */
      @GetMapping(value="recipe/recipe_recommand_vue.do",produces = "text/plain;charset=utf-8")
      public String recipe_recommand(int no)
      {
    	  String result="";
    	  if(no==1)
    	  {
    		  String[] data={"밑반찬","메인반찬","국/탕","찌개","디저트","면/만두","밥/죽/떡","퓨전","김치/젓갈/장류","양념/소스/잼","양식","샐러드","스프","빵","과자","차/음료/술"};
    	      JSONArray arr=new JSONArray();
    	      for(String d:data)
    	      {
    	    	  arr.add(d);
    	      }
    	      result=arr.toJSONString();
    	  }
    	  else if(no==2)
    	  {
    		  String[] data={"일상","초스피드","손님접대","술안주","다이어트","도시락","영양식","간식","야식","해장","이유식"};
    		  JSONArray arr=new JSONArray();
    		  for(String d:data)
    	      {
    	    	  arr.add(d);
    	      }
    	      result=arr.toJSONString();
    	  }
    	  else if(no==3)
    	  {
    		  String[] data={"소고기","돼지고기","닭고기","육류","채소류","해물류","달걀","밀가루","건어물","버섯","과일","곡류"};
    		  JSONArray arr=new JSONArray();
    		  for(String d:data)
    	      {
    	    	  arr.add(d);
    	      }
    	      result=arr.toJSONString();
    	  }
    	  else if(no==4)
    	  {
    		  String[] data={"볶음","끓이기","부침","조림","무침","비빔","찜","절임","튀김","삶기","굽기","데치기","회"};
    		  JSONArray arr=new JSONArray();
    		  for(String d:data)
    	      {
    	    	  arr.add(d);
    	      }
    	      result=arr.toJSONString();
    	  }
    	  else if(no==5)
    	  {
    		  String[] data={"여성/뷰티", "엄마/아기", "건강/질병", "제철요리"};
    		  JSONArray arr=new JSONArray();
    		  for(String d:data)
    	      {
    	    	  arr.add(d);
    	      }
    	      result=arr.toJSONString();
    	  }
    	  return result;
      }
      @GetMapping(value="recipe/recipe_recom_data_vue.do",
    		  produces = "text/plain;charset=utf-8")
      public String recipe_recom_data(int page,String fd)
      {
    	  System.out.println("page="+page);
    	  System.out.println("fd="+fd);
    	  String result="";
    	  try
    	  {
    		  int curpage=page;
    		  Map map=new HashMap();
    		  int rowSize=12;
    		  int start=(rowSize*curpage)-(rowSize-1);
    		  int end=(rowSize*curpage);
    		  
    		  map.put("start", start);
    		  map.put("end", end);
    		  map.put("fd", fd.replace("/", "|"));
    		  
    		  List<RecipeVO> list=dao.recipeRecommandData(map);
    		  int totalpage=dao.recipeRecommandTotalPage(fd.replace("/", "|"));
    		  
    		  //JSON => 전송 
    		  JSONArray arr=new JSONArray();
    		  int i=0;
    		  for(RecipeVO vo:list)
    		  {
    			  //vo => JSONObject
    			  JSONObject obj=new JSONObject(); // JSONP
    			  // Vue , React , NodeJS => Full Stack 
    			  // Spring , Spring-boot => NodeJS
    			  obj.put("no", vo.getNo());
    			  obj.put("poster", vo.getPoster());
    			  obj.put("title", vo.getTitle());
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
      
      @PostMapping(value="recipe/recipe_goods_data.do",produces = "text/plain;charset=utf-8")
      public String recipe_goods_data(String fd)
      {
    	  String result="";
    	  try
    	  {
    		  fd=fd.substring(0,fd.indexOf(" "));
    		  int count=dao.goodsCountData(fd);
    		  List<GoodsVO> list=dao.goodsLikeData(fd);
    		  JSONArray arr=new JSONArray();//[] => [{},{},{}..]
    		  int i=0;
    		  for(GoodsVO vo:list)
    		  {
    			  JSONObject obj=new JSONObject();//{}
    			  obj.put("name", vo.getProduct_name());
    			  obj.put("poster", vo.getProduct_poster());
    			  obj.put("price", vo.getProduct_price());
    			  if(i==0)
    			  {
    				  obj.put("count", count);
    			  }
    			  arr.add(obj);
    			  i++;
    		  }
    		  result=arr.toJSONString();
    	  }catch(Exception ex){}
    	  return result;
      }
}





