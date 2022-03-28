package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
import com.sist.dao.*;
@Service // DAO 여러개 통합 (BI) => 3문제 DAO VS Service
// *** SQL Injection 방지 (클래스 캡슐화)
public class FoodServiceImpl implements FoodService{
    @Autowired
    private CategoryDAO cdao;
    @Autowired
    private FoodDAO fdao;
	
	@Override
	public List<FoodVO> categoryFoodListData(int cno) {
		// TODO Auto-generated method stub
		return fdao.categoryFoodListData(cno);
	}

	@Override
	public FoodVO foodDetailData(Map map) {
		// TODO Auto-generated method stub
		return fdao.foodDetailData(map);
	}

	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return fdao.foodFindData(map);
	}

	@Override
	public List<CategoryVO> categoryListData() {
		// TODO Auto-generated method stub
		return cdao.categoryListData();
	}

	@Override
	public CategoryVO categoryInfoData(int cno) {
		// TODO Auto-generated method stub
		return cdao.categoryInfoData(cno);
	}
	
	

}
