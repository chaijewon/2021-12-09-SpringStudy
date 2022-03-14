package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class EmpDAO extends SqlSessionDaoSupport{
  /*
   *   <select id="empListData" resultType="EmpVO">
   *       List<EmpVO> , EmpVO
		   SELECT empno,ename,job,hiredate,sal,deptno
		   FROM emp
		 </select>
		 <!-- 상세보기 -->
		 <select id="empDetailData" resultType="EmpVO" parameterType="int">
		   SELECT emp,ename,job,hiredate,sal,deptno
		   FROM emp
		   WHERE empno=#{empno}
		 </select>
   */
	public List<EmpVO> empListData()
	{
		return getSqlSession().selectList("empListData");
		// 메소드안에 연결과 닫기가 만들어져 있다 
		// getSqlSession() 
		/*
		 *     getSqlSession()
		 *     {
		 *        SqlSession session=null;
		 *        try
		 *        {
		 *           session=ssf.openSession();//연결
		 *           
		 *        }catch(Exception ex)
		 *        {
		 *           ex.printStackTrace();
		 *        }
		 *        finally
		 *        {
		 *           if(session!=null)
		 *              session.close();//닫기
		 *        }
		 *     }
		 */
	}
	public EmpVO empDetailData(int empno)
	{
		return getSqlSession().selectOne("empDetailData", empno);
	}
	/*
	 *   <select id="empDeptJoinData" resultMap="empMap">
		   SELECT empno,ename,job,hiredate,sal,emp.deptno,dname,loc
		   FROM emp,dept
		   WHERE emp.deptno=dept.deptno
		 </select>
	 */
	public List<EmpVO> empDeptJoinData()
	{
		return getSqlSession().selectList("empDeptJoinData");
	}
	/*
	 *  <select id="empDeptDetailData" resultMap="empMap" parameterType="int">
		   SELECT empno,ename,job,hiredate,sal,emp.deptno,dname,loc
		   FROM emp,dept
		   WHERE emp.deptno=dept.deptno
		   AND empno=#{empno}
		 </select>
	 */
	public EmpVO empDeptDetailData(int empno)
	{
		return getSqlSession().selectOne("empDeptDetailData", empno);
	}
}
