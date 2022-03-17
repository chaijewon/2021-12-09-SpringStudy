package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.*;
import com.sist.vo.DataBoardVO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
@Controller //Model => 반드시 설정 (HandlerMapping => @Controller가 있는 곳에서 
//@GetMapping , @RequestMapping , @PostMapping 
//@Controller가 없는 상테에서는 스킵
//사용자 요청 처리 => 결과값 전송 => 화면 이동 
//----------- 요청값 (매개변수 이용) , 결과값을 전송 (Model 전송객체 이용) 
//화면 이동 => forward , sendRedirect() => 재전송 
// forward => return "경로/JSP명" sendRedirect => return "redirect:~.do"
@RequestMapping("databoard/") //공통으로 사용되는 경로명을 제거할 목적 
public class DataBoardController {
  // 1. DAO가 필요하다 
  @Autowired
  private DataBoardDAO dao;
  // 2. 기능별 처리 
  @GetMapping("list.do") // databoard/list.do
  public String databoard_list(String page,Model model)
  {
	  // String page,Model model => DispatcherServlet에서 채워준다 
	  // 1. request,response는 사용하지 않는다 
	  // 2. 결과값을 JSP로 전송 => 전송 클래스 (Model)
	  /*
	   *   1. 메소드 : 리턴형 : String : forward처리할 JSP
	   *                             sendRedirect를 이용한 재전송 
	   *                    void : 다운로드 , JavaScript
	   *             매개변수 : 1) 일반 데이터 (String , int , double)
	   *                     2) 커맨드객체 : VO단위 
	   *                     3) 배열 (체크박스) , List형으로 받을 수 있다 
	   */
	  // 사용자가 첫페이지에서는 페이지를 보낼 수가 없다 => 디폴트 제작 
	  if(page==null)
		  page="1";
	  // 1. 현재 페이지 지정 
	  int curpage=Integer.parseInt(page);
	  // 2. 현재 페이지에 대한 데이터 읽기 
	  Map map=new HashMap();
	  // WHERE num BETWEEN #{start} AND #{end} =>Map으로 전송시에는 키명
	  // map.get("start") map.get("end")
	  int rowSize=10;
	  int start=(rowSize*curpage)-(rowSize-1); //rownum은 1번부터 
	  // 1~10(1), 11~20(2) , 21~30(3)
	  int end=rowSize*curpage;
	  
	  map.put("start", start);
	  map.put("end", end);
	  
	  List<DataBoardVO> list=dao.databoardListData(map);
	  // 3. 총페이지 
	  int totalpage=dao.databoardTotalPage();
	  
	  // 4. JSP에서 출력할 데이터 전송 
	  model.addAttribute("list", list);
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  // 오늘 날짜 전송 => new
	  String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	  model.addAttribute("today", today);
	  // 5. model에 등록된 데이터를 출력하는 JSP를 지정 
	  return "databoard/list";// 확장자를 사용하면 안된다 
	  // ModelAndView => ViewResolver가 받아서 JSP를 찾은 다음에 request로 변환해서 전송
  }
  
  // 2. 글쓰기 폼 
  @GetMapping("insert.do")
  public String databoard_insert()
  {
	  return "databoard/insert";
  }
  // 3. 실제 오라클에 저장 
  @PostMapping("insert_ok.do")
  // insert완료 => list.jsp => 재전송
  public String databoard_insert_ok(DataBoardVO vo)
  {
	  List<MultipartFile> list=vo.getFiles();
	  if(list==null) // 업로드가 안된 상태
	  {
		  vo.setFilename("");
		  vo.setFilesize("");
		  vo.setFilecount(0);
	  }
	  else // 업로드가 된 상태 
	  {
		  String tempName="";
		  String tempSize="";
		  
		  for(MultipartFile mf:list)
		  {
			  String fn=mf.getOriginalFilename(); // 사용자 보낸 파일명 읽기
			  File file=new File("c:\\upload\\"+fn);
			  try
			  {
			     mf.transferTo(file);// 실제 업로드 
			  }catch(Exception ex){}
			  tempName+=fn+",";
			  tempSize=file.length()+",";
		  }
		  tempName=tempName.substring(0,tempName.lastIndexOf(","));
		  tempSize=tempSize.substring(0,tempSize.lastIndexOf(","));
		  vo.setFilename(tempName);
		  vo.setFilesize(tempSize);
		  vo.setFilecount(list.size());// 다운로드 여부 
	  }
	  dao.databoardInsert(vo);
	  // insert 처리 => list.jsp이동 (첨부된 데이터를 볼 수 있다)
	  return "redirect:list.do";
  }
  @GetMapping("detail.do")
                               //사용자가 요청한 값
  public String databoard_detail(int no,Model model)
  {
	  // 오라클로부터 데이터 읽기 => DAO연결 
	  DataBoardVO vo=dao.databoardDetailData(no);// 요청처리 (DAO연동)
	  model.addAttribute("vo", vo);//요청 결과값을 보낸다 
	  return "databoard/detail"; // 결과값 화면을 보여준다 
  }
  /*
   *   1. 매개변수 => 사용자가 요청한 값을 받는다 (request.getParameter():스프링에서 처리)
   *   2. DAO연결,Web크롤링,XML파싱,JSON... 요청처리 
   *   3. 요청 처리 결과값을 JSP로 전송 : model
   *   4. 어떤 JSP를 보여줄것인지 설정 (return) => 새로운 JSP(jsp명) , 기존의 JSP(redirect)
   *   
   */
}












