package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

// 데이터형 설정 => 스프링에서 메모리 할당을 하지 않는다
/*
 NO                                        NOT NULL NUMBER
 NAME                                      NOT NULL VARCHAR2(100)
 SCORE                                              NUMBER(2,1)
 ADDRESS                                   NOT NULL VARCHAR2(300)
 POSTER                                    NOT NULL VARCHAR2(4000)
 IMAGES                                             VARCHAR2(4000)
 */
@Getter
@Setter
public class HotelVO {
   private int no;
   private String name,address,poster,images;
   private double score;
}
