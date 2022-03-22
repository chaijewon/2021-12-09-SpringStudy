package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface ReplyBoardMapper {
   // 기능 
   // 1. 목록출력 => 페이징 
   @Select("SELECT no,subject,name,"
		  +"TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,group_tab,num "
		  +"FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
		  +"FROM (SELECT no,subject,name,regdate,hit,group_tab "
		  +"FROM spring_replyboard "
		  +"ORDER BY group_id DESC,group_step ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<ReplyBoardVO> replyBoardListData(Map map);
   // 1-1. 총페이지 
   @Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_replyboard")
   public int replyBoardTotalPage();
   
   // 1-2. 출력 순서 
   @Select("SELECT COUNT(*) FROM spring_replyboard")
   public int replyBoardCount();
   
   // 2. 새글 올리기 
   @Insert("INSERT INTO spring_replyboard(no,name,subject,content,"
		  +"pwd,group_id) VALUES("
		  +"sr_no_seq.nextval,#{name},#{subject},"
		  +"#{content},#{pwd},"
		  +"(SELECT NVL(MAX(group_id)+1,1) FROM spring_replyboard))")
   public void replyBoardInsert(ReplyBoardVO vo);
   // 3. 상세보기 
   @Select("SELECT no,name,subject,content,"
		  +"TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
		  +"FROM spring_replyboard "
		  +"WHERE no=#{no}")
   public ReplyBoardVO replyBoardDetailData(int no);
   // 3-1. 조회수 증가 
   @Update("UPDATE spring_replyBoard SET "
		  +"hit=hit+1 "
		  +"WHERE no=#{no}")
   public void hitIncrement(int no);
   // 4. 답변 : SQL문장 여러개 사용 => 트랜잭션 (XML , Annotation)
   // 4-1 : no에 해당되는 데이터 읽기 (group_id , group_step,group_tab)
   // 4-2 : group_step => 증가  => UPDATE
   // 4-3 : 실제 insert  => INSERT
   // 4-4 : depth증가  => UPDATE
   // 비절차 언어 => 에러발생 => 밑에 있는 문장을 수행한다 (단점) 
   // 일괄 처리  => 4개전체 성공 (COMMIT) , 4개중에 1개라도 실패(Rollback)
   // 트랜잭션 프로그램 (금융권 , 공기업 => 트랜잭션 처리가 거의 등장)
   /*
    *    try
    *    {
    *        getConnection()
    *        SELECT
    *        UPDATE
    *        INSERT
    *        UPDATE
    *        commit()
    *    }catch(Exception ex)
    *    {
    *        rollback()
    *    }
    *    finally
    *    {
    *       disConnection()
    *    }
    *    
    *    @Transactional
    */
   // 5. 삭제 : SQL문장 여러개 사용 => 트랜잭션
   // 6. 수정 
   @Select("SELECT pwd FROM spring_replyboard "
		  +"WHERE no=#{no}")
   public String replyBoardGetPassword(int no);
   
   @Update("UPDATE spring_replyboard SET "
		  +"name=#{name},subject=#{subject},"
		  +"content=#{content} "
		  +"WHERE no=#{no}")
   public void replyBoardUpdate(ReplyBoardVO vo);
   // 7. 찾기 : MyBatis동적 쿼리 작성방법 (XML , Annotation)
}










