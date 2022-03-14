package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

// 사용자 정의 데이터형 (스프링에서 메모리 할당하지 않는다)
// ~VO , ~DTO => 사용자 정의 데이터형 (메모리할당 필요시마다 프로그래머가 사용)
// Integer , Double , String (데이터를 모아서 관리하는 역할) => 한개,한명 
@Setter
@Getter
public class LocationVO {
  private String title;
  private String address;
  private String msg;
}
