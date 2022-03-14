package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        // 저장된 객체를 얻어 온다 
        Sawon sa=(Sawon)app.getBean("sa1");
        System.out.println("이름:"+sa.getName());
        System.out.println("부서:"+sa.getDept());
        System.out.println("직위:"+sa.getJob());
        System.out.println("나이:"+sa.getAge());
        System.out.println("연봉:"+sa.getPay());
        System.out.println("==============");
        sa=(Sawon)app.getBean("sa2");
        System.out.println("이름:"+sa.getName());
        System.out.println("부서:"+sa.getDept());
        System.out.println("직위:"+sa.getJob());
        System.out.println("나이:"+sa.getAge());
        System.out.println("연봉:"+sa.getPay());
        System.out.println("==============");
        sa=(Sawon)app.getBean("sa3");
        System.out.println("이름:"+sa.getName());
        System.out.println("부서:"+sa.getDept());
        System.out.println("직위:"+sa.getJob());
        System.out.println("나이:"+sa.getAge());
        System.out.println("연봉:"+sa.getPay());
	}

}
