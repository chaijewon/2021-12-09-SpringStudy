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
<style type="text/css">
.container-fluid{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   
}
h1{
    text-align: center;
}
</style>
</head>
<body>
  <div class="container-fluid">
    <h1>서울 호텔</h1>
    <div class="row">
     <div class="col-sm-9">
      <div class="col-md-4" v-for="vo in hotel_list">
	    <div class="thumbnail">
	      <span v-on:click="detail(vo.no)">
	        <img :src="vo.poster" alt="Lights" style="width:230px;height:180px">
	        <div class="caption">
	          <p style="font-size: 8pt">{{vo.name }}</p>
	        </div>
	      </span>
	    </div>
	  </div>
	  </div>
	  <div class="col-sm-3" v-show="isopen">
	   <table class="table">
	    <tr>
	     <td class="text-center">
	      <img :src="hotel_detail.poster" style="100%">
	     </td>
	    </tr>
	    <tr>
	      <td>
	       <table class="table">
	         <tr>
	           <td v-for="i in images">
	             <img :src="i" width="100%">
	           </td>
	         </tr>
	       </table>
	      </td>
	    </tr>
	    <tr>
	      <td>{{hotel_detail.name}}
	      <span style="color:orange">{{hotel_detail.score}}</span>
	      </td>
	    </tr>
	    <tr>
	      <td>{{hotel_detail.address}}</td>
	    </tr>
	   </table>
	  </div>
    </div>
    <div class="row">
      <div class="text-center">
       <input type=button class="btn btn-sm btn-danger" 
       value="이전" v-on:click="prev()">
       {{curpage}} page / {{totalpage}} pages
       <input type=button class="btn btn-sm btn-danger"
       value="다음" v-on:click="next()">
      </div>
    </div>
  </div>
  <script>
  new Vue({
	   el:'.container-fluid',
	   data:{
		   curpage:1,
		   totalpage:0,
		   hotel_list:[],
		   hotel_detail:{},
		   isopen:false,
		   images:[]
	   },
	   mounted:function(){
		   axios.get('http://localhost:8080/web/hotel/list.do',{
			   params:{
				   page:this.curpage
			   }
		   }).then(result=>{
			   console.log(result.data);
			   this.hotel_list=result.data;
			   this.curpage=result.data[0].curpage;
			   this.totalpage=result.data[0].totalpage;
		   })
	   },
	   methods:{
		   prev:function(){
			   this.curpage=this.curpage>1?this.curpage-1:this.curpage;
			   axios.get('http://localhost:8080/web/hotel/list.do',{
				   params:{
					   page:this.curpage
				   }
			   }).then(result=>{
				   console.log(result.data);
				   this.hotel_list=result.data;
				   this.curpage=result.data[0].curpage;
				   this.totalpage=result.data[0].totalpage;
			   })
		   },
		   next:function(){
			   this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
			   axios.get('http://localhost:8080/web/hotel/list.do',{
				   params:{
					   page:this.curpage
				   }
			   }).then(result=>{
				   console.log(result.data);
				   this.hotel_list=result.data;
				   this.curpage=result.data[0].curpage;
				   this.totalpage=result.data[0].totalpage;
			   })
		   },
		   detail:function(no){
			   this.isopen=true;
			   axios.get('http://localhost:8080/web/hotel/detail2.do',{
				   params:{
					   no:no
				   }
			   }).then(result=>{
				   console.log(result.data)
				   this.hotel_detail=result.data;
				   this.images=this.hotel_detail.images.split("^");
			   })
		   }
	   }
  })
  </script>
</body>
</html>






