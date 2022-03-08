package com.sist.di3;
import java.util.*;
/*
 *  public List<SeoulHotelVO> seoulHotelData(int page)
   {
	   List<SeoulHotelVO> list=new ArrayList<SeoulHotelVO>();
	   try
	   {
		   conn=dbcp.getConnection();
		   // SQL문장 입력 
		   String sql="SELECT no,name,score,poster,num "
				     +"FROM (SELECT no,name,score,poster,rownum as num "
				     +"FROM (SELECT no,name,score,poster "
				     +"FROM seoul_hotel ORDER BY no ASC)) "
				     +"WHERE num BETWEEN ? AND ?";
		   ps=conn.prepareStatement(sql);
		   int rowSize=12;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=rowSize*page;
		   
		   /////////////////////////
		   ps.setInt(1, start);
		   ps.setInt(2, end);
		   ///////////////////////// parameterType
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   SeoulHotelVO vo=new SeoulHotelVO(); resultType
			   vo.setNo(rs.getInt(1));
			   vo.setName(rs.getString(2));
			   vo.setScore(rs.getDouble(3));
			   vo.setPoster(rs.getString(4));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   dbcp.disConnection(conn, ps);
	   }
	   return list;
   }
 */

import org.mybatis.spring.support.SqlSessionDaoSupport;
public class HotelDAO extends SqlSessionDaoSupport{
    public List<HotelVO> hotelListData()
    {
    	return getSqlSession().selectList("hotelListData");
    }
}
