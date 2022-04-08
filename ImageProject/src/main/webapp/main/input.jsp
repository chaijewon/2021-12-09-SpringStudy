<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= application.getRealPath("/") %>
<form method=post action="upload.do" enctype="multipart/form-data">
이미지 선택 : <input type="file" name="upload" size=20>
<input type=submit value="전송">
</form>
</body>
</html>