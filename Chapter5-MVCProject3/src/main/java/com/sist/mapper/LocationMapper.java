package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface LocationMapper {
  @Select("SELECT no,title,poster,num "
		 +"FROM (SELECT no,title,poster,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(seoul_location sl_no_pk)*/ no,title,poster "
		 +"FROM seoul_location)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<LocationVO> locationListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_location")
  public int locationTotalPage();
  
  @Select("SELECT * FROM seoul_location "
		 +"WHERE no=#{no}")
  public LocationVO locationDetailData(int no);
}
