package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
@RestController // Ajax , VueJS (vuex), ReactJS (redux)
public class SeoulRestController {
   @Autowired
   private SeoulHotelDAO dao;
   
   @GetMapping(value="hotel/list.do",produces="text/plain;charset=utf-8")
   public String hote_list(int page)
   {
	   Map map=new HashMap();
	   int rowSize=20;
	   int start=(rowSize*page)-(rowSize-1);
	   int end =rowSize*page;
	   map.put("start", start);
	   map.put("end", end);
	   List<SeoulHotelVO> list=dao.hotelListData(map);
	   int totalpage=dao.hotelTotalPage();
	   
	   JSONArray arr=new JSONArray();//List
	   int i=0;
	   for(SeoulHotelVO vo:list)
	   {
		   JSONObject obj=new JSONObject();//VO
		   obj.put("no", vo.getNo());
		   obj.put("poster", vo.getPoster());
		   obj.put("name", vo.getName());
		   if(i==0)
		   {
			   obj.put("curpage", page);
			   obj.put("totalpage", totalpage);
		   }
		   arr.add(obj);
		   i++;
		   
	   }
	   System.out.println(arr.toJSONString());
	   return arr.toJSONString();
	   
   }
   // List ==> JSONArray
   // VO   ==> JSONObject
   @GetMapping(value="hotel/detail.do",produces = "text/plain;charset=utf-8")
   public String hotel_detail(int no)
   {
	   SeoulHotelVO vo=dao.hotelDetailData(no);
	   JSONObject obj=new JSONObject();
	   obj.put("no", vo.getNo());
	   obj.put("name", vo.getName());
	   obj.put("score", vo.getScore());
	   obj.put("address", vo.getAddress());
	   obj.put("poster", vo.getPoster());
	   obj.put("images", vo.getImages());
	   return obj.toJSONString();
   }
   @GetMapping(value="hotel/detail2.do",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
   public SeoulHotelVO hotel_detail2(int no)
   {
	   SeoulHotelVO vo=dao.hotelDetailData(no);
	   return vo;
   }
   @GetMapping(value="hotel/list2.do",produces="text/plain;charset=utf-8")
   public List<SeoulHotelVO> hote_list2(int page)
   {
	   Map map=new HashMap();
	   int rowSize=20;
	   int start=(rowSize*page)-(rowSize-1);
	   int end =rowSize*page;
	   map.put("start", start);
	   map.put("end", end);
	   List<SeoulHotelVO> list=dao.hotelListData(map);
	   int totalpage=dao.hotelTotalPage();
	   return list;
   }
}







