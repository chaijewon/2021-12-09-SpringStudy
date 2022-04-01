package com.sist.aop;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		   {
			   Document doc=Jsoup.connect("https://weather.naver.com/").get();
			   Element weather=doc.select("tr.now td.info").get(0);
			   Element poster=doc.select("tr.now td.ico img").get(0);
			   Element temp=doc.select("tr.now td.info span.temp").get(0);
			   Element temp2=doc.select("tr.now td.info span.temp2").get(0);
			   System.out.println(weather.text().substring(0,weather.text().lastIndexOf("기")));
			   System.out.println(poster.attr("src"));
			   System.out.println(temp.text());
			   System.out.println(temp2.text());
			   System.out.println(weather.text().substring(0,weather.text().lastIndexOf("기")));
			   System.out.println(poster.attr("src"));
			   System.out.println(temp.text());
			   System.out.println(temp2.text());
		   }catch(Exception ex){ex.printStackTrace();}
	}

}
