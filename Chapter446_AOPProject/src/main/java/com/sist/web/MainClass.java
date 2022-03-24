package com.sist.web;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyDAO dao=new MyDAO(); // 스프링 => Container(메모리 할당 =필요시마다 주소를 얻어서 사용)
        System.out.println("=== select() call ===");
        dao.select();
        System.out.println("=== insert() call ===");
        dao.insert();
        System.out.println("=== update() call ===");
        dao.update();
        System.out.println("=== delete() call ===");
        dao.delete();
        System.out.println("=== find() call ===");
        dao.find();
        
	}

}
