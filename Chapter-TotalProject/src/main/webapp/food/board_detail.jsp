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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['사용단어', '사용횟수'],
          ['Work',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    7]
        ]);

        var options = {
          title: '내용분석',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
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
           <button class="btn btn-sm btn-danger" v-on:click="update()">수정</button>
           <button class="btn btn-sm btn-success" v-on:click="del()">삭제</button>
           <button class="btn btn-sm btn-primary" v-on:click="list()">목록</button>
         </td>
        </tr>
      </table>
     </div>
     <div class="row">
       <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
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
	   	// 사용자 정의 함수 
		methods:{
	   		list:function(){
	   			location.href="board.do"
	   		},
	   		update:function(){
	   			// ES6 => ';'은선택
	   			/*
	   			         자바스크립트
	   			         데이터형 : 자동지정변수 
	   			             var = let(지역변수) , const(상수형변수)
	   			     let a=10 ==== a:int
	   			     let a=10.5 == a:double
	   			     ------------------------- Number
	   			     let a='aaa'    a:String
	   			     let a="bbb"    a:String 
	   			     let a={}       a:Object  => {키:값}
	   			                                 ---멤버변수 
	   			             예) let a={"no":1,"name":"홍길동"}
                              a.no
                              a.name
                              --------------------------JSON
                              => 모든언어가 파싱이 가능 (kotlin,javascript라이브러리)
	   			     let a=[] == a:Array
	   			     let a=true == a:boolean
	   			     
	   			          기능 처리 : 사용자 정의 함수 
	   			          function func_name(매개변수:변수명)
                          {
	   			        	  
                          }
                          const func_name=function(){}
                          const func_name=()=>{} (람다식) : 함수포인터
	   			          내장 객체
	   			          window (브라우저)=>외곽 담당 (메뉴바,상태바 , 타이틀바)
	   			            |                 |           |
	   			         docuement(출력공간)   history    location
	   			            |
	   			           form (입력창)
	   			          이벤트 처리 
	   			          onclick , onchange , onmouseover onmouseout
	   			          onkeyup, onkeydown , onhover(jquery)
	   			*/
	   			location.href="board_update.do?no="+this.no
	   		    // 폴더  => food 
	   		},
	   		del:function(){
	   			location.href="board_delete.do?no="+this.no;
	   		}
	   	}
	   }) 
  </script>
</body>
</html>





