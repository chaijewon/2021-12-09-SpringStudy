package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.HotelVO;
public interface HotelMapper {
  @Select("SELECT no,title,poster,score,num "
		 +"FROM (SELECT no,title,poster,score,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(seoul_hotel sh_no_pk) */ no,title,poster,score "
		 +"FROM seoul_hotel)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<HotelVO> hotelListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_hotel")
  public int hotelTotalPage();
  
  @Select("SELECT no,title,poster,score,images "
		 +"FROM seoul_hotel "
		 +"WHERE no=#{no}")
  public HotelVO hotelDetailData(int no);
}
