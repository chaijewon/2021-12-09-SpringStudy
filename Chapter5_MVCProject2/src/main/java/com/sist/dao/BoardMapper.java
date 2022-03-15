package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
// MyBatis(SQL) / JPA(SQL문장)
// findByIdANDPassword() => WHERE id='' AND password=''
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
  
  // 총페이지 
  @Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_board")
  public int boardTotalPage();
  // resultType=>SQL실행 결과값 , parameterType(?에 값을 채운다 => #{}) => 매개변수 
  
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
  //1.비밀번호 검색 
  // => #{}=> 매개변수 , SQL실행 결과값 : 리턴형
  @Select("SELECT pwd FROM spring_board "
		 +"WHERE no=#{no}")
  public String boardGetPassword(int no);
  
  //2.수정 데이터 읽기 => 재사용 boardDetailData
  //3.실제 수정 
  @Update("UPDATE spring_board SET "
		 +"name=#{name},subject=#{subject},content=#{content} "
		 +"WHERE no=#{no}")
  public void boardUpdate(BoardVO vo);
  // 삭제하기 
  @Delete("DELETE FROM spring_board "
		 +"WHERE no=#{no}")
  public void boardDelete(int no);
}








