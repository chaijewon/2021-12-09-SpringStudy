package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface BooksMapper {
   @Select("SELECT title,price FROM books "
		  +"WHERE title LIKE '%'||#{title}||'%'")
   public List<BooksVO> booksFindData(String title);
   public List<BooksVO> booksListData();
   /*
		   <select id="booksListData" resultType="BooksVO">
		    SELECT title,price FROM books
		   </select>
    */
}
