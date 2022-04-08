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
  width:650px;
}
</style>
</head>
<body>
<div class="wrapper row2">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">서울 명소</a></li>
      <li><a href="#">상세보기</a></li>
    </ul>
    <!-- ################################################################################################ -->
  </div>
 </div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear">
   <table class="table">
    <tr>
     <td class="text-center">
      <img src="${vo.poster }" style="width:100%">
     </td>
    </tr>
    <tr>
      <td class="text-center"><h3>${vo.title}</h3></td>
    </tr>
    <tr>
      <td class="text-center">${vo.msg }</td>
    </tr>
    <tr>
      <td class="text-center">${vo.address }</td>
    </tr>
    <tr>
      <td>
       <div id="map" style="width:100%;height:350px;"></div>

		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=676eb5fa2637b234997b24dd7566e9ba&libraries=services"></script>
		<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
		
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch('${address}', function(result, status) {
		
		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
		
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });
		
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;color:black">${vo.title}</div>'
		        });
		        infowindow.open(map, marker);
		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
		</script>
      </td>
    </tr>
   </table>
   <h3>인근 맛집</h3>
   <hr>
   <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          
          <ul class="nospace clear">
           <c:forEach var="fvo" items="${fList }" varStatus="s">
            <c:if test="${s.index%4==0 }">
              <li class="one_quarter first"><a href="../food/detail.do?no=${fvo.no }"><img src="${fvo.poster }"  title="${fvo.name }" style="width:300px;height:300px"></a></li>
            </c:if>
            <c:if test="${s.index%4!=0 }">
              <li class="one_quarter"><a href="../food/detail.do?no=${fvo.no }"><img src="${fvo.poster }" title="${fvo.name }" style="width:300px;height:300px"></a></li>
            </c:if>
           </c:forEach>
            
          </ul>
          
        </figure>
      </div>
  </main>
</div>
</body>
</html>


