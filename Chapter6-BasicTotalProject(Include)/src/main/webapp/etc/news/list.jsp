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
  <div class="container" id="app">
   <h1 class="text-center">네이버 뉴스</h1>
   <div class="row">
    <table class="table">
     <tr>
      <td>
       <input type=text size="20" class="input-sm">
       <input type=button value="검색" class="btn btn-sm btn-primary">
      </td>
     </tr>
    </table>
    <table class="table">
      <tr>
       <td>
         <table class="table" v-for="vo in news_data">
          <tr>
           <td><span style="color:orange">{{vo.title}}</span></td>
          </tr>
          <tr>
           <td>{{vo.description}}</td>
          </tr>
          <tr>
           <td class="text-right">{{vo.author}}</td>
          </tr>
         </table>
       </td>
      </tr>
    </table>
   </div>
  </div>
  <script>
   new Vue({
	   el:'#app',
	   data:{
		   news_data:[],
		   fd:'영화'
	   },
	   mounted:function(){
		   axios.get("http://localhost:8080/main/etc/news/news_data.do",{
			   params:{
				   fd:this.fd
			   }
		   }).then(result=>{
			   this.news_data=result.data
			   console.log(result.data)
		   })
	   }
	   
   })
  </script>
</body>
</html>


