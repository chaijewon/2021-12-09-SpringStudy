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
  width:960px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
let u=0;
$(function(){
	$('.replys').click(function(){
	    $('.rInsert').hide();
	    $('.rUpdate').hide();
		let no=$(this).attr("value");
		if(i==0)
		{
		   $('#m'+no).show();
		   i=1;
		}
		else
		{
			$('#'+no).hide();
			i=0;
		}
		
	})
	$('.updates').click(function(){
		$('.rInsert').hide();
	    $('.rUpdate').hide();
		let no=$(this).attr("value");
		if(u==0)
		{
		   $('#u'+no).show();
		   u=1;
		}
		else
		{
			$('#u'+no).hide();
			u=0;
		}
	})
})
</script>
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
                      <span class="btn btn-xs btn-info updates" value="${fvo.no }">수정</span>
                      <span class="btn btn-xs btn-success">삭제</span>
                     </c:if>
                     <span class="btn btn-xs btn-warning replys" value="${fvo.no }">댓글</span>
                    </c:if>
                  </td>
                 </tr>
                 <tr>
                   <td colspan="2">
                    <pre style="white-space: pre-wrap;background-color:white;border:none">${fvo.msg }</pre>
                   </td>
                 </tr>
               </table>
               <%-- 댓글  --%>
               <table class="table rInsert" id="m${fvo.no }" style="display:none">
		         <tr>
		           <td>
		             <form method="post" action="#">
		              <input type=hidden name=fno value="${vo.no}">
		              <textarea rows="6" cols="77" style="float: left" name="msg"></textarea>
		              <input type=submit value="댓글쓰기" 
		              style="height: 122px;background-color: blue;color:white;"
		              >
		             </form>
		           </td>
		         </tr>
		        </table>
		        <%-- 수정 --%>
		        <table class="table rUpdate" id="u${fvo.no }" style="display:none">
		         <tr>
		           <td>
		             <form method="post" action="reply_update.do">
		              <input type=hidden name=fno value="${vo.no}">
		              <input type=hidden name=no value="${fvo.no }">
		              <textarea rows="6" cols="77" style="float: left" name="msg">${fvo.msg }</textarea>
		              <input type=submit value="수정하기" 
		              style="height: 122px;background-color: blue;color:white;"
		              >
		             </form>
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
	             <form method="post" action="reply_insert.do">
	              <input type=hidden name=fno value="${vo.no}">
	              <textarea rows="6" cols="77" style="float: left" name="msg"></textarea>
	              <input type=submit value="댓글쓰기" 
	              style="height: 122px;background-color: blue;color:white;"
	              >
	             </form>
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









