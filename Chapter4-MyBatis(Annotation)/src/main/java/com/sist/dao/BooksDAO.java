package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
public class BooksDAO {
    private BooksMapper mapper;
   // 스프링에서 구현된 mapper를 받아 온다 

	public void setMapper(BooksMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<BooksVO> booksListData()
	{
		return mapper.booksListData();
	}
	public List<BooksVO> booksFindData(String title)
	{
		return mapper.booksFindData(title);
	}
   
}
