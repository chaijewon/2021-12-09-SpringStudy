package com.sist.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 데이터베이스 (오라클 , MySQL) => 단위가 record(row) => 한줄 전체를 모아서 전송할 목적 
// VO/DTO (1.문제)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodVO {
   private int no,cno;
   private double score;
   private String name,address,tel,poster,time,parking,type,menu;
}
