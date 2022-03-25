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
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading inline">
           <input type=text size=20 class="input-sm" v-model="address" :value="address">
           <input type=button value="검색" class="btn btn-sm btn-primary" v-on:click="find()">
          </header>
          <ul class="nospace clear">
            <li class="one_quarter first" v-for="(vo,index) in food" v-if="index%4==0"><a :href="'../food/detail.do?no='+vo.no"><img :src="vo.poster" :title="vo.name"></a></li>
            <li class="one_quarter" v-else><a :href="'../food/detail.do?no='+vo.no"><img :src="vo.poster" :title="vo.name"></a></li>
          </ul>
          
        </figure>
      </div>
      <!-- ################################################################################################ --> 
      <!-- ################################################################################################ -->
      <!--
          VueJS 데이터 출력 => 속성 : , {{}} 
       -->
      <nav class="pagination">
        <ul>
          <li><button v-on:click="prev()">&laquo; 이전</button></li>
          <li>{{curpage}} page / {{totalpage}} pages</li>
          <li><button v-on:click="next()">다음 &raquo;</button></li>
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
		   food:[],
		   address:'강남',
		   curpage:1,
		   totalpage:0
	   },
	   mounted:function(){
		   // $(function(){}) window.onload=function()
		   // find_vue.do?page=1&addr=강남
		   // data:{page: , addr:}
		   axios.get("http://localhost:8080/web/food/find_vue.do",{
			   params:{
				   page:this.curpage,
				   addr:this.address
			   }
		   }).then(res=>{
			   console.log(res.data)
			   this.food=res.data;
			   this.curpage=res.data[0].curpage;
			   this.totalpage=res.data[0].totalpage;
		   })
	   },
	   methods:{
		   // 사용자 정의 메소드 
		   find:function(){
			   this.curpage=1;
			   axios.get("http://localhost:8080/web/food/find_vue.do",{
				   params:{
					   page:this.curpage,
					   addr:this.address
				   }
			   }).then(res=>{
				   console.log(res.data)
				   this.food=res.data;
				   this.curpage=res.data[0].curpage;
				   this.totalpage=res.data[0].totalpage;
			   })
		   },
		   prev:function(){
			   this.curpage=this.curpage>1?this.curpage-1:this.curpage;
			   axios.get("http://localhost:8080/web/food/find_vue.do",{
				   params:{
					   page:this.curpage,
					   addr:this.address
				   }
			   }).then(res=>{
				   console.log(res.data)
				   this.food=res.data;
				   this.curpage=res.data[0].curpage;
				   this.totalpage=res.data[0].totalpage;
			   })
		   },
		   next:function(){
			   this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
			   axios.get("http://localhost:8080/web/food/find_vue.do",{
				   params:{
					   page:this.curpage,
					   addr:this.address
				   }
			   }).then(res=>{
				   console.log(res.data)
				   this.food=res.data;
				   this.curpage=res.data[0].curpage;
				   this.totalpage=res.data[0].totalpage;
			   })
		   }
		   
	   }
   })
  </script>
</body>
</html>