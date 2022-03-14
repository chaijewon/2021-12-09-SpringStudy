package com.sist.di;

import org.springframework.stereotype.Component;

@Component("mi2")
// <bean id="mi2" class="MemberImpl2">
public class MemberImpl2 implements Member{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("MemberImpl2:display() Call...");
	}

}
