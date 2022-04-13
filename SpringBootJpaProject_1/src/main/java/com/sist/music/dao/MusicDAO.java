package com.sist.music.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.music.entity.MusicEntity;
import java.util.*;
@Repository
/*
 *  no int AI PK 
	cno int 
	title varchar(500) 
	singer varchar(300) 
	album varchar(300) 
	state varchar(20) 
	idcrement int 
	poster varchar(500) 
	mkey varchar(100)
 */
public interface MusicDAO extends JpaRepository<MusicEntity, Integer>{
    @Query(value="SELECT no,cno,title,singer,album,state,idcrement,"
    	  +"poster,mkey "
    	  +"FROM music WHERE cno=:cno ORDER BY no ASC limit :start,20",nativeQuery = true)
    public List<MusicEntity> musicListData(@Param("cno") Integer cno,@Param("start") Integer start);
    
    @Query(value="SELECT CEIL(COUNT(*)/20.0) FROM music WHERE cno=:cno",nativeQuery = true)
    public int musicTotalPage(@Param("cno") int cno);
    
    public MusicEntity findByNo(int no); // 자동 처리 
    // SELECT * FROM music WHERE no=no 
    /*
     *   findBySingerAndTitle(String singer,String title)
     *   WHERE singer=singer and title=title
     *   findByNameLike  => WHERE name Like...
     *   메소드명으로 SQL문장 제작 
     *   '%'||검색어||'%' = 오라클 
     *   CONCAT('%',:title ,'%') = mysql ,mariadb
     *   :title => ?1 ?2...
     */
    @Query(value="SELECT no,cno,title,singer,album,state,idcrement,"
    	  +"poster,mkey "
    	  +"FROM music WHERE title LIKE CONCAT('%',:title ,'%') "
    	  +"limit :start,20"
    	  ,nativeQuery = true)
    public List<MusicEntity> musicFindData(@Param("title") String title,
    	  @Param("start") Integer start);

    @Query(value="SELECT CEIL(COUNT(*)/20.0) FROM music "
    	  +"WHERE title LIKE CONCAT('%',:title,'%')",nativeQuery = true)
    public int musicFindTotalPage(@Param("title") String title);
    
    
}






