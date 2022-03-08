package com.sist.di;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class EmpDAO extends SqlSessionDaoSupport{
    public List<EmpVO> empListData()
    {
    	return getSqlSession().selectList("empListData");
    	// ¿­°í / ´Ý±â
    }
}
