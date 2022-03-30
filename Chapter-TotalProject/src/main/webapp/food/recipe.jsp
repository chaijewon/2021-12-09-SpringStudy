<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width:100%;
}
</style>
</head>
<body>
  <div class="container">
     총 <span style="color:green;font-size: 30px"><fmt:formatNumber value="${count }" pattern="000,000"/></span>개의 맛있는 레시피가 있습니다.
    <div style="height: 10px"></div>
    <div class="row">
     <c:forEach var="vo" items="${list}">
        <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="recipe_detail.do?no=${vo.no }">
		        <img src="${vo.poster }" alt="Lights" style="width:230px;height:180px">
		        <div class="caption">
		          <p style="font-size: 9px">${vo.title }</p>
		          <p style="font-size: 9px">By&nbsp;${vo.chef }</p>
		        </div>
		      </a>
		    </div>
		  </div>
      </c:forEach>
    </div>
    <div class="row">
      <div class="text-center">
        <ul class="pagination">
         <%-- startPage => 1,11,21... --%>
         <c:if test="${startPage>1 }">
          <li><a href="recipe.do?page=${startPage-1}">&lt;</a></li>
         </c:if>
         <c:forEach var="i" begin="${startPage }" end="${endPage }">
           <c:if test="${curpage==i }">
            <c:set var="style" value="class=active"/>
           </c:if>
           <c:if test="${curpage!=i }">
            <c:set var="style" value=""/>
           </c:if>
           <li ${style }><a href="recipe.do?page=${i }">${i }</a></li>
         </c:forEach>
         <c:if test="${endPage<totalpage }">
          <li><a href="recipe.do?page=${endPage+1 }">&gt;</a></li>
         </c:if>
		</ul>
      </div>
    </div>
  </div>
</body>
</html>







