package com.sist.di2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 *   컨테이너 : 객체생성 = 변수 초기화 = 객체 소멸 (객체의 생명주기) 관리 
 *           1) 객체 생성 : <bean id="" class="">
 *           2) 변수 초기화 : 생성자 
 *                       <bean id="" class=""
 *                        c:변수명="값" (c:_0="값")
 *                        setter에 값을 주입 
 *                       <bean id="" class=""
 *                        p:변수명="값">
 *           3) 메소드 자동 호출 : 
 *                init-method=""  ======> 객체 생성시 호출 
 *                destroy-method="" =====> 객체 소멸시에 호출 
 *         -------------------------------------------------
 *           DI (의존성 주입)
 *              = setter DI
 *              = constructor DI
 *              = method DI
 *         --------------------------------------------------
 *          DI를 사용할때는 객체 주소값 대입 , 오라클 정보 전송
 *          라이브러리에 값을 채운다 ....
 *          50page ~ 54page
 *          
 *          
 *          ==> 스프링 => 어떤 클래스를 저장해서 사용할 지 (VO외에 나머지 모든 클래스 등록)
 *          ==>         변수의 초기값 설정 
 *                      클래스와 클래스의 관계 설정 
 *          ---------------------- 클래스를 동작하기 위한 메뉴얼 제작 ------------
 *          XML(4버전) , 자바(5버전) 
 *          
 *          ==> 객체 주입 , 라이브러리 클래스에 값 주입 
 *              ----------------------------- MyBatis사용
 *              => 자동 주입 (@Autowired)
 *              => 클래스 한개씩 등록 <bean>
 *                 패키지 단위로 등록 ( <component-scan> ) 
 *                        
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app2.xml");
        Sawon sa=(Sawon)app.getBean("sa");
        
		GenericXmlApplicationContext app1=
				new GenericXmlApplicationContext("app2.xml");
		Sawon sa1=(Sawon)app1.getBean("sa");
		app1.close();
	}

}
