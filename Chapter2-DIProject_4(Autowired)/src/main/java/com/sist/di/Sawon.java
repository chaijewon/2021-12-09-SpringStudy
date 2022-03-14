package com.sist.di;

import org.springframework.stereotype.Component;

@Component
public class Sawon {
    private String name="홍길동";
    private String dept="개발부";
    private String job="대리";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public void init()
	{
		System.out.println("===== 사원 정보 =====");
	}
	public void destory()
	{
		System.out.println("===== 사원 객체 해제 =====");
	}
	   
}
