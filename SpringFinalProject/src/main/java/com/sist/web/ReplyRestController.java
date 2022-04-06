package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController //화면변경(X) , 출력에 필요한 데이터 , 자바스크립트 전송 
public class ReplyRestController {
    @Autowired
	private ReplyDAO dao;
    
    @PostMapping("reply/update_ok.do")
    public String replyUpdateOk(ReplyVO vo)
    {
    	String result="";
    	boolean bCheck=dao.replyUpdate(vo);
    	if(bCheck==true)
    	{
    		result="<script>location.href=\"../reply/detail.do?no="+vo.getNo()+"\";</script>";
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
    @PostMapping("reply/delete_ok.do")
    public String replyDeleteOk(int no,String pwd)
    {
    	String result="";
    	ReplyVO vo=dao.replyDetailData(no);
    	boolean bCheck=false;
    	if(vo.getGroup_step()==0)
    	{
    		bCheck=dao.replyDelete1(no, vo.getGroup_id(), pwd);
    	}
    	else
    	{
    		bCheck=dao.replyDelete2(no, pwd);
    	}
    	
    	if(bCheck==true)
    	{
    		result="<script>location.href=\"../reply/list.do\";</script>";
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
