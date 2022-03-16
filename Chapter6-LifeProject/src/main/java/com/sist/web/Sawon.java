package com.sist.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
// 생명주기 (XMl을 읽거나 ,Java설정 파일을 읽었을때 스프링이 동작하는 과정 (객체 생명주기)
public class Sawon implements InitializingBean,
DisposableBean,BeanNameAware,BeanFactoryAware{
    private String name;
    private String sex;
    
    public Sawon()
    {
    	System.out.println("Sawon() Call..:객체 생성후 Map에 저장");
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("setName() Call...:name변수에 값을 첨부...");
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
		System.out.println("setSex() Call...:sex변수에 값을 첨부...");
	}
	
	public void init()
	{
		System.out.println("init() Call...:객체가 생성된 다음 바로 자동 호출");
	}
	public void destroy()
	{
		System.out.println("destroy() Call...:객체 소멸시 호출되는 메소드");
	}
	
	public void print()
	{
		System.out.println("프로그래머가 호출...");
		System.out.println("=== 사원 정보 ===");
		System.out.println("이름:"+name);
		System.out.println("성별:"+sex);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("생성된 객체 저장하는 단계...");
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("객체 ID읽기...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("setter를 이용한 값 주입 완료...");
	}
  
}
