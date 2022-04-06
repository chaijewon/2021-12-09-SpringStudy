package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *   JSP => 요청 => Model => 전송받은 데이터 출력 => JSP
 *        ------  ------    -----------------------
 *        DispatcherServlet       ViewResolver(InternalResourceViewResolver,TilesView)
 *                HandlerMapping  ---------------------------------
 *                --------------      => 경로명 , 확장자 
 *                1. 클래스 찾기                  => 등록된 리턴형  ==> 
 *                   @Controller
 *                   @RestController 
 *                2. 메소드 찾기
 *                   @RequestMapping
 *                   @Getmapping
 *                   @PostMapping
 *                => 1) 에러 (Autowired,404)
 */
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Controller //화면 변경 , 변경된 JSP에 값을 전송 
// ReplyController를 메모리 할당을 하고 => ReplyDAO의 주소값을 주입 
@RequestMapping("reply/")
public class ReplyController {
   @Autowired // 반드시 스프링에서 메모리 할당후 저장된 객체 주소를 가지고 올때 사용 
   private ReplyDAO dao; //null
   // dao = null => URL주소 , SQL문장 => output 
   
   @GetMapping("list.do")
   public String replyListData(String page,Model model)
   {
	// String s=request.getParameter("page")
	   // 웹에서 나오는 모든 데이터형은 String
	   // Integer.parseInt(null) => 오류
	   // 사용자 보내준 데이터 => 매개변수 (DispatcherServlet)
	   // Model은 전송할 데이터가 있는 경우에만 사용 (전송객체) => request,response사용하지 않는다 
       if(page==null)
    	   page="1";  // 매개변수 => 모든 데이터는 String으로 받을 수 있다 
       // 데이터형 변경 => int,double....
       // 사용자가 첫페이지에서는 보내주지 않는 값이 있다 (page) => null (String)
       int curpage=Integer.parseInt(page);
       Map map=new HashMap();
       // #{start} , #{end} 
       int rowSize=10;
       int start=(rowSize*curpage)-(rowSize-1); //rownum은 1번부터 시작 
       int end=rowSize*curpage; // rownum => 중간에서 데이터를 추출 할 수 없다 (Top-N)
       // MySQL => limit 1,10 , 11,10... limit ?,? 
       map.put("start", start);
       map.put("end", end);
       List<ReplyVO> list=dao.replyListData(map);
      
       int totalpage=dao.replyTotalPage();
       
       int count=dao.replyRowCount();
       count=count-((curpage*rowSize)-rowSize);// 일괄처리 (번호 순서대로 수행)
       // 블록별 처리 
       final int BLOCK=3;
       int startPage=((curpage-1)/BLOCK*BLOCK)+1;
       // curpage => 1,10  ==> startPage=1
       // curpage => 11,20 ==> startPage=11
       int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
       // curpage => 1,10  ==> endPage=10
       // curpage => 11,20 ==> endPage=20
       
       if(endPage>totalpage)
    	   endPage=totalpage; // 마지막 페이지 
       
       // 화면 출력한 데이터 => 모아서 => list.jsp로 전송 
       model.addAttribute("list", list);
       model.addAttribute("curpage", curpage);
       model.addAttribute("totalpage", totalpage);
       model.addAttribute("startPage", startPage);
       model.addAttribute("endPage", endPage);
       model.addAttribute("count", count);
	   return "reply/list";
   }
   @GetMapping("insert.do")
   public String replyInsert()
   {
	   return "reply/insert";
   }
   @PostMapping("insert_ok.do")
   // checkbox => String[]
   // name="file[0]" name="file[1]" => List
   // int ~VO 
   // 글쓰기,수정하기 ,회원가입 => VO
   // 상세보기 => int 
   public String replyInsertOk(ReplyVO vo) // 사용자가 보내준 데이터를 전체 받는 경우 (커맨드객체)
   {
	   dao.replyInsert(vo);
	   return "redirect:list.do";
   }
   @GetMapping("detail.do")
   public String replyDetailData(int no,Model model)
   {
	   ReplyVO vo=dao.replyDetailData(no);
	   int count=dao.replyCount(vo.getGroup_id());
	   model.addAttribute("vo", vo);
	   model.addAttribute("count", count);
	   return "reply/detail";
   }
   @GetMapping("reply.do")
   public String replyReply(int no, Model model)
   {
	   model.addAttribute("no", no);
	   return "reply/reply";
   }
   @PostMapping("reply_ok.do")
   public String replyReplyInsert(int pno,ReplyVO vo)
   {
	   ReplyVO pvo=dao.replyParentInfoData(pno);
	   vo.setGroup_id(pvo.getGroup_id());
	   vo.setGroup_step(pvo.getGroup_step()+1);
	   vo.setGroup_tab(pvo.getGroup_tab()+1);
	   
	   dao.replyReplyInsert(vo);
	   
	   return "redirect:list.do";
   }
   // 요청 => 무슨값을 보낼지 (상세보기 => 번호(Primary key))
   // 검색 => 검색어 
   @GetMapping("update.do")
   /*
    *    public void addAttribute(String key,Object obj)
    *    {
    *        request.setAttribute(key,obj);
    *    }
    */
   public String replyUpdate(int no,Model model)
   {
	   ReplyVO vo=dao.replyUpdateData(no);
	   model.addAttribute("vo", vo);
	   return "reply/update";
   }
   
   @GetMapping("delete.do")
   public String replyDelete(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "reply/delete";
   }
}









