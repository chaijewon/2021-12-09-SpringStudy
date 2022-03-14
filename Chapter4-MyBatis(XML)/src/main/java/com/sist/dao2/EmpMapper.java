package com.sist.dao2;
import java.util.*;

import org.apache.ibatis.annotations.Select;
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
}
