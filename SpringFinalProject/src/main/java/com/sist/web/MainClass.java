package com.sist.web;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          String address="04084 서울 마포구 양화진길 46 (합정동, 양화진홍보관)";
          address=address.replaceAll("[0-9]", "");// 전체 숫자를 공백으로 변환 
	  	  address=address.trim();
	  	  System.out.println("1. address="+address);
	  	  String addr1=address.substring(address.indexOf(" ")+1);
	  	  System.out.println("2. addr1="+addr1);
	  	  String addr2=addr1.trim().substring(0,addr1.indexOf(" "));
	  	  System.out.println("3. addr2="+addr2);
	}

}
