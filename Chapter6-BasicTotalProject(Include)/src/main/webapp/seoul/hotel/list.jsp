<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
   <h1 class="text-center">서울 호텔</h1>
   <div class="row">
     <c:forEach var="vo" items="${list }">
	   <div class="col-md-3">
	    <div class="thumbnail">
	      <a href="/main/seoul/hotel/detail_before.do?no=${vo.no }">
	        <img src="${vo.poster }" alt="Lights" style="width:230px;height:180px">
	        <div class="caption">
	          <p>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></p>
	        </div>
	      </a>
	    </div>
	  </div>
	 </c:forEach>
   </div>
   <div class="row">
     <div class="text-center">
        <ul class="pagination">
         <c:if test="${startPage>1 }">
          <li><a href="/main/seoul/hotel/list.do?page=${startPage-1 }">&lt;</a></li>
         </c:if>
         <c:forEach var="i" begin="${startPage }" end="${endPage }">
		  <li ${i==curpage?"class=active":"" }><a href="/main/seoul/hotel/list.do?page=${i }">${i }</a></li>
		 </c:forEach>
		 <c:if test="${endPage<totalpage }">
		  <li><a href="/main/seoul/hotel/list.do?page=${endPage+1 }">&gt;</a></li>
		 </c:if>
		</ul>
     </div>
   </div>
   <h3>최신 방문 호텔</h3>
   <hr>
   <div class="row">
     <c:forEach var="vo" items="${cList }" varStatus="s">
      <c:if test="${s.index<9 }">
	      <a href="/main/seoul/hotel/detail.do?no=${vo.no }">
	       <img src="${vo.poster }" style="width:100px;height: 100px"
	         title="${vo.name }"
	       >
	      </a>
      </c:if>
     </c:forEach>
   </div>
  </div>
</body>
</html>





