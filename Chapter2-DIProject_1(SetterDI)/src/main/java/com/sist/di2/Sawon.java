package com.sist.di2;

public class Sawon {
    private String name;
    public Sawon(String name)
    {
	   this.name=name;
	   System.out.println("�����ڸ� ���� ���� �Է�..");//1
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("setName()�� ���� ���� �Է�..");//2
	}
	public void init()
	{
		System.out.println("Sawon ��ü ���� �Ϸ�!!");//3
	}
	public void destory()
	{
		System.out.println("Sawon ��ü �޸� ����!!");//4
	}
  
}
