package com.sist.music.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
/*
 *     보유기술 
 *     ======
 *     프로그램 언어  : Java , HTML5 , JavaScript(ES6) , .....
 *     데이터베이스 : Oracle 18c , (MySQL 8.0.28)
 *     운영체제       : 리눅스(우분투) , 윈도우 
 *     사용 기술  : JSP , Ajax , (React) , (Redux) , (Vue) , OpenApi
 *              (AWS) , MyBatis , (JPA)
 *     프레임워크  : Spring5 , (Spring-Boot)  => Bold체
 *     
 *     희망부서 
 *       SI/SM  ==> Java 웹개발  , Java 웹개발(Front-End)
 *       솔루션     ==> SW개발 
 *                  데이터베이스 관련 개발 
 *                  
 *                  Java 웹개발 / SW개발 
 *     ----------------------------------------------------------
 *     1. 목표 
 *        = 사이트 목적(요구사항) 
 *        = 개인 목적 => Ajax와 MyBatis , MVC구조를 익히는데 주력 
 *        
 *     2. 성과 
 *     
 *     ------------------ 증거제시 (캡쳐화면)   Ajax를 이용한 검색  Vue를 이용한 게시판 
 *     3. 사이트 주요 기능 
 *         => 본인외 ==> 설명이 가능  Vue를 이용한 게시판 (기여도 80%)
 *     4. 개인 담당 
 *     -----------------
 */
@Entity(name="music")
@Setter
@Getter
public class MusicEntity {
	@Id
	private int no;
	private int cno,idcrement;
	private String title,singer,album,state,poster,mkey;
}








