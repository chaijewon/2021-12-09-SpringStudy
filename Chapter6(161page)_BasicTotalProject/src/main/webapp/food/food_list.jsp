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
  width:800px;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <div class="container">
    <div class="jumbotron">
      <h3 class="text-center">{{category_vo.title}}</h3>
      <h4 class="text-center">{{category_vo.subject}}</h4>
    </div>
    <div class="row">
      <table class="table">
        <tr>
          <td>
            <table class="table" v-for="vo in food_list">
             <tr>
               <td class="text-center" width=30% rowspan="4">
                 <img :src="vo.poster" style="width: 240px;height: 200px">
                 
               </td>
               <td width=70%>{{vo.name}}&nbsp;<span style="color:orange">{{vo.score}}</span></td>
             </tr>
             <tr>
               <td width=70%>주소:{{vo.address}}</td>
             </tr>
             <tr>
               <td width=70%>전화:{{vo.tel}}</td>
             </tr>
             <tr>
               <td width=70%>음식종류:{{vo.type}}</td>
             </tr>
            </table>
          </td>
        </tr>
      </table>
    </div>
   </div>
   <!-- VueJS 제어 -->
   <script>
     new Vue({
    	 el:'.container',
    	 data:{
    		 // 멤버변수 
    		 food_list:[],
    		 category_vo:{},
    		 cno:${cno}
    	 },
    	 // 브라우저 시작 : window.onload , jquery:$(function())
    	 mounted:function(){
    		 axios.get("http://localhost:8080/web/food_js/food_info.do",{
    			 // 데이터 전송 
    			 params:{
    				 cno:this.cno
    			 }
    		 }).then(response=>{
    			 console.log(response.data)
    			 this.category_vo=response.data
    		 })
    		 // food_list.do?no=1
    		 axios.get("http://localhost:8080/web/food_js/food_list.do",{
    			 params:{
    				 cno:this.cno
    			 }
    		 }).then(response=>{
    			 console.log(response.data)
    			 this.food_list=response.data
    		 })
    	 }
     })
   </script>
</body>
</html>









