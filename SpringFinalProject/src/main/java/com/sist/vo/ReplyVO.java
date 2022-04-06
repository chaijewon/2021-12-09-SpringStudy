package com.sist.vo;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ReplyVO {
   private int no;
   private String name;
   private String subject;
   private String content;
   private String pwd;
   private Date regdate;
   private int hit;
   private int group_id;
   private int group_step;
   private int group_tab;
   private String dbday;
}
