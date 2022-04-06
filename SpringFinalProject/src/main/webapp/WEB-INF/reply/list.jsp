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
.row{
  margin: 0px auto;
  width:900px;
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
      <li><a href="#">묻고답하기</a></li>
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
     <h3 class="text-center">묻고 답하기</h3>
     <table class="table">
       <tr>
        <td>
         <a href="insert.do" class="btn btn-sm btn-info">새글</a>
        </td>
       </tr>
     </table>
     <table class="table table-striped">
      <tr>
        <th width=10% class="text-center">번호</th>
        <th width=45% class="text-center">제목</th>
        <th width=15% class="text-center">이름</th>
        <th width=20% class="text-center">작성일</th>
        <th width=10% class="text-center">조회수</th>
      </tr>
      <c:set var="count" value="${count }"/>
      <c:forEach var="vo" items="${list }">
       <tr>
        <td width=10% class="text-center">${count }</td>
        <td width=45%>
        <c:if test="${vo.group_tab==1 }">
          &nbsp;&nbsp;
          <img src="../images/demo/re_icon.png">
        </c:if>
        <a href="../reply/detail.do?no=${vo.no }">${vo.subject }</a></td>
        <%--
             http://localhost:8080 /web  /freeboard/detail.do?no=10
             ===================== ======================== =====
                                   =====    
                ServerInfo         ContextPath
             ================================================ URL
                                  =========================== URI 
                                  no => 톰캣에 의해서 request에 담아진다 
         --%>
        <td width=15% class="text-center">${vo.name }</td>
        <td width=20% class="text-center">${vo.dbday }</td>
        <td width=10% class="text-center">${vo.hit }</td>
       </tr>
       <c:set var="count" value="${count-1 }"/>
      </c:forEach>
     </table>
     
    <nav class="pagination">
      <!-- class="current" -->
        <ul>
          <c:if test="${startPage>1 }">
           <li><a href="../reply/list.do?page=${startPage-1 }">&laquo; Previous</a></li>
          </c:if>
          <c:forEach var="i" begin="${startPage }" end="${endPage }">
           <c:if test="${i==curpage }">
            <c:set var="style" value="class=current"/>
           </c:if>
           <c:if test="${i!=curpage }">
            <c:set var="style" value=""/>
           </c:if>
           <li ${style }><a href="../reply/list.do?page=${i }">${i }</a></li>
          </c:forEach>
          
          <c:if test="${endPage<totalpage }">
          <li><a href="../reply/list.do?page=${endPage+1 }">Next &raquo;</a></li>
          </c:if>
        </ul>
      </nav>
      <!-- ################################################################################################ -->
    </div>
    <!-- ################################################################################################ -->
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
</body>
</html>
