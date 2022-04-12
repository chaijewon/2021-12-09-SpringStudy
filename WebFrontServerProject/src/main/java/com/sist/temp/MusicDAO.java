package com.sist.temp;
import java.util.*;
import java.sql.*;
public class MusicDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
   
   public MusicDAO()
   {
	   try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
	   }catch(Exception ex){}
   }
   
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"root","happy");
	   }catch(Exception ex) {}
   }
   
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   /*
    *   no int AI PK 
		cno int 
		title varchar(500) 
		singer varchar(300) 
		album varchar(300) 
		state varchar(20) 
		idcrement int 
		poster varchar(500) 
		mkey varchar(100)
		
		String sql="INSERT INTO music(cno,title,singer,album,state,"
				  +"idcrement,poster,mkey) VALUES("+vo.getCno()+",'"+vo.getTitle()
				  +"','"+vo.getSinger()+"','"+....
				  Statement
				  
    */
   public void musicInsert(MusicVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO music(cno,title,singer,album,state,"
				     +"idcrement,poster,mkey) VALUES(?,?,?,?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getCno());
		   ps.setString(2, vo.getTitle());
		   ps.setString(3, vo.getSinger());
		   ps.setString(4, vo.getAlbum());
		   ps.setString(5, vo.getState());
		   ps.setInt(6, vo.getIdcrement());
		   ps.setString(7, vo.getPoster());
		   ps.setString(8, vo.getMkey());
		   ps.executeUpdate();// commit()
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






