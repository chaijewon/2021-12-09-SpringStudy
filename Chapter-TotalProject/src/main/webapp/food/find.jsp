<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width:960px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      Search:<input type=text size=20 class="input-sm" v-model="ss"
             :value="ss">
             <input type=button class="btn btn-sm btn-danger"
              value="검색" v-on:click="find()">
    </div>
    <div class="row">
      <div class="col-sm-8">
        
      </div>
      <div class="col-sm-4">
      
      </div>
    </div>
  </div>
  <script>
    new Vue({
    	el:'.container',
    	data:{
    		find_list:[],
    		ss:'',
    		curpage:1,
    		totalpage:0,
    		detail:{}
    	},
    	methods:{
    		find:function(){
    			
    		}
    	}
    })
  </script>
</body>
</html>









