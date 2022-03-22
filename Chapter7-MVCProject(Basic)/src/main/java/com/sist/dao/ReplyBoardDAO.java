package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class ReplyBoardDAO {
   // 구현된 매퍼를 스프링으로부터 받아 온다 
   @Autowired
   private ReplyBoardMapper mapper;// 구현된 클래스의 주소값을 자동주입 
   public List<ReplyBoardVO> replyBoardListData(Map map)
   {
	   return mapper.replyBoardListData(map);
   }
   public int replyBoardTotalPage()
   {
	   return mapper.replyBoardTotalPage();
   }
   public int replyBoardCount()
   {
	   return mapper.replyBoardCount();
   }
   public void replyBoardInsert(ReplyBoardVO vo)
   {
	   mapper.replyBoardInsert(vo);
   }
   public ReplyBoardVO replyBoardDetailData(int no)
   {
	   mapper.hitIncrement(no);// 조회수 증가 
	   return mapper.replyBoardDetailData(no);
   }
   public ReplyBoardVO replyBoardUpdateData(int no)
   {
	   return mapper.replyBoardDetailData(no);
   }
   
   public boolean replyBoardUpdate(ReplyBoardVO vo)
   {
	   boolean bCheck=false;
	   // 비밀번호 검색
	   String db_pwd=mapper.replyBoardGetPassword(vo.getNo());
	   if(db_pwd.equals(vo.getPwd()))
	   {
		   bCheck=true;
		   // 실제 수정 
		   mapper.replyBoardUpdate(vo);
	   }
	   else
	   {
		   bCheck=false;
	   }
	   return bCheck;
   }
}







