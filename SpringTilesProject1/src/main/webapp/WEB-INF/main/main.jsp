<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table border=1 bordercolor=black width=960 height=760>
    <tr>
      <td colspan=2 height=100 align="center">
       <tiles:insertAttribute name="header"/>
      </td>
    </tr>
    <tr>
      <td height=560 align="center" width=200>
        <tiles:insertAttribute name="menu"/>
      </td>
      <td height=560 align="center" width=760>
        <tiles:insertAttribute name="content"/>
      </td>
    </tr>
    <tr>
      <td colspan=2 height=100 align="center">
        <tiles:insertAttribute name="footer"/>
      </td>
    </tr>
  </table>
</body>
</html>