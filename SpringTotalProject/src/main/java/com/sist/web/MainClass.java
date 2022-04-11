package com.sist.web;
import java.util.*;
import com.sist.dao.*;

//DB (오라클 => MySQL) => URL,driver , username , password 
// => SQL => (데이터형 , 함수) 
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        StudentDAO dao=new StudentDAO();
        List<StudentVO> list=dao.stdListData();
        for(StudentVO vo:list)
        {
        	System.out.println(vo.getHakbun()+" "
        			+vo.getName()+" "
        			+vo.getKor()+" "
        			+vo.getEng()+" "
        			+vo.getMath()+" "
        			+vo.getDbday());
        }
	}

}
