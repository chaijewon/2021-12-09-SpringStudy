<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width:960px;
}
</style>
</head>
<body>
  <div class="container">
    <h3 class="text-right">
     <a href="chat.do" class="btn btn-sm btn-info">채팅</a>
     <a href="find.do" class="btn btn-sm btn-info">검색</a>
     <a href="recipe.do" class="btn btn-sm btn-info">레시피</a>
     <a href="chef.do" class="btn btn-sm btn-info">쉐프</a>
    </h3>
    <h3>믿고보는 맛집 리스트</h3>
    <hr>
    <div class="row">
      <c:forEach var="vo" items="${list}" varStatus="s">
       <c:if test="${s.index>=0 && s.index<12 }">
        <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="list.do?cno=${vo.cno }">
		        <img src="${vo.poster }" alt="Lights" style="width:230px;height:180px">
		        <div class="caption">
		          <p style="font-size: 8px">${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
       </c:if>
      </c:forEach>
    </div>
    <h3>지역별 인기 맛집</h3>
    <hr>
    <div class="row">
      <c:forEach var="vo" items="${list}" varStatus="s">
       <c:if test="${s.index>=12 && s.index<18 }">
        <div class="col-md-4">
		    <div class="thumbnail">
		      <a href="list.do?cno=${vo.cno }">
		        <img src="${vo.poster }" alt="Lights" style="width:230px;height:180px">
		        <div class="caption">
		          <p style="font-size: 8px">${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
       </c:if>
      </c:forEach>
    </div>
    <h3>메뉴별 인기 맛집</h3>
    <hr>
    <div class="row">
      <c:forEach var="vo" items="${list}" varStatus="s">
       <c:if test="${s.index>=18 && s.index<30 }">
        <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="list.do?cno=${vo.cno }">
		        <img src="${vo.poster }" alt="Lights" style="width:230px;height:180px">
		        <div class="caption">
		          <p style="font-size: 8px">${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
       </c:if>
      </c:forEach>
    </div>
  </div>
</body>
</html>
