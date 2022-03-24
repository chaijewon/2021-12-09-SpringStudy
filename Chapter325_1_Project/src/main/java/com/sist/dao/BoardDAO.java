package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class BoardDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *   <select id="boardListData" resultType="BoardVO">
		   SELECT no,subject,name,regdate,hit
		   FROM project_freeboard
		 </select>
	 */
	public List<BoardVO> boardListData()
	{
		return getSqlSession().selectList("boardListData");
	}
    
	public List<BoardVO> boardFindData(Map map)
	{
		return getSqlSession().selectList("boardFindData",map);
		// 동적 쿼리 => 데이터는 map
	}
}
