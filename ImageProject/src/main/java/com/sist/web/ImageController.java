package com.sist.web;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {
   @GetMapping("main/input.do")
   public String main_input()
   {
	   return "main/input";
   }
   @PostMapping("main/upload.do")
   public String main_upload(MultipartFile upload,Model model)
   {
	   String path="C:\\springDev\\springStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ImageProject\\main\\";
	   String fn=upload.getOriginalFilename(); // 사용자 보낸 파일명 읽기
	   File file=new File(path+fn);
	   try
	   {
		     upload.transferTo(file);// 실제 업로드 
	   }catch(Exception ex){}
	   model.addAttribute("img", fn);
	   return "main/main";
   }
}
