package com.sist.spring1;
// �������̸� new�� ������� �ʴ´� 
// new�� ����ϸ� �������� ���� ���α׷����� ���� => ���������� ��ƴ� (������=���������� ���� ���α׷�)
// �ε� ���� => opensource�׷� 
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Hello hello=new Hello();
        String msg=hello.sayHello("ȫ�浿");
        System.out.println(msg);
	}

}
