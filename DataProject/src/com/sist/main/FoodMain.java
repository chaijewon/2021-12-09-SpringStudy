package com.sist.main;
import java.net.URLEncoder;
import java.util.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.*;
/*
 *  <div class="top_list_slide">
        <ul class="list-toplist-slider" style="width: 531px;">
            <li>
              <img class="center-croping" alt="제천/단양 맛집 베스트 5곳 사진"
                   data-lazy="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/ltkypgxhkzqpxvfh.png?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"/>

              <a href="/top_lists/2893_jecheon_danyang"
                 onclick="trackEvent('CLICK_TOPLIST', {&quot;section_position&quot;:0,&quot;section_title&quot;:&quot;믿고 보는 맛집 리스트&quot;,&quot;position&quot;:0,&quot;link_key&quot;:&quot;TIVMDQO&quot;});">
                <figure class="ls-item">
                  <figcaption class="info">
                    <div class="info_inner_wrap">
                      <span class="title">제천/단양 맛집 베스트 5곳</span>
                      <p class="desc">"제천, 단양 맛집 가보자고"</p>
                      <p class="hash">
                          <span>#제천 </span>
                          <span>#단양 </span>
                          <span>#충청북도 </span>
                          <span>#충북 </span>
                          <span>#제천시 </span>
                          <span>#단양시 </span>
                          <span>#리솜리조트 </span>
                          <span>#리솜포레스트 </span>
                          <span>#리솜 </span>
                          <span>#단양역 </span>
                          <span># </span>
                      </p>
                    </div>
                  </figcaption>
                </figure>
              </a>
            </li>
            <li>
 */
public class FoodMain {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        FoodMain fm=new FoodMain();
        //fm.foodCategoryData();
        //fm.foodHouseData();
        fm.foodLocationData();
	}
	public void foodCategoryData()
	{
		DataDAO dao=new DataDAO();
		System.out.println("foodCatgorydata():dao="+dao);
		try
        {
        	Document doc=Jsoup.connect("https://www.mangoplate.com/").get();
        	Elements title=doc.select("div.top_list_slide span.title");
        	Elements subject=doc.select("div.top_list_slide p.desc");
        	Elements poster=doc.select("div.top_list_slide img.center-croping");
        	Elements link=doc.select("div.top_list_slide ul.list-toplist-slider a");
        	for(int i=0;i<title.size();i++)
        	{
        		System.out.println("번호:"+(i+1));
        		System.out.println(title.get(i).text());
        		System.out.println(subject.get(i).text());
        		System.out.println(poster.get(i).attr("data-lazy"));
        		System.out.println(link.get(i).attr("href"));
        		
        		FoodCategoryVO vo=new FoodCategoryVO();
        		vo.setCno(i+1);
        		vo.setTitle(title.get(i).text());
        		vo.setSubject(subject.get(i).text());
        		vo.setPoster(poster.get(i).attr("data-lazy"));
        		vo.setLink("https://www.mangoplate.com"+link.get(i).attr("href"));
        		
        		//dao.foodCategoryInsert(vo);
        		System.out.println("==================================================");
        	}
        }catch(Exception ex){}
	}
	
	public void foodHouseData()
	{
		try
		   {
			   DataDAO dao=DataDAO.newInstance();
			   List<FoodCategoryVO> list=dao.foodCategoryInfoData();
			   int m=1;
			   for(FoodCategoryVO vo:list)
			   {
				   /*
				   System.out.println("카테고리 번호:"+vo.getCno());
				   System.out.println("제목:"+vo.getTitle());
				   System.out.println("부제목:"+vo.getSubject());
				   System.out.println("이미지:"+vo.getPoster());
				   System.out.println("링크:"+vo.getLink());
				   System.out.println("======================================================");
			      
			      <div class="info">
	                        <div class="wannago_wrap">
	                          <button class="btn-type-icon favorite wannago_btn "
	                                  data-restaurant_uuid="276164"
	                                  data-action_id="">
	                          </button>
	                          <p class="wannago_txt">가고싶다 </p>
	                        </div>
	                        <span class="title ">
			      */
				   Document doc=Jsoup.connect(vo.getLink()).get();
				   Elements link=doc.select("div.info span.title a");
				   for(int i=0;i<link.size();i++)
				   {
					   //System.out.println(link.get(i).attr("href"));
					   Document doc2=
							Jsoup.connect("https://www.mangoplate.com"+link.get(i).attr("href")).get();
					   /*
					    *  <div class="restaurant_title_wrap"> 
					    *  <span class="title"> 
					    *  <h1 class="restaurant_name">부성불고기찜닭</h1> 
					    *  <strong class="rate-point "> 
					    *  <span>4.2</span> </strong>
	                        
	                        figure class="restaurant-photos-item">
	                        img class="center-croping
					    */
					   Element title=doc2.selectFirst("span.title h1.restaurant_name");
				       Element score=doc2.selectFirst("strong.rate-point span");
				       // 포스터 
				       /*
				        *  https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/276164/1862524_1609739956858?fit=around|512:512&amp;crop=512:512;*,*&amp;output-format=jpg&amp;output-quality=80
				        */
				       Elements poster=doc2.select("figure.restaurant-photos-item img.center-croping");
				       String image="";
				       for(int j=0;j<poster.size();j++)
				       {
				    	   image+=poster.get(j).attr("src")+"^"; // , 
				       }
				       image=image.substring(0,image.lastIndexOf("^"));// 마지막 ^를 제거 
				       image=image.replace("&", "#");
				       StringTokenizer st=new StringTokenizer(image,"^");
				       int k=1;
				       
				       while(st.hasMoreTokens())
				       {
				    	   System.out.println(k+"."+st.nextToken());
				    	   k++;
				       }
				       // 한개 => Element , 여러개 => Elements
				       /*
				        *   <table class="info no_menu "> 
	                        <tr class="only-desktop"> 
					      <th>주소</th> 
					      <td>강원도 강릉시 옥가로 50<br/> 
					      <span class="Restaurant__InfoAddress--Rectangle">지번</span> 
					      <span class="Restaurant__InfoAddress--Text">
					         강원도 강릉시 옥천동 219-11</span> 
					      </td> 
					    </tr>     <tr class="only-desktop"> 
					      <th>전화번호</th> 
					      <td>033-641-3601</td> 
	      					</tr>
				        */
				       /*Element address=doc2.select("table.info td").get(0);
				       String addr=address.text();
				       Element tel=doc2.select("table.info td").get(1);
				       String phone=tel.text();
				       Element type=doc2.select("table.info td").get(2);
				       String tp=type.text();
				       
				       String pr="";
				       try
				       {
				          Element price=doc2.select("table.info th").get(3);
				          String s=price.text();
				          if(s.equals("가격대"))
				          {
				        	  Element pp=doc2.select("table.info td").get(3);
				        	  pr=pp.text();
				          }
				       }catch(Exception ex)
				       {
				    	      pr="none";
				       }
				       
				       
				       //Element parking=doc2.selectFirst("");
				       //Element time=doc2.selectFirst("");
				       //Element menu=doc2.selectFirst("");
				        
				        */
				       ////////////////////////////////////////////////////
				       String addr="no",phone="no",tp="no",pr="no",pa="no",ti="no",mu="no";
				       Elements etc=doc2.select("table.info tr th");
				       //System.out.println(etc);
				       for(int a=0;a<etc.size();a++)
				       {
				    	   String ss=etc.get(a).text();
				    	   if(ss.equals("주소"))
				    	   {
				    		   Element e=doc2.select("table.info td").get(a);
				    		   addr=e.text();
				    	   }
				    	   else if(ss.equals("전화번호"))
				    	   {
				    		   Element e=doc2.select("table.info td").get(a);
				    		   phone=e.text();
				    	   }
				    	   else if(ss.equals("음식 종류"))
				    	   {
				    		   Element e=doc2.select("table.info td").get(a);
				    		   tp=e.text();
				    	   }
				    	   else if(ss.equals("가격대"))
				    	   {
				    		   Element e=doc2.select("table.info td").get(a);
				    		   pr=e.text();
				    	   }
				    	   else if(ss.equals("주차"))
				    	   {
				    		   Element e=doc2.select("table.info td").get(a);
				    		   pa=e.text();
				    	   }
				    	   else if(ss.equals("영업시간"))
				    	   {
				    		   Element e=doc2.select("table.info td").get(a);
				    		   ti=e.text();
				    	   }
				    	   else if(ss.equals("메뉴"))
				    	   {
				    		   Element e=doc2.select("table.info td").get(a);
				    		   mu=e.text();
				    	   }
				       }
				       System.out.println("번호:"+m);
				       System.out.println("업체명:"+title.text());
				       System.out.println("점수:"+score.text());
				       System.out.println("주소:"+addr);
				       System.out.println("전화:"+phone);
				       System.out.println("음식종류:"+tp);
				       System.out.println("가격대:"+pr);
				       System.out.println("주차:"+pa);
				       System.out.println("영업시간:"+ti);
				       System.out.println("메뉴:"+mu);
				       System.out.println("===========================");
				       // 데이터베이스 저장 
				       FoodHouseVO fvo=new FoodHouseVO();
				       fvo.setNo(m);
				       fvo.setCno(vo.getCno());
				       fvo.setName(title.text());
				       fvo.setScore(Double.parseDouble(score.text()));
				       fvo.setAddress(addr);
				       fvo.setTel(phone);
				       fvo.setType(tp);
				       fvo.setPrice(pr);
				       fvo.setParking(pa);
				       fvo.setTime(ti);
				       fvo.setMenu(mu);
				       fvo.setPoster(image);
				       // 번호는 자동 증가 
				       // <script id="reviewCountInfo" type="application/json">[{"action_value":1,"count":0},{"action_value":2,"count":3},{"action_value":3,"count":23}]</script>
				       Element review=doc2.selectFirst("script#reviewCountInfo");
				       // class(중복) => . , id(중복이 없다) => # => 태그 구분
				       //System.out.println(review.data()); // script => data()
				       String json=review.data();
				       JSONParser jp=new JSONParser();
				       JSONArray arr=(JSONArray)jp.parse(json);
				       String good="",soso="",bad="";
				       for(int b=0;b<arr.size();b++)
				       {
				    	   JSONObject obj=(JSONObject)arr.get(b);
				    	   if(b==0)
				    	   {
				    		   bad=String.valueOf(obj.get("count"));
				    	   }
				    	   else if(b==1)
				    	   {
				    		   soso=String.valueOf(obj.get("count"));
				    	   }
				    	   else if(b==2)
				    	   {
				    		   good=String.valueOf(obj.get("count"));
				    	   }
				       }
				       System.out.println("GOOD:"+good);
				       System.out.println("SOSO:"+soso);
				       System.out.println("BAD:"+bad);
				       fvo.setGood(Integer.parseInt(good));
				       fvo.setSoso(Integer.parseInt(soso));
				       fvo.setBad(Integer.parseInt(bad));
				       // 데이터베이스에 저장 
				       dao.foodHouseInsert(fvo);
				       m++;
				   }
				   
			   }
		   }catch(Exception ex){ex.printStackTrace();}
	}
	public void foodLocationData()
	{
		DataDAO dao=DataDAO.newInstance();
		try
		{
			String[] gus = { "강서구", "양천구", "구로구", "마포구", "영등포구", "금천구",
				    "은평구", "서대문구", "동작구", "관악구", "종로구", "중구", "용산구", "서초구", "강북구",
				    "성북구", "도봉구", "동대문구", "성동구", "강남구", "노원구", "중랑구", "광진구", "송파구",
				    "강동구" };
            int k=1;
            // https://www.mangoplate.com/search/%EC%A4%91%EA%B5%AC?keyword=%EC%A4%91%EA%B5%AC&page=2
            /*
             *  <ul class="list-restaurants">
                  <li class="list-restaurant server_render_search_result_item">
                      <div class="list-restaurant-item" data-subcusine_code="30">
                        <figure class="restaurant-item">
                          <a class="only-desktop_not" href="/restaurants/NKeKBl9J2p"
             */
            int m=1;
            for(String gu:gus)
            {
            	System.out.println("구:"+gu);
            	
            	for(int i=1;i<=10;i++)
            	{
            		String url="https://www.mangoplate.com/search/"
              			  +URLEncoder.encode(gu, "UTF-8")+"?keyword="
              			  +URLEncoder.encode(gu, "UTF-8")+"&page="+i;
              	    Document doc=Jsoup.connect(url).get();
              	    Elements link=doc.select("figure.restaurant-item a");
              	    for(int j=0;j<link.size();j++)
              	    {
              	    	System.out.println(link.get(j).attr("href"));
              	    	Document doc2=
    							Jsoup.connect("https://www.mangoplate.com"+link.get(j).attr("href")).get();
    					   /*
    					    *  <div class="restaurant_title_wrap"> 
    					    *  <span class="title"> 
    					    *  <h1 class="restaurant_name">부성불고기찜닭</h1> 
    					    *  <strong class="rate-point "> 
    					    *  <span>4.2</span> </strong>
    	                        
    	                        figure class="restaurant-photos-item">
    	                        img class="center-croping
    					    */
    					   Element title=doc2.selectFirst("span.title h1.restaurant_name");
    				       
    					   String sss="";
    					   try
    				       {
	    					    Element score=doc2.selectFirst("strong.rate-point span");
	    					    sss=score.text();
    				       }catch(Exception ex)
    				       {
    				    	   sss="0.0";
    				       }
    				       // 포스터 
    				       /*
    				        *  https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/276164/1862524_1609739956858?fit=around|512:512&amp;crop=512:512;*,*&amp;output-format=jpg&amp;output-quality=80
    				        */
    				       Elements poster=doc2.select("figure.restaurant-photos-item img.center-croping");
    				       String image="";
    				       for(int o=0;o<poster.size();o++)
    				       {
    				    	   image+=poster.get(o).attr("src")+"^"; // , 
    				       }
    				       image=image.substring(0,image.lastIndexOf("^"));// 마지막 ^를 제거 
    				       image=image.replace("&", "#");
    				       StringTokenizer st=new StringTokenizer(image,"^");
    				       int p=1;
    				       
    				       while(st.hasMoreTokens())
    				       {
    				    	   System.out.println(p+"."+st.nextToken());
    				    	   p++;
    				       }
    				       // 한개 => Element , 여러개 => Elements
    				       /*
    				        *   <table class="info no_menu "> 
    	                        <tr class="only-desktop"> 
    					      <th>주소</th> 
    					      <td>강원도 강릉시 옥가로 50<br/> 
    					      <span class="Restaurant__InfoAddress--Rectangle">지번</span> 
    					      <span class="Restaurant__InfoAddress--Text">
    					         강원도 강릉시 옥천동 219-11</span> 
    					      </td> 
    					    </tr>     <tr class="only-desktop"> 
    					      <th>전화번호</th> 
    					      <td>033-641-3601</td> 
    	      					</tr>
    				        */
    				       /*Element address=doc2.select("table.info td").get(0);
    				       String addr=address.text();
    				       Element tel=doc2.select("table.info td").get(1);
    				       String phone=tel.text();
    				       Element type=doc2.select("table.info td").get(2);
    				       String tp=type.text();
    				       
    				       String pr="";
    				       try
    				       {
    				          Element price=doc2.select("table.info th").get(3);
    				          String s=price.text();
    				          if(s.equals("가격대"))
    				          {
    				        	  Element pp=doc2.select("table.info td").get(3);
    				        	  pr=pp.text();
    				          }
    				       }catch(Exception ex)
    				       {
    				    	      pr="none";
    				       }
    				       
    				       
    				       //Element parking=doc2.selectFirst("");
    				       //Element time=doc2.selectFirst("");
    				       //Element menu=doc2.selectFirst("");
    				        
    				        */
    				       ////////////////////////////////////////////////////
    				       String addr="no",phone="no",tp="no",pr="no",pa="no",ti="no",mu="no";
    				       Elements etc=doc2.select("table.info tr th");
    				       //System.out.println(etc);
    				       for(int a=0;a<etc.size();a++)
    				       {
    				    	   String ss=etc.get(a).text();
    				    	   if(ss.equals("주소"))
    				    	   {
    				    		   Element e=doc2.select("table.info td").get(a);
    				    		   addr=e.text();
    				    	   }
    				    	   else if(ss.equals("전화번호"))
    				    	   {
    				    		   Element e=doc2.select("table.info td").get(a);
    				    		   phone=e.text();
    				    	   }
    				    	   else if(ss.equals("음식 종류"))
    				    	   {
    				    		   Element e=doc2.select("table.info td").get(a);
    				    		   tp=e.text();
    				    	   }
    				    	   else if(ss.equals("가격대"))
    				    	   {
    				    		   Element e=doc2.select("table.info td").get(a);
    				    		   pr=e.text();
    				    	   }
    				    	   else if(ss.equals("주차"))
    				    	   {
    				    		   Element e=doc2.select("table.info td").get(a);
    				    		   pa=e.text();
    				    	   }
    				    	   else if(ss.equals("영업시간"))
    				    	   {
    				    		   Element e=doc2.select("table.info td").get(a);
    				    		   ti=e.text();
    				    	   }
    				    	   else if(ss.equals("메뉴"))
    				    	   {
    				    		   Element e=doc2.select("table.info td").get(a);
    				    		   mu=e.text();
    				    	   }
    				       }
    				       System.out.println("번호:"+m);
    				       System.out.println("업체명:"+title.text());
    				       System.out.println("점수:"+sss);
    				       System.out.println("주소:"+addr);
    				       System.out.println("전화:"+phone);
    				       System.out.println("음식종류:"+tp);
    				       System.out.println("가격대:"+pr);
    				       System.out.println("주차:"+pa);
    				       System.out.println("영업시간:"+ti);
    				       System.out.println("메뉴:"+mu);
    				       System.out.println("===========================");
    				       // 데이터베이스 저장 
    				       FoodLocationVO fvo=new FoodLocationVO();
    				       fvo.setNo(m);
    				       
    				       fvo.setName(title.text());
    				       fvo.setScore(Double.parseDouble(sss));
    				       fvo.setAddress(addr);
    				       fvo.setTel(phone);
    				       fvo.setType(tp);
    				       fvo.setPrice(pr);
    				       fvo.setParking(pa);
    				       fvo.setTime(ti);
    				       fvo.setMenu(mu);
    				       fvo.setPoster(image);
    				       // 번호는 자동 증가 
    				       // <script id="reviewCountInfo" type="application/json">[{"action_value":1,"count":0},{"action_value":2,"count":3},{"action_value":3,"count":23}]</script>
    				       Element review=doc2.selectFirst("script#reviewCountInfo");
    				       // class(중복) => . , id(중복이 없다) => # => 태그 구분
    				       //System.out.println(review.data()); // script => data()
    				       String json=review.data();// javasctript
    				       // text() => HTML  attr= HTML html =HTML  
    				       JSONParser jp=new JSONParser();
    				       JSONArray arr=(JSONArray)jp.parse(json);//[{},{},{}]
    				       String good="",soso="",bad="";
    				       for(int b=0;b<arr.size();b++)
    				       {
    				    	   JSONObject obj=(JSONObject)arr.get(b);//{}
    				    	   if(b==0)
    				    	   {
    				    		   bad=String.valueOf(obj.get("count"));
    				    		   //                       키 {"count":10}
    				    	   }
    				    	   else if(b==1)
    				    	   {
    				    		   soso=String.valueOf(obj.get("count"));
    				    	   }
    				    	   else if(b==2)
    				    	   {
    				    		   good=String.valueOf(obj.get("count"));
    				    	   }
    				       }
    				       System.out.println("GOOD:"+good);
    				       System.out.println("SOSO:"+soso);
    				       System.out.println("BAD:"+bad);
    				       fvo.setGood(Integer.parseInt(good));
    				       fvo.setSoso(Integer.parseInt(soso));
    				       fvo.setBad(Integer.parseInt(bad));
    				       // 데이터베이스에 저장 
    				       dao.foodLocationInsert(fvo);
    				       m++;
              	    }
            	}
            	System.out.println("==============================");
            	k++;
            }
		}catch(Exception ex){}
	}

}





