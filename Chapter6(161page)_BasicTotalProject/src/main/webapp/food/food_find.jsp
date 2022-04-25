<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width:960px;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
    <div class="row">
     <table class="table">
       <tr>
        <td>
         <input type=text size="15" class="input-sm">
         <input type=button value="검색" class="btn btn-sm btn-danger">
        </td>
       </tr>
     </table>
     <div style="height: 30px"></div>
        <div class="col-md-3" v-for="vo in food_list">
		    <div class="thumbnail">
		      <a href="#">
		        <img :src="vo.poster" alt="Lights" style="width:230px;height:180px">
		        <div class="caption">
		          <p style="font-size: 8px">{{vo.title }}</p>
		        </div>
		      </a>
		    </div>
		  </div>
    </div>
    <div class="row">
      <div class="text-center">
        <ul class="pagination">
          <li><button v-if="startPage>1">&lt;</button></li>
          
           <li class="active"><button v-for="i in endPage">{{i}}</button></li>
         
		  
		  <li><button v-for="i in endPage">{{i}}</button></li>
		  
		  <li><button v-if="endPage<totalpage" v-on:click="next()">&gt;</button></li>
		</ul>
      </div>
    </div>
  </div>
  <script>
   new Vue({
	   el:'.container',
	   data:{
		   food_list:[],
		   curpage:1,
		   totalpage:0,
		   startPage:0,
		   endPage:0,
		   fd:''
	   },
	   mounted:function(){
		   axios.get('http://localhost:8080/web/food_js/food_find.do',{
			   params:{
				   page:this.curpage
			   }
		   }).then(response=>{
			   console.log(response.data)
			   this.food_list=response.data;
			   this.curpage=response.data[0].curpage;
			   this.totalpage=response.data[0].totalpage;
			   this.startPage=response.data[0].startPage;
			   this.endPage=response.data[0].endPage;
		   })
	   },
		   methods:{
			   //this.curpage=this.endPage<this.totalpage?this.endPage+1
			   next:function(){
				   axios.get('http://localhost:8080/web/food_js/food_find.do',{
					   params:{
						   page:this.endPage+1
					   }
				   }).then(response=>{
					   console.log(response.data)
					   this.food_list=response.data;
					   this.curpage=response.data[0].curpage;
					   this.totalpage=response.data[0].totalpage;
					   this.startPage=response.data[0].startPage;
					   this.endPage=response.data[0].endPage;
				   })
			   }
		   }
	   
   })
  </script>
</body>
</html>