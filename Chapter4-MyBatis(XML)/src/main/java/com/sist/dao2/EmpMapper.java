package com.sist.dao2;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface EmpMapper {
  /*
	   *  <select id="empListData" resultType="EmpVO">
		   SELECT empno,ename,job,hiredate,sal,deptno
		   FROM emp
		 </select>
		 <!-- �󼼺��� -->
		 <select id="empDetailData" resultType="EmpVO" parameterType="int">
		   SELECT empno,ename,job,hiredate,sal,deptno
		   FROM emp
		   WHERE empno=#{empno}
		 </select>
   */
	@Select("SELECT empno,ename,job,hiredate,sal,deptno FROM emp")
	public List<EmpVO> empListData();
	//     resultType             parameterType
	// �������̽��� ����� �޼ҵ带 �ڵ� ������ �Ѵ� 
	@Select("SELECT empno,ename,job,hiredate,sal,deptno FROM emp "
		   +"WHERE empno=#{empno}")
	public EmpVO empDetailData(int empno);
}