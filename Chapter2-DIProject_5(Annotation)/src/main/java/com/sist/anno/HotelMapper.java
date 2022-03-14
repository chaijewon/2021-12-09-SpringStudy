package com.sist.anno;

import org.apache.ibatis.annotations.Select;
import java.util.*;
public interface HotelMapper {
   @Select("SELECT name,address FROM seoul_hotel")
   public List<HotelVO> hotelListData();// 자동 구현 
   /*
    *   <select id="hotelListData" resultType="HotelVO">
    *    SELECT name,address FROM seoul_hotel
    *   </select>
    */
}
