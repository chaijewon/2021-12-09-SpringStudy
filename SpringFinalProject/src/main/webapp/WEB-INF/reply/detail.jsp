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
.row{
  margin: 0px auto;
  width:650px;
}
</style>
</head>
<body>
<div class="wrapper row2">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">커뮤니티</a></li>
      <li><a href="#">묻고 답하기</a></li>
    </ul>
    <!-- ################################################################################################ -->
  </div>
 </div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear">
    <div class="row">
      <h3 class="text-center">내용보기</h3>
      <table class="table">
        <tr>
         <th class="text-center" width=20%>번호</th>
         <td class="text-center" width=30%>${vo.no }</td>
         <th class="text-center" width=20%>작성일</th>
         <td class="text-center" width=30%>${vo.dbday }</td>
        </tr>
        <tr>
         <th class="text-center" width=20%>이름</th>
         <td class="text-center" width=30%>${vo.name }</td>
         <th class="text-center" width=20%>조회수</th>
         <td class="text-center" width=30%>${vo.hit }</td>
        </tr>
        <tr>
         <th class="text-center" width=20%>제목</th>
         <td colspan="3">${vo.subject }</td>
        </tr>
        <tr>
          <td colspan="4" valign="top" class="text-left" height="200">
           <pre style="border:none;background-color:white;white-space: pre-wrap;">${vo.content }</pre>
          </td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
            <c:if test="${count!=1 }">
              <a href="../reply/reply.do?no=${vo.no }" class="btn btn-xs btn-info">답변</a>
            </c:if>
            <a href="../reply/update.do?no=${vo.no }" class="btn btn-xs btn-danger">수정</a>
            <a href="../reply/delete.do?no=${vo.no }" class="btn btn-xs btn-success">삭제</a>
            <a href="list.do" class="btn btn-xs btn-info">목록</a>
          </td>
        </tr>
      </table>
    </div>
  </main>
</body>
</html>