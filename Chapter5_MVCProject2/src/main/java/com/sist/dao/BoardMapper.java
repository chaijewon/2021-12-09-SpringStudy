package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
public interface BoardMapper {
  // 페이징 기법 , 정렬(INDEX)
  @Select("SELECT no,subject,name,regdate,hit,num "
		 +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		 +"FROM (SELECT /*+ INDEX_DESC(spring_board sb_no_pk)*/no,subject,name,regdate,hit "
		 +"FROM spring_board)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
         //                    map의 key  map의 key => map.get("start");
  // 리턴형 (resultType), 매개변수(parameterType)
  // 리턴형 , 매개변수는 1개만 첨부가 가능 
  // 여러개의 데이터가 들어갈때 => Map , BoardVO를 이용한다 
  public List<BoardVO> boardListData(Map map);
  
  @SelectKey(keyProperty = "no",resultType = int.class,before = true,
		  statement = "SELECT NVL(MAX(no)+1,1) as no FROM spring_board")
  //Sequence(자동 증가 번호)
  // keyProperty=>컬럼 대상 , resultType=int.class
  // before => 먼저 실행하는 SQL문장 , statement=실제 수행하는 SQL문장 설정  
  @Insert("INSERT INTO spring_board(no,name,subject,content,pwd) "
		 +"VALUES(#{no},#{name},#{subject},#{content},#{pwd})")
  //              vo.getNo() , vo.getName() , vo.getSubject()
  public void boardInsert(BoardVO vo);
  // UPDATE , DELETE , SELECT
  
  // 상세보기 
  @Update("UPDATE spring_board SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
  public void hitIncrement(int no);
  
  @Select("SELECT no,name,subject,content,regdate,hit "
		 +"FROM spring_board "
		 +"WHERE no=#{no}")
  public BoardVO boardDetailData(int no);
  // 수정하기 
  // 삭제하기 
}








