<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   width:450px;
}
h1{
    text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <h1>개인정보</h1>
    <div class="row">
    <form method=post action="../main/output.do">
      <table class="table">
       <tr>
         <td width=20% class="text-right">이름</td>
         <td width=80%>
          <input type=text name=name size=20 class="input-sm">
         </td>
       </tr>
       <tr>
         <td width=20% class="text-right">성별</td>
         <td width=80%>
          <input type=radio name=sex value="남자" checked>남자
          <input type=radio name=sex value="여자">여자
         </td>
       </tr>
       <tr>
         <td width=20% class="text-right">주소</td>
         <td width=80%>
          <input type=text name=addr size=35 class="input-sm">
         </td>
       </tr>
       <tr>
         <td width=20% class="text-right">전화</td>
         <td width=80%>
          <input type=text name=tel size=20 class="input-sm">
         </td>
       </tr>
       <tr>
         <td colspan="2" class="text-center">
           <button class="btn btn-sm btn-danger">전송</button>
         </td>
       </tr>
      </table>
      </form>
    </div>
  </div>
</body>
</html>








