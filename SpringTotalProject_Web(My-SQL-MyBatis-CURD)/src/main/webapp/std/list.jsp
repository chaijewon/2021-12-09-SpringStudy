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
   text-align: center
}
</style>
</head>
<body>
   <div class="container">
     <h1>학생 성적표</h1>
     <div class="row">
       <table class="table">
         <tr>
          <td>
            <a href="insert.do" class="btn btn-sm btn-danger">등록</a>
          </td>
         </tr>
       </table>
       <table class="table">
         <tr class="success">
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
            <a href="update.do?hakbun=${vo.hakbun }"
             class="btn btn-xs btn-warning"
            >수정</a>
            <a href="delete.do?hakbun=${vo.hakbun }"
             class="btn btn-xs btn-info"
            >삭제</a>
           </td>
         </tr>
         </c:forEach>
       </table>
       <table class="table">
         <tr>
           <td class="text-center">
            <a href="list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-info">이전</a>
              ${curpage } page / ${totalpage } pages
            <a href="list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-success">다음</a>
           </td>
         </tr>
       </table>
     </div>
   </div>
</body>
</html>











