package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;
//DAO여러개를 통합 BI
@Service
public class FoodService implements Food{
    @Autowired
    private CategoryDAO cDao;
    @Autowired
    private FoodDAO fDao;
	
    
	public List<CategoryVO> categoryAllData() {
		// TODO Auto-generated method stub
		return cDao.categoryAllData();
	}


	@Override
	public CategoryVO categoryInfodata(int cno) {
		// TODO Auto-generated method stub
		return cDao.categoryInfodata(cno);
	}


	@Override
	public List<FoodVO> categoryFoodListData(int cno) {
		// TODO Auto-generated method stub
		return cDao.categoryFoodListData(cno);
	}

}
