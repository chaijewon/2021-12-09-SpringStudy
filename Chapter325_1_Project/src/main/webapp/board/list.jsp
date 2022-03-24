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
   <h1>게시판 목록</h1>
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
   <table width=850>
    <tr>
     <td>
      <form method="post" action="find.do">
	      Search:<input type=checkbox name="fs" value="N">이름
	      <input type=checkbox name="fs" value="S">제목
	      <input type=checkbox name="fs" value="C">내용
	      <input type="text" size=15 name="ss">
	      <input type=submit value="검색">
      </form>
     </td>
    </tr>
   </table>
</body>
</html>