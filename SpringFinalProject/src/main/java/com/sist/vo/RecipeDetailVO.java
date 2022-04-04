package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *   NO                                                 NUMBER
	 POSTER                                             VARCHAR2(260)
	 TITLE                                              VARCHAR2(2000)
	 CHEF                                               VARCHAR2(200)
	 CHEF_POSTER                                        VARCHAR2(1000)
	 CHEF_PROFILE                                       VARCHAR2(2000)
	 INFO1                                              VARCHAR2(50)
	 INFO2                                              VARCHAR2(50)
	 INFO3                                              VARCHAR2(50)
	 CONTENT                                            VARCHAR2(4000)
	 FOODMAKE                                           VARCHAR2(4000)
	 ETC                                                VARCHAR2(1000)
 */
@Getter
@Setter
public class RecipeDetailVO {
   private int no;
   private String poster,title,chef,chef_poster,
                  chef_profile,info1,info2,info3,content,foodmake,etc;
}
