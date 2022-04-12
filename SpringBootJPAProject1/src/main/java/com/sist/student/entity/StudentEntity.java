package com.sist.student.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/*
 *  hakbun int AI PK 
name varchar(34) 
kor int 
math int 
eng int 
regdate date
 */
@Entity(name="student") // 테이블명 지정 
public class StudentEntity {
	@Id
    private int hakbun;
	@Column(nullable = false,unique = false,length = 34 )
	private String name;
	private int kor,eng,math;
	private Date regdate;
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
