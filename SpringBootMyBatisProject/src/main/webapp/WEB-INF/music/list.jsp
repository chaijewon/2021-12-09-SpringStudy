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
   text-align: center
}
</style>
</head>
<body>
   <div class="container">
     <h1>Genie Top200</h1>
     <div class="row">
       <table class="table">
         <tr class="danger">
           <th class="text-center">순위</th>
           <th class="text-center"></th>
           <th class="text-center">곡명</th>
           <th class="text-center">가수명</th>
         </tr>
         <c:forEach var="vo" items="${list }">
         <tr>
           <td class="text-center">${vo.no }</td>
           <td class="text-center">
            <img src="${vo.poster }" style="width:35px;height: 35px">
           </td>
           <td>${vo.title }</td>
           <td>${vo.singer }</td>
         </tr>
         </c:forEach>
       </table>
       <table class="table">
         <tr>
           <td class="text-center">
             <a href="/?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-info">이전</a>
              ${curpage } page / ${totalpage } pages
             <a href="/?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-success">다음</a>
           </td>
         </tr>
       </table>
     </div>
   </div>
</body>
</html>





