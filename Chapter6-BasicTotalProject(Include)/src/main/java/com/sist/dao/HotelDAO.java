package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;
@Repository
public class HotelDAO {
   // 구현된 클래스 읽기 
   @Autowired
   private HotelMapper mapper;
   
   /*
    *  @Select("SELECT no,title,poster,score,num "
		 +"FROM (SELECT no,title,poster,score,rownum as num "
		 +"FROM (SELECT + INDEX_ASC(seoul_hotel sh_no_pk)  no,title,poster,score "
		 +"FROM seoul_hotel)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
		  public List<HotelVO> hotelListData(Map map);
		  
		  @Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_hotel")
		  public int hotelTotalPage();
		  
		  @Select("SELECT no,title,poster,score,images "
				 +"FROM seoul_hotel "
				 +"WHERE no=#{no}")
		  public HotelVO hotelDetailData(int no);
    */
   public List<HotelVO> hotelListData(Map map)
   {
	   return mapper.hotelListData(map);
   }
   public int hotelTotalPage()
   {
	   return mapper.hotelTotalPage();
   }
   public HotelVO hotelDetailData(int no)
   {
	   return mapper.hotelDetailData(no);
   }
}









