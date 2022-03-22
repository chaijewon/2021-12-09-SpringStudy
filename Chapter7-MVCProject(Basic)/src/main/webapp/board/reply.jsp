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
  width:850px;
}
h1{
   text-align: center;
}
</style>
</head>
<body>
   <div class="container">
    <h1>답변형 게시판 답변하기</h1>
    <div class="row">
    <form method="post" action="reply_ok.do">
     <table class="table">
      <tr>
       <th width=10% class="warning text-right">이름</th>
       <td width=90%>
         <input type=text size=20 class="input-sm" name=name>
       </td>
      </tr>
      <tr>
       <th width=10% class="warning text-right">제목</th>
       <td width=90%>
         <input type=text size=60 class="input-sm" name=subject>
       </td>
      </tr>
      <tr>
       <th width=10% class="warning text-right">내용</th>
       <td width=90%>
         <textarea rows="10" cols="62" name=content></textarea>
       </td>
      </tr>
      <tr>
       <th width=10% class="warning text-right">비밀번호</th>
       <td width=90%>
         <input type=password size=15 class="input-sm" name=pwd>
       </td>
      </tr>
      <tr>
        <td colspan="2" class="text-center">
          <input type=submit class="btn btn-sm btn-danger" 
          value="답변">
          <input type=button class="btn btn-sm btn-primary" 
          value="취소" onclick="javascript:history.back()">
        </td>
      </tr>
     </table>
     </form>
    </div>
   </div>
</body>
</html>
