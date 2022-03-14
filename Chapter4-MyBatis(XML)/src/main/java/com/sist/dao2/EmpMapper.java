package com.sist.dao2;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
// 94page
/*
 *   MyBatis : XML , Annotation 
 *            -----  ----------
 *   Spring : XML , Annotation 
 *           -----
 */
public interface EmpMapper {
  /*
	   *  <select id="empListData" resultType="EmpVO">
		   SELECT empno,ename,job,hiredate,sal,deptno
		   FROM emp
		 </select>
		 <!-- 상세보기 -->
		 <select id="empDetailData" resultType="EmpVO" parameterType="int">
		   SELECT empno,ename,job,hiredate,sal,deptno
		   FROM emp
		   WHERE empno=#{empno}
		 </select>
   */
	@Select("SELECT empno,ename,job,hiredate,sal,deptno FROM emp")
	public List<EmpVO> empListData();
	//     resultType             parameterType
	// 인터페이스에 등록한 메소드를 자동 구현을 한다 
	@Select("SELECT empno,ename,job,hiredate,sal,deptno FROM emp "
		   +"WHERE empno=#{empno}")
	public EmpVO empDetailData(int empno);
	
	// <resultMap>
	@Results({
		@Result(property="dvo.dname",column = "dname"),
		@Result(property = "dvo.loc",column = "loc")
	})
	/*
	 *    property ==> setXxx()
	 *    column   ==> rs.getString("dname")
	 *    vo.getDvo().setDname(rs.getString("dname"))
	 */
	// 조인 
	@Select("SELECT empno,ename,job,sal,emp.deptno,dname,loc "
		   +"FROM emp,dept "
		   +"WHERE emp.deptno=dept.deptno")
	public List<EmpVO> empdeptJoinData();
}









