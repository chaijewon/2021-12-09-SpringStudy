<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
     <ul>
      <li><button v-on:click="change(1)">박스오피스</button></li>
      <li><button v-on:click="change(2)">실시간 예매율</button></li>
      <li><button v-on:click="change(3)">좌석 점유율</button></li>
      <li><button v-on:click="change(4)">온라인 이용순위</button></li>
     </ul>
    <!-- ################################################################################################ --> 
   </div>
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading">{{title}}</header>
          <ul class="nospace clear">
            <li class="one_quarter first" v-for="(vo,index) in movie_list" v-if="index%4==0"><a href="#"><img :src="'https://www.kobis.or.kr'+vo.thumbUrl" style="width:100%"></a></li>
            
            <li class="one_quarter" v-else><a href="#"><img :src="'https://www.kobis.or.kr'+vo.thumbUrl" style="width:100%"></a></li>
            
          </ul>
          
        </figure>
      </div>
      </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
 <script>
   new Vue({
	   el:'.container',
	   data:{
		   movie_list:[],
		   title:'',
		   no:1
	   },
	   methods:{
		   change:function(index){
			   switch(index)
			   {
			   case 1:
				   this.title="박스오피스";
				   break;
			   case 2:
				   this.title="실시간 예매율";
				   break;
			   case 3:
				   this.title="좌석 점유율";
				   break;
			   case 4:
				   this.title="온라인 이용순위";
				   break;
			   }
			   // 데이터 읽기
			   // https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do
			   //searchMainDailyBoxOffice.do
			   //searchMainRealTicket.do
			   //searchMainDailySeatTicket.do
			   //searchMainOnlineDailyBoxOffice.do
			   axios.get("http://localhost:8080/web/movie/movie_vue.do",{
				   params:{
					   no:index
				   }
			   })
			   .then(result=>{
				   console.log(result.data);
				   this.movie_list=result.data
			   })
		   }
		   
	   }
   })
 </script>
</body>
</html>