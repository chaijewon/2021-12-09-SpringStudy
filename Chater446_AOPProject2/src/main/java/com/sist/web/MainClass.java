package com.sist.web;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 메모리 할당 요청 => 메모리 할당된 클래스 객체를 저장하는 공간 => 컨테이너 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MyDAO dao=(MyDAO)app.getBean("myDAO"); // web 자동 
		dao.sawonNameData();
	}

}
