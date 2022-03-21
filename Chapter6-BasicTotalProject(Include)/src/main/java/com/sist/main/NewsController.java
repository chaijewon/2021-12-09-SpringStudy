package com.sist.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.NewsVO;

@RestController
public class NewsController {
   @GetMapping(value="etc/news/news_data.do",produces = "text/plain;charset=utf-8")
   public String news_data(String fd)
   {
	   System.out.println("전송 받음:"+fd);
	   String result="";
	   try
	   {
		   String[] title= {
				  "아트토큰, 환기미술관과 함께 하이퍼큐브 NFT프로젝트 발표",
				  "[조기숙이 만난 예술가] 멀티퍼포밍 아티스트 이영란",
				  "'쪼개기 후원' 이영옥 전 포항시의원, 2심도 벌금형",
				  "동국대 듀이카, 2023학년도 신입생 모집 위한 입학상담 진행",
				  "[SR문화] '파친코', 윤여정 \"재일교포의 세월 다 표현해야...큰일 났다"
				 
		   };
		   String[] desc= {
				   "이 프로젝트는 김환기 화백의 작품에 멀티미디어 VFX기술을 적용하여 새생명을 불어넣는 작업으로 아트토큰은 이를 위해 영화 반지의 제왕, 아바타, 어벤져스, 알",
				   "춤, 연극, 영화, TV, 대학교수 등 만능 공연예술가 이영란을 대학로 한 식당에서 만났다. 아직도 젊음과... 또 영화배우, TV의 MC와 리포터까지 굉장히 잡다하게 했어요. 그래서 저를 멀티 예능인으로 생각해요.\" -무용과...",
				   "대구지법 제4형사항소부(부장판사 이영화)는 18일 정치자금법 위반 혐의로 기소된 이영욱 전 포항시의원 항소심에서 벌금 1200만원을 선고했다. 재판부는 \"원심이 이 전 시의원의 범죄 혐의에 대해 분리 선고하지 않은...",
				   "공무원행정), 영화학 전공(영화영상제작, 연기), 건강관리학 전공(스포츠재활, 스포츠건강관리)을 운영 중이고, 주말학사과정으로 컴퓨터공학 전공, 경영학 전공, 심리학 전공, 행정학 전공, 스포츠재활학 전공이 있다....",
				   "영화적인 화면이 진짜 좋았다\"고 말했다. \"젊은 선자 역 배우가 신인이라 걱정을 많이 했는데 너무 잘했다\"며... ⓒ애플 TV+ 윤여정은 이 작품의 관전 포인트에 대해 \"난 영화평론가가 아니라 그런 질문에는 대답할줄 모른다...\r\n"
		   };
		   String[] author= {
				      "보건뉴스",
					  "조이뉴스24",
					  "뉴시스",
					  "공무원수험신문",
					  "SR타임스"
		   };
		   JSONArray arr=new JSONArray();
		   for(int i=0;i<5;i++)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("title", title[i]);
			   obj.put("description", desc[i]);
			   obj.put("author", author[i]);
			   arr.add(obj);
		   }
		   System.out.println("arr="+arr);
		   result=arr.toJSONString();
	   }catch(Exception ex){}
	   return result;
   }
}
