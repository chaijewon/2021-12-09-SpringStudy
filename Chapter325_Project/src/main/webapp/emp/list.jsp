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
  <h1>사원 이름 목록</h1>
  <form method="post" action="find.do">
  <c:forEach var="name" items="${list }">
    <input type=checkbox name="names" value="${name }">${name}
  </c:forEach>
  <br>
  <input type=submit value="전송">
  </form>
</body>
</html>