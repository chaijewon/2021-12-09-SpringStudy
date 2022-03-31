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
  width:600px;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <div class="container">
     <h1 class="text-center">글쓰기</h1>
     <div class="row">
       <table class="table">
        <tr>
         <th width=15% class="text-right warning">이름</th>
         <td width=85%><input type=text id="name" size=15 v-model="name"></td>
        </tr>
        <tr>
         <th width=15% class="text-right warning">제목</th>
         <td width=85%><input type=text id="subject" size=50 v-model="subject"></td>
        </tr>
        <tr>
         <th width=15% class="text-right warning">내용</th>
         <td width=85%>
          <textarea rows="10" cols="55" id="content" v-model="content"></textarea>
         </td>
        </tr>
        <tr>
         <th width=15% class="text-right warning">비밀번호</th>
         <td width=85%><input type=password id="pwd" size=10 v-model="pwd"></td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
           <button class="btn btn-sm btn-info" v-on:click="write()">글쓰기</button>
           <button class="btn btn-sm btn-success" v-on:click="cancel()">취소</button>
          </td>
        </tr>
       </table>
     </div>
   </div>
   <script>
    new Vue({
    	el:'.container',
    	data:{
    		/*
    		    List => []
    		    VO => {}
    		    문자열 => ''
    		    숫자 => 0
    		    논리 => true/false
    		*/
    		name:'',
    		subject:'',
    		content:'',
    		pwd:''
    	},
    	methods:{
    		write:function(){
    			if(this.name=='')
    			{
    				let n=document.getElementById("name");
    				n.focus();
    				return;
    			}
    			if(this.subject=='')
    			{
    				let n=document.getElementById("subject");
    				n.focus();
    				return;
    			}
    			if(this.content=='')
    			{
    				let n=document.getElementById("content");
    				n.focus();
    				return;
    			}
    			if(this.pwd=='')
    			{
    				let n=document.getElementById("pwd");
    				n.focus();
    				return;
    			} 
    			
    			// 전송 서버 
    			axios.get('http://localhost:8080/web/food/insert_ok.do',{
    				params:{
    					name:this.name,
    					subject:this.subject,
    					content:this.content,
    					pwd:this.pwd
    				}
    			}).then(res=>{
    				location.href="board.do"
    				
    			})
    		},
    		cancel:function(){
    			history.back();
    		}
    	}
    })
   </script>
</body>
</html>










