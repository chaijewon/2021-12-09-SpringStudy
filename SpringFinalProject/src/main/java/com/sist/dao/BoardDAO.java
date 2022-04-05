package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 데이터베이스 처리 => JDBC => DBCP(1차) => ORM(Mybatis , JPA, Hibernate)
//                                                SQL없이 처리가 가능 
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository //메모리 할당이 가능 
public class BoardDAO {
   // 스프링으로부터 필요한 객체주소를 주입 요청 => @Autowired , @Resource
    @Autowired
	private BoardMapper mapper;
    
    public List<BoardVO> boardListData(Map map) // 매개변수를 여러개 받을 수 있다
    {
    	return mapper.boardListData(map); // 매개변수를 반드시 한개만 사용이 가능 
    	// 여러개의 데이터값이 필요시에는 ~VO , Map
    }
    public void boardInsert(BoardVO vo)
    {
    	mapper.boardInsert(vo);
    }
    
    public int boardRowCount()
    {
    	return mapper.boardRowCount(); // 삭제 => 번호가 순서(출력 => 게시판번호(X)) 
    }
    
    public int boardTotalPage()
    {
    	return (int)(Math.ceil(mapper.boardRowCount()/10.0));
    }
}
