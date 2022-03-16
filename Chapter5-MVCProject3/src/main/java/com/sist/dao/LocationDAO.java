package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
/*
 *  DAO : 오라클 연동  
 *  Controller :  DAO , JSP연결 
 *  JSP : 화면 출력 
 */
@Repository
public class LocationDAO {
   // MyBatis에서 구현된 객체 주소값을 주입 요청 
   @Autowired
   private LocationMapper mapper;
   /*
    *  @Select("SELECT no,title,poster,num "
		 +"FROM (SELECT no,title,poster,rownum as num "
		 +"FROM (SELECT + INDEX_ASC(seoul_location sl_no_pk) no,title,poster "
		 +"FROM seoul_location)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
		  public List<LocationVO> locationListData(Map map);
		  
		  @Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_location")
		  public int locationTotalPage();
		  
		  @Select("SELECT * FROM seoul_location "
				 +"WHERE no=#{no}")
		  public LocationVO locationDetailData(int no);
    */
   public List<LocationVO> locationListData(Map map)
   {
	   return mapper.locationListData(map);
   }
   public int locationTotalPage()
   {
	   return  mapper.locationTotalPage();
   }
   public LocationVO locationDetailData(int no)
   {
	   return mapper.locationDetailData(no);
   }
}
