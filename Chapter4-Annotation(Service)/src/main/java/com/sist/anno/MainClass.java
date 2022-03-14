package com.sist.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Component("mc")
// �������� �޸��Ҵ� ��û => ���α׷� ����ñ��� ����
public class MainClass {
	@Autowired
    private LocationService service;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	  new ClassPathXmlApplicationContext("app.xml");
        MainClass mc=(MainClass)app.getBean("mc");
        List<LocationVO> list=mc.service.locationListData();
        for(LocationVO vo:list)
        {
        	System.out.println(vo.getTitle());
        	System.out.println(vo.getAddress());
        	System.out.println(vo.getMsg());
        	System.out.println("===============================");
        }
	}

}
