package com.sist.music.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageVO {
  private int curpage;
  private int totalpage;
  private int startPage;
  private int endPage;
}
