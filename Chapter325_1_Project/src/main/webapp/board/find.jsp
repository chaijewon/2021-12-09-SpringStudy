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
   <h1>게시판 검색</h1>
   <table width=850 border=1 bordercolor=black>
     <tr>
      <th width=10%>번호</th>
      <th width=45%>제목</th>
      <th width=15%>이름</th>
      <th width=20%>작성일</th>
      <th width=10%>조회수</th>
     </tr>
     <c:forEach var="vo" items="${list }">
       <tr>
         <td width="10%">${vo.no }</td>
         <td width="45%">${vo.subject }</td>
         <td width="15%">${vo.name }</td>
         <td width="20%">${vo.regdate }</td>
         <td width="10%">${vo.hit }</td>
       </tr>
     </c:forEach>
   </table>

</body>
</html>