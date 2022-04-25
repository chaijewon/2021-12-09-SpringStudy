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
   <div class="row">
     <c:forEach var="vo" items="${list }">
       <div class="col-md-3">
          <a href="/movie_detail?mno=${vo.mno }">
		    <div class="thumbnail">
		        <img src="${vo.poster }" style="width:280px;height:300px" class="posters" data-no="${vo.mno }">
		        <div class="caption">
		          <p style="font-size: 7px">${vo.title }</p>
		        </div>
		    </div>
		  </a>
		 </div>
     </c:forEach>
   </div>
   <div class="row">
     <div class="text-center">
       <ul class="pagination">
         <c:forEach var="i" begin="${startPage }" end="${endPage}">
           <c:if test="${i==curpage }">
		    <li class="active"><a href="/movie_list?page=${i }&cno=${cno}">${i }</a></li>
		   </c:if>
		   <c:if test="${i!=curpage }">
		    <li><a href="/movie_list?page=${i }&cno=${cno}">${i }</a></li>
		   </c:if>
         </c:forEach>
          
		</ul>
     </div>
   </div>
</body>
</html>
