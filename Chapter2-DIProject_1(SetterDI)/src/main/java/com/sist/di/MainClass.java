package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        // ����� ��ü�� ��� �´� 
        Sawon sa=(Sawon)app.getBean("sa1");
        System.out.println("�̸�:"+sa.getName());
        System.out.println("�μ�:"+sa.getDept());
        System.out.println("����:"+sa.getJob());
        System.out.println("����:"+sa.getAge());
        System.out.println("����:"+sa.getPay());
        System.out.println("==============");
        sa=(Sawon)app.getBean("sa2");
        System.out.println("�̸�:"+sa.getName());
        System.out.println("�μ�:"+sa.getDept());
        System.out.println("����:"+sa.getJob());
        System.out.println("����:"+sa.getAge());
        System.out.println("����:"+sa.getPay());
        System.out.println("==============");
        sa=(Sawon)app.getBean("sa3");
        System.out.println("�̸�:"+sa.getName());
        System.out.println("�μ�:"+sa.getDept());
        System.out.println("����:"+sa.getJob());
        System.out.println("����:"+sa.getAge());
        System.out.println("����:"+sa.getPay());
	}

}
