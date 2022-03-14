package com.sist.mybatis;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao2.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	new ClassPathXmlApplicationContext("app2.xml");
        //DAO�� ���������κ��� ������ �´� 
        //�������� ��ϵ� DAO�� ������ �Ϸ� => new (null�̴�)
        EmpDAO dao=(EmpDAO)app.getBean("dao");
        //����Ŭ�� ��ϵ� �����͸� �б� �����Ѵ� 
        List<EmpVO> list=dao.empListData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEmpno()+" "
        			+vo.getEname()+" "
        			+vo.getJob()+" "
        			+vo.getSal());
        }
        System.out.println("=================================");
        List<EmpVO> jList=dao.empdeptJoinData();
        for(EmpVO vo:jList)
        {
        	System.out.println(vo.getEmpno()+" "
        			+vo.getEname()+" "
        			+vo.getJob()+" "
        			+vo.getSal()+" "
        			+vo.getDvo().getDname()+" "
        			+vo.getDvo().getLoc());
        }
	}

}
