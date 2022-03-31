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
  width:100%;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
     <table class="table">
      <tr>
       <td class="text-center" colspan="3">
        <img src="${vo.poster }" style="width:100%">
       </td>
      </tr>
      <tr>
        <td class="text-center" colspan="3">${vo.chef }</td>
      </tr>
      <tr>
        <td class="text-center" colspan="3"><h3>${vo.title }</h3></td>
      </tr>
      <tr>
        <td class="text-center" colspan="3"><h3>${vo.content }</h3></td>
      </tr>
      <tr>
       <td class="text-center"><img src="info1.png"></td>
       <td class="text-center"><img src="info2.png"></td>
       <td class="text-center"><img src="info3.png"></td>
      </tr>
      <tr>
       <td class="text-center">${vo.info1 }</td>
       <td class="text-center">${vo.info2 }</td>
       <td class="text-center">${vo.info3 }</td>
      </tr>
     </table>
     <h3>재료</h3>
     <table class="table">
      <c:forTokens items="${vo.etc }" delims="," var="data">
       <tr>
        <%-- Controller  --%>
        <td><a href="recipe_goods_list.do?data=${data }">${data }</a></td>
      </tr>
      </c:forTokens>
     </table>
     <h3>조리법</h3>
     <table class="table">
       <c:forEach var="ss" items="${fList }" varStatus="s">
         <tr>
          <td width=70%>${ss }</td>
          <td width=30%><img src="${iList[s.index]}" style="width:250px;height:200px"></td>
         </tr>
       </c:forEach>
     </table>
     <h3>쉐프정보</h3>
     <table class="table">
       <tr>
        <td width=30% rowspan="2">
         <img src="${vo.chef_poster }" style="width:35px;height: 35px">
        </td>
        <td width=70%>
          ${vo.chef }
        </td>
       </tr>
       <tr>
         <td width=70%>${vo.chef_profile }</td>
       </tr>
     </table>
    </div>
  </div>
</body>
</html>










