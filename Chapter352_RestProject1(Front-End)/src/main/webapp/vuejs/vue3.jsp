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
  <div id="app1">
   <h1>{{name}}</h1>
   <h1>{{age}}</h1>
   <h1>{{sex}}</h1>
  </div>
  <hr>
  <div id="app2">
   <h1>{{name}}</h1>
   <h1>{{age}}</h1>
   <h1>{{sex}}</h1>
  </div>
  <script>
    new Vue({
    	el:'#app1',
    	data:{
    		name:'홍길동',
    		age:25,
    		sex:'남자'
    	}
    })
    new Vue({
    	el:'#app2',
    	data:{
    		name:'심청이',
    		age:20,
    		sex:'여자'
    	}
    })
  </script>
</body>
</html>