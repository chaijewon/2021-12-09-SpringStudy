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
     width:960px;
  }
 </style>
</head>
<body>
  <div class="container">
   <div class="row">
     <table class="table">
      <tr>
        <td colspan="5">
         <h3 class="text-center">${vo.name }</h3>
        </td>
      </tr>
      <tr>
        <td colspan="5">
         <img src="${vo.poster }" width=100%>
        </td>
      </tr>
      <tr>
        <c:forTokens items="${vo.images }" delims="^" var="img">
          <td class="text-center">
            <img src="${img }" width=100%>
          </td>
        </c:forTokens>
      </tr>
      <tr>
        <td colspan="5">${vo.address }</td>
      </tr>
      <tr>
        <td class="text-right" colspan="5">
         <a href="javascript:history.back()" 
            class="btn btn-sm btn-danger">목록</a>
        </td>
      </tr>
     </table>
   </div>
  </div>
</body>
</html>






