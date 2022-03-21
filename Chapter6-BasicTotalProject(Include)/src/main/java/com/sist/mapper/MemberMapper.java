package com.sist.mapper;

import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
  // ID체크 (존재여부 확인)
  @Select("SELECT COUNT(*) FROM project_member "
		 +"WHERE id=#{id}")
  public int idCount(String id);
  // Password체크
  @Select("SELECT pwd FROM project_member "
		 +"WHERE id=#{id}")
  public String getPassword(String id);
  // name을 읽기 
  @Select("SELECT name FROM project_member "
		 +"WHERE id=#{id}")
  public String memberGetName(String id);
  
}
