package com.sist.react.service;

import java.util.List;
import java.util.Map;

import com.sist.react.vo.CategoryVO;
import com.sist.react.vo.FoodVO;
import com.sist.react.vo.RecipeVO;
import com.sist.react.vo.SeoulVO;

public interface ReactService {
	public List<CategoryVO> foodCategoryData(Map map);
	public List<FoodVO> foodCategoryListData(int cno);
	public CategoryVO foodCategoryInfoData(int cno);
	public FoodVO foodDetailData(int no);
	
	//seoul
	public List<SeoulVO> seoulLocationData(Map map);
	public int seoulLocationTotalPage();
}
