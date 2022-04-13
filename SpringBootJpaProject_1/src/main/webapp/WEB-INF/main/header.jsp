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
      <a class="navbar-brand" href="/main">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/main">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Music<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/top200">Top200</a></li>
          <li><a href="/genre_music">장르별 뮤직</a></li>
          <li><a href="/music_find">뮤직검색</a></li>
        </ul>
      </li>
      <li><a href="/movie_list">Movie</a></li>
      <li><a href="/movie_news">영화뉴스</a></li>
    </ul>
  </div>
</nav>
</body>
</html>