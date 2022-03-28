package com.sist.service;
// 관련된 DAO를 모아서 관리 => BI
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
public interface FoodService {
	public List<FoodVO> categoryFoodListData(int cno);
	public FoodVO foodDetailData(Map map);
	public List<FoodVO> foodFindData(Map map);
	public List<CategoryVO> categoryListData();
	public CategoryVO categoryInfoData(int cno);
}
