package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
// v-for , v-model+v-for , v-if , v-show , v-on...
public interface SeoulHotelMapper {
  @Select("SELECT no,poster,name,num "
		 +"FROM (SELECT no,poster,name,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(seoul_hotel sh_no_pk)*/no,poster,name "
		 +"FROM seoul_hotel)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<SeoulHotelVO> hotelListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_hotel")
  public int hotelTotalPage();
  
  @Select("SELECT no,poster,name,score,images,address "
		 +"FROM seoul_hotel "
		 +"WHERE no=#{no}")
  public SeoulHotelVO hotelDetailData(int no);
  
}
