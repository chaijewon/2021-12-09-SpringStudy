package com.sist.di;

import org.springframework.stereotype.Component;

@Component
public class Sawon {
    private String name="ȫ�浿";
    private String dept="���ߺ�";
    private String job="�븮";
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
		System.out.println("===== ��� ���� =====");
	}
	public void destory()
	{
		System.out.println("===== ��� ��ü ���� =====");
	}
	   
}
