package com.sist.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

// 일반 클래스 => id가 없는 경우에는 자동으로 ID배정 => mainClass 
/*
 *    상속 
 *    class A
 *    {
 *    }
 *    class B extends A  ==> A,B
 *    {
 *    }
 *    
 *    B b=new B();
 *    A a=new B();
 *    
 *    class C extends A  ==> A,C
 *    {
 *    }
 *    
 *    C c=new C();
 *    A a=new C(); 
 *    
 *    인터페이스 (클래스의 일종) => 다중 상속 
 *    interface I
 *    class A implements I
 *      A a=new A()
 *      I i=new A() ==> A , I
 *    class B implements I
 *      B b=new B();
 *      I i=new B(); ==> I , B
 *    
 *    
 *    ==> XML <bean> => getBean()
 *    ==> XML을 이용하지 않고 어노테이션으로 처리 
 *    ==> XML + Annotation
 *        ----------------- 일반적으로 사용 
 *        XML은 공통으로 사용되는 (라이브러리) => MyBatis , ViewResolver
 *                                       MultipartResolver
 *        사용자 정의 => Annotation 
 *        MyBatis ==> XML , Annotation
 *        
 */
@Component
public class MainClass {
	// DI ==> 객체 주소를 얻어서 사용  
	@Autowired // 스프링에서 자동을 찾아서 주입 
    private Sawon sa;
	@Autowired// 자동 주입 => 같은 객체가 여러개 있는 경우 처리가 안된다 
	          //           ------- 상속 , 인터페이스 상속 
	          // 상속 : 자신 , 상위 (데이터형이 두개 생긴다)
	           
	@Qualifier("mi2") // 같은 유형의 클래스는 특정 객체를 지정 
	private Member m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        MainClass mc=(MainClass)app.getBean("mainClass");
        System.out.println("이름:"+mc.sa.getName());
        System.out.println("부서:"+mc.sa.getDept());
        System.out.println("직위:"+mc.sa.getJob());
        
        mc.m.display();
	}

}
