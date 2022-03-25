package com.sist.web;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
// 일반 데이터전송(X) , 파일 변경만 가능 (파일명 , .do)
public class MovieController {
  @GetMapping("movie/movie.do")
  public String movie_movie()
  {
	  // WEB-INF/movie/movie.jsp => 
	  return "movie/movie";
  }
  // @Controller + @Response => @RestController
  @GetMapping(value="movie/movie_vue.do",produces = "text/plain;charset=utf-8")
  @ResponseBody
  public String movie_vue(int no)
  {
	  System.out.println("no="+no);
	  /*
	   *  // https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do
			   //searchMainDailyBoxOffice.do
			   //searchMainRealTicket.do
			   //searchMainDailySeatTicket.do
			   //searchMainOnlineDailyBoxOffice.do
	   */
	  String result="";
	  try
	  {
		  String strUrl="";
		  switch(no)
		  {
		  case 1:
			  strUrl="searchMainDailyBoxOffice.do";
			  break;
		  case 2:
			  strUrl="searchMainRealTicket.do";
			  break;
		  case 3:
			  strUrl="searchMainDailySeatTicket.do";
			  break;
		  case 4:
			  strUrl="searchMainOnlineDailyBoxOffice.do";
			  break;
		  }
		  // Document doc=Jsoup.connect().get()
		  // <html><body>[]</body></html>
		  URL url=new URL("https://www.kobis.or.kr/kobis/business/main/"+strUrl);
		  HttpURLConnection conn=
				  (HttpURLConnection)url.openConnection();
		  if(conn!=null)
		  {
			  BufferedReader in=
					 new BufferedReader(
							 new InputStreamReader(conn.getInputStream()));
			  StringBuffer sb=new StringBuffer();
			  while(true)
			  {
				  String data=in.readLine();
				  System.out.println(data);
				  if(data==null) break;
				  sb.append(data);
			  }
			  in.close();
			  result=sb.toString();
		  }
		  System.out.println(result);
	  }catch(Exception ex){}
	  return result;
  }
  
}




