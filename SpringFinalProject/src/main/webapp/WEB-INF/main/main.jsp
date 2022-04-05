<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('div#chat').toggleClass('active');
	var $win = $(window);
	var top = $(window).scrollTop(); // 현재 스크롤바의위치값을 반환합니다.
	
	/*사용자 설정 값 시작*/
	var speed          = 1000;     // 따라다닐 속도 : "slow", "normal", or "fast" or numeric(단위:msec)
	var easing         = 'linear'; // 따라다니는 방법 기본 두가지 linear, swing
	var $layer         = $('div#chat_container'); // 레이어셀렉팅
	var layerTopOffset = 0;   // 레이어 높이 상한선, 단위:px
	$layer.css('position', 'absolute');
	/*사용자 설정 값 끝*/
	
	// 스크롤 바를 내린 상태에서 리프레시 했을 경우를 위해
	if (top > 0 )
	  $win.scrollTop(layerTopOffset+top);
	else
	  $win.scrollTop(0);
	
	//스크롤이벤트가 발생하면
	$(window).scroll(function(){
	
	  var yPosition = $win.scrollTop()+300;
	  if (yPosition< 0)
	  {
	    yPosition = $win.scrollTop()+300;
	  }
	  $layer.animate({"top":yPosition }, {duration:speed, easing:easing, queue:false});
	});
})
	

</script>
<link href="../layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<style type="text/css">
div#chat_container{
    position: absolute;
    bottom: 0;
    right: 10px;
    width: 270px;
    height: 310px;
    overflow: hidden;
    z-index: 1000;
    /*top:300px;*/
}
div#chat{
    position: absolute;
    bottom: 0;
    right: 10px;
    width: 250px;
    height: 300px;
    background-color: #efefef;
    box-shadow: 0px 0px 7px rgba(0, 0, 0, 0.25);
    transition:transform 300ms;
}

div#chat.active{transform: translateY(271px);}
div#chat header{
    width: 100%;
    height: auto;
    background-color: #FDCE6E;
    cursor: pointer;
}
div#chat header h1{
    font-family: 'Roboto Slab', sans-serif;
    color: white;
    font-size: 16px;
    text-align: left;
    whidth: 100%;
    margin: 0;
    padding: 3px 0 3px 20px;
}
div#chat section.content{
    overflow:scroll;
    background-color: #ffe1e1;
    position:absolute;
    top:29px;
    left: 0;
    right: 0;
    bottom:0;
}
div#chat form{
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 40px;
    background-color: white;
}
div#chat form input{
    display: block;
    width: 90%;
    height: 30px;
    border: none;
    line-height: 30px;
    margin: 5px auto;
    border-botom: 1px solid #303030;
    background-color: white;
    font-size: 16px;
}
div#chat form a{}

/* Experience digital logo */
#Provided_by{
    position:fixed;
    bottom: 20px;
    left:70px;
    color: #424242;
    text-decoration: none;
    font-family: sans-serif;
    margin-top: -20px;
    font-weight: 200;
}
#Provided_by img{
    position: absolute;
    bottom: -8px;
    width: 40px;
    left: -50px;
}
</style>
</head>
<body id="top">
<tiles:insertAttribute name="header"/>
<%--
    <jsp:include page="/WEB-INF/main/header.jsp">
 --%>
<tiles:insertAttribute name="content"/>
<tiles:insertAttribute name="footer"/>

<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS -->
<script src="../layout/scripts/jquery.min.js"></script>
<script src="../layout/scripts/jquery.backtotop.js"></script>
<script src="../layout/scripts/jquery.mobilemenu.js"></script>
<script src="../layout/scripts/jquery.flexslider-min.js"></script>
       <div id="chat_container">
          <div id="chat" class="active">
              <header><h1>Chat</h1></header>
              <section class="content">
                  <div class="message_content">
                      
                  </div>
              </section>
              <form>
                <input type="text" id="input_chat"
                  
                />
            </form>
          </div>
       </div>
</body>
</html>