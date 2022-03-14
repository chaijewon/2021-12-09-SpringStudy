package com.sist.di;

import org.springframework.stereotype.Component;

@Component("mi1")
//<bean id="mi1" class="MemberImpl1">
public class MemberImpl1 implements Member{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("MemberImpl1:display() Call...");
	}

}
