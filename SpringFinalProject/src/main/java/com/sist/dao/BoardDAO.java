package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 데이터베이스 처리 => JDBC => DBCP(1차) => ORM(Mybatis , JPA, Hibernate)
//                                                SQL없이 처리가 가능 
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
/*
 *  개발자들의 약속 
 *  1. 클래스  : 시작 대문자  
 *  2. 변수 , 메소드 : 소문자 시작
 *  3. 단어2개이상 : 두번째 단어는 대문자 
 *  ============================= React :  클래스
 *  오라클 : 키워드는 대소문자로 한다 (오라클) , Mysql(소문자)
 */
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
    
    public BoardVO boardDetailData(int no)
    {
    	mapper.hitIncrement(no);
    	return mapper.boardDetailData(no);
    }
    
    public BoardVO boardUpdateData(int no)
    {
    	return mapper.boardDetailData(no);
    }
    
    // 수정 
    public boolean boardUpdate(BoardVO vo)
    {
    	boolean bCheck=false;
    	String db_pwd=mapper.boardGetPassword(vo.getNo());
    	if(db_pwd.equals(vo.getPwd()))
    	{
    		bCheck=true;
    		mapper.boardUpdate(vo);
    	}
    	return bCheck;
    }
    // 삭제 
    public boolean boardDelete(int no,String pwd)
    {
    	boolean bCheck=false;
    	String db_pwd=mapper.boardGetPassword(no);
    	if(db_pwd.equals(pwd))
    	{
    		bCheck=true;
    		mapper.boardDelete(no);
    	}
    	return bCheck;
    }
    
}








