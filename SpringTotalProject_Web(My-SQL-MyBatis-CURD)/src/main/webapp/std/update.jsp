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
  width:350px;
}
h1{
   text-align: center
}
</style>
</head>
<body>
  <div class="container">
    <h1>성적 수정</h1>
    <div class="row">
     <form method="post" action="update_ok.do">
       <table class="table">
         <tr>
           <td width=20%>이름</td>
           <td width=80%>
            <input type=text name=name size=15 class="input-sm"
              value="${vo.name }"
            >
            <input type=hidden name=hakbun value="${vo.hakbun }">
           </td>
         </tr>
         <tr>
           <td width=20%>국어</td>
           <td width=80%>
            <input type=text name=kor size=15 class="input-sm"
             value="${vo.kor }"
            >
           </td>
         </tr>
         <tr>
           <td width=20%>영어</td>
           <td width=80%>
            <input type=text name=eng size=15 class="input-sm"
             value="${vo.eng }"
            >
           </td>
         </tr>
         <tr>
           <td width=20%>수학</td>
           <td width=80%>
            <input type=text name=math size=15 class="input-sm"
             value="${vo.math }"
            >
           </td>
         </tr>
         <tr>
           <td colspan="2" class="text-center">
             <button class="btn btn-sm btn-primary">등록</button>
             <input type=button value="취소" class="btn btn-sm btn-primary"
             onclick="javascript:history.back()">
           </td>
         </tr>
       </table>
     </form>
    </div>
  </div>
</body>
</html>
