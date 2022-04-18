package com.sist.last.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.last.dao.*;
import com.sist.last.entity.*;
@RestController
public class MusicRestController {
   @Autowired
   private MusicDAO dao;
   
   @PostMapping("/music/detail")
   public MusicEntity music_detail(int no)
   {
	   MusicEntity vo=dao.musicDetailData(no);
	   return vo;
   }
}
