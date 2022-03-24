package com.sist.dao;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class BoardVO {
  private int no,hit;
  private String name,subject,content,pwd;
  private Date regdate;
}
