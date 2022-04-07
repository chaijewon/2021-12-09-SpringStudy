package com.sist.vo;

import lombok.Getter;
import lombok.Setter;
/*
 *   NO                                        NOT NULL NUMBER
     TITLE                                     NOT NULL VARCHAR2(200)
     POSTER                                    NOT NULL VARCHAR2(500)
     MSG                                       NOT NULL VARCHAR2(4000)
     ADDRESS
     NO                                        NOT NULL NUMBER
	 NAME                                      NOT NULL VARCHAR2(100)
	 SCORE                                              NUMBER(2,1)
	 ADDRESS                                   NOT NULL VARCHAR2(300)
	 POSTER                                    NOT NULL VARCHAR2(4000)
	 IMAGES
 */
@Getter
@Setter
public class SeoulVO {
  private int no;
  private double score;
  private String name,title,msg,poster;
  private String address,images;
}
