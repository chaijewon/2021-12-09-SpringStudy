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
  width:650px;
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
      <li><a href="#">묻고 답하기</a></li>
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
      <h3 class="text-center">수정</h3>
      <form method=post action="../reply/update_ok.do">
      <table class="table">
        <tr>
          <th width=20% class="text-right">이름</th>
          <td width=80%>
           <input type=text name=name size=15 class="input-sm"
             value="${vo.name }"
           >
           <input type=hidden name=no value="${vo.no }">
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">제목</th>
          <td width=80%>
           <input type=text name=subject size=55 class="input-sm"
            value="${vo.subject }"
           >
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">내용</th>
          <td width=80%>
            <textarea rows="10" cols="58" name=content>${vo.content }</textarea>
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">비밀번호</th>
          <td width=80%>
            <input type=password name=pwd size=10 class="input-sm">
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <input type=submit value="수정" class="btn btn-sm btn-success">
            <input type=button value="취소" class="btn btn-sm btn-info"
             onclick="javasecript:history.back()"
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