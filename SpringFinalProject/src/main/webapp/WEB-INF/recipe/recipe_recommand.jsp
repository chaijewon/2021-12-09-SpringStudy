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
      <li><a href="#">레시피</a></li>
      <li><a href="#">레시피 추천</a></li>
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
              <button class="btn btn-sm btn-danger" v-on:click="recipe(1)">종류별</button>
              <button class="btn btn-sm btn-success" v-on:click="recipe(2)">상황별</button>
              <button class="btn btn-sm btn-info" v-on:click="recipe(3)">재료별</button>
              <button class="btn btn-sm btn-warning" v-on:click="recipe(4)">방법별</button>
              <button class="btn btn-sm btn-primary" v-on:click="recipe(5)">테마별</button>
          </header>
          <div class="row">
            <span class="btn btn-sm btn-warning" v-for="data in recom_list" v-on:click="find(data)">{{data}}</span>
          </div>
          <div style="height: 50px"></div>
          <ul class="nospace clear">
            
            <li class="one_quarter first" v-for="(vo,index) in recipe_list" v-if="index%4==0"><a :href="'../recipe/detail.do?no='+vo.no"><img :src="vo.poster" :title="vo.title"></a></li>
            <li class="one_quarter" v-else><a :href="'../recipe/detail.do?no='+vo.no"><img :src="vo.poster" :title="vo.title"></a></li>

          </ul>
          
        </figure>
      </div>
      <!-- ################################################################################################ -->
      <!-- ################################################################################################ -->
       <nav class="pagination">
        <!-- class="current" -->
        <ul>
          <li><button v-on:click="prev()">이전</button></li>
          <li>{{curpage}} page / {{totalpage}} pages</li>
          <li><button v-on:click="next()">다음</button></li>
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
		fd:'',
		no:1,
		recipe_list:[],
		curpage:1,
		totalpage:0
	},
	mounted:function(){
		let _this=this;
		axios.get("http://localhost:8080/web/recipe/recipe_recommand_vue.do",{
			params:{
				no:_this.no
			}
		}).then(function(res){
			console.log(res)
			console.log(res.data); // res= header , config , data
			_this.recom_list=res.data;
		})
	},
	methods:{
		recipe:function(no){
			let _this=this;
			axios.get("http://localhost:8080/web/recipe/recipe_recommand_vue.do",{
				params:{
					no:no
				}
			}).then(function(res){
				console.log(res)
				console.log(res.data); // res= header , config , data
				_this.recom_list=res.data;
			})
		},
		find:function(fd){
			this.fd=fd;
			this.curpage=1;
			//alert(this.fd);
			let _this=this;
			axios.get("http://localhost:8080/web/recipe/recipe_recom_data_vue.do",{
				params:{
					fd:fd,
					page:_this.curpage
				}
			}).then(function(res){
				console.log(res)
				console.log(res.data); // res= header , config , data
				_this.recipe_list=res.data;
				_this.curpage=res.data[0].curpage;
				_this.totalpage=res.data[0].totalpage
			})
		},
		prev:function(){
			this.curpage=this.curpage>1?this.curpage-1:this.curpage;
			let _this=this;
			axios.get("http://localhost:8080/web/recipe/recipe_recom_data_vue.do",{
				params:{
					fd:_this.fd,
					page:_this.curpage
				}
			}).then(function(res){
				console.log(res)
				console.log(res.data); // res= header , config , data
				_this.recipe_list=res.data;
				_this.curpage=res.data[0].curpage;
				_this.totalpage=res.data[0].totalpage
			})
		},
		next:function(){
			this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
			let _this=this;
			axios.get("http://localhost:8080/web/recipe/recipe_recom_data_vue.do",{
				params:{
					fd:_this.fd,
					page:_this.curpage
				}
			}).then(function(res){
				console.log(res)
				console.log(res.data); // res= header , config , data
				_this.recipe_list=res.data;
				_this.curpage=res.data[0].curpage;
				_this.totalpage=res.data[0].totalpage
			})
		}
		
		
		
	}
  })
 </script>
</body>
</html>