package com.sist.react.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.react.vo.*;
@Repository
@Mapper
public interface RecipeMapper {
   public List<RecipeVO> recipeListData();
}
