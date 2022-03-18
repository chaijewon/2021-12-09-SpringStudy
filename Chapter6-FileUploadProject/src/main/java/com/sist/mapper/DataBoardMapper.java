package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.DataBoardVO;
public interface DataBoardMapper {
   //1. 목록 출력 => 페이징 기법 
   @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
		  +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		  +"FROM (SELECT /*+ INDEX_DESC(spring_databoard sd_no_pk)*/ no,subject,name,regdate,hit "
		  +"FROM spring_databoard)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<DataBoardVO> databoardListData(Map map);
   //2. 총페이지 구하기 
   @Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_databoard")
   public int databoardTotalPage();
   //3. 글쓰기 => 파일 업로드 
   @Insert("INSERT INTO spring_databoard VALUES("
		  +"sd_no_seq.nextval,#{name},#{subject},#{content},"
		  +"#{pwd},SYSDATE,0,#{filename},#{filesize},#{filecount})")
   public void databoardInsert(DataBoardVO vo);
   //4. 내용보기 => 파일 다운로드
   //4-1. 조회수 증가  
   @Update("UPDATE spring_databoard SET "
		  +"hit=hit+1 "
		  +"WHERE no=#{no}")
   public void hitIncrement(int no); // @Insert,@Update,@Delete => AutoCommit
   /*
    *   1. 공통기반 소스 (자동 호출가능=>AOP)
    *   2. 핵심 소스 => 핵심을 중심으로 코딩 (스프링)
    */
   //4-2. 실제 상세볼 데이터 
   @Select("SELECT no,name,subject,content,"
		  +"TO_CHAR(regdate,'YYYY-MM-DD') as dbday,"
		  +"hit,filename,filesize,filecount "
		  +"FROM spring_databoard "
		  +"WHERE no=#{no}"
		  )
   public DataBoardVO databoardDetailData(int no);
   // 기타 
   @Select("SELECT COUNT(*) FROM spring_databoard")
   public int databoardRowCount(); // 번호출력 (삭제=번호가 사라진다)
   //5. 수정 
   @Select("SELECT pwd FROM spring_databoard "
		  +"WHERE no=#{no}")
   public String databoardGetPassword(int no);
   //5-1. 실제 수정 
   @Update("UPDATE spring_databoard SET "
		  +"name=#{name},subject=#{subject},"
		  +"content=#{content} "
		  +"WHERE no=#{no}")
   public void databoardUpdate(DataBoardVO vo);
   //6. 삭제 => 파일 삭제 
   @Delete("DELETE FROM spring_databoard "
		  +"WHERE no=#{no}")
   public void databoardDelete(int no);
   //7. 검색 => 동적 SQL 
   @Select("SELECT no,subject,name,"
   		  +"TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
		  +"FROM spring_databoard "
   		  +"WHERE ${fs} LIKE '%'||#{ss}||'%'")
   // ${fs} => name (컬럼명,테이블명)  , #{fs} => 'name'
   public List<DataBoardVO> databoardFindData(Map map);
}










