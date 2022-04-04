<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row2">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">레시피</a></li>
      <li><a href="#">레시피 리스트</a></li>
      <li><a href="#">레시피 상세보기</a></li>
    </ul>
    <!-- ################################################################################################ -->
  </div>
</div>
<div class="wrapper row3">
  <main class="container clear"> 
    <table>
     <tr>
      <td align=center>
       <img src="${vo.poster }" style="width: 800px;height:350px">
      </td>
     </tr>
     <tr>
       <td align=center>${vo.chef }</td>
     </tr>
     <tr>
       <td align=center><h3>${vo.title }</h3></td>
     </tr>
     <tr>
       <td align=center>${vo.content }</td>
     </tr>
    </table>
    <table>
      <tr>
        <td align=center><img src="../images/demo/project_image/info1.png"></td>
        <td align=center><img src="../images/demo/project_image/info2.png"></td>
        <td align=center><img src="../images/demo/project_image/info3.png"></td>
      </tr>
      <tr>
        <td align=center>${vo.info1 }</td>
        <td align=center>${vo.info2 }</td>
        <td align=center>${vo.info3 }</td>
      </tr>
    </table>
    <table>
      <caption><h3>재료</h3></caption>
      <c:forTokens var="d" items="${vo.etc }" delims=",">
       <tr>
         <td>${d }</td>
       </tr>
      </c:forTokens>
    </table>
    <table>
      <caption><h3>조리순서</h3></caption>
      <tr>
       <td>
        <c:forEach var="d" items="${mList }" varStatus="s">
          <table>
           <tr>
             <td width=70%>${d }</td>
             <td width=30% align=center>
              <img src="${pList[s.index]}" style="width: 250px;height: 130px">
             </td>
           </tr>
          </table>
        </c:forEach>
       </td>
      </tr>
    </table>
    <table>
      <caption><h3>레시피 작성자</h3></caption>
      <tr>
        <td width=30% align=center rowspan="2">
         <img src="${vo.chef_poster }" style="width:120px;height: 120px">
        </td>
        <td width=70%>${vo.chef }</td>
      </tr>
      <tr>
        <td width=70%>${vo.chef_profile }</td>
      </tr>
    </table>
  </main>
</div>
</body>
</html>








