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
		      <a href="#">
		        <img src="${vo.poster }" alt="Lights" style="width:230px;height:180px">
		        <div class="caption">
		          <p style="font-size: 8px">${vo.title }</p>
		          <p style="font-size: 8px">By&nbsp;${vo.chef }</p>
		        </div>
		      </a>
		    </div>
		  </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>







