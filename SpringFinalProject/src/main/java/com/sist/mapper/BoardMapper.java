package com.sist.mapper;
// Mapper => PreparedStatement , ResultSet 
// MyBatis에서  1.SQL문장 , 2.?에 값 설정 , 3.받는 데이터형 
//                      -----------  ------------
//                       매개변수로 설정(parameterType)  리턴형으로 설정(resultType) 
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface BoardMapper {
   // 목록 출력  => Read => 퍼포먼트 (자바,인라인뷰) => String / StringBuffer
   @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
		  +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		  +"FROM (SELECT /*+ INDEX_DESC(final_board fb_no_pk)*/no,subject,name,regdate,hit "
		  +"FROM final_board)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<BoardVO> boardListData(Map map);
   
   @Select("SELECT COUNT(*) FROM final_board")
   public int boardRowCount();
   // 상세 보기  => Read
   // 글쓰기      => Create
   // 기본키 => Mybatis => @SelectKey, 서브쿼리 , sequence => 자동증가번호 
   @Insert("INSERT INTO final_board(no,name,subject,content,pwd) "
		  +"VALUES(fb_no_seq.nextval,#{name},#{subject},"
		  +"#{content},#{pwd})")
   public void boardInsert(BoardVO vo);
   // VO => #{name} => vo.getName() , #{subject} => vo.getSubject()
   // Map => #{start} => map.get("start")
   // 수정하기   => Update
   // 삭제        => Delete 
   // DB , XML , IO => ***메모리 (ArrayList) add,remove,set,get
}
