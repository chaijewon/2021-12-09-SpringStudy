package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface BoardMapper {
	/*
	 *  <select id="boardListData" resultType="BoardVO">
		   SELECT no,subject,name,regdate,hit
		   FROM project_freeboard
		 </select>
	 */
   @Select("SELECT no,subject,name,regdate,hit "
		  +"FROM project_freeboard")
   public List<BoardVO> boardListData();
   /*
    *    <select id="boardFindData" resultType="BoardVO" parameterType="hashmap">
   SELECT no,subject,name,regdate,hit
   FROM project_freeboard
   WHERE
   <!-- 
     => name subject
        subject content
     WHERE 
     name LIKE '%'||'%'
     OR subject LIKE '%'||'%'
     OR content LIKE '%'||'%'
    -->
   <trim prefix="(" suffix=")" prefixOverrides="OR">
     <foreach collection="fsArr" item="fd">
      <trim prefix="OR">
       <if test="fd=='N'.toString()">
        name LIKE '%'||#{ss}||'%'
       </if>
       <if test="fd=='S'.toString()">
        subject LIKE '%'||#{ss}||'%'
       </if>
       <if test="fd=='C'.toString()">
        content LIKE '%'||#{ss}||'%'
       </if>
       </trim>
     </foreach>
   </trim>
 </select>
    */
   @Select("<script>"
		  +"SELECT no,subject,name,regdate,hit "
		  +"FROM project_freeboard "
		  +"WHERE "
		  +"<trim prefix=\"(\" suffix=\")\" prefixOverrides=\"OR\">" + 
		  "     <foreach collection=\"fsArr\" item=\"fd\">" + 
		  "      <trim prefix=\"OR\">" + 
		  "       <if test=\"fd=='N'.toString()\">" + 
		  "        name LIKE '%'||#{ss}||'%'" + 
		  "       </if>" + 
		  "       <if test=\"fd=='S'.toString()\">" + 
		  "        subject LIKE '%'||#{ss}||'%'" + 
		  "       </if>" + 
		  "       <if test=\"fd=='C'.toString()\">" + 
		  "        content LIKE '%'||#{ss}||'%'" + 
		  "       </if>" + 
		  "       </trim>" + 
		  "     </foreach>" + 
		  "   </trim>"
		  +"</script>")
   public List<BoardVO> boardFindData(Map map);
}
