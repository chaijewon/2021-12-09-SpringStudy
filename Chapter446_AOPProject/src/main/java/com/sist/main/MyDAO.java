package com.sist.main;

import org.springframework.stereotype.Component;

@Component
public class MyDAO {
  public void select()
  {
	  // getConnection() => Before
	  System.out.println("데이터 읽기");
	  // disConnection() => After
  }
  public void insert()
  {
	  // getConnection() => Before
	  System.out.println("데이터 추가");
	  // disConnection() => After
  }
  public void update()
  {
	  // getConnection() => Before
	  System.out.println("데이터 수정");
	  // disConnection() => After
  }
  public void delete()
  {
	  // getConnection() => Before
	  System.out.println("데이터 삭제");
	  // disConnection() => After
  }
}
