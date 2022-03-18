package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *   NO                                        NOT NULL NUMBER
 TITLE                                     NOT NULL VARCHAR2(200)
 POSTER                                    NOT NULL VARCHAR2(500)
 MSG                                       NOT NULL VARCHAR2(4000)
 ADDRESS                                   NOT NULL VARCHAR2(300)
 */
@Getter
@Setter
public class LocationVO {
   private int no;
   private String title,poster,msg,address;
}
