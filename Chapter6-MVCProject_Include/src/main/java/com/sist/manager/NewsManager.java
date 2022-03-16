package com.sist.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.vo.*;
import java.io.*;
import java.net.*;
@Component
/*
 *  https://search.naver.com/search.naver?where=news&query=%EC%98%81%ED%99%94&sm=tab_opt&sort=1&photo=0&field=0&pd=0&ds=&de=&docid=&related=0&mynews=0&office_type=0&office_section_code=0&news_office_checked=&nso=so%3Add%2Cp%3Aall&is_sug_officeid=0
 */
public class NewsManager {
   public static void main(String[] args) {
	   NewsManager n=new NewsManager();
	   n.newsFindData("영화"); //50개 
   }
   public List<NewsVO> newsFindData(String ss)
   {
	   List<NewsVO> list=new ArrayList<NewsVO>();
	   try
	   {
		   String strUrl="http://newssearch.naver.com/search.naver?where=rss&query="
				         +URLEncoder.encode(ss, "UTF-8");
		   URL url=new URL(strUrl);
		   StringBuffer sb=new StringBuffer();
		   HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		   if(conn!=null) //web에 연결되었다면 
		   {
			   BufferedReader br=
					   new BufferedReader(
							   new InputStreamReader(
									   conn.getInputStream(),"UTF-8"));
			   while(true)
			   {
				   String s=br.readLine();
				   if(s==null) break;
				   sb.append(s);
			   }
		   }
		   //System.out.println(sb.toString());
		   // API => Naver News 
		   Document doc=Jsoup.parse(sb.toString()); // Jsoup(HTML/XML)
		   Elements title=doc.select("rss channel item title");
		   Elements desc=doc.select("rss channel item description");
		   Elements author=doc.select("rss channel item author");
		   for(int i=0;i<title.size();i++)
		   {
			   NewsVO vo=new NewsVO();
			   vo.setTitle(title.get(i).text());
			   vo.setDescription(desc.get(i).text());
			   vo.setAuthor(author.get(i).text());
			   list.add(vo);
		   }
	   }catch(Exception ex){}
	   return list;
   }
}










