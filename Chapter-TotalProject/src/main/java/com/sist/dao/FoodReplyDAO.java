package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void replyReplyInsert(int pno,FoodReplyVO vo)
    {
    	//1. 상위 (답변 대상의 정보 읽기) = 18일전
    	FoodReplyVO pvo=mapper.replyParentInfoData(pno);
    	//2. group_step + 1 : 답변 출력 순서 
    	mapper.replyGroupStepIncrement(pvo);
    	//3. insert
    	vo.setGroup_id(pvo.getGroup_id());
    	vo.setGroup_step(pvo.getGroup_step()+1);
    	vo.setGroup_tab(pvo.getGroup_tab()+1);
    	vo.setRoot(pno);
    	mapper.replyReplyInsert(vo);
    	//4. depth증가
    	mapper.replyDepthIncrement(pno);
    }
    
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class )
    public void replyDelete(int no)
    {
    	FoodReplyVO vo=mapper.replyInfoData(no);
    	if(vo.getDepth()==0)
    	{
    		mapper.replyDelete(no);
    	}
    	else
    	{
    		mapper.replyMsgUpdate(no);
    	}
    	mapper.replyDepthDecrement(vo.getRoot());// 상위 
    	// commit()
    }
}











