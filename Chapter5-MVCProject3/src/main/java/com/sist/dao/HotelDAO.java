package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository //메모리 할당 요청 
public class HotelDAO {
  @Autowired //스프링에서 저장되어 있는 객체를 자동으로 찾아서 주입 (자동주입)
  // @Autowired는 반드시 스프링에서 메모리 할당하는 클래스에서만 가능 
  private HotelMapper mapper;
  
  public List<HotelVO> hotelListData(Map map)
  {
	  return mapper.hotelListData(map);
  }
  public HotelVO hotelDetailData(int no)
  {
	  return mapper.hotelDetailData(no);
  }
  public int hotelCount()
  {
	  int count=mapper.hotelCount();
	  return (int)(Math.ceil(count/20.0));//자바로 총페이지를 구할 수 있다 
  }
}
