package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
// DAO => Connection , 한개 생성후 여러 클래스에서 사용이 가능 
// 메모리 누수 현상 방지 (싱글턴) =>가비지컬렉션이 회수하는 시간이 많이 걸린다 
// 스프링은 객체 생성시 싱글턴이 기본으로 설정되어 있다 
// 디자인 (GOF 23) => 싱글턴.팩토리 => SqlSessionFactoryBean , MapperFactoryBean
@RestController // @ResponseBody => 승격 (메소드형 => 클래스형)
// Spring-Boot 
public class BoardRestController {
   @Autowired
   private BoardDAO dao; // BoardController에 있는 dao는 같은 주소를 가지고 있다 
   // => 싱글턴 
   @PostMapping("freeboard/update_ok.do")
   public String freeboard_update_ok(BoardVO vo)
   {
	   String result="";
	   boolean bCheck=dao.boardUpdate(vo);
	   if(bCheck==true)
	   {
		   //location.href=""
		   result="<script>location.href=\"../freeboard/detail.do?no="+vo.getNo()+"\";</script>";
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
   
   @PostMapping("freeboard/delete_ok.do")
   public String freeboard_delete_ok(int no,String pwd)
   {
	   String result="";
	   boolean bCheck=dao.boardDelete(no,pwd);
	   if(bCheck==true)
	   {
		   //location.href=""
		   result="<script>location.href=\"../freeboard/list.do\";</script>";
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
}










