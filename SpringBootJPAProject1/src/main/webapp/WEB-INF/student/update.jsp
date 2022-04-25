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
  width:550px;
}
h1{
   text-align: center
}
</style>
</head>
<body>
  <div class="container">
    <h1>수정하기</h1>
    <div class="row">
      <form method=post action="/update_ok">
      <table class="table">
        <tr>
          <th width="20%">이름</th>
          <td width="80%"><input type=text name=name size=20 
           class="input-sm" value="${vo.name }">
           <input type=hidden name=no value="${vo.hakbun }">
          </td>
        </tr>
        <tr>
          <th width="20%">국어</th>
          <td width="80%"><input type=text name=kor size=20 
           class="input-sm" value="${vo.kor }">
          </td>
        </tr>
        <tr>
          <th width="20%">영어</th>
          <td width="80%"><input type=text name=eng size=20 
           class="input-sm" value="${vo.eng }">
          </td>
        </tr>
        <tr>
          <th width="20%">수학</th>
          <td width="80%"><input type=text name=math size=20 
           class="input-sm" value="${vo.math}">
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
           <input type=submit value="수정"
             class="btn btn-sm btn-info">
           <input type=button value="취소"
             class="btn btn-sm btn-success"
             onclick="javascript:history.back()">
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>