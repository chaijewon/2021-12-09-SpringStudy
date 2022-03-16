package com.sist.mapper;
import java.util.*;
/*
 *   HotelController (Model) <=====> HotelDAO <=====> MyBatis
 *                           HotelVO          HotelVO
 *   => List : selectList()
 *      VO   : selectOne()
 *      insert(),update(),delete()
 *      --------------------------- XML
 *   => SQL,메소드 설정 (리턴형 , 매개변수)
 *      => 리턴형,매개변수(반드시 1개 설정) 
 *              ------- 데이터가 많은 경우 (~VO,Map(Vo에 없는 변수는 Map))
 */

import org.apache.ibatis.annotations.Select;

import com.sist.vo.HotelVO;
public interface HotelMapper {
   // 목록 출력 (페이지) = List = 인라인뷰 (페이징 기법) => Top-N(중간에 있는 데이터를 자를 수 없다)
   // INDEX => 자동 설정 (pk,uk) => 자주 검색하는 컬럼
   // Order By는 권장하지 않는다 (속도가 저하)
	@Select("SELECT no,name,poster,score,num "
		  +"FROM (SELECT no,name,poster,score,rownum as num "
		  +"FROM (SELECT /*+ INDEX_ASC(seoul_hotel sh_no_pk)*/ no,name,poster,score "
		  +"FROM seoul_hotel)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
	/*
	 *   MySQL (80%,오라클 20%),MariaDB
	 *     SELECT no,name,poster,score FROM seoul_hotel 
	 *     limit #{start},#{rowSize}
	 *     
	 *     NVL ==> ifnull ..
	 */
	// SQL문장을 수행하는 메소드를 선언=마이바티스에서 자동 구현 
	public List<HotelVO> hotelListData(Map map); // #{start} , map.get("start")
    // 총페이지 구하기
	@Select("SELECT COUNT(*) FROM seoul_hotel")
	public int hotelCount();
	// 상세보기 => VO
	@Select("SELECT no,name,poster,score,images "
		   +"FROM seoul_hotel "
		   +"WHERE no=#{no}")
	public HotelVO hotelDetailData(int no);
}














