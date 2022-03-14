package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import com.sist.dao.*;
public interface BooksMapper {
  @Select("SELECT title,price FROM books")
  public List<BooksVO> booksListData(); // 구현 완료
  @Select("SELECT title,price FROM books "
		 +"WHERE title LIKE '%'||#{title}||'%'")
  public List<BooksVO> booksFindData(String title);
  //                        mysql => concat('%',#{title},'%')
  //  NVL => ifnull , 인라인뷰 , limit start,갯수 => mysql 
  //     ------------- ------------- -
  //        resultType(리턴형)  id parameterType(매개변수)
  // <bean id="" resultType="" parameterType="">
  /*
   *    resultType : 값을 받아서 저장할때 사용 
   *                 List<BooksVO>
   *                 BooksVO
   *                 일반데이터형 : String , int , double ....
   *                 ResultSet관련 => 없는 경우 (insert,update,delete)
   *                 
   *    parameterType : ?에 값을 채운다 
   *                    ?가 여러개 있는 경우 (VO에 있는 변수 => VO
   *                                    VO에 없는 변수 => HashMap) 
   *                    ?가 한개 있는 경우 : 일반 데이터형을 사용한다 
   *                                    String , int , double...
   *                 PreparedStatement와 관련 
   *                 public List<SeoulLocationVO> seoulLocationData(int page)
   {
	   List<SeoulLocationVO> list=new ArrayList<SeoulLocationVO>();
	   try
	   {
		   //1. 주소 읽기 
		   conn=dbcp.getConnection();
		   //2. SQL문장 
		    * -----------------------------------------------------
		   String sql="SELECT no,title,poster,num "
				     +"FROM (SELECT no,title,poster,rownum as num "
				     +"FROM (SELECT no,title,poster "
				     +"FROM seoul_location ORDER BY no DESC)) "
				     +"WHERE num BETWEEN ? AND ?";
				     ----------------------------------------------
		   // 인라인뷰 => Top-N => 중간에 데이터를 자를 수 없다 
		   ps=conn.prepareStatement(sql);
		   int rowSize=12;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=rowSize*page; 
		   
		   // ?에 값을 채운다 ==> parameterType
		    * -------------------------
		   ps.setInt(1, start);
		   ps.setInt(2, end);
		   ----------------------------
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
		      --------------------------------------------
		       resultType
			   SeoulLocationVO vo=new SeoulLocationVO();
			   vo.setNo(rs.getInt(1));
			   vo.setTitle(rs.getString(2));
			   vo.setPoster(rs.getString(3));
			   
			   list.add(vo);
			   -------------------------------------------
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
}
