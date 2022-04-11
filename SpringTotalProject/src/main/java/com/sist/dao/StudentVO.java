package com.sist.dao;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
/*
 *   1. ~VO : readonly (setter(X), getter(O)) => spring
 *            다름 변수 추가가 가능 
 *   2. ~DTO : 컬럼외에 다른 변수 추가가 가능 (데이터를 모아서 전송) => mybatis
 *             => getter/setter
 *   3. ~Entity : 테이블 컬러명과 일치(다른 변수를 사용할 수 없다) => JPA
 *   ============================ record단위 (데이터베이스의 row)
 */
@Getter
@Setter
public class StudentVO {
  private int hakbun,kor,eng,math;
  private String name,dbday;
  private Date regdate;
}
