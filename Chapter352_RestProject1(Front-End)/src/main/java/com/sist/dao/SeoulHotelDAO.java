package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;//vuex
@Repository
public class SeoulHotelDAO {
   @Autowired
   private SeoulHotelMapper mapper;
   
   public List<SeoulHotelVO> hotelListData(Map map)
   {
	   return mapper.hotelListData(map);
   }
   public SeoulHotelVO hotelDetailData(int no)
   {
	   return mapper.hotelDetailData(no);
   }
   public int hotelTotalPage()
   {
	   return mapper.hotelTotalPage();
   }
}
