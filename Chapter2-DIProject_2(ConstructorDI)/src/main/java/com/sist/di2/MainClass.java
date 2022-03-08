package com.sist.di2;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        BooksDAO dao=(BooksDAO)app.getBean("dao2");
        List<BooksVO> list=dao.booksListData();
        for(BooksVO vo:list)
        {
        	System.out.println(vo.getTitle()+" "
        			+vo.getAuthor()+" "
        			+vo.getPrice());
        }
	}

}
