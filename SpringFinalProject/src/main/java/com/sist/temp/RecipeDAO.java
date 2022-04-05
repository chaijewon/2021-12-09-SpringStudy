package com.sist.temp;
import java.sql.*;
import java.util.*;
public class RecipeDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@211.63.89.131:1521:XE";
   private final String DRIVER="oracle.jdbc.driver.OracleDriver";
   private final String USERNAME="hr";
   private final String PASSWORD="happy";
   ////////////////////////////////// BasicDataSource
   
   public RecipeDAO()
   {
	   try
	   {
		   Class.forName(DRIVER);
	   }catch(Exception ex){}
   }
   
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
	   }catch(Exception ex) {}
   }
   
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex){}
   }
   ////////////////////////////// SqlSessionFactoryBean
   //// MapperFactoryBean => SQL문장을 읽어서 처리 (SQL) => 결과값을 받을 준비 
   public void recipeListData_java(int page)
   {
	   // 예외 => 비정상 종료를 방지하고 정상 상태를 유지할 목적
	   //        사전에 에러를 방지하는 프로그램 
	   // 종료 => 예외회피 , 예외복구 
	   // 자바 (1권) => 컬렉션 , 제네릭스 타입 , IO
	   try
	   {
		   getConnection();
		   String sql="SELECT no,title FROM recipe ORDER BY no";
		   int i=0;
		   int j=0;
		   int pagecnt=(page*10)-10;
		   // 시작위치 => 1page=0 , 2page=10 
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   
		   while(rs.next())
		   {
			   if(i<10 && j>=pagecnt) 
			   {
				   System.out.println(rs.getInt(1)+"."+rs.getString(2));
				   i++;//10개씩 나눠주는 변수 
			   }
			   j++;// while이 돌아가는 횟수 
		   }
		   rs.close();
		   
	   }catch(Exception ex) 
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
           disConnection();
	   }
   }
   public void recipeListData_oracle(int page)
   {
	   try
	   {
		   getConnection();
		   String sql="SELECT no,title,num "
				     +"FROM (SELECT no,title,rownum as num "
				     +"FROM (SELECT no,title "
				     +"FROM recipe ORDER BY no)) "
				     +"WHERE num BETWEEN ? AND ?";
		   int rowSize=10;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=(rowSize*page);
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, start); // #{start}
		   ps.setInt(2, end);// #{end}
		   // 프로그램의 단점 => (int start,int end) => 메소드 호출시에 할당 
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   System.out.println(rs.getInt(1)+"."+rs.getString(2));
		   }
		   rs.close();
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   public void recipeListData_oracle1(int page)
   {
	   try
	   {
		   getConnection();
		   String sql="SELECT no,title,num "
				     +"FROM (SELECT no,title,rownum as num "
				     +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,title "
				     +"FROM recipe)) "
				     +"WHERE num BETWEEN ? AND ?";
		   int rowSize=10;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=(rowSize*page);
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, start); // #{start}
		   ps.setInt(2, end);// #{end}
		   // 프로그램의 단점 => (int start,int end) => 메소드 호출시에 할당 
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   System.out.println(rs.getInt(1)+"."+rs.getString(2));
		   }
		   rs.close();
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
}







