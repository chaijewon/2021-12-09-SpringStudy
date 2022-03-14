package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.mapper.LocationMapper;
import com.sist.vo.LocationVO;
// DAO VS Service (차이점)
// OOP VS AOP 
// DI 
// JDBC VS ORM
// 스프링을 정석으로 구현 
@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationMapper mapper;
	@Override
	public List<LocationVO> locationListData() {
		// TODO Auto-generated method stub
		return mapper.locationListData();
	}

}
