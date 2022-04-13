package com.sist.dao;
// DBCP (톰캣)=> 웹에서만 사용이 가능 (웹애플리케이션의 데이터베이스 기본)
// 일반 JDBC 사용 
import java.util.*;
import java.sql.*;
/*
 *   MNO      NOT NULL NUMBER        
	CNO               NUMBER        
	TITLE    NOT NULL VARCHAR2(500) 
	GRADE    NOT NULL VARCHAR2(50)  
	RESERVE           VARCHAR2(20)  
	GENRE    NOT NULL VARCHAR2(200) 
	TIME              VARCHAR2(30)  
	REGDATE           VARCHAR2(200) 
	DIRECTOR NOT NULL VARCHAR2(100) 
	ACTOR             VARCHAR2(200) 
	SHOWUSER          VARCHAR2(20)  
	POSTER   NOT NULL VARCHAR2(260) 
	STORY             CLOB          
	KEY      NOT NULL VARCHAR2(50)  
	HIT               NUMBER        
	SCORE             NUMBER(3,2)   
 */
public class DataDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
   private static DataDAO dao;
   // 드라이버 등록 
   public DataDAO()
   {
	   try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
	   }catch(Exception ex){}
   }
   // 연결 
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
   // 싱글턴 => DAO를 한번만 사용이 가능 (메모리 공간을 1개만 생성) = 재사용
   // 스프링에서는 기본 (싱글턴) => 필요시에는 여러개 객체 생성 => prototype
   public static DataDAO newInstance()
   {
	   if(dao==null)
		   dao=new DataDAO();
	   return dao;
   }
   // 데이터 수집 => insert
   /*
    *  mno int AI PK 
cno int 
title varchar(200) 
time varchar(100) 
grade varchar(100) 
reserve varchar(200) 
genre varchar(200) 
regdate varchar(200) 
director varchar(200) 
actor varchar(300) 
showUser varchar(100) 
poster varchar(260) 
story text 
mkey varchar(100)
    */
   public void movieInsert(MovieVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO movie(cno,title,time,grade,reserve,genre,regdate,"
				     +"director,actor,showUser,poster,story,mkey) "
				     +"VALUES(?,?,?,?,?,?,?,?,?,?,?,"
				     +"?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getCno());
		   ps.setString(2, vo.getTitle());
		   ps.setString(3, vo.getTime());
		   ps.setString(4, vo.getGrade());
		   ps.setString(5, vo.getReserve());
		   ps.setString(6, vo.getGenre());
		   ps.setString(7, vo.getRegdate());
		   ps.setString(8, vo.getDirector());
		   ps.setString(9, vo.getActor());
		   ps.setString(10, vo.getShowUser());
		   ps.setString(11, vo.getPoster());
		   ps.setString(12, vo.getStory());
		   ps.setString(13, vo.getKey());
		   // 실행요청 
		   ps.executeUpdate();// Commit()
		   /*
		    *   => 크롤링 / 오라클 열기(닫기) 
		    *      ==== 약간 속도를 줄인다 (Thread.sleep())
		    *      
		    */
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   
   // 카테고리 저장 
   public void foodCategoryInsert(FoodCategoryVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO project_food_category VALUES("
				     +"?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getCno());
		   ps.setString(2, vo.getTitle());
		   ps.setString(3, vo.getSubject());
		   ps.setString(4, vo.getPoster());
		   ps.setString(5, vo.getLink());
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 카테고리별 맛집 저장
   /*
    *   NO      NOT NULL NUMBER         
	CNO              NUMBER         
	POSTER  NOT NULL VARCHAR2(2000) 
	NAME    NOT NULL VARCHAR2(300)  
	SCORE   NOT NULL NUMBER(2,1)    
	ADDRESS NOT NULL VARCHAR2(1000) 
	TEL     NOT NULL VARCHAR2(20)   
	TYPE    NOT NULL VARCHAR2(100)  
	PRICE            VARCHAR2(100)  
	PARKING          VARCHAR2(100)  
	TIME             VARCHAR2(100)  
	MENU             VARCHAR2(4000) 
	GOOD             NUMBER         
	SOSO             NUMBER         
	BAD              NUMBER 
    */
   public void foodHouseInsert(FoodHouseVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO project_food_house VALUES("
				     +"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getNo());
		   ps.setInt(2, vo.getCno());
		   ps.setString(3, vo.getPoster());
		   ps.setString(4, vo.getName());
		   ps.setDouble(5, vo.getScore());
		   ps.setString(6, vo.getAddress());
		   ps.setString(7, vo.getTel());
		   ps.setString(8, vo.getType());
		   ps.setString(9, vo.getPrice());
		   ps.setString(10, vo.getParking());
		   ps.setString(11, vo.getTime());
		   ps.setString(12, vo.getMenu());
		   ps.setInt(13, vo.getGood());
		   ps.setInt(14, vo.getSoso());
		   ps.setInt(15, vo.getBad());
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 지역별 맛집 => 캡쳐 
   /*
    *   no NUMBER, -- 고유번호 
   poster VARCHAR2(4000) CONSTRAINT fh1_poster_nn NOT NULL,
   name VARCHAR2(200) CONSTRAINT fh1_title_nn NOT NULL,
   score NUMBER(2,1) CONSTRAINT fh1_socre_nn NOT NULL,
   address VARCHAR2(300) CONSTRAINT fh1_address_nn NOT NULL,
   tel VARCHAR2(30) CONSTRAINT fh1_tel_nn NOT NULL,
   type VARCHAR2(100) CONSTRAINT fh1_type_nn NOT NULL,
   price VARCHAR2(50) CONSTRAINT fh1_price_nn NOT NULL,
   parking VARCHAR2(20),
   time VARCHAR2(50),
   menu VARCHAR2(1000),
   good NUMBER,
   soso NUMBER,
   bad NUMBER,
    */
   public void foodLocationInsert(FoodLocationVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO food_location VALUES("
				     +"?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getNo());
		   ps.setString(2, vo.getPoster());
		   ps.setString(3, vo.getName());
		   ps.setDouble(4, vo.getScore());
		   ps.setString(5, vo.getAddress());
		   ps.setString(6, vo.getTel());
		   ps.setString(7, vo.getType());
		   ps.setString(8, vo.getPrice());
		   ps.setString(9, vo.getParking());
		   ps.setString(10, vo.getTime());
		   ps.setString(11, vo.getMenu());
		   ps.setInt(12, vo.getGood());
		   ps.setInt(13, vo.getSoso());
		   ps.setInt(14, vo.getBad());
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   
   public List<FoodCategoryVO> foodCategoryInfoData()
   {
	   // link , cno
	   List<FoodCategoryVO> list=new ArrayList<FoodCategoryVO>();
	   try
	   {
		   getConnection();
		   String sql="SELECT cno,link FROM project_food_category "
				     +"ORDER BY 1";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   FoodCategoryVO vo=new FoodCategoryVO();
			   vo.setCno(rs.getInt(1));
			   vo.setLink(rs.getString(2));
			   list.add(vo);
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
	   return list;
   }
   // ==> 영화 => 맛집 => 레시피 => 명소 ,호텔 , 자연(관광) => 일정(코스) (추천)
   // 명소 
   /*
    *  NO      NOT NULL NUMBER         
	TITLE   NOT NULL VARCHAR2(200)  
	POSTER  NOT NULL VARCHAR2(500)  
	MSG     NOT NULL VARCHAR2(4000) 
	ADDRESS NOT NULL VARCHAR2(300)   
	
	   no int, 
       name varchar(100), 
       address varchar(200), 
	   poster varchar(200),
	   msg varchar(1000)
    */
   public void seoulLocationInsert(SeoulLocationVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO location VALUES(?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getNo());
		   ps.setString(2, vo.getTitle());
		   ps.setString(3, vo.getAddress());
		   ps.setString(4, vo.getPoster());
		   ps.setString(5, vo.getMsg());
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 호텔
   /*
    *  NO      NOT NULL NUMBER         
	NAME    NOT NULL VARCHAR2(100)  
	SCORE            NUMBER(2,1)    
	ADDRESS NOT NULL VARCHAR2(300)  
	POSTER  NOT NULL VARCHAR2(4000) 
    */
   public void seoulHotelInsert(SeoulHotelVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO seoul_hotel VALUES(?,?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getNo());
		   ps.setString(2, vo.getName());
		   ps.setDouble(3, vo.getScore());
		   ps.setString(4, vo.getAddress());
		   ps.setString(5, vo.getPoster());
		   ps.setString(6, vo.getImages());
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 자연 
   /*
    *  NO      NOT NULL NUMBER         
TITLE   NOT NULL VARCHAR2(200)  
POSTER  NOT NULL VARCHAR2(300)  
MSG     NOT NULL VARCHAR2(4000) 
ADDRESS NOT NULL VARCHAR2(300)
    */
   public void seoulNatureInsert(SeoulNatureVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO seoul_nature VALUES(?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getNo());
		   ps.setString(2, vo.getTitle());
		   ps.setString(3, vo.getPoster());
		   ps.setString(4, vo.getMsg());
		   ps.setString(5, vo.getAddress());
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 레시피 
   // 레시피 상세
   // 쉐프 
   
}






