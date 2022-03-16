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
   width:650px;
}
h1{
    text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <h1>네이버 뉴스 검색</h1>
    <div class="row">
      <table class="table">
       <tr>
        <td>
         <form method=post action="find.do">
          <input type=text name="ss" size=20 class="input-sm">
          <button class="btn btn-sm btn-danger">검색</button>
         </form>
        </td>
       </tr>
      </table>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
     <c:forEach var="vo" items="${list }">
       <table class="table">
         <tr>
          <td><span style="color:orange">${vo.title }</span></td>
         </tr>
         <tr>
          <td>${vo.description }</td>
         </tr>
         <tr>
           <td class="text-right">${vo.author }</td>
         </tr>
       </table>
     </c:forEach>
    </div>
  </div>
</body>
</html>





