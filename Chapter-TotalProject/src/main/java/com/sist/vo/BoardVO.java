package com.sist.vo;
import java.util.*; //CURD

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BoardVO {
  private int no,hit;
  private String name,subject,content,pwd,dbday;
  private Date regdate;
}
