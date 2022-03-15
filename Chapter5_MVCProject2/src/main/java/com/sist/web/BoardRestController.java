package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
@RestController

// 화면 이동 요청 => 일반 데이터 (자바스크립트) => VueJS
public class BoardRestController {
   @Autowired
   // 스프링에 요청 => dao객체주소를 대입 => 객체 비교 (instanceof)
   private BoardDAO dao;
   
   @PostMapping("board/update_ok.do") // jsp한개를 생략
   public String board_upadte_ok(BoardVO vo)
   {
	   String result="";
	   boolean bCheck=dao.boardUpdate(vo);
	   if(bCheck==true)
	   {
		   result="<script>"
				 +"location.href=\"detail.do?no="+vo.getNo()+"\""
				 +"</script>";
	   }
	   else
	   {
		   result="<script>"
				 +"alert(\"Password Fail!!\");"
				 +"history.back();"
				 +"</script>";
	   }
	   return result;
   }
   
   @PostMapping("board/delete_ok.do")
   public String board_delete_ok(int no,String pwd)
   {
	   String result="";
	   boolean bCheck=dao.boardDelete(no, pwd);
	   if(bCheck==true)
	   {
		   result="1";
	   }
	   else
	   {
		   result="0";
	   }
	   return result;
   }
   
   
}
