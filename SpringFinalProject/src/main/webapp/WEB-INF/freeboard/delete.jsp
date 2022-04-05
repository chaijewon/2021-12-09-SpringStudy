<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
  margin: 0px auto;
  width:400px;
}
</style>
</head>
<body>
<div class="wrapper row2">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">커뮤니티</a></li>
      <li><a href="#">자유게시판</a></li>
    </ul>
    <!-- ################################################################################################ -->
  </div>
 </div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear">
    <div class="row">
      <h3 class="text-center">삭제하기</h3>
     <form method=post action="../freeboard/delete_ok.do">
      <table class="table">
        <tr>
          <td class="text-center">
          비밀번호:<input type=password name=pwd size=15 class="input-sm">
            <input type=hidden name=no value="${no }">
          </td>
        </tr>
        <tr>
          <td class="text-center">
            <input type=submit value="삭제" class="btn btn-sm btn-danger">
            <input type=button value="취소" class="btn btn-sm btn-info"
              onclick="javascript:history.back()"
            >
          </td>
        </tr>
      </table>
      </form>
    </div>
  </main>
</div>
</body>
</html>






