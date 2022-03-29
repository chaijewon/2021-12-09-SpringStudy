package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 *  //1. 로그인 
   //1-1. ID존재 여부 
   @Select("SELECT COUNT(*) FROM project_member "
		  +"WHERE id=#{id}")
   public int idCount(String id);
   //1-2. password/name
   @Select("SELECT pwd||','||name FROM project_member "
		  +"WHERE id=#{id}")
   public String memberGetPwdAndName(String id);
 */
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodReplyDAO {
    @Autowired
    private FoodReplyMapper mapper;
    
    public String isLogin(String id,String pwd)
    {
    	String result="";
    	//1. id체크
    	int count=mapper.idCount(id);
    	if(count==0) //ID가 없다
    	{
    		result="NOID";
    	}
    	else //ID가 있다 
    	{
    		String data=mapper.memberGetPwdAndName(id);
    		StringTokenizer st=new StringTokenizer(data,",");
    		String db_pwd=st.nextToken();
    		String name=st.nextToken();
    		if(db_pwd.equals(pwd))// 로그인 
    		{
    			result=name;
    		}
    		else // 비밀번호가 틀린 상태 
    		{
    			result="NOPWD";
    		}
    	}
    	
    	return result;
    }
    
    public List<FoodReplyVO> replyListData(int fno)
    {
    	return mapper.replyListData(fno);
    }
    
    public void replyInsert(FoodReplyVO vo)
    {
    	mapper.replyInsert(vo);
    }
    
    public void replyUpdate(FoodReplyVO vo)
    {
    	mapper.replyUpdate(vo);
    }
}











