package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class BoardDAO {
   @Autowired
   private BoardMapper mapper;
   
   public List<BoardVO> boardListData(Map map)
   {
	   return mapper.boardListData(map);
   }
   public void boardInsert(BoardVO vo)
   {
	   mapper.boardInsert(vo);
   }
   public BoardVO boardDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.boardDetailData(no);
   }
   public int boardTotalPage()
   {
	   return mapper.boardTotalPage();
   }
   
   public BoardVO boardUpdateData(int no)
   {
	   return mapper.boardDetailData(no);//재사용 
   }
   
   public boolean boardUpdate(BoardVO vo)
   {
	   boolean bCheck=false;
	   String db_pwd=mapper.boardGetPassword(vo.getNo());
	   if(db_pwd.equals(vo.getPwd()))
	   {
		   bCheck=true;
		   // 실제 수정 
		   mapper.boardUpdate(vo); // update,delete,insert => autocommit
	   }
	   else
	   {
		   bCheck=false; 
	   }
	   return bCheck;
   }
   
   public boolean boardDelete(int no,String pwd)
   {
	   boolean bCheck=false;
	   String db_pwd=mapper.boardGetPassword(no);
	   if(db_pwd.equals(pwd))
	   {
		   bCheck=true;
		   // 실제 수정 
		   mapper.boardDelete(no);// update,delete,insert => autocommit
	   }
	   else
	   {
		   bCheck=false; 
	   }
	   return bCheck;
   }
   
   
}
