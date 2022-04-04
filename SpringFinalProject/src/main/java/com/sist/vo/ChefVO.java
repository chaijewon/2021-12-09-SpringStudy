package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *   POSTER                                             VARCHAR2(260)
 CHEF                                               VARCHAR2(500)
 MEM_CONT1                                          VARCHAR2(100)
 MEM_CONT3                                          VARCHAR2(100)
 MEM_CONT7                                          VARCHAR2(100)
 MEM_CONT2                                          VARCHAR2(100)
 */
@Setter
@Getter
public class ChefVO {
  private String poster,chef,mem_cont1,mem_cont2,mem_cont3,mem_cont7;
}
