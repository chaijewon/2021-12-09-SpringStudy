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
  width:850px;
}
h1{
   text-align: center;
}
td{
    font-size: 9pt;
}
</style>
</head>
<body>
  <div class="container">
    <h1>답변형게시판(7장-트랜잭션,MyBatis동적 쿼리)</h1>
    <div class="row">
      <table class="table">
       <tr>
         <td>
          <a href="insert.do" class="btn btn-sm btn-danger">새글</a>
         </td>
       </tr>
      </table>
      <table class="table table-hover">
       <tr class="danger">
        <th class="text-center" width=10%>번호</th>
        <th class="text-center" width=45%>제목</th>
        <th class="text-center" width=15%>이름</th>
        <th class="text-center" width=20%>작성일</th>
        <th class="text-center" width=10%>조회수</th>
       </tr>
       <c:set var="count" value="${count }"/>
       <c:forEach var="vo" items="${list }">
         <tr>
           <td class="text-center" width="10%">${count }</td>
           <td width="45%">
             <c:if test="${vo.group_tab>0 }">
               <c:forEach var="i" begin="1" end="${vo.group_tab }">
                &nbsp;&nbsp;
               </c:forEach>
               <img src="re_icon.png"/>
             </c:if>
             <a href="detail.do?no=${vo.no }">${vo.subject }</a>
             <%-- .do(요청) 처리 = @Controller --%>
             &nbsp;
             <c:if test="${today==vo.dbday }">
               <sup style="color:red">new</sup>
             </c:if>
           </td>
           <td class="text-center" width="15%">${vo.name }</td>
           <td class="text-center" width="20%">${vo.dbday }</td>
           <td class="text-center" width="10%">${vo.hit }</td>
         </tr>
         <c:set var="count" value="${count-1 }"/>
       </c:forEach>
      </table>
      <table class="table">
        <tr>
         <td class="text-left">
           Search:<input type="checkbox" name="fs" value="N">이름
           <input type="checkbox" name="fs" value="S">제목
           <input type="checkbox" name="fs" value="C">내용
           <input type=text size=15 class="input-sm" name="ss">
           <input type=submit value="검색" class="btn btn-sm btn-primary">
         </td>
         <td class="text-right">
           <a href="#" class="btn btn-sm btn-info">이전</a>
           ${curpage } page / ${totalpage } pages
           <a href="#" class="btn btn-sm btn-success">다음</a>
         </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>














