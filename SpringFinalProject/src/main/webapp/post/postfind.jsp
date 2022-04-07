<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
 <div id="app">
  우편번호:<input type=text size=15 v-model="post" :value="post">
 <button v-on:click="postfind()">검색</button>
 <p>
  주소<input type=text size=50 v-model="address" :value="address">
  <p>
   주소<input type=text size=50 v-model="address1" :value="address1">
 </div>
 <script>
  new Vue({
	  el:'#app',
	  data:{
		  post:'',
		  address:'',
		  address1:''
	  },
	  methods:{
		  postfind:function() {
		      new window.daum.Postcode({
		        oncomplete: (data) => {
		          
		          this.post = data.zonecode;
		          this.address= data.roadAddress;
		        },
		      }).open();
		  }
		   
	  }
  })
 </script>
</body>
</html>