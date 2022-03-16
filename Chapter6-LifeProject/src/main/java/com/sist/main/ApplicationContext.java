package com.sist.main;

import java.io.File;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ApplicationContext {
  private Map map=new HashMap();
  public static void main(String[] args) {
	ApplicationContext app=
			new ApplicationContext("C:\\springDev\\springStudy\\Chapter6-LifeProject\\src\\main\\java\\com\\sist\\main\\app.xml");
    Sawon sa=(Sawon)app.getBean("sa");
    System.out.println(sa.getName());
    System.out.println(sa.getSex());
  }
  public ApplicationContext(String path)
  {
	  try
	  {
		  SAXParserFactory spf=SAXParserFactory.newDefaultInstance();
		  SAXParser sp=spf.newSAXParser();
		  HandlerMapping hm=new HandlerMapping();
		  sp.parse(new File(path), hm);
		  map=hm.getClsMap();
	  }catch(Exception ex){}
  }
  public Object getBean(String id)
  {
	  return map.get(id);
  }
}
