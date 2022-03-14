package com.sist.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.HotelDAO;
import com.sist.vo.*;
import java.util.*;
// ���������� �޸� �Ҵ��� �� Ŭ������ ���ؼ��� �ڵ������� �����ϴ� 
// @Component("mc") => getBean("mc")
// @Component => default id�� ���� ==> class������ ���� => ù�ڸ� �ҹ��� 
@Component("mc")
public class MainClass {
	@Autowired
    private HotelDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // �������� �޸� �Ҵ� ��û 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		//MainClass m=new MainClass();
		MainClass m=(MainClass)app.getBean("mc");
		List<HotelVO> list=m.dao.hotelListData();
		for(HotelVO vo:list)
		{
			System.out.println("ȣ�ڸ�:"+vo.getName());
			System.out.println("�ּ�:"+vo.getAddress());
		}
	}

}
