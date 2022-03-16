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
h1{
    text-align: center;
}
</style>
</head>
<body>
  <div class="container">
   <h1>${vo.title } 상세보기</h1>
   <div class="row">
    <table class="table">
     <tr>
      <td class="text-center">
       <img src="${vo.poster }" style="width:900px;height:450px">
      </td>
     </tr>
    </table>
    <table class="table">
      <tr>
       <td><h3>${vo.title }</h3></td>
      </tr>
      <tr>
       <td><h3>${vo.address }</h3>
      </tr>
      <tr>
       <td><h3>${vo.msg }</h3>
      </tr>
      <tr>
       <td class="text-right">
         <input type="button" class="btn btn-sm btn-primary"
          value="목록" onclick="javascript:history.back()">
       </td>
      </tr>
    </table>
   </div>
  </div>
</body>
</html>





