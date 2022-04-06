package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 오라클 연결 ==> @Controller연결 
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
// 조립 => DAO (Mapper) , DAO포함해서 조립 (요청처리)=> Controller
// @Select , @Insert , @Update , @Delete => SQL문장은 1개맘 사용이 가능 
// 단 2개이상을 사용할때는 subquery를 이용한다 (MySQL)
@Repository
public class ReplyDAO {
  // 스프링에서 구현된 클래스를 주소를 받는다 
  @Autowired
  private ReplyMapper mapper;
  
  public List<ReplyVO> replyListData(Map map)
  {
	  return mapper.replyListData(map);
  }
  public int replyRowCount()
  {
	  return mapper.replyRowCount();
  }
  public int replyTotalPage()
  {
	  return (int)(Math.ceil(mapper.replyRowCount()/10.0));
  }
  public void replyInsert(ReplyVO vo)
  {
	  mapper.replyInsert(vo);
  }
  public ReplyVO replyDetailData(int no)
  {
	  mapper.replyHitIncrement(no);
	  return mapper.replyDetailData(no);
  }
  public int replyCount(int group_id)
  {
	  return mapper.replyCount(group_id);
  }
  public ReplyVO replyParentInfoData(int no)
  {
	  return mapper.replyParentInfoData(no);
  }
  public void replyReplyInsert(ReplyVO vo)
  {
	  mapper.replyReplyInsert(vo);  
  }
  public ReplyVO replyUpdateData(int no)
  {
	  return mapper.replyDetailData(no);
  }
  public boolean replyUpdate(ReplyVO vo)
  {
	  boolean bCheck=false;
	  String db_pwd=mapper.replyGetPassword(vo.getNo());
	  if(db_pwd.equals(vo.getPwd()))
	  {
		  bCheck=true;
		  mapper.replyUpdate(vo);
	  }
	  return bCheck;
  }
  
  public boolean replyDelete1(int no,int group_id,String pwd)
  {
	  boolean bCheck=false;
	  String db_pwd=mapper.replyGetPassword(no);
	  if(db_pwd.equals(pwd))
	  {
		  bCheck=true;
		  mapper.replyDelete1(group_id);
	  }
	  return bCheck;
  }
  public boolean replyDelete2(int no,String pwd)
  {
	  boolean bCheck=false;
	  String db_pwd=mapper.replyGetPassword(no);
	  if(db_pwd.equals(pwd))
	  {
		  bCheck=true;
		  mapper.replyDelete2(no);
	  }
	  return bCheck;
  }
}









