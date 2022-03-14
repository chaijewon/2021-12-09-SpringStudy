package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface NatureMapper {
  @Select("SELECT title,address,msg FROM seoul_nature")
  public List<NatureVO> natureListData();
}
