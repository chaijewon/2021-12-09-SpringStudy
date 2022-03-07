package com.sist.container;
// 스프링은 등록된 클래스를 관리해주는 역할 
// 스프링 => 컨테이너 (클래스 관리 영역)
// 클래스 = 컴포넌트 (한개이상의 기능을 가지고 있는 클래스)
public class Sawon {
    private String name;
    private String dept;
    private String job;
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
   
}
