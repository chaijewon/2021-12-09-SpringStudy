package com.sist.dao;
import java.util.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;

@Repository
public class StudentDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@211.63.89.131:1521:XE";
   //1. 드라이버 등록 
   public StudentDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex){}
   }
   //2. 연결 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex){}
   }
   //3. 해제
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex){}
   }
   /////////////////////////// SqlSessionFactory가 해결 
   // 4. 목록 읽기 
   public List<StudentVO> studentListData()
   {
	   List<StudentVO> list=new ArrayList<StudentVO>();
	   try
	   {
		   getConnection(); // @Before
		   ////////////////핵심 코딩 => 메소드마다 달라진다 
		   String sql="SELECT no,name,kor,eng,math "
				     +"FROM std_input";
		   /////////////// 공통으로 사용되는 코드 => selectList
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery(); //commit(X)
		   while(rs.next())
		   {
			   // 어떤 데이터에 값을 담을지 설정 => resultType="StudentVO"
			   StudentVO vo=new StudentVO();
			   vo.setNo(rs.getInt(1));
			   vo.setName(rs.getString(2));
			   vo.setKor(rs.getInt(3));
			   vo.setEng(rs.getInt(4));
			   vo.setMath(rs.getInt(5));
			   ///////////////////////////// selectOne
			   list.add(vo); //selectList
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   // @AfterThrowing 
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // @After
		   disConnection();
	   }
	   // @AfterReturning
	   return list;
   }
   // 5. 추가 => 3명 동시에 => 트랜잭션 적용 => 1(X),2,3 => 전체 취소 
   public void studentInsert()
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO std_input VALUES(?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   //?에 값을 채운다 
		   ps.setInt(1, 1);
		   ps.setString(2, "홍길동");
		   ps.setInt(3, 90);
		   ps.setInt(4, 80);
		   ps.setInt(5, 95);
		   // 오라클에 실행 요청 ==> 
		   ps.executeUpdate(); // commit()
		   
		   sql="INSERT INTO std_input VALUES(?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   //?에 값을 채운다 
		   ps.setInt(1, 1);
		   ps.setString(2, "심청이");
		   ps.setInt(3, 90);
		   ps.setInt(4, 80);
		   ps.setInt(5, 95);
		   // 오라클에 실행 요청 ==> 
		   ps.executeUpdate(); // commit()
		   
		   sql="INSERT INTO std_input VALUES(?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   //?에 값을 채운다 
		   ps.setInt(1, 3);
		   ps.setString(2, "박문수");
		   ps.setInt(3, 90);
		   ps.setInt(4, 80);
		   ps.setInt(5, 95);
		   // 오라클에 실행 요청 ==> 
		   ps.executeUpdate(); // commit()
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 1=commit,2(X),3 => 1은 수행 , 1=commit,2=commit,3(X) => 1,2수행 
   // 동시에 처리 => 일괄처리 (트랜잭션) 
   // 입고 => 재고  , 출고 => 재고  => 동시처리 , 카드 결제 = 포인트 누적 
   
   public void txInsert()
   {
	   try
	   {
		   getConnection();
		   conn.setAutoCommit(false);//지원(AOP) => @Around
		   String sql="INSERT INTO std_input VALUES(?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   //?에 값을 채운다 
		   ps.setInt(1, 1);
		   ps.setString(2, "홍길동");
		   ps.setInt(3, 90);
		   ps.setInt(4, 80);
		   ps.setInt(5, 95);
		   // 오라클에 실행 요청 ==> 
		   ps.executeUpdate(); 
		   
		   sql="INSERT INTO std_input VALUES(?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   //?에 값을 채운다 
		   ps.setInt(1, 2);
		   ps.setString(2, "심청이");
		   ps.setInt(3, 90);
		   ps.setInt(4, 80);
		   ps.setInt(5, 95);
		   // 오라클에 실행 요청 ==> 
		   ps.executeUpdate(); 
		   
		   sql="INSERT INTO std_input VALUES(?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   //?에 값을 채운다 
		   ps.setInt(1, 3);
		   ps.setString(2, "박문수");
		   ps.setInt(3, 90);
		   ps.setInt(4, 80);
		   ps.setInt(5, 95);
		   // 오라클에 실행 요청 ==> 
		   ps.executeUpdate(); 
		   
		   conn.commit(); // 지원 @Around
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
		   try
		   {
			   conn.rollback();// 모든 SQL문장을 취소 
			   // 스프링에 지원 => @AfterThrowing
		   }catch(Exception e) {}
	   }
	   finally
	   {
		   
		   try
		   {
			   // 원상 복귀 
			   conn.setAutoCommit(true); // 스프링에서 지원 @After
		   }catch(Exception ex) {}
		   disConnection();
	   }
   }
}








