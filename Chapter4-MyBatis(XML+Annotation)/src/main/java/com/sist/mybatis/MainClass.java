package com.sist.mybatis;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.BooksVO;
// 89페이지 ~100페이지 (핵심) 
// MyBatis => Basic (동적 SQL) 
/*
 *    XML 
 *    ====
 *      MyBatis => Config (1) , -mapper , Mapper (여러개)
 *                              ------------------------
 *                                테이블 갯수 동일  
 *      Spring => 설정파일을 나눠서 처리 (분산 = 기능별 분산)
 *      
 *      Basic 
 *        => <select> : id , resultType , parameterType
 *                      JOIN / Subquery 
 *           <insert> : id , parameterType
 *           <update> : id , parameterType
 *           <delete> : id , parameterType
 *           <sql> : 중복된 SQL문장을 모아서 처리 
 *           <resultMap> : ResultSet에 있는 데이터를 VO를 통해서 받는 경우
 *               => default(VO를 만들때 컬럼명과 동일하게 만들면 설정이 필요 없다)
 *               => 실무는 컬럼명과 VO의 변수명이 틀리다 (resultMap)
 *                  => as 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. 스프링에서 XML을 읽는다 
		ApplicationContext app=
			new ClassPathXmlApplicationContext("app.xml");
		// 등록된 클래스를 메모리 할당 => setXxx()에 값을 설정
		BooksDAO dao=(BooksDAO)app.getBean("dao");
		// 스프링에 등록된 DAO만 완전 셋팅이 된다 
		List<BooksVO> list=dao.booksListData();
		for(BooksVO vo:list)
		{
			System.out.println(vo.getTitle()+" "+vo.getPrice());
		}
		System.out.println("========================");
		list=dao.booksFindData("시작");
		for(BooksVO vo:list)
		{
			System.out.println(vo.getTitle()+" "+vo.getPrice());
		}
		
	}

}
