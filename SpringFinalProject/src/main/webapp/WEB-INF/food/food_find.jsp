<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../images/demo/food.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
$(function(){
	$('.images').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","none")
	})
	
	$('.images').click(function(){
		let gu=$(this).attr("data-value");
		for(let i=1;i<=25;i++)
		{
			$('#gu'+i).attr("src","../images/demo/map/gu_"+i+"_off.png")
		}
		$(this).attr("src","../images/demo/map/gu_"+gu+"_on.png")
		
		$.ajax({
			type:'get',
			url:'../food/food_find_result.do',
			data:{"gu":gu},
			success:function(res) // then(function(res)) axios
			{
				$('.content').html(res);
			}
		})
	})
	
})
</script>
</head>
<body>
<div class="wrapper row2">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">맛집</a></li>
      <li><a href="#">맛집 목록</a></li>
      <li><a href="#">맛집 찾기</a></li>
    </ul>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row2">
  <div id="a">
    <img id="seoul_1" src="../images/demo/map/1111.png">
    <c:forEach var="i" begin="1" end="25">
     <%-- <img id="gu${i }" src="../images/demo/map/gu_${i }_off.png"
      onmouseover="this.src='../images/demo/map/gu_${i }_on.png'"
      onmouseout="this.src='../images/demo/map/gu_${i }_off.png'"
      class="images" data-value="${i }"
     > --%>
     <img id="gu${i }" src="../images/demo/map/gu_${i }_off.png"
      class="images" data-value="${i }"
     >
    </c:forEach>
  </div>
</div>
<div class="wrapper row3">
  <main class="container clear"> 
    <div class="content"> 
    
    </div>
  </main>
</div>
</body>
</html>