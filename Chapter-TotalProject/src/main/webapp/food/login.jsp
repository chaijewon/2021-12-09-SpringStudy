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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#logBtn').click(function(){
		let id=$('#id').val();
		if(id.trim()=="")
		{
			$('#id').focus();
			return;
		}
		let pwd=$('#pwd').val();
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			return;
		}
		/*
		    axios.get().then(res=>{})
		*/
		$.ajax({
			type:'POST',
			url:'login_ok.do',
			data:{"id":id,"pwd":pwd},
			success:function(res){
				if(res=='NOID')
				{
					alert("아이디가 존재하지 않습니다!!")
					$('#id').val("");
					$('#pwd').val("");
					$('#id').focus();
				}
				else if(res=='NOPWD')
				{
					alert("비밀번호가 틀립니다!!")
					$('#pwd').val("");
					$('#pwd').focus();
				}
				else
			    {
					location.href="main.do";
			    }
			}
		})
	})
	$('#logoutBtn').click(function(){
		location.href="logout.do";
	})
})

</script>
</head>
<body>
  <div class="container">
    <h1 class="text-center">로그인</h1>
    <div class="row">
      <table class="table">
        <tr>
         <td width="25%" class="text-right">ID</td>
         <td width="75%">
           <input type=text id=id size=15 class="input-sm">
         </td>
        </tr>
        <tr>
         <td width="25%" class="text-right">PW</td>
         <td width="75%">
           <input type=password id=pwd size=15 class="input-sm">
         </td>
        </tr>
        <tr>
          <td class="text-center" colspan="2">
            <input type=button value="로그인" class="btn btn-sm btn-danger" id="logBtn">
            <input type=button value="로그아웃" class="btn btn-sm btn-success" id="logoutBtn">
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>



