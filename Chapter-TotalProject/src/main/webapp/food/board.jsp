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
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
    <h1 class="text-center">자유게시판</h1>
    <div class="row">
     <table class="table">
       <tr>
        <td>
         <button class="btn btn-sm btn-success" v-on:click="insert()">새글</button>
        </td>
       </tr>
     </table>
     <table class="table">
       <tr class="warning">
        <th width=10% class="text-center">번호</th>
        <th width=45% class="text-center">제목</th>
        <th width=15% class="text-center">이름</th>
        <th width=20% class="text-center">작성일</th>
        <th width=10% class="text-center">조회수</th>
       </tr>
       <tr v-for="vo in board_list">
        <td width=10% class="text-center">{{vo.no}}</td>
        <td width=45%><a :href="'board_detail.do?no='+vo.no">{{vo.subject}}</a></td>
        <td width=15% class="text-center">{{vo.name}}</td>
        <td width=20% class="text-center">{{vo.regdate}}</td>
        <td width=10% class="text-center">{{vo.hit}}</td>
       </tr>
     </table>
     <table class="table">
       <tr>
         <td class="text-center">
          <button class="btn btn-sm btn-danger" v-on:click="prev()">이전</button>
          {{curpage}} page / {{totalpage}} pages
          <button class="btn btn-sm btn-primary" v-on:click="next()">다음</button>
         </td>
       </tr>
     </table>
    </div>
  </div>
  <script>
    new Vue({
    	el:'.container',
    	data:{
    		board_list:[],
    		curpage:1,
    		totalpage:0
    	},
    	// 시작 => window.onload , $(function(){})
    	mounted:function(){
    		this.dataSend();
    	},
    	methods:{
    		dataSend:function(){
    			axios.get("http://localhost:8080/web/food/list_vue.do",{
        			params:{
        				page:this.curpage
        			}
    			}).then(res=>{
        			console.log(res.data);
        			this.board_list=res.data;
        			this.curpage=res.data[0].curpage;
        			this.totalpage=res.data[0].totalpage;
        		})
    		},
    		prev:function(){
    			this.curpage=this.curpage>1?this.curpage-1:this.curpage;
    			this.dataSend();
    		},
    		next:function(){
    			this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
    			this.dataSend();
    		},
    		insert:function(){
    			location.href="insert.do";
    		}
    	}
    })
  </script>
</body>
</html>










