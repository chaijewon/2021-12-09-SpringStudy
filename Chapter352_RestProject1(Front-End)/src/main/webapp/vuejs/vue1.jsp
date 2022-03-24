<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
     VueJS : 자바스크립트 라이브러리 
     ------ AngularJS에서 파생 => 누적 (유지보수)
     IT 단점 => 공부 (주춤하면 ~ )
     ASP => 삼성물산 => JSP 
     3년차 => 개발자 / 소모품 (80%)
     -------------------------
     AngularJS === Jquery ========= React ==== VueJS
     ---------    --------         -------     ------ 가상돔 , 양방향 , 라이브러리가 많지 않다
            양방향              라이브러리양(무겁다)   속도가 빠르다 
                                                               가상돔을 이용하기 때문에 
                                                                           단방향  => class
                                       |
                                      Hooks (function)
                                  --------------------- 데이터를 읽어서 화면 (View)
                                  데이터관리 <==> 데이터를 출력 ==> MVC (Redux,vuex)
                                            ================= mobx ,saga(Framework)
     = 가상돔 (메모리) => 게임 (더블버퍼링) : 소스 코딩이 올라간다 <==> 실제 메모리(브라우저에서 읽어가는 위치)
                                                  vue라이브러리에 위해 고속 카피
       String VS StringBuffer
       
       => 가상돔에 올리는 방법 
          --------------- 함수지원  => mounted()
     = 형식 
       <div>
         <div id="aaa">
           ==
           ==
           ==
         </div>
       </div>
       <script>
         new Vue({
           1. 영역 (제어하는 영역) 지정 
           el : 'css형식' => id:#aaa , class:.aaa => container
           data:{ => 멤버변수 지정 => 출력내용에 관련된 변수 
             1) 목록 : [] (List)
                                객체 : {} (VO) ==> {키:값,키:값}
                                 ---키가 멤버변수 => 자바스크립트의 객체 => 표현하는 방법 JSON
                             문자열 : ''
                                정수 : 1 
           }
           methods:{
                          사용자 정의 함수 : 이벤트 처리 함수
           },
                     생명주기 함수
           beforeCreate :vue객체 생성전
           created : vue객체 생성 완료 
           beforeMount : 가상돔에 HTML을 올리기전 
           -------------- componentWillMount():react
           ***mounted : 가상돔에 올라간 상태 => $(function(){}) window.onload => 스프링으로부터 데이터를 읽어 온다 
           ---------------componentDidMount
           beforeUpdate : 수정전 
           ---------------compoentWillUpdate()
           ***updated : 수정완료 => 내용변경
           --------------- componentDidUpdate()
           beforeDestroy : 메모리 해제 전
           destoryed : 메모리 해제 완료 
           
         })
       </script>
              디렉티브 : v- 
               v-if , v-else : 조건문 
               v-show : 
               v-for : 반복문 
               v-model : 양방향 
              이벤트 처리
               v-on:click 
               v-on:change
               v-on:keyup
               v-on:keydown 
              사용자 정의 이벤트 (이벤트 버스 => 실시간 채팅) 
               $emit() 
              스프링 연동 (axios) => 요청 => 데이터 받기 
              axios.get('url').then(res=>{})
                    ---------- -------------- res가 결과값 =>{처리}
                                               요청 
              라우터 (화면 이동) => include
              
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div id="app">
   <h1>{{message}}</h1>
  </div>
  <script>
   new Vue({
	   el:'#app',
	   data:{
		   message:'Hello VueJS'
	   },
	   beforeCreate:function(){
		   console.log("beforeCreate Call...");
	   },
	   created:function(){
		   console.log("created Call...");
	   },
	   beforeMount:function(){
		   console.log("beforeMount Call...");
	   },
	   mounted:function(){
		   console.log("mounted Call...");
	   },
	   beforeUpdate:function(){
		   console.log("beforeUpdate Call...");
	   },
	   updated:function(){
		   console.log("beforeCreate Call...");
	   },
	   beforeDestroy:function(){
		   console.log("beforeDestroy Call...");
	   },
	   destroyed:function(){
		   console.log("destroyed Call...");
	   }
   })
  </script>
</body>
</html>





