package com.sist.di2;
import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(LocationConfig.class);
        LocationDAO dao=(LocationDAO)app.getBean("dao");
        List<LocationVO> list=dao.locationListData();
        for(LocationVO vo:list)
        {
        	System.out.println("疙家:"+vo.getName());
        	System.out.println("家俺:"+vo.getMessage());
        	System.out.println("林家:"+vo.getAddr());
        	System.out.println("==================================");
        }
        
        Scanner scan=new Scanner(System.in);
        System.out.print("林家 涝仿:");
        String addr=scan.next();
        list=dao.locationFindData(addr);
        for(LocationVO vo:list)
        {
        	System.out.println("疙家:"+vo.getName());
        	System.out.println("家俺:"+vo.getMessage());
        	System.out.println("林家:"+vo.getAddr());
        	System.out.println("==================================");
        }
	}

}
