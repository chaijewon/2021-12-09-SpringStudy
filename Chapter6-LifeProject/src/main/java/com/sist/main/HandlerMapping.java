package com.sist.main;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.Method;
import java.util.*;
/*
 *   <?xml version="1.0" encoding="UTF-8"> => startDocument()
 *   <beans> => startElement()
 *     <bean id="" class="" />
 *     startElement()      endElement()
 *     
 *   </beans> => endElement()
 *   endDocument()
 */
public class HandlerMapping extends DefaultHandler{
    private Map clsMap=new HashMap();
    private Class clsName;
    private Object obj;
	public Map getClsMap() {
		return clsMap;
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try
		{
			if(qName.equals("bean"))
			{
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				String name=attributes.getValue("p:name");
				String sex=attributes.getValue("p:sex");
				// 메모리 할당 
				clsName=Class.forName(cls);
				obj=clsName.getDeclaredConstructor().newInstance();
				String type1=attributes.getQName(2);
				String type2=attributes.getQName(3);
				System.out.println("id:"+id);
				System.out.println("class:"+cls);
				System.out.println("obj:"+obj);
				System.out.println("type1:"+type1);
				System.out.println("type2:"+type2);
				System.out.println("=======XML 출력 완료=========");
				String s1=type1.substring(type1.indexOf(":")+1);
				String s2=type2.substring(type2.indexOf(":")+1);
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m:methods)
				{
					if(m.getName().equalsIgnoreCase("set"+s1))
					{
						m.invoke(obj, name);
					}
					if(m.getName().equalsIgnoreCase("set"+s2))
					{
						m.invoke(obj, sex);
					}
				}
				clsMap.put(id, obj);
			}
		}catch(Exception ex){}
	}
    
}





