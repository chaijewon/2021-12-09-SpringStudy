package com.sist.mapper;
//  �޸��Ҵ� (X) => ������ ��û 

import org.apache.ibatis.annotations.Select;

import com.sist.vo.LocationVO;

import java.util.*;
public interface LocationMapper {
  @Select("SELECT title,address,msg FROM seoul_location")
  public List<LocationVO> locationListData();//���� �Ϸ�
}
