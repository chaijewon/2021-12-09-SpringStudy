package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class HotelDAO {
   @Autowired // 자동 주입 
   private HotelMapper mapper;
   
   public List<HotelVO> hotelListData()
   {
	   return mapper.hotelListData();
   }
}
