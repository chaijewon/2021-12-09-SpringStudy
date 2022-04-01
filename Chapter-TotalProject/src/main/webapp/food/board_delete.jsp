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
  width:350px;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <div class="container">
     <h1 class="text-center">삭제하기</h1>
     <div class="row">
      <table class="table">
        <tr>
          <td class="text-center">
           비밀번호 : <input type=password id="pwd" size=15 class="input-sm"
              v-model="pwd">
          </td>
        </tr>
        <tr>
          <td class="text-center">
            <button class="btn btn-sm btn-danger" v-on:click="del()">삭제</button>
            <button class="btn btn-sm btn-primary" v-on:click="cancel()">취소</button>
          </td>
        </tr>
      </table>
     </div>
   </div>
   <script>
    new Vue({
    	el:'.container',
    	data:{
    		pwd:'',
    		no:${no},
    		msg:''
    	},
    	methods:{
    		cancel:function(){
    			history.back();
    		},
    		del:function(){
    			let _this=this;
    			if(this.pwd=="")
    			{
    				// 유효성 검사 
    				let p=document.getEelementById("pwd");
    				p.focus();
    				return;
    			}
    			// 서버로 값을 전송 
    			axios.get('http://localhost:8080/web/food/board_delete_ok.do',{
    				// 요청 데이터를 전송하는 영역
    				params:{
    					no:this.no,
    					pwd:this.pwd
    				}
    			// success:function(res)
    			}).then(function(res){
    				console.log(res.data);
    				_this.msg=res.data //YES/NO
    				// function을 사용하면 => this(axios) , => (this는 Vue)
    				if(_this.msg=="YES")
    				{
    					// 이동 => 목록으로 이동 
    					location.href="board.do"; // sendRedirect
    				}
    				else
    				{
    					alert("비밀번호가 틀립니다!!")
    					let i=document.getElementById("pwd");
    					_this.pwd="";
    					i.focus();
    				}
    			})
    		}
    	}
    })
   </script>
</body>
</html>





