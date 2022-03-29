package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface FoodReplyMapper {
   //1. 로그인 
   //1-1. ID존재 여부 
   @Select("SELECT COUNT(*) FROM project_member "
		  +"WHERE id=#{id}")
   public int idCount(String id);
   //1-2. password/name
   @Select("SELECT pwd||','||name FROM project_member "
		  +"WHERE id=#{id}")
   public String memberGetPwdAndName(String id);
   //2. 댓글 읽기
   /*
    *    NO                                        NOT NULL NUMBER
		 FNO                                                NUMBER
		 ID                                        NOT NULL VARCHAR2(20)
		 NAME                                      NOT NULL VARCHAR2(34)
		 MSG                                       NOT NULL CLOB
		 REGDATE                                            DATE
		 GROUP_ID                                           NUMBER
		 GROUP_STEP                                         NUMBER
		 GROUP_TAB                                          NUMBER
		 ROOT                                               NUMBER
		 DEPTH
    */
   @Select("SELECT no,id,name,msg,"
		  +"TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,"
		  +"group_tab "
		  +"FROM foodReply "
		  +"WHERE fno=#{fno} "
		  +"ORDER BY group_id DESC,group_step ASC")
   public List<FoodReplyVO> replyListData(int fno);
   //3. 댓글 쓰기
   @Insert("INSERT INTO foodReply(no,fno,id,name,msg,group_id) "
		  +"VALUES((SELECT NVL(MAX(no)+1,1) FROM foodReply),"
		  +"#{fno},#{id},#{name},#{msg},"
		  +"(SELECT NVL(MAX(group_id)+1,1) FROM foodReply))")
   public void replyInsert(FoodReplyVO vo);
   
   //4. 댓글 수정
   @Update("UPDATE foodReply SET "
		  +"msg=#{msg} "
		  +"WHERE no=#{no}")
   public void replyUpdate(FoodReplyVO vo);
   // 트랜잭션 
   //5. 댓글 삭제
   //6. 댓글 => 댓글 
}
