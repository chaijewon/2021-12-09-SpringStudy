package com.sist.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

// �Ϲ� Ŭ���� => id�� ���� ��쿡�� �ڵ����� ID���� => mainClass 
/*
 *    ��� 
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
 *    �������̽� (Ŭ������ ����) => ���� ��� 
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
 *    ==> XML�� �̿����� �ʰ� ������̼����� ó�� 
 *    ==> XML + Annotation
 *        ----------------- �Ϲ������� ��� 
 *        XML�� �������� ���Ǵ� (���̺귯��) => MyBatis , ViewResolver
 *                                       MultipartResolver
 *        ����� ���� => Annotation 
 *        MyBatis ==> XML , Annotation
 *        
 */
@Component
public class MainClass {
	// DI ==> ��ü �ּҸ� �� ���  
	@Autowired // ���������� �ڵ��� ã�Ƽ� ���� 
    private Sawon sa;
	@Autowired// �ڵ� ���� => ���� ��ü�� ������ �ִ� ��� ó���� �ȵȴ� 
	          //           ------- ��� , �������̽� ��� 
	          // ��� : �ڽ� , ���� (���������� �ΰ� �����)
	           
	@Qualifier("mi2") // ���� ������ Ŭ������ Ư�� ��ü�� ���� 
	private Member m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        MainClass mc=(MainClass)app.getBean("mainClass");
        System.out.println("�̸�:"+mc.sa.getName());
        System.out.println("�μ�:"+mc.sa.getDept());
        System.out.println("����:"+mc.sa.getJob());
        
        mc.m.display();
	}

}
