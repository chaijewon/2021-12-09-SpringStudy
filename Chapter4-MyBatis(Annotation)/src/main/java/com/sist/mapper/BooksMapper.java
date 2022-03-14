package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import com.sist.dao.*;
public interface BooksMapper {
  @Select("SELECT title,price FROM books")
  public List<BooksVO> booksListData(); // ���� �Ϸ�
  @Select("SELECT title,price FROM books "
		 +"WHERE title LIKE '%'||#{title}||'%'")
  public List<BooksVO> booksFindData(String title);
  //                        mysql => concat('%',#{title},'%')
  //  NVL => ifnull , �ζ��κ� , limit start,���� => mysql 
  //     ------------- ------------- -
  //        resultType(������)  id parameterType(�Ű�����)
  // <bean id="" resultType="" parameterType="">
  /*
   *    resultType : ���� �޾Ƽ� �����Ҷ� ��� 
   *                 List<BooksVO>
   *                 BooksVO
   *                 �Ϲݵ������� : String , int , double ....
   *                 ResultSet���� => ���� ��� (insert,update,delete)
   *                 
   *    parameterType : ?�� ���� ä��� 
   *                    ?�� ������ �ִ� ��� (VO�� �ִ� ���� => VO
   *                                    VO�� ���� ���� => HashMap) 
   *                    ?�� �Ѱ� �ִ� ��� : �Ϲ� ���������� ����Ѵ� 
   *                                    String , int , double...
   *                 PreparedStatement�� ���� 
   *                 public List<SeoulLocationVO> seoulLocationData(int page)
   {
	   List<SeoulLocationVO> list=new ArrayList<SeoulLocationVO>();
	   try
	   {
		   //1. �ּ� �б� 
		   conn=dbcp.getConnection();
		   //2. SQL���� 
		    * -----------------------------------------------------
		   String sql="SELECT no,title,poster,num "
				     +"FROM (SELECT no,title,poster,rownum as num "
				     +"FROM (SELECT no,title,poster "
				     +"FROM seoul_location ORDER BY no DESC)) "
				     +"WHERE num BETWEEN ? AND ?";
				     ----------------------------------------------
		   // �ζ��κ� => Top-N => �߰��� �����͸� �ڸ� �� ���� 
		   ps=conn.prepareStatement(sql);
		   int rowSize=12;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=rowSize*page; 
		   
		   // ?�� ���� ä��� ==> parameterType
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
