package com.sist.di;
// ������ �����̳ʿ� ��û => �޸� �Ҵ�ÿ� �������� ä���� (���) => DI
//  ��ü �ּҰ� ä��� ��찡 ��κ� 
//  1. �Ϲ� ������ ä��� , 2. ��ü �ּҰ� , 3. List�� ���� ä��� , 4. Map�� �� ä��� 
//  Injection (����) �޸𸮽ÿ� ���� ���� 
//  => 1. setter (set�޼ҵ带 �̿��ؼ� ���� ä���)
//  => 2. ������ �Ű������� �̿��ؼ� ���� ä���ش�
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
