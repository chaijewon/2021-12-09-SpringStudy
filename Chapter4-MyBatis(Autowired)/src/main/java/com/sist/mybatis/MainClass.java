package com.sist.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.HotelDAO;
import com.sist.vo.*;
import java.util.*;
// 스프링에서 메모리 할당을 한 클래스에 대해서만 자동주입이 가능하다 
// @Component("mc") => getBean("mc")
// @Component => default id가 지정 ==> class명으로 생성 => 첫자만 소문자 
@Component("mc")
public class MainClass {
	@Autowired
    private HotelDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 스프링에 메모리 할당 요청 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		//MainClass m=new MainClass();
		MainClass m=(MainClass)app.getBean("mc");
		List<HotelVO> list=m.dao.hotelListData();
		for(HotelVO vo:list)
		{
			System.out.println("호텔명:"+vo.getName());
			System.out.println("주소:"+vo.getAddress());
		}
	}

}
