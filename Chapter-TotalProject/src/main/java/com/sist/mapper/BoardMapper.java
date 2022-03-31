package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
// annotation => xml
public interface BoardMapper {
  // 목록 : 페이징 => 인라인뷰  @Select => rownum (top-n(X) , 중간에 있는 데이터는 못가지고 온다)
  // MySQL ==> ~~~ limit 1,10  , 11,10
  @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
		 +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		 +"FROM (SELECT /*+ INDEX_DESC(project_freeboard pf_no_pk)*/no,subject,name,regdate,hit "
		 +"FROM project_freeboard)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<BoardVO> boardListData(Map map);
  // 추가 : 자동증가 번호 @SelectKey , @Insert
  // 상세보기 : 조건에 맞는 데이터 인출 @Update @Select => 분석 데이터 분석 (그래프)
  // 데이터 분석(데이터마이닝 => 형태소분석)  => API (꼬꼬마)
  // 수정 : UPDATE사용법  @Select @Update
  // 삭제 : DELETE사용법  @Select @Delete 
}
