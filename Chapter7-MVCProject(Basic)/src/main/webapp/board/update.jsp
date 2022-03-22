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
    <h1>답변형 게시판 수정하기</h1>
    <div class="row">
    <%--
         @Controller => 이동할 수 있는 파일지정 (스크립트를 전송 할 수 없다)
                     => update_ok.jsp를 추가 
         @RestController => 스크립트 전송이 가능 
     --%>
    <form method="post" action="update_ok.do">
     <table class="table">
      <tr>
       <th width=10% class="warning text-right">이름</th>
       <td width=90%>
         <input type=text size=20 class="input-sm" 
         name=name value="${vo.name }">
         <input type=hidden name=no value="${vo.no }">
       </td>
      </tr>
      <tr>
       <th width=10% class="warning text-right">제목</th>
       <td width=90%>
         <input type=text size=60 class="input-sm" 
         name=subject value="${vo.subject }">
       </td>
      </tr>
      <tr>
       <th width=10% class="warning text-right">내용</th>
       <td width=90%>
         <textarea rows="10" cols="62" name=content>${vo.content }</textarea>
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
          value="수정">
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
