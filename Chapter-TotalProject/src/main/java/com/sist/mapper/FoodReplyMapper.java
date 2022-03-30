package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
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
   /*
    *   no => 고유번호 (1. 삭제 , 2. 수정 , 3. 상세보기) => 중복없는 PRIMARY KEY
    *   fno => 참조 (게시판 , 맛집...) FOREIGN KEY
    *   id => 작성자 (댓글 => 이름 ,비밀번호) => 찾기(본인여부 확인)
    *   name => 출력용 
    *   msg  => 댓글 내용 
    *   regdate => 작성일 
    *   ----------------- 일반 댓글 
    *   group_id => 그룹 (같은 답변을 모아주는 역할) => 답변별 구분(sort)
    *     AAAA (1)
    *      =>BBBB(1)
    *       =>CCCC(1)
    *   group_step => 출력 순서 
    *     AAAA (0)
    *       =>BBBB(1)
    *        =>CCCCC(2)
    *       =>DDDD(3)
    *   group_tab => 레벨 
    *     AAAA(0)
    *      =>BBBB(1)
    *       =>CCCC(2)
    *      =>DDDD(1)
    *   ----------------- 답변을 출력하기 위한 컬럼명 
    *   root
    *   depth
    *   ----------------- 삭제를 위한 컬럼명 
    */
   //6-1. group_id (그대로), group_step(+1) , group_tab(+1) =>
   @Select("SELECT group_id,group_step,group_tab "
		  +"FROM foodReply "
		  +"WHERE no=#{no}")
   public FoodReplyVO replyParentInfoData(int no);
   //6-2. 위치 변경 (정상적으로 답변 출력하는 과정)
   @Update("UPDATE foodReply SET "
		  +"group_step=group_step+1 "
		  +"WHERE group_id=#{group_id} AND group_step>#{group_step}")
   public void replyGroupStepIncrement(FoodReplyVO vo);
   /*
    *                  group_id   group_step  group_tab
    *   AAAAA             1            0          0
    *    =>DDDDD          1            1          1
    *    =============================================
    *    =>BBBBB          1            2          1 
    *     =>CCCCCC        1            3          2
    *     
    *   오라클 단점 ORDER BY => 같은 번호를 가지고 있는 경우 => 
    *      먼저 insert된 데이터 우선순
    *    
    */
   //6-3. 실제 데이터 추가 => 답변 (insert와 동일) 
   /*
    * 
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
    
   @Insert("INSERT INTO foodReply VALUES("
		  +"(SELECT NVL(MAX(no)+1,1) FROM foodReply),"
		  +"#{fno},#{id},#{name},#{msg},"
		  +"SYSDATE,#{group_id},#{group_step},"
		  +"#{group_tab},#{root},0)")
   public void replyReplyInsert(FoodReplyVO vo);
   //6-4. => 각 뎃글마다 답변 갯수가 몇개인지 확인 ( 0 => 삭제 , 0이 아니면 답변 => 수정)
   @Update("UPDATE foodReply SET "
		  +"depth=depth+1 "
		  +"WHERE no=#{no}")
   public void replyDepthIncrement(int no);
   
   // 삭제 
   // 7-1. => 삭제할 댓글의 depth(답변이 달려있는 확인) , root(상위 게시물의 depth감소)
   @Select("SELECT depth,root "
		  +"FROM foodReply "
		  +"WHERE no=#{no}")
   public FoodReplyVO replyInfoData(int no);
   // 7-2. => depth>0 => UPDATE (관리자가 삭제한 댓글입니다)
   @Update("UPDATE foodReply SET "
		  +"msg='관리자가 삭제한 댓글입니다' "
		  +"WHERE no=#{no}")
   public void replyMsgUpdate(int no);
   // 7-3. => depth=0 => DELETE 
   @Delete("DELETE FROM foodReply "
		  +"WHERE no=#{no}")
   public void replyDelete(int no);
   // 7-4. => depth감소 => UPDATE => 동시처리 => 트랜잭션
   @Update("UPDATE foodReply SET "
		  +"depth=depth-1 "
		  +"WHERE no=#{no}")
   public void replyDepthDecrement(int no);
   // 댓글을 전체 삭제 => 재귀호출 (X) 
}










