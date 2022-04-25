package com.sist.web;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.*;
import com.sist.vo.*;
/*
 *   => Back-End
 *   
 *   자바 
 *   오라클 
 *   JSP
 *   스프링 
 *   
 *   => Front-End
 *      JavaScript , Ajax , Jquery , NodeJS , ReactJS, VueJS
 *                                            (Redux)  (vuex)
 *                                            
 *   => Back-End + Front-End (FullStack)
 *   
 *   => 퍼블리셔
 *      HTML , CSS (학원 추천은 없다 => 잡포털사이트에서 선택) => 아트학원 
 */
@Controller
public class SeoulController {
    private SeoulDAO dao;
    // XML을 이용해서 주입시에 => 반드시 setXxx가 필요하다 
	public void setDao(SeoulDAO dao) 
	{ 
		this.dao = dao; 
	}
	// 4.3 => @RequestMapping => 분리 (@GetMapping,@PostMapping)
	@GetMapping("hotel/list.do") //사용요청을 처리하는 메소드를 찾을 때 사용 
	// 인덱스 (찾기) => if을 추가하는 내용 
	/*
	 *   Model(요청하는 부분) => 메소드의 리턴형
	 *     = void => 다운로드
	 *     = String => 화면 변경 (forward,redirect)
	 *       데이터를 전송 : forward 
	 *       ========= 전송 객체 이용 : Model 
	 *       화면만 이동 (재전송) : redirect 
	 *       ========= 전송 객체 이용 : RedirectAttributes
	 *     = 사용자가 보내준 데이터 받기 
	 *       1. 일반 데이터형 (int , String , double) => 데이터형이 틀릴 경우 (400)
	 *       2. VO단위로 받기 (insert,update)
	 *       3. List 
	 *       4. 배열 : checkbox 
	 *     = 라이브러리 받기 
	 *       1. Model : 전송 객체 
	 *       2. HttpSession 
	 *       3. HttpServletResponse : Cookie전송 
	 *       4. HttpServletRequest : Cookie생성 
	 *       5. RedirectAttributes
	 */
	public String hotel_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashedMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end =rowSize*curpage;
		map.put("start", start);
		map.put("end",end);
		List<HotelVO> list=dao.hotelListData(map);
		int totalpage=dao.hotelTotalPage();
		
		// JSP에서 필요한 데이터를 전송 
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		return "hotel/list";
	}
	// aws => 호스팅 => IP => 저장 (운영체제 한개를 빌린다 => tomcat (java))
	@GetMapping("hotel/detail")
	public String hotel_detail(int no, Model model)
	{
		HotelVO vo=dao.hotelDetailData(no);
		model.addAttribute("vo", vo);
		return "hotel/detail";
	}

}









