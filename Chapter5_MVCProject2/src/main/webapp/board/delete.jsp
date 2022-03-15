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
h1{
    text-align: center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#subBtn').click(function(){
		let pwd=$('#pwd').val();
		let no=$('#no').val();
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			return;
		}
		// @RestController를 이용해서 데이터를 받아서 처리 
		$.ajax({
			type:'post',
			url:'delete_ok.do',
			data:{"no":no,"pwd":pwd},
			success:function(res)
			{
				let r=parseInt(res);
				if(r==0)
				{
					alert("비밀번호가 틀립니다!!");
					$('#pwd').val("");
					$('#pwd').focus();
				}
				else
				{
					location.href="list.do";
				}
			}
		})
	})
})
</script>
</head>
<body>
   <div class="container">
     <h1>삭제하기</h1>
     <div class="row">
     <!-- <form method="post" action="delete_ok.do"> -->
      <table class="table">
       <tr>
         <td class="text-center">
          비밀번호:<input type="password" name=pwd size=15 class="input-sm" id="pwd">
            <input type=hidden name=no value="${no }" id="no">
         </td>
       </tr>
       <tr>
         <td class="text-center">
          <input type=button value="삭제" class="btn btn-sm btn-danger" id="subBtn">
          <input type=button value="취소" class="btn btn-sm btn-primary"
            onclick="javascript:history.back()"
          >
         </td>
       </tr>
      </table>
      <!-- </form> -->
     </div>
   </div>
</body>
</html>





