package com.sist.vo;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
// lombok => getter/setter , 생성자(매개변수) => 소스상에는 미존재 , 메모리에는 존재 
@Setter
@Getter
public class DataBoardVO {
  private int no;
  private String name;
  private String subject;
  private String content;
  private String pwd;
  private Date regdate;//TO_CHAR , <fmt:formatDate>
  private int hit;
  private String filename;
  private String filesize;
  private int filecount;
  private String dbday;
  private List<MultipartFile> files; // 파일업로드시 파일을 받는 변수 (배열형식)
  // 여러개를 동시에 받아서 처리 
}
