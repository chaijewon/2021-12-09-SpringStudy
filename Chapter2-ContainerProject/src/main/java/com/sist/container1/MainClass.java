package com.sist.container1;

public class MainClass {
  public static void main(String[] args) {
	   String path="C:\\springDev\\springStudy\\Chapter2-ContainerProject\\src\\main\\java\\com\\sist\\container1\\app.xml";
	   ApplicationContext app=
			   new ApplicationContext(path);
	   Sawon sa=(Sawon)app.getBean("sa");
	   sa.setName("박문수");
	   sa.setDept("영업부");
	   sa.setJob("사원");
	   System.out.println("이름:"+sa.getName());
	   System.out.println("부서:"+sa.getDept());
	   System.out.println("직위:"+sa.getJob());
  }
   
   
}
