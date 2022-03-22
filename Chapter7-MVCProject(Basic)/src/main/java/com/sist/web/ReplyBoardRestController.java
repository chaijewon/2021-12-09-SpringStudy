package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class ReplyBoardRestController {
   // 필요한 객체를 스프링에서 얻어 온다 DAO
   // ReplyBoardController => ReplyBoardDAO dao 
   @Autowired
   private ReplyBoardDAO dao; // 동일 (싱글턴 사용)
   
   // 사용자 요청 구분 
   @PostMapping("board/update_ok.do")
   public String board_update_ok(ReplyBoardVO vo)
   {
	   // 스크립트 전송할 수 있는 Controller , JSON 
	   String script="";
	   boolean bCheck=dao.replyBoardUpdate(vo);
	   if(bCheck==true)
	   {
		   script="<script>"
				 +"location.href=\"detail.do?no="+vo.getNo()+"\";"
				 +"</script>";
	   }
	   else
	   {
		   script="<script>"
				 +"alert(\"Password Fail!!\");"
				 +"history.back();"
				 +"</script>";
		   // 주의점 => Ajax  => 크롬에서만 실행 , IE=>문자열로 출력
	   }
	   return script;
   }
}










