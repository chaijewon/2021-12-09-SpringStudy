<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
  width:350px;
}
h1{
   text-align: center
}
</style>
</head>
<body>
  <div class="container">
    <h1>성적 등록</h1>
    <div class="row">
     <form:form method="post" action="insert_ok.do" modelAttribute="studentVO">
       <table class="table">
         <tr>
           <td width=20%>이름</td>
           <td width=80%>
            <input type=text name=name size=15 class="input-sm">
           </td>
         </tr>
         <tr>
           <td colspan="2"><span style="color:red">
            <form:errors path="name"></form:errors>
           </span></td>
         </tr>
         <tr>
           <td width=20%>국어</td>
           <td width=80%>
            <input type=text name=kor size=15 class="input-sm">
           </td>
         </tr>
         <tr>
           <td colspan="2"><span style="color:red">
            <form:errors path="kor"></form:errors>
           </span></td>
         </tr>
         <tr>
           <td width=20%>영어</td>
           <td width=80%>
            <input type=text name=eng size=15 class="input-sm">
           </td>
         </tr>
         <tr>
           <td colspan="2"><span style="color:red">
            <form:errors path="eng"></form:errors>
           </span></td>
         </tr>
         <tr>
           <td width=20%>수학</td>
           <td width=80%>
            <input type=text name=math size=15 class="input-sm">
           </td>
         </tr>
         <tr>
           <td colspan="2"><span style="color:red">
            <form:errors path="math"></form:errors>
           </span></td>
         </tr>
         <tr>
           <td colspan="2" class="text-center">
             <button class="btn btn-sm btn-primary">등록</button>
             <input type=button value="취소" class="btn btn-sm btn-primary"
             onclick="javascript:history.back()">
           </td>
         </tr>
       </table>
     </form:form>
    </div>
  </div>
</body>
</html>








