<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   width:960px;
}
h1{
    text-align: center;
}
</style>
</head>
<body>
  <div class="container">
   <h1>서울 명소</h1>
   <div class="row">
    <table class="table">
     <tr>
       <td class="text-right">
        ${curpage } page / ${totalpage } pages
       </td>
     </tr>
    </table>
    <div style="height: 30px"></div>
    <c:forEach var="vo" items="${list }">
     <div class="col-md-3">
		   <div class="thumbnail">
		      <a href="detail.do?no=${vo.no }">
		        <img src="${vo.poster }" alt="Lights" style="width:220px;height:180px">
		        <div class="caption">
		          <p style="font-size: 8px">${vo.title }</p>
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
          <li><a href="list.do?page=${startPage-1 }">&lt;</a></li>
         </c:if>
         <c:forEach var="i" begin="${startPage }" end="${endPage }">
           <c:if test="${i==curpage }">
             <c:set var="style" value="class=active"/>
           </c:if>
           <c:if test="${i!=curpage }">
             <c:set var="style" value=""/>
           </c:if>
           <li ${style }><a href="list.do?page=${i }">${i }</a></li>
         </c:forEach>
         <c:if test="${endPage<totalpage }">
          <li><a href="list.do?page=${endPage+1 }">&gt;</a></li>
         </c:if>
		</ul>
     </div>
   </div>
  </div>
</body>
</html>