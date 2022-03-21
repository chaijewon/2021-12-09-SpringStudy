package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  CNO                                       NOT NULL NUMBER
 TITLE                                     NOT NULL VARCHAR2(100)
 SUBJECT                                   NOT NULL VARCHAR2(100)
 POSTER                                    NOT NULL VARCHAR2(260)
 LINK                                               VARCHAR2(100)
 */
@Getter
@Setter
public class CategoryVO {
   private int cno;
   private String title,subject,poster;
}
