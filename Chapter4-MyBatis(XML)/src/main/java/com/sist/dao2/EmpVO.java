package com.sist.dao2;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class EmpVO {
  private int empno;
  private String ename;
  private String job;
  private Date hiredate;
  private int sal;
  private int deptno;
  private DeptVO dvo=new DeptVO();//조인 => 자바에서 조인(포함 클래스)
}
