package com.sist.di;
// 스프링 컨테이너에 요청 => 메모리 할당시에 변수값을 채워라 (명령) => DI
//  객체 주소값 채우는 경우가 대부분 
//  1. 일반 변수값 채우기 , 2. 객체 주소값 , 3. List에 값을 채운다 , 4. Map에 값 채우기 
//  Injection (주입) 메모리시에 값을 주입 
//  => 1. setter (set메소드를 이용해서 값을 채운다)
//  => 2. 생성자 매개변수를 이용해서 값을 채워준다
public class Sawon {
    private String name;
    private String dept;
    private String job;
    private int age;
    private int pay;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	  
}
