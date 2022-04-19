package com.sist.react.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.react.dao.FoodMapper;
import com.sist.react.dao.RecipeMapper;
import com.sist.react.dao.SeoulMapper;
import com.sist.react.vo.CategoryVO;
import com.sist.react.vo.RecipeVO;

@Service
public class ReactServiceImpl implements ReactService{
    @Autowired
    private FoodMapper fMapper;
    @Autowired
    private RecipeMapper rMapper;
    @Autowired
    private SeoulMapper sMapper;
    
	@Override
	public List<CategoryVO> foodCategoryData(Map map) {
		// TODO Auto-generated method stub
		return fMapper.foodCategoryData(map);
	}
	
}
