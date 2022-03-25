<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
 <div class="wrapper row3">
  <main class="container clear"> 
    <table class="table">
     <tr>
      <td class="text-center" v-for="img in images">
       <img :src="img" width="100%">
      </td>
     </tr>
    </table>
    <table class="table">
      <tr>
        <td colspan="2"><h4>{{food_detail.name}}&nbsp;
         <span style="color:orange">{{food_detail.score}}</span></h4></td>
      </tr>
      <tr>
        <td width=10% style="color:gray">주소</td>
        <td width=90%>{{food_detail.address}}</td>
      </tr>
      <tr>
        <td width=10% style="color:gray">전화</td>
        <td width=90%>{{food_detail.tel}}</td>
      </tr>
      <tr>
        <td width=10% style="color:gray">음식종류</td>
        <td width=90%>{{food_detail.type}}</td>
      </tr>
      <tr>
        <td width=10% style="color:gray">주차</td>
        <td width=90%>{{food_detail.parking}}</td>
      </tr>
      <tr>
        <td width=10% style="color:gray">영업시간</td>
        <td width=90%>{{food_detail.time}}</td>
      </tr>
      <tr>
        <td width=10% style="color:gray">메뉴</td>
        <td width=90%>{{food_detail.menu}}</td>
      </tr>
      <tr>
        <td><a href="javascript:history.back()">목록</a></td>
      </tr>
    </table>
  </main>
 </div>
 <%--
       class A
       {
          B b=new B(){
             this(B)
          }
          A()
          {
             this(A)
          }
       }
       class B
       {
          
       }
  --%>
 <script>
   new Vue({
	   el:'.container',
	   data:{
		   no:${no},
		   food_detail:{}, //VO => []
		   images:[]
	   },
	   // ?no=
	   mounted:function(){
		   
		   axios.get("http://localhost:8080/web/food/detail_vue.do",{
			   params:{
				   no:this.no
			   }
		   }).then(result=>{
			   this.food_detail=result.data;
			   this.images=result.data.poster.split("^");
		   })
	   }
   })
 </script>
</body>
</html>