package com.sist.music.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *  no int AI PK 
	cno int 
	title varchar(500) 
	singer varchar(300) 
	album varchar(300) 
	state varchar(20) 
	idcrement int 
	poster varchar(500) 
	mkey varchar(100)
 */
@Entity(name="music")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
// default 생성자
public class MusicEntity {
   @Id
   private int no;
   private int cno,idcrement;
   private String title,singer,album,state,poster,mkey;
   
}
