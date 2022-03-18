<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   width:600px;
}
h1{
    text-align: center;
}
</style>
</head>
<body>
   <div class="container">
    <h1>내용보기(다운로드 기능)</h1>
    <div class="row">
      <table class="table">
        <tr>
          <th class="text-center warning" width=20%>번호</th>
          <td class="text-center" width=30%>${vo.no }</td>
          <th class="text-center warning" width=20%>작성일</th>
          <td class="text-center" width=30%>${vo.dbday }</td>
        </tr>
        <tr>
          <th class="text-center warning" width=20%>이름</th>
          <td class="text-center" width=30%>${vo.name }</td>
          <th class="text-center warning" width=20%>조회수</th>
          <td class="text-center" width=30%>${vo.hit }</td>
        </tr>
        <tr>
          <th class="text-center warning" width=20%>제목</th>
          <td colspan="3">${vo.subject }</td>
        </tr>
        <c:if test="${vo.filecount!=0 }">
          <tr>
           <th class="text-center warning" width=20%>첨부파일</th>
           <td colspan="3">
             <ul>
               <c:forEach var="fdata" items="${fList }" varStatus="s">
                <li><a href="download.do?fn=${fdata }">${fdata }</a>(${sList[s.index] }Bytes)</li>
               </c:forEach>
             </ul>
           </td>
          </tr>
        </c:if>
        <tr>
          <td class="text-left" valign="top" height="200" colspan="4">
            <pre style="white-space: pre-wrap;border:none;background-color:white">${vo.content }</pre>
          </td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
           <a href="update.do?no=${vo.no }" class="btn btn-sm btn-danger">수정</a>
           <a href="delete.do?no=${vo.no }" class="btn btn-sm btn-info">삭제</a>
           <%-- .do : @Controller = @RequestMapping : DAO연결  --%>
           <a href="list.do" class="btn btn-sm btn-success">목록</a>
          </td>
        </tr>
      </table>
    </div>
   </div>
</body>
</html>






