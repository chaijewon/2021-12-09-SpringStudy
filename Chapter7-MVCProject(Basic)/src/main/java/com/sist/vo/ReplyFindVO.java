package com.sist.vo;

import java.util.Arrays;
// 찾기 
public class ReplyFindVO {
	private String ss;
    private String fs;
	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	public String getFs() {
		return fs;
	}

	public void setFs(String fs) {
		this.fs = fs;
	}
	
	public String[] getFsArr()
	{
		return fs==null?new String[]{}:fs.split("");
	}
    // 체크 박스로 받아서 처리 
    public static void main(String[] args) {
		ReplyFindVO rf=new ReplyFindVO();
		rf.setFs("NCS");//조건 검색 (MyBatis => 동적 쿼리)
		System.out.println(Arrays.toString(rf.getFsArr()));
	}
  
}
