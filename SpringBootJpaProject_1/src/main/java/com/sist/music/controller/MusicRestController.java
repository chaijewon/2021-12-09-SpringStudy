package com.sist.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.music.dao.*;
import com.sist.music.entity.*;
@RestController
public class MusicRestController {
   @Autowired
   private MusicDAO dao;
   //jackson-bind => List,객체(VO) => 자동으로 JSON매핑 
   @PostMapping("/music_ajax")
   public MusicEntity music_ajax(int no)
   {
	   MusicEntity me=dao.findByNo(no);
	   return me;
   }
}
