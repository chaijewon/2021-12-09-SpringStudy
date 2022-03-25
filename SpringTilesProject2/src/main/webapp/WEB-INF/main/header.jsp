<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear"> 
   
    <div id="logo" class="fl_left">
      <h1><a href="index.html">스프링 프로젝트</a></h1>
    </div>
    <div class="fl_right">
      <ul class="inline">
        <li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
        <li><i class="fa fa-envelope-o"></i> info@domain.com</li>
      </ul>
    </div>
   
  </header>
</div>

<div class="wrapper row2">
  <nav id="mainav" class="clear"> 
    
    <ul class="clear">
      <li class="active"><a href="../main/main.do">Home</a></li>
      <li><a class="drop" href="#">서울 여행</a>
        <ul>
          <li><a href="../seoul/location.do">명소</a></li>
          <li><a href="../seoul/nature.do">자연/관광</a></li>
          <li><a href="../seoul/hotel.do">호텔</a></li>
        </ul>
      </li>
      <li><a href="../food/search.do">맛집검색</a></li>
      <li><a href="../chat/chat.do">실시간채팅</a></li>
    </ul>
    
  </nav>
</div>
</body>
</html>