package com.sist.mapper;
//  메모리할당 (X) => 구현을 요청 

import org.apache.ibatis.annotations.Select;

import com.sist.vo.LocationVO;

import java.util.*;
public interface LocationMapper {
  @Select("SELECT title,address,msg FROM seoul_location")
  public List<LocationVO> locationListData();//구현 완료
}
