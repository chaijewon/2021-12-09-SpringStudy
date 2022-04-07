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
<div class="wrapper">
  <div id="slider" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="flexslider basicslider">
      <ul class="slides">
        <li><img src="../images/demo/slides/01.jpg" alt="" style="width:1950px;height: 650px">
          <%-- <div class="txtoverlay">
            <div class="centralise">
              <div class="verticalwrap">
                <article>
                  <h2 class="heading uppercase">ivamus commodo mi a lobortis ultrices</h2>
                  <p><a class="btn orange pushright" href="#">Leo facilisis odio</a> <a class="btn red" href="#">Quis mollis nibh dolor</a></p>
                </article>
              </div>
            </div>
          </div>--%>
        </li>
        <li><img src="../images/demo/slides/02.jpg" alt="" style="width:1950px;height: 650px">
          <%--<div class="txtoverlay">
            <div class="centralise">
              <div class="verticalwrap">
                <article>
                  <h2 class="heading uppercase">Curabitur ullamcorper malesuada tempor</h2>
                  <p><a class="btn red" href="#">Suspendisse lobortis mauris</a></p>
                </article>
              </div>
            </div>
          </div>--%>
        </li>
        <li><img src="../images/demo/slides/03.jpg" alt="" style="width:1950px;height: 650px">
          <%--<div class="txtoverlay">
            <div class="centralise">
              <div class="verticalwrap">
                <article>
                  <h2 class="heading uppercase">Fusce in nisi auctor imperdiet quam quis</h2>
                  <p><a class="btn orange pushright" href="#">Integer posuere arcu nec</a> <a class="btn red" href="#">Odio sollicitudin sagittis</a></p>
                </article>
              </div>
            </div>
          </div>--%>
        </li>
      </ul>
    </div>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row2">
  <div id="services" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="group">
      <div class="one_third first">
        <article class="service"><i class="icon red circle fa fa-bell-o"></i>
          <h2 class="heading">서울 명소</h2>
          <p class="btmspace-10">놓칠 수 없는 서울의 명소</p>
          <p><a href="../seoul/location.do">Read More &raquo;</a></p>
        </article>
      </div>
      <div class="one_third">
        <article class="service"><i class="icon orange circle fa fa-bicycle"></i>
          <h2 class="heading">서울 자연/관광</h2>
          <p class="btmspace-10">멀리 가지 않아도 도심 속에서 느낄 수 있는 자연의 힐링</p>
          <p><a href="../seoul/nature.do">Read More &raquo;</a></p>
        </article>
      </div>
      <div class="one_third">
        <article class="service"><i class="icon green circle fa fa-mortar-board"></i>
          <h2 class="heading">서울 호텔</h2>
          <p class="btmspace-10">잠드는 순간에도 특별한 경험을 원하는 여행객 모두를 위한 서울의 호텔</p>
          <p><a href="../seoul/hotel.do">Read More &raquo;</a></p>
        </article>
      </div>
    </div>
    <!-- ################################################################################################ -->
    <div class="clear"></div>
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row6">
  <section id="cta" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="three_quarter first">
      <h2 class="heading">오늘의 레시피</p>
    </div>
    <!-- ################################################################################################ -->
  </section>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row2">
  <div class="latest"> 
    <!-- ################################################################################################ -->
    <ul class="nospace group">
      <c:forEach var="vo" items="${list }">
        <li>
	        <figure><a class="overlay" href="#"><img src="${vo.poster }" style="width:380px;height: 380px"></a>
	          <figcaption class="inspace-30 center">
	            <p class="bold uppercase">${vo.title }</p>
	            <p><a href="../recipe/detail.do?no=${vo.no }">상세보기 &raquo;</a></p>
	          </figcaption>
	        </figure>
	      </li>
      </c:forEach>
      
      
    </ul>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container nospace clear"> 
    <!-- main body -->
    <!-- ################################################################################################ -->
    <div class="group">
      <div class="one_half first paditout">
        <h2 class="heading uppercase btmspace-50">오늘의 뮤직</h2>
        <ul class="nospace group">
          <li class="btmspace-30">
            <article class="service largeicon"><i class="icon nobg circle fa fa-ra"></i>
              <h6 class="heading"><a href="#">노래명</a></h6>
              <p>봄여름가을겨울 (Still Life)</p>
            </article>
          </li>
          <li class="btmspace-30">
            <article class="service largeicon"><i class="icon nobg circle fa fa-female"></i>
              <h6 class="heading"><a href="#">가수명</a></h6>
              <p>BIGBANG (빅뱅)</p>
            </article>
          </li>
          <li>
            <article class="service largeicon"><i class="icon nobg circle fa fa-history"></i>
              <h6 class="heading"><a href="#">앨범명</a></h6>
              <p>봄여름가을겨울 (Still Life)</p>
            </article>
          </li>
        </ul>
      </div>
      <div class="one_half">
        <iframe src="http://youtube.com/embed/eN5mG_yMDiM" width=500 height="600"></iframe>
      </div>
    </div>
    <!-- ################################################################################################ -->
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
</body>
</html>