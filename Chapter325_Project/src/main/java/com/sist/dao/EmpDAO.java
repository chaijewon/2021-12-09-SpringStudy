package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *     <select id="empGetNameData" resultType="string">
		    SELECT ename FROM emp
		   </select>
	 */
	//     resultType              paramterType
    public List<String> empGetNameData()
    {
    	return getSqlSession().selectList("empGetNameData");
    }
    
    public List<EmpVO> empFindData(Map map)
    {
    	return getSqlSession().selectList("empFindData",map);
    }
}
