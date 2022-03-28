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
    <div class="row">
      <table class="table">
        <tr>
         <c:forTokens items="${vo.poster }" delims="^" var="img">
           <td><img src="${img }" style="width:100%"></td>
         </c:forTokens>
        </tr>
      </table>
    </div>
    <div class="row">
      <table class="table">
       <tr>
        <td colspan="2"><h3>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h3></td>
       </tr>
       <tr>
         <td width=15%>주소</td>
         <td width=85%>${vo.address }</td>
       </tr>
       <tr>
         <td width=15%>전화</td>
         <td width=85%>${vo.tel }</td>
       </tr>
       <tr>
         <td width=15%>음식종류</td>
         <td width=85%>${vo.type }</td>
       </tr>
       <tr>
         <td width=15%>주차</td>
         <td width=85%>${vo.parking }</td>
       </tr>
       <tr>
         <td width=15%>영업시간</td>
         <td width=85%>${vo.time }</td>
       </tr>
       <tr>
         <td width=15%>메뉴</td>
         <td width=85%>${vo.menu }</td>
       </tr>
      </table>
    </div>
  </div>
</body>
</html>









