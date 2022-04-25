package com.sist.music.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.music.entity.MovieEntity;
import java.util.*;
@Repository
/*
 *  private int mno;
   private int cno;
   private String title,time,grade,reserve,genre,regdate,
                  director,actor,showUser,poster,story,mkey;
 */
public interface MovieDAO extends JpaRepository<MovieEntity, Integer>{
   // 영화 목록 
	/*
	 *   @Query(value="SELECT mno,cno,title,time,grade,reserve,genre,regdate,"
		 +"director,actor,showuser,poster,story,mkey "
		 +"FROM movie WHERE cno=:cno ORDER BY mno ASC "
		 +"limit :start,20",nativeQuery = true) => Mybatis
		 일반 쿼리 
		 @Query("SELECT mno,cno,title,time,grade,reserve,genre,regdate,"
		 +"director,actor,showuser,poster,story,mkey "
		 +"FROM movie WHERE cno=:cno ORDER BY mno ASC "
		 +"limit :start,20")
		 JPQL => 컬럼명 
	 */
   @Query(value="SELECT mno,cno,title,time,grade,reserve,genre,regdate,"
		 +"director,actor,showuser,poster,story,mkey "
		 +"FROM movie WHERE cno=:cno ORDER BY mno ASC "
		 +"limit :start,20",nativeQuery = true)
   public List<MovieEntity> movieListData(@Param("cno") Integer cno,
		  @Param("start") Integer start);
   // 총페이지 
   @Query(value="SELECT CEIL(COUNT(*)/20.0) "
		 +"FROM movie WHERE cno=:cno",nativeQuery = true)
   public int movieTotalPage(@Param("cno") Integer cno);
   // 메소드 Query
   public MovieEntity findByMno(int mno);
   
   // 찾기 
   @Query(value="SELECT mno,cno,title,time,grade,reserve,genre,regdate,"
		 +"director,actor,showuser,poster,story,mkey "
		 +"FROM movie WHERE title LIKE CONCAT('%',:title,'%') "
		 +"limit :start,20",nativeQuery = true)
   public List<MovieEntity> movieFindData(@Param("title") String title,
		   @Param("start") Integer start);
   
   @Query(value = "SELECT CEIL(COUNT(*)/20.0) "
		 +"FROM movie WHERE title LIKE CONCAT('%',:title,'%')",nativeQuery = true)
   public int movieFindTotalPage(@Param("title") String title);
}
