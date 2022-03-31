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
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <div class="container">
     <h1 class="text-center">내용보기</h1>
     <div class="row">
      <table class="table">
        <tr>
         <th width=20% class="text-center warning">번호</th>
         <td width=30% class="text-center">{{vo.no}}</td>
         <th width=20% class="text-center warning">작성일</th>
         <td width=30% class="text-center">{{vo.regdate}}</td>
        </tr>
        <tr>
         <th width=20% class="text-center warning">이름</th>
         <td width=30% class="text-center">{{vo.name}}</td>
         <th width=20% class="text-center warning">조회수</th>
         <td width=30% class="text-center">{{vo.hit}}</td>
        </tr>
        <tr>
         <th width=20% class="text-center warning">제목</th>
         <td colspan="3">{{vo.subject}}</td>
        </tr>
        <tr>
          <td colspan="4" class="text-left" valign="top" height="200">
            <pre style="white-space: pre-wrap;background-color:white;border:none">{{vo.content}}</pre>
          </td>
        </tr>
        <tr>
         <td colspan="4" class="text-right">
           <button class="btn btn-sm btn-danger">수정</button>
           <button class="btn btn-sm btn-success">삭제</button>
           <button class="btn btn-sm btn-primary" v-on:click="list()">목록</button>
         </td>
        </tr>
      </table>
     </div>
   </div>
   <script>
   new Vue({
	   	el:'.container',
	   	data:{
	   		vo:{},
	   		no:${no}
	   	},
	   	mounted:function(){
	   		axios.get('http://localhost:8080/web/food/board_detail_vue.do',{
	   			params:{
	   				no:this.no
	   			}
	   		}).then(res=>{
	   			console.log(res.data)
	   			this.vo=res.data;
	   		})
	   	},
	   	methods:{
	   		list:function(){
	   			location.href="board.do"
	   		}
	   	}
	   })
   </script>
</body>
</html>





