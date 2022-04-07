<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="wrapper row2">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">맛집</a></li>
      <li><a href="#">맛집 추천</a></li>
    </ul>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body -->
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading">
              <button class="btn btn-sm btn-danger" v-on:click="food(1)">감성</button>
              <button class="btn btn-sm btn-success" v-on:click="food(2)">날씨/계절</button>
          </header>
          <div class="row">
            <span class="btn btn-sm btn-warning" v-for="data in recom_list" v-on:click="find(data)">{{data}}</span>
          </div>
          <div style="height: 50px"></div>
          <ul class="nospace clear">
            
            <li class="one_quarter first" v-for="(vo,index) in food_list" v-if="index%4==0"><a :href="'../food/detail.do?no='+vo.no"><img :src="vo.poster" :title="vo.name"></a></li>
            <li class="one_quarter" v-else><a :href="'../food/detail.do?no='+vo.no"><img :src="vo.poster" :title="vo.name"></a></li>

          </ul>
          
        </figure>
      </div>
      <!-- ################################################################################################ -->
      <!-- ################################################################################################ -->
       <nav class="pagination">
        <!-- class="current" -->
        <ul>
          <!-- <li><button v-on:click="prev()">이전</button></li>
          <li>{{curpage}} page / {{totalpage}} pages</li>
          <li><button v-on:click="next()">다음</button></li> -->
        </ul>
       </nav>
       
      
      <!-- ################################################################################################ -->
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
		  recom_list:[],
		  food_list:[]
	  },
	  methods:{
		  food:function(no){
			  let _this=this;
			  // .do?no=1
			  axios.get("http://localhost:8080/web/food/food_recommand_vue.do",{
				  params:{
					  no:no
				  }
			  }).then(function(res){
				  console.log(res.data);
				  _this.recom_list=res.data;
			  })
		  },
		  find:function(fd){
			  let _this=this;
			  // .do?no=1
			  axios.get("http://localhost:8080/web/food/food_find_vue.do",{
				  params:{
					  fd:fd
				  }
			  }).then(function(res){
				  console.log(res.data);
				  _this.food_list=res.data;
			  })
		  }
	  }
  })
 </script>
</body>
</html>