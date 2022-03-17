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
h1{
    text-align: center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let fileIndex=0;
$(function(){
	$('#addBtn').click(function(){
		$('#user-table > tbody').append(
		   '<tr id="f'+fileIndex+'">'
		  +'<td width="20%" class="text-right">File'+(fileIndex+1)+'</td>'
		  +'<td width="80%"><input type=file name="files['+fileIndex+']" size=20></td>'
		  +'</tr>'
		)
		fileIndex++;
	})
	$('#removeBtn').click(function(){
		if(fileIndex>0)
		{
			$('#f'+(fileIndex-1)).remove();
			fileIndex--;
		}
	})
})
</script>
</head>
<body>
   <div class="container">
     <h1>글쓰기(파일업로드)</h1>
     <div class="row">
      <%-- 151page , 152page  
        multipart/form-data 파일 업로드 (method=post) post기반 
      --%>
      <form method=post action="insert_ok.do" enctype="multipart/form-data">
       <table class="table">
        <tr>
          <th class="text-right warning" width=15%>이름</th>
          <td width=85%>
           <input type=text name=name size=15 class="input-sm">
          </td>
        </tr>
        <tr>
          <th class="text-right warning" width=15%>제목</th>
          <td width=85%>
           <input type=text name=subject size=45 class="input-sm">
          </td>
        </tr>
        <tr>
          <th class="text-right warning" width=15%>내용</th>
          <td width=85%>
           <textarea rows="10" cols="50" name="content"></textarea>
          </td>
        </tr>
        <tr>
          <th class="text-right warning" width=15%>첨부파일</th>
          <td width=85%>
           <table class="table">
            <tr>
             <td class="text-right">
              <input type="button" class="btn btn-xs btn-info" value="Add" id="addBtn">
              <input type="button" class="btn btn-xs btn-success" value="Remove" id="removeBtn">
             </td>
            </tr>
           </table>
           <table class="table" id="user-table">
            <tbody>
            
            </tbody>
           </table>
          </td>
        </tr>
        <tr>
          <th class="text-right warning" width=15%>비밀번호</th>
          <td width=85%>
           <input type=password name=pwd size=10 class="input-sm">
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <input type=submit value="글쓰기" class="btn btn-sm btn-danger">
            <input type=button value="취소" class="btn btn-sm btn-primary"
             onclick="javascript:history.back()"
            >
          </td>
        </tr>
       </table>
       </form>
     </div>
   </div>
</body>
</html>







