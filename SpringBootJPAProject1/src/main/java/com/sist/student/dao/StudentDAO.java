package com.sist.student.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.student.entity.StudentEntity;

@Repository
public interface StudentDAO extends JpaRepository<StudentEntity, Integer>{
  // Where findByXxx() findByNameLike(String name) 
  // where name=       findByNameAndHakbun   name=? and hakbun=?
  public StudentEntity findByHakbun(int hakbun);
  
  @Query(value = "SELECT hakbun,name,kor,eng,math,regdate FROM student WHERE name LIKE CONCAT('%',:name,'%')",nativeQuery = true)
  public List<StudentEntity> studentNameFind(@Param("name") String name);
  
  @Query(value = "SELECT hakbun,name,kor,eng,math,regdate "
		 +"FROM student ORDER BY hakbun ASC limit :start,2",nativeQuery = true)
  public List<StudentEntity> studentListData(@Param("start") int start);
  
  @Query("SELECT CEIL(COUNT(*)/2.0) FROM student")
  public int studentTotalPage();
}
