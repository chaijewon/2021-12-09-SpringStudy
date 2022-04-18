package com.sist.last.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/*
 *  create table movie(
   mno int auto_increment,
   cno int,
   title varchar(200),
   time varchar(100),
   grade varchar(100),
   reserve varchar(200),
   genre varchar(200),
   regdate varchar(200),
   director varchar(200),
   actor varchar(300),
   showUser varchar(100),
   poster varchar(260),
   story text,
   mkey varchar(100),
   primary key(mno)
);
 */
@Entity(name="movie")
@Setter
@Getter
public class MovieEntity {
  @Id
  private int mno;
  private int cno;
  private String title,time,grade,reserve,genre,regdate,
                 director,actor,showuser,poster,story,mkey;
} 




