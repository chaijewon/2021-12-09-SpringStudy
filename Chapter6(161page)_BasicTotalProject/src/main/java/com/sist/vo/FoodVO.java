package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  NO                                        NOT NULL NUMBER
 CNO                                                NUMBER
 POSTER                                    NOT NULL VARCHAR2(4000)
 NAME                                      NOT NULL VARCHAR2(200)
 SCORE                                     NOT NULL NUMBER(2,1)
 ADDRESS                                   NOT NULL VARCHAR2(300)
 TEL                                       NOT NULL VARCHAR2(30)
 TYPE                                      NOT NULL VARCHAR2(100)
 PRICE                                     NOT NULL VARCHAR2(50)
 PARKING                                            VARCHAR2(20)
 TIME                                               VARCHAR2(50)
 MENU                                               VARCHAR2(1000)
 GOOD                                               NUMBER
 SOSO                                               NUMBER
 BAD                                                NUMBER
 RESERVE_DAYS                                       VARCHAR2(100)
 */
@Getter
@Setter
public class FoodVO {
   private int no,cno;
   private double score;
   private String poster,name,tel,type,price,parking,time,menu,address;
}
