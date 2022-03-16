package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.HotelVO;
/*
 *  @Select("SELECT no,name,poster,score,num "
		   +"FROM (SELECT no,name,poster,score,rownum as num "
		   +"FROM (SELECT + INDEX_ASC(seoul_hotel sh_no_pk) no,name,poster,score "
		   +"FROM seoul_hotel)) "
		   +"WHERE num BETWEEN #{start} AND #{end}")
	public List<HotelVO> hotelListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_hotel")
	public int hotelTotalPage();
	// 상세보기 => VO
	@Select("SELECT no,name,poster,score,images,address "
		   +"FROM seoul_hotel "
		   +"WHERE no=#{no}")
	public HotelVO hotelDetailData(int no);
 */
import com.sist.mapper.*;
@Repository
public class HotelDAO {
    @Autowired
    private HotelMapper mapper;
    public List<HotelVO> hotelListData(Map map)
    {
    	return mapper.hotelListData(map);
    }
    public int hotelTotalPage()
    {
    	return mapper.hotelTotalPage();
    }
    public HotelVO hotelDetailData(int no)
    {
    	return mapper.hotelDetailData(no);
    }
    
}













