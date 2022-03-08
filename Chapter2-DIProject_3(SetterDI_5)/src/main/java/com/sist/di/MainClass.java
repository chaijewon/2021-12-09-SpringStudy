package com.sist.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(EmpConfig.class);
        EmpDAO dao=app.getBean("dao",EmpDAO.class);
        // 형변환 없이 사용 
        List<EmpVO> list=dao.empListData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEmpno()+" "
        			+vo.getEname()+" "
        			+vo.getJob());
        }
	}

}
