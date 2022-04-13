<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  <script>
  $( function() {
    /* $( "#dialog" ).dialog(); */
    $('.posters').hover(function(){
    	$(this).css("cursor","pointer")
    },function(){
    	$(this).css("cursor","")
    })
    
    // 포스터 클릭시 처리 
    $('.posters').click(function(){
    	let no=$(this).attr("data-no");
    	$.ajax({
    		type:'post',
    		url:'/music_ajax',
    		data:{"no":no},
    		success:function(res)
    		{
    			console.log(res);
    			//let json=JSON.parse(res);
    			$('#music').attr("src","http://youtube.com/embed/"+res.mkey)
    			$('#title').text(res.title);
    			$('#singer').text(res.singer);
    			$('#album').text(res.album)
    			
    			$('#dialog').dialog({
    				autoOpen:false,
    				width:500,
    				height:530,
    				modal:true
    			}).dialog("open");
    		}
    	})
    })
  });
  </script>
</head>
<body>
   <div class="row">
     <div class="text-center">
       <a href="/genre_music?cno=2" class="btn btn-sm btn-danger">가요</a>
       <a href="/genre_music?cno=3" class="btn btn-sm btn-success">POP</a>
       <a href="/genre_music?cno=4" class="btn btn-sm btn-info">OST</a>
       <a href="/genre_music?cno=5" class="btn btn-sm btn-warning">트롯</a>
       <a href="/genre_music?cno=6" class="btn btn-sm btn-primary">JAZZ</a>
     </div>
   </div>
   <div style="height: 30px"></div>
   <div class="row">
     <c:forEach var="vo" items="${list }">
       <div class="col-md-3">
		    <div class="thumbnail">
		        <img src="${vo.poster }" style="width:100%" class="posters" data-no="${vo.no }">
		        <div class="caption">
		          <p style="font-size: 8px">${vo.title }</p>
		        </div>
		    </div>
		  </div>
     </c:forEach>
     <div id="dialog" title="동영상" style="display:none">
      <table class="table">
        <tr>
          <td colspan="2">
            <iframe src="" style="width:450px;height:300px" id="music"></iframe>
          </td>
        </tr>
        <tr>
          <td width=20% class="text-right">곡명</td>
          <td width=80% id="title"></td>
        </tr>
        <tr>
          <td width=20% class="text-right">가수명</td>
          <td width=80% id="singer"></td>
        </tr>
        <tr>
          <td width=20% class="text-right">앨범</td>
          <td width=80% id="album"></td>
        </tr>
      </table>
     </div>
   </div>
   <div class="row">
     <div class="text-center">
       <ul class="pagination">
         <c:forEach var="i" begin="1" end="5">
           <c:if test="${i==curpage }">
		    <li class="active"><a href="/genre_music?page=${i }&cno=${cno}">${i }</a></li>
		   </c:if>
		   <c:if test="${i!=curpage }">
		    <li><a href="/genre_music?page=${i }&cno=${cno}">${i }</a></li>
		   </c:if>
         </c:forEach>
          
		</ul>
     </div>
   </div>
</body>
</html>
