package com.sist.dao;

import org.springframework.stereotype.Component;
import java.util.*;
@Component
public class MyDAO {
   public List<String> sawonNameData()
   {
	   List<String> list=new ArrayList<String>();
	   list.add("홍길동");
	   list.add("심청이");
	   list.add("박문수");
	   return list;
   }
}
