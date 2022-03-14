package com.sist.di;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.NatureConfig;
import com.sist.dao.*;
import com.sist.vo.NatureVO;
/*
 *   ���������� �����ϴ� Ŭ������ �����ֱ� (HashMap�� ����) => getBean() : DL
 *     DL => id��(���ڿ�)���� ��ü �ּҸ� ã�� �´� 
 *     DI => �޸� �Ҵ�ÿ� �ʿ��� ������ ���� ���� 
 *     ------------------------------------
 *           setXxx("���⿡ ���� ÷��") 
 *           MainClass("���⿡ ���� ÷��")
 *     ------------------------------------
 *     ��)
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
 *         a.setName("ȫ�浿"); => a��� ��ü�� ���� (������:Ŭ����  ������)
 *         
 *         => ������ 
 *         <bean id="a" class="A"
 *          p:name="ȫ�浿"
 *         />
 *         
 *      ���� (������) : XML�б� , �ڹ��б�
 *      1) ��� Ŭ���� �޸� �Ҵ��� �Ѵ� 
 *      2) setterDI�� ���� 
 *      3) init-method ȣ�� (�ִ� ���)
 *      ----------------------------
 *        ���α׷��Ӱ� Ȱ�� 
 *      ----------------------------
 *      4) destory-method ȣ�� (�޸𸮿��� ����)
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
