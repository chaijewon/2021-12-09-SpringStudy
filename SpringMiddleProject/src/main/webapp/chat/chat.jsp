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
  width:650px;
}
h1{
   text-align: center
}
#chatArea{
  height: 250px;
  overflow-y:auto;
  border: 1px solid black;
}
</style>
<!-- 자바스크립트 : 데이터 전송(자바스크립트와 Spring WebSocket과 연결 -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/socketjs-client/1.3.0/socketjs.min.js"></script> -->
<script type="text/javascript">
let websocket;
function connection()
{
	  // 소켓 생성 
	  websocket=new WebSocket("ws://localhost:8080/web/chat/chat-ws")
	  websocket.onopen=onOpen;
	  websocket.onmessage=onMessage;
	  websocket.onclose=onClose;
}
// callback => websocket에서 자동 호출 함수 지정 
function onOpen(event)
{
	 alert("스프링 채팅 서버와 연결되었습니다!!");
}
function onMessage(event) {
	let data=event.data;
	if(data.substring(0,4)=="msg:") //문자 채팅 : msg: , 방만들기 : makeroom:
    {
		appendMessage(data.substring(4));
    }
}
function onClose(event)
{
	alert("스프링 채팅서버와 연결 종료되었습니다!!")
}
function disConnection()
{
	websocket.close();
}
function send()
{
	let name=$('#name').val();
	if(name.trim()=="")
	{
		$('#name').focus();
		return;
	}
	let msg=$('#sendMsg').val();
	if(msg.trim()=="")
	{
		$('#sendMsg').focus();
		return;
	}
	// 입력이 된 경우
	websocket.send("msg:["+name+"]"+msg);
	$('#sendMsg').val("")
	$('#sendMsg').focus();
}
function appendMessage(msg)
{
	$('#recvMsg').append(msg+"<br>");
	let ch=$('#chatArea').height();
	let m=$('#recvMsg').height()-ch;
	$('#chatArea').scrollTop(m);
}
$(function(){
	$('#startBtn').click(function(){
		connection();
	})
	$('#closeBtn').click(function(){
		disConnection();
	})
	$('#sendBtn').click(function(){
		send();
	})
	$('#sendMsg').keydown(function(key){
		if(key.keyCode==13)//13=enter
		{
		   send();	
		}
	})
})
</script>
</head>
<body>
  <div class="container">
    <h1>WebSocket을 이용한 간단한 웹채팅</h1>
    <%-- security , task , validation --%>
    <div class="row">
      <table class="table">
       <tr>
       <td>
               이름:<input type=text id=name class="inpu-sm">
         <input type=button value="입장" class="btn btn-sm btn-info" id="startBtn">
         <input type=button value="퇴장" class="btn btn-sm btn-success" id="closeBtn">
       </td>
       </tr>
       <tr>
         <td>
           <div id="chatArea">
             <div id="recvMsg"></div>
           </div>
         </td>
       </tr>
       <tr>
         <td>
           <input type=text id="sendMsg" size=50 class="input-sm">
           <input type=button id="sendBtn"
             class="btn btn-sm btn-danger" value="전송">
         </td>
       </tr>
      </table>
    </div>
  </div>
</body>
</html>







