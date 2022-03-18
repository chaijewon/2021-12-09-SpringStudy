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
   width:800px;
}
h1{
    text-align: center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#findBtn').on("click",function(){
		let ss=$('#ss').val();
		if(ss.trim()=="")
		{
			$('#ss').focus();
			return;
		}
		$('#frm').submit();
	})
})
</script>
</head>
<body>
   <div class="container">
     <h1>자료실(Spring 이용):파일업로드/다운로드</h1>
     <div class="row">
      <table class="table">
       <tr>
        <td>
         <a href="insert.do" class="btn btn-sm btn-primary">새글</a>
        </td>
       </tr>
      </table>
      <table class="table">
        <tr class="info">
         <th width=10% class="text-center">번호</th>
         <th width=45% class="text-center">제목</th>
         <th width=15% class="text-center">이름</th>
         <th width=20% class="text-center">작성일</th>
         <th width=10% class="text-center">조회수</th>
        </tr>
        <c:set var="count" value="${count }"/>
        <c:forEach var="vo" items="${list }" varStatus="s">
           <tr ${s.index%2==1?"class=warning":"" }>
	         <td width=10% class="text-center">${count }</td>
	         <td width=45%><a href="detail.do?no=${vo.no }">${vo.subject }</a>
	           <c:if test="${vo.dbday==today }">
	            <sup style="color:red">new</sup>
	           </c:if>
	         </td>
	         <td width=15% class="text-center">${vo.name }</td>
	         <td width=20% class="text-center">${vo.dbday }</td>
	         <td width=10% class="text-center">${vo.hit }</td>
	        </tr>
	        <c:set var="count" value="${count-1 }"/>
        </c:forEach>
      </table>
      <table class="table">
        <tr>
          <td class="text-left">
           <form method="post" action="find.do" id="frm">
	           Search:<select class="input-sm" name="fs">
	              <option value="name">이름</option>
	              <option value="subject">제목</option>
	              <option value="content">내용</option>
	           </select>
	           <input type=text name=ss class="input-sm" size=15 id="ss">
	           <input type=button value="검색" class="btn btn-sm btn-danger" id="findBtn">
           </form>
          </td>
          <td class="text-right">
            <a href="list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-primary">이전</a>
            ${curpage } page / ${totalpage } pages
            <a href="list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-primary">다음</a>
          </td>
        </tr>
      </table>
     </div>
   </div>
</body>
</html>






