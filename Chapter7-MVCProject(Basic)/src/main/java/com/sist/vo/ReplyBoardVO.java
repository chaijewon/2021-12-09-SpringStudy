package com.sist.vo;
/*
 *  NO                                        NOT NULL NUMBER
 NAME                                      NOT NULL VARCHAR2(34)
 SUBJECT                                   NOT NULL VARCHAR2(2000)
 CONTENT                                   NOT NULL CLOB
 PWD                                       NOT NULL VARCHAR2(10)
 REGDATE                                            DATE
 HIT                                                NUMBER
 GROUP_ID                                           NUMBER
 GROUP_STEP                                         NUMBER
 GROUP_TAB                                          NUMBER
 ROOT                                               NUMBER
 DEPTH                                              NUMBER
 */
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ReplyBoardVO {
  private int no,hit,group_id,group_step,group_tab,root,depth;
  private String name,subject,content,pwd,dbday;
  private Date regdate;
}
