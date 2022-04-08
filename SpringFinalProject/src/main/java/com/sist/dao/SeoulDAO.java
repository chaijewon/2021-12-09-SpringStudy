package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class SeoulDAO {
   @Autowired
   private SeoulMapper mapper;
   
   public List<SeoulVO> seoulLocationData(Map map)
   {
	   return mapper.seoulLocationData(map);
   }
   public int seoulLocationTotalPage()
   {
	   return mapper.seoulLocationTotalPage();
   }
   
   public List<SeoulVO> seoulNatureData(Map map)
   {
	   return mapper.seoulNatureData(map);
   }
   public int seoulNatureTotalPage()
   {
	   return mapper.seoulNatureTotalPage();
   }
   
   public List<SeoulVO> seoulHotelData(Map map)
   {
	   return mapper.seoulHotelData(map);
   }
   public int seoulHotelTotalPage()
   {
	   return mapper.seoulHotelTotalPage();
   }
   
   ////////////////// 상세보기 
   public SeoulVO seoulLocationDetailData(int no)
   {
	   return mapper.seoulLocationDetailData(no);
   }
   public List<FoodVO> seoulLocationFoodHouse(String address)
   {
	   return mapper.seoulLocationFoodHouse(address);
   }
   public List<RecipeVO> seoulLocationRecipe(String type)
   {
	   return mapper.seoulLocationRecipe(type);
   }
   public SeoulVO seoulNatureDetailData(int no)
   {
	   return mapper.seoulNatureDetailData(no);
   }
   
   public SeoulVO seoulHotelDetailData(int no)
   {
	   return mapper.seoulHotelDetailData(no);
   }
   
   public SeoulVO seoulMyLocationData(String address)
   {
	   return mapper.seoulMyLocationData(address);
   }
   
   public FoodVO seoulMyFoodData1(String address)
   {
	   return mapper.seoulMyFoodData1(address);
   }
   public FoodVO seoulMyFoodData2(String address)
   {
	   return mapper.seoulMyFoodData2(address);   
   }
   public SeoulVO seoulMyNatureData(String address)
   {
	   return mapper.seoulMyNatureData(address);
   }
}
