package com.sist.react.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeoulVO {
	  private int no;
	  private double score;
	  private String name,title,msg,poster;
	  private String address,images;
	  private int curpage,totalpage;
}
