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
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1><a href="../main/main.do">Recipe And Food</a></h1>
    </div>
    <!-- ################################################################################################ -->
    <nav id="mainav" class="fl_right">
      <ul class="clear">
        <li class="active"><a href="../main/main.do">Home</a></li>
        <li><a class="drop" href="#">Recipe</a>
          <ul>
            <li><a href="../recipe/list.do">레시피 목록</a></li>
            <li><a href="#">추천 레시피</a></li>
            <li><a href="#">레시피 제작</a></li>
            <li><a href="#">레시피 검색</a></li>
            <li><a href="#">쉐프</a></li>
          </ul>
        </li>
        <li><a class="drop" href="#">맛집</a>
          <ul>
            <li><a href="../food/list.do">맛집목록</a></li>
            <li><a href="#">맛집찾기</a></li>
            <li><a href="#">맛집추천</a></li>
          </ul>
        </li>
        <li><a class="drop" href="#">커뮤니티</a>
          <ul>
            <li><a href="../board/list.do">자유게시판</a></li>
            <li><a href="../reply/list.do">묻고답하기</a></li>
            <li><a href="../chat/chat.do">실시간 상담</a></li>
          </ul>
        </li>
        <li><a href="#">재료가격비교</a></li>
        <li><a href="#">코스만들기</a></li>
      </ul>
    </nav>
    <!-- ################################################################################################ -->
  </header>
</div>
</body>
</html>