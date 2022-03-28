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
  width:800px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="jumbotron">
     <h2 class="text-center">${vo.title }</h2>
     <h3 class="text-center">${vo.subject }</h3>
    </div>
    <div class="row">
     <table class="table">
      <tr>
        <td>
          <c:forEach var="fvo" items="${list }">
            <table class="table">
             <tr>
               <td class="text-center" width=30% rowspan="4">
                 <a href="detail_before.do?no=${fvo.no }">
                 <img src="${fvo.poster }" style="width:240px;height: 180px">
                 </a>
               </td>
               <%-- cookie (방문 맛집)
                    response는 두개를 동시 전송이 불가능 (HTML,Cookie)
                    session VS cookie 
                    GET VS POST
                --%>
               <td width=70%><h4><a href="detail_before.do?no=${fvo.no }">${fvo.name }</a>&nbsp;<span style="color:orange">${fvo.score }</span></h4></td>
             </tr>
             <tr>
              <td width=70%>${fvo.address }</td>
             </tr>
             <tr>
              <td width=70%>${fvo.tel }</td>
             </tr>
             <tr>
              <td width=70%>${fvo.type }</td>
             </tr>
            </table>
          </c:forEach>
        </td>
      </tr>
     </table>
    </div>
  </div>
</body>
</html>










