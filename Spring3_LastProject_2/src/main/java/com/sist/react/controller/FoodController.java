package com.sist.react.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.react.service.*;
import com.sist.react.vo.*;
@RestController
public class FoodController {
   @Autowired
   private ReactService service;
   
   @GetMapping("/food/category")
   public List<CategoryVO> foodCategoryData(int no)
   {
	   Map map=new HashMap();
	   if(no==1)
	   {
		   map.put("start", 1);
		   map.put("end", 12);
	   }
	   else if(no==2)
	   {
		   map.put("start", 13);
		   map.put("end", 18);
	   }
	   else if(no==3)
	   {
		   map.put("start", 19);
		   map.put("end", 30);
	   }
	   return service.foodCategoryData(map);
   }
}
