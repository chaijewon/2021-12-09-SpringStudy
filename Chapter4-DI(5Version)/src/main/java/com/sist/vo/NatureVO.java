package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NatureVO {
  private String title;
  private String address;
  private String msg;
  // VO => 컬럼명 매칭  ==> 자연의 한개에 대한 정보를 가지고 있다 (관련된 데이터를 모아서 처리)
}
