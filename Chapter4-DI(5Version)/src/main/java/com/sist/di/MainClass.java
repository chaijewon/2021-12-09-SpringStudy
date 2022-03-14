package com.sist.di;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.NatureConfig;
import com.sist.dao.*;
import com.sist.vo.NatureVO;
/*
 *   스프링에서 관리하는 클래스의 생명주기 (HashMap에 저장) => getBean() : DL
 *     DL => id명(문자열)으로 객체 주소를 찾아 온다 
 *     DI => 메모리 할당시에 필요한 변수의 값을 주입 
 *     ------------------------------------
 *           setXxx("여기에 값을 첨부") 
 *           MainClass("여기에 값을 첨부")
 *     ------------------------------------
 *     예)
 *         class A
 *         {
 *            String name;
 *            public void setName(String name)
 *            {
 *               this.name=name;
 *            }
 *         }
 *         
 *         A a=new A();
 *         a.setName("홍길동"); => a라는 객체를 관리 (스프링:클래스  관리자)
 *         
 *         => 스프링 
 *         <bean id="a" class="A"
 *          p:name="홍길동"
 *         />
 *         
 *      순서 (스프링) : XML읽기 , 자바읽기
 *      1) 모든 클래스 메모리 할당을 한다 
 *      2) setterDI를 수행 
 *      3) init-method 호출 (있는 경우)
 *      ----------------------------
 *        프로그래머가 활용 
 *      ----------------------------
 *      4) destory-method 호출 (메모리에서 해제)
 */
@Component("mc")
public class MainClass {
	@Autowired
    private NatureDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        	new AnnotationConfigApplicationContext(NatureConfig.class);
        MainClass m=(MainClass)app.getBean("mc");
        List<NatureVO> list=m.dao.natureListData();
        for(NatureVO vo:list)
        {
        	System.out.println(vo.getTitle());
        	System.out.println(vo.getAddress());
        	System.out.println(vo.getMsg());
        	System.out.println("=============================");
        }
	}

}
