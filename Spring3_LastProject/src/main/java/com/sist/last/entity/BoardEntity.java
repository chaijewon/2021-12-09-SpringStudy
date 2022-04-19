package com.sist.last.entity;

import java.time.LocalDateTime;
/*
 *  no int,
   name varchar(20) not null,
   subject varchar(1000) not null,
   content text not null,
   pwd varchar(10) not null,
   regdate datetime default now(),
   hit int default 0,
 */
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
@Entity(name="board")
@Getter
@Setter
// insert , update , delete 
// jpa => 검색 (조건=@Query)
public class BoardEntity {
	@Id 
    private int no;
	private String name,subject,content,pwd;
	private LocalDateTime regdate;
	private int hit;
	
	@PrePersist
	public void regdate()
	{
		this.regdate=LocalDateTime.now();
	}
}
