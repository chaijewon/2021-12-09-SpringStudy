package com.sist.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        HotelDAO dao=(HotelDAO)app.getBean("dao3");
        List<HotelVO> list=dao.hotelListData();
        for(HotelVO vo:list)
        {
        	System.out.println(vo.getName()+" "
        			+vo.getScore()+" "
        			+vo.getAddress());
        }
	}

}
