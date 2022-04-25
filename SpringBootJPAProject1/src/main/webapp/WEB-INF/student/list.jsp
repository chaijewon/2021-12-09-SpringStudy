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
  width:550px;
}
h1{
   text-align: center
}
</style>
</head>
<body>
  <div class="container">
   <h1>성적표</h1>
   <div class="row">
    <table class="table">
      <tr class="info">
        <th class="text-center">학번</th>
        <th class="text-center">이름</th>
        <th class="text-center">국어</th>
        <th class="text-center">영어</th>
        <th class="text-center">수학</th>
        <th class="text-center">비고</th>
      </tr>
      <c:forEach var="vo" items="${list }">
        <tr>
         <td class="text-center">${vo.hakbun }</td>
         <td class="text-center">${vo.name }</td>
         <td class="text-center">${vo.kor }</td>
         <td class="text-center">${vo.eng }</td>
         <td class="text-center">${vo.math }</td>
         <td class="text-center">
          <a href="/delete/${vo.hakbun }" class="btn btn-xs btn-danger">삭제</a>
          <a href="/update/${vo.hakbun }" class="btn btn-xs btn-primary">수정</a>
         </td>
        </tr>
      </c:forEach>
    </table>
    <table class='table'>
      <tr>
        <td>
         <form method=post action="/find">
         <input type=text name="ss" size=20 class="input-sm">
         <input type=submit value="검색"
           class="btn btn-sm btn-warning"
         >
         </form>
        </td>
      </tr>
    </table>
   </div>
  </div>
</body>
</html>