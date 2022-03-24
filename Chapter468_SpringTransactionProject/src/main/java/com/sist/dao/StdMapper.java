package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
public interface StdMapper {
  @Select("SELECT * FROM std_input")
  public List<StdVO> stdListData();
  @Insert("INSERT INTO std_input VALUES("
		 +"#{no},#{name},#{kor},#{eng},#{math})")
  public void stdInsert(StdVO vo);
}
