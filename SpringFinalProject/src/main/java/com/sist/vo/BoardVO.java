package com.sist.vo;
// ~VO , ~Bean , ~Dto => 데이터를 모아소 관리할 목적 => 한번에 전송 
// 단위는 항상 Record (컬럼여러개 모아서 관리) => ROW
// 사용자 정의 데이터형  => 구조체(자바에서는 존재하지 않는다) => C / C++ / C#
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor  // default 생성자 
public class BoardVO {
  private int no,hit;
  private Date regdate;
  private String name,subject,content,pwd,dbday;
}
