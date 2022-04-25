package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
    @Autowired
	private FoodMapper mapper;
   
    public List<FoodVO> foodFindData(Map map)
    {
    	return mapper.foodFindData(map);
    }
    
    public int foodLocationTotalPage()
    {
    	return mapper.foodLocationTotalPage();
    }
}
