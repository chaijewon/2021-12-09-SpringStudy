package com.sist.spring1;
// 가급적이면 new를 사용하지 않는다 
// new를 사용하면 의존성이 높은 프로그램으로 변경 => 유지보수가 어렵다 (스프링=유지보수가 편한 프로그램)
// 로드 존슨 => opensource그룹 
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Hello hello=new Hello();
        String msg=hello.sayHello("홍길동");
        System.out.println(msg);
	}

}
