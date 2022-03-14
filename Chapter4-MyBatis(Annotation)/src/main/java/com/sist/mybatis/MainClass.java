package com.sist.mybatis;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        // app(Container => XML�� ��ϵ� ��� Ŭ������ �����ϴ� ����)
        BooksDAO dao=(BooksDAO)app.getBean("dao");
        List<BooksVO> list=dao.booksListData();
        for(BooksVO vo:list)
        {
        	System.out.println(vo.getTitle()+"("+vo.getPrice()+")");
        }
        System.out.println("=======================");
        Scanner scan=new Scanner(System.in);
        System.out.print("����:");
        String title=scan.next();
        list=dao.booksFindData(title);
        for(BooksVO vo:list)
        {
        	System.out.println(vo.getTitle()+"("+vo.getPrice()+")");
        }
	}

}







