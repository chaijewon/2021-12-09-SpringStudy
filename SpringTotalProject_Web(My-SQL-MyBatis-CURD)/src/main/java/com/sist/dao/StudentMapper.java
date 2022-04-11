package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
public interface StudentMapper {
  @Select("SELECT hakbun,name,kor,eng,math,"
		 +"DATE_FORMAT(regdate,'%Y-%M-%D') as dbday "
		 +"FROM student ORDER BY hakbun DESC "
		 +"limit #{start},#{size}")
  public List<StudentVO> stdListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/10.0) FROM student")
  public int studentTotalPage();
  
  @Insert("INSERT INTO student(name,kor,eng,math,regdate) "
		 +"VALUES(#{name},#{kor},#{eng},#{math},now())")
  public void stdInsert(StudentVO vo);
  
  @Delete("DELETE FROM student WHERE hakbun=#{hakbun}")
  public void stdDelete(int hakbun);
  
  // 수정 데이터 읽기 LIKE '%'||#{fd}||'%' => concat('%',#{fd},'%')
  @Select("SELECT hakbun,name,eng,math,kor "
		 +"FROM student "
		 +"WHERE hakbun=#{hakbun}")
  public StudentVO stdUpdateData(int hakbun);
  // 실제 수정 
  @Update("UPDATE student SET "
		 +"name=#{name},kor=#{kor},eng=#{eng},math=#{math} "
		 +"WHERE hakbun=#{hakbun}")
  public void stdUpdate(StudentVO vo);
}








