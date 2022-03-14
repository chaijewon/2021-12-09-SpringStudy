package com.sist.mybatis;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Ŭ������ ��� 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		// �ʿ��� Ŭ������ app���� ã�Ƽ� ��� 
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		// ��� ��� 
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getHiredate().toString()+" "
					+vo.getSal()+" "
					+vo.getDeptno());
		}
		// �󼼺��� 
		EmpVO vo=dao.empDetailData(7788);
		System.out.println("���:"+vo.getEmpno());
		System.out.println("�̸�:"+vo.getEname());
		System.out.println("����:"+vo.getJob());
		System.out.println("�Ի���:"+vo.getHiredate().toString());
		System.out.println("�޿�:"+vo.getSal());
		System.out.println("�μ�:"+vo.getDeptno());
		
		System.out.println("============== Emp JOIN Dept ==========");
		List<EmpVO> jList=dao.empDeptJoinData();
		for(EmpVO jvo:jList)
		{
			System.out.println(
					        jvo.getEmpno()+" "
							+jvo.getEname()+" "
							+jvo.getJob()+" "
							+jvo.getHiredate().toString()+" "
							+jvo.getSal()+" "
							+jvo.getDeptno()+" "
							+jvo.getDvo().getDname()+" "
							+jvo.getDvo().getLoc()
			);
			
		}
		System.out.println("============== Emp JOIN Dept (Detail) ======");
		EmpVO jvo=dao.empDeptDetailData(7788);
		System.out.println("���:"+jvo.getEmpno());
		System.out.println("�̸�:"+jvo.getEname());
		System.out.println("����:"+jvo.getJob());
		System.out.println("�Ի���:"+jvo.getHiredate().toString());
		System.out.println("�޿�:"+jvo.getSal());
		System.out.println("�μ�:"+jvo.getDeptno());
		System.out.println("�μ���:"+jvo.getDvo().getDname());
		System.out.println("�ٹ���:"+jvo.getDvo().getLoc());
	}

}
