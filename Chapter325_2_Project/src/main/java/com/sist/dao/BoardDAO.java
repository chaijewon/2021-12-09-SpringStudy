package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class BoardDAO {
   @Autowired
   private BoardMapper mapper;
   
   public List<BoardVO> boardListData()
   {
	   return mapper.boardListData();
   }
   public List<BoardVO> boardFindData(Map map)
   {
	   return mapper.boardFindData(map);
   }
}
