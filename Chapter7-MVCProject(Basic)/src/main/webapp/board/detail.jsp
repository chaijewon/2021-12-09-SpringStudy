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
td{
    font-size: 9pt;
}
</style>
</head>
<body>
  <div class="container">
    <h1>내용보기</h1>
    <div class="row">
      <table class="table">
       <tr>
         <th width=20% class="text-center warning">번호</th>
         <td width=30% class="text-center">${vo.no }</td>
         <th width=20% class="text-center warning">작성일</th>
         <td width=30% class="text-center">${vo.dbday }</td>
       </tr>
       <tr>
         <th width=20% class="text-center warning">이름</th>
         <td width=30% class="text-center">${vo.name }</td>
         <th width=20% class="text-center warning">조회수</th>
         <td width=30% class="text-center">${vo.hit }</td>
       </tr>
       <tr>
         <th width=20% class="text-center warning">제목</th>
         <td colspan="3">${vo.subject }</td>
       </tr>
       <tr>
         <td colspan="4" class="text-left" height="200" valign="top">
          <pre style="white-space: pre-wrap;border:none;background-color:white;">${vo.content }</pre>
         </td>
       </tr>
       <tr>
        <%--
              MyBatis의 동적 쿼리
                => trim , if , choose , foreach  
              Transaction 
                => SQL문장을 동시에 수행 (일괄처리) 
                   ----------------- DML(INSERT,UPDATE,DELETE)
                => 내용보기 : UPDATE , SELECT 
                
                reply : select , update , insert , update
                delete : select , update ,delete , update
         --%>
         <td colspan="4" class="text-right">
          <a href="reply.do?no=${vo.no }" class="btn btn-xs btn-success">답변</a>
          <a href="update.do?no=${vo.no }" class="btn btn-xs btn-info">수정</a>
          <%-- .do => DispatcherServlet => @Controller --%>
          <a href="delete.do?no=${vo.no }" class="btn btn-xs btn-danger">삭제</a>
          <a href="list.do" class="btn btn-xs btn-warning">목록</a>
         </td>
       </tr>
      </table>
    </div>
  </div>
</body>
</html>







