<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width:960px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <table class="table">
        <tr>
         <c:forTokens items="${vo.poster }" delims="^" var="img">
           <td><img src="${img }" style="width:100%"></td>
         </c:forTokens>
        </tr>
      </table>
    </div>
    <div class="row">
      <table class="table">
       <tr>
        <td colspan="2"><h3>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h3></td>
       </tr>
       <tr>
         <td width=15%>주소</td>
         <td width=85%>${vo.address }</td>
       </tr>
       <tr>
         <td width=15%>전화</td>
         <td width=85%>${vo.tel }</td>
       </tr>
       <tr>
         <td width=15%>음식종류</td>
         <td width=85%>${vo.type }</td>
       </tr>
       <tr>
         <td width=15%>주차</td>
         <td width=85%>${vo.parking }</td>
       </tr>
       <tr>
         <td width=15%>영업시간</td>
         <td width=85%>${vo.time }</td>
       </tr>
       <c:if test="${vo.menu!='no' }">
	       <tr>
	         <td width=15%>메뉴</td>
	         <td width=85%>
	           <ul>
	           <c:forTokens items="${vo.menu }" delims="원" var="m">
	             <li>${m }</li>
	           </c:forTokens>
	           </ul>
	         </td>
	       </tr>
       </c:if>
      </table>
    </div>
    <div style="height: 50px"></div>
    <div class="row">
      <div class="col-sm-9">
        <%-- 댓글  --%>
       <table class="table">
         <tr>
           <td>
             <c:forEach var="fvo" items="${rList }">
               <table class="table">
                 <tr>
                  <td class="text-left">◐${fvo.name }(${fvo.dbday })</td>
                  <td class="text-right">
                    <c:if test="${sessionScope.id!=null }">
                     <c:if test="${sessionScope.id==fvo.id }">
                      <a href="#" class="btn btn-xs btn-info">수정</a>
                      <a href="#" class="btn btn-xs btn-success">삭제</a>
                     </c:if>
                     <a href="#" class="btn btn-xs btn-warning">댓글</a>
                    </c:if>
                  </td>
                 </tr>
                 <tr>
                   <td colspan="2">
                    <pre style="white-space: pre-wrap;background-color:white;border:none">${fvo.msg }</pre>
                   </td>
                 </tr>
               </table>
             </c:forEach>
           </td>
         </tr>
       </table>
       <div style="height: 10px"></div>
       <c:if test="${sessionScope.id!=null }">
	        <table class="table">
	         <tr>
	           <td>
	             <textarea rows="6" cols="77" style="float: left"></textarea>
	             <input type=submit value="댓글쓰기" 
	              style="height: 122px;background-color: blue;color:white;"
	             >
	           </td>
	         </tr>
	        </table>
        </c:if>
      </div>
      <div class="col-sm-3">
        <%-- 레시피  --%>
        <table class="table">
          <c:forEach var="rvo" items="${list }">
            <tr>
              <td class="text-center">
               <img src="${rvo.poster }" style="width: 100%"
                title="${rvo.title }"
               >
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </div>
</body>
</html>









