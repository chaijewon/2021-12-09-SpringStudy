package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
// jsp로 처리 요청값을 전송 
// 일반 데이터 , 데이터를 묶어서 전송 (JSON,XML)
public class FoodRestController {
    @Autowired
    private FoodService service; // FoodController에서 사용하는 service와 동일한 객체 
    // 스프링은 싱글턴 객ㅊ테를 가지고 있다 (재사용) = 메모리 절약방법 
    //146페이지 객체 타입 (자바스크립트에 데이터 타입 : 객체 => {키:값} => JSON)
    @GetMapping(value = "food_js/food_list.do",
    		produces = "text/plain;charset=UTF-8")
    public String food_list(int cno)
    {
    	//1. 데이터베이스 값을 가지고 온다 
    	List<FoodVO> list=service.categoryFoodListData(cno);
    	for(FoodVO vo:list)
    	{
    		String poster=vo.getPoster();
    		poster=poster.substring(0,poster.indexOf("^"));
    		vo.setPoster(poster);
    		
    		String address=vo.getAddress();
    		address=address.substring(0,address.lastIndexOf("지"));
    		vo.setAddress(address);
    	}
    	
    	//1. 배열 ==> javascript List(X) => [] => JSONArray
    	JSONArray arr=new JSONArray();
    	//2. 객체(VO) => javascript VO(X) => {} => JSONObject
    	for(FoodVO vo:list)
    	{
    		JSONObject obj=new JSONObject();
    		obj.put("no", vo.getNo());
    		obj.put("poster",vo.getPoster());
    		obj.put("name",vo.getName());
    		obj.put("score",vo.getScore());
    		obj.put("type",vo.getType());
    		obj.put("tel",vo.getTel());
    		obj.put("address",vo.getAddress());
    		//{no:1,poster:'http~',name:'',score:5.0,....}
    		// 배열에 첨부 
    		arr.add(obj);
    	}
    	return arr.toJSONString();
    }
    
    @GetMapping(value="food_js/food_info.do",produces ="text/plain;charset=UTF-8")
    public String food_info(int cno)
    {
    	//DB연동
    	CategoryVO vo=service.categoryInfodata(cno);
    	JSONObject obj=new JSONObject();
    	obj.put("title", vo.getTitle());
    	obj.put("subject",vo.getSubject());
    	return obj.toJSONString();
    }
}











