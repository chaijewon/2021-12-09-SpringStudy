package com.sist.music.vo;

import lombok.Getter;
import lombok.Setter;

/*
 * no int AI PK 
cno int 
title varchar(500) 
singer varchar(300) 
album varchar(300) 
state varchar(20) 
idcrement int 
poster varchar(500) 
mkey varchar(100)
 */
@Setter
@Getter
public class MusicVO {
   private int no,cno,idcrement;
   private String title,singer,album,state,poster,mkey;
}
