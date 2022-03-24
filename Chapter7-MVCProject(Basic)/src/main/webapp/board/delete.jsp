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
   text-align: center;
}
</style>
</head>
<body>
   <div class="container">
     <h1>삭제하기</h1>
     <div class="row">
       <table class="table">
        <tr>
         <td class="text-center">
         <form method=post action="delete_ok.do">
          비밀번호:<input type=password size=15 class="input-sm" name=pwd>
            <input type=hidden value="${no }" name=no>
          <input type=submit value="삭제" class="btn btn-sm btn-danger">
          </form>
         </td>
        </tr>
       </table>
     </div>
   </div>
</body>
</html>






