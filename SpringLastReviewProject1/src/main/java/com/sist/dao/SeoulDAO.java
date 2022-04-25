package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.vo.*;
public class SeoulDAO extends SqlSessionDaoSupport{
   public List<HotelVO> hotelListData(Map map)
   {
	   return getSqlSession().selectList("hotelListData",map);
	   // 오라클 연결 , 해제 포함 
   }
   public int hotelTotalPage()
   {
	   return getSqlSession().selectOne("hotelTotalPage");
   }
   public HotelVO hotelDetailData(int no)
   {
	   return getSqlSession().selectOne("hotelDetailData", no);
   }
}
