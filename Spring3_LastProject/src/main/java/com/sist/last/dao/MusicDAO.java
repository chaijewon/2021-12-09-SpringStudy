package com.sist.last.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.last.entity.MusicEntity;
import java.util.*;
@Repository
// 제네릭스는 무조건 클래스형을 사용한다 (Wrapper)
/*
 *  private int no;
  private int cno,idcrement;
  private String title,singer,album,state,poster,mkey;
*/
public interface MusicDAO extends JpaRepository<MusicEntity, Integer>{
  // 페이지 나누기 
  @Query(value="SELECT no,cno,idcrement,title,singer,"
		+"album,state,poster,mkey "
		+"FROM music "
		+"WHERE cno=:cno ORDER BY no ASC "
		+"limit :start,12",nativeQuery = true)
  public List<MusicEntity> musicListData(@Param("cno") Integer cno,
		  @Param("start") Integer start);
  @Query(value="SELECT CEIL(COUNT(*)/12.0) FROM music "
		+"WHERE cno=:cno",nativeQuery = true)
  public int musicTotalPage(@Param("cno") Integer cno);
  
  @Query(value="SELECT no,cno,idcrement,title,singer," + 
  		"album,state,poster,mkey " +
		"FROM music WHERE no=:no",nativeQuery = true)
  public MusicEntity musicDetailData(@Param("no") Integer no);
}
