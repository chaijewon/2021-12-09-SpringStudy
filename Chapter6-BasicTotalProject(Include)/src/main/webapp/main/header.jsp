<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Include</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../../main/main.do">Home</a></li>
      <li><a href="/main/seoul/location/list.do">명소</a></li>
      <li><a href="/main/seoul/natrue/list.do">자연/관광</a></li>
      <li><a href="/main/seoul/hotel/list.do">호텔</a></li>
      <li><a href="#">뉴스</a></li>
      <%-- XML 파싱(naver=이미지) --%>
      <li><a href="#">영화</a></li>
      <%-- 영화진흥원 (VueJS) --%>
    </ul>
  </div>
</nav>
</body>
</html>