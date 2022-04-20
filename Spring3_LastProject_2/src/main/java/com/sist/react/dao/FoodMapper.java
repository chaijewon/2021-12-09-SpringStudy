package com.sist.react.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.react.vo.*;
@Repository
@Mapper
public interface FoodMapper {
   // xml의 id와 메소드명이 동일 
   public List<CategoryVO> foodCategoryData(Map map);
   public List<FoodVO> foodCategoryListData(int cno);
   public CategoryVO foodCategoryInfoData(int cno);
}
