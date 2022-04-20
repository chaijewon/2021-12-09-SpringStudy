package com.sist.react.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.react.dao.FoodMapper;
import com.sist.react.dao.RecipeMapper;
import com.sist.react.dao.SeoulMapper;
import com.sist.react.vo.CategoryVO;
import com.sist.react.vo.FoodVO;
import com.sist.react.vo.RecipeVO;
import com.sist.react.vo.SeoulVO;

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

	@Override
	public List<FoodVO> foodCategoryListData(int cno) {
		// TODO Auto-generated method stub
		return fMapper.foodCategoryListData(cno);
	}

	@Override
	public CategoryVO foodCategoryInfoData(int cno) {
		// TODO Auto-generated method stub
		return fMapper.foodCategoryInfoData(cno);
	}

	@Override
	public FoodVO foodDetailData(int no) {
		// TODO Auto-generated method stub
		return fMapper.foodDetailData(no);
	}
    // seoul
	@Override
	public List<SeoulVO> seoulLocationData(Map map) {
		// TODO Auto-generated method stub
		return sMapper.seoulLocationData(map);
	}

	@Override
	public int seoulLocationTotalPage() {
		// TODO Auto-generated method stub
		return sMapper.seoulLocationTotalPage();
	}
	// recipe
	
}
