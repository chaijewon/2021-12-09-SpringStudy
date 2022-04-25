<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
    <table class="table">
      <tr>
        <td>
         <iframe src="http://youtube.com/embed/${vo.mkey }" style="width:940px;height: 500px"></iframe>
        </td>
      </tr>
    </table>
    <div style="height: 30px"></div>
    <table class="table">
      <tr>
        <td width=30% class="text-center" rowspan="7">
          <img src="${vo.poster }" width=100%>
        </td>
        <td colspan="2"><h3>${vo.title }</h3></td>
      </tr>
      <tr>
        <td class="text-right" width=15%>감독</td>
        <td width="55%">${vo.director }</td>
      </tr>
      <tr>
        <td class="text-right" width=15%>출연</td>
        <td width="55%">${vo.actor }</td>
      </tr>
      <tr>
        <td class="text-right" width=15%>장르</td>
        <td width="55%">${vo.genre }</td>
      </tr>
      <tr>
        <td class="text-right" width=15%>등급</td>
        <td width="55%">${vo.grade }</td>
      </tr>
      <tr>
        <td class="text-right" width=15%>개봉일</td>
        <td width="55%">${vo.regdate }</td>
      </tr>
      <tr>
        <td class="text-right" width=15%>누적관객</td>
        <td width="55%">${vo.showuser }</td>
      </tr>
      <tr>
        <td colspan="3" valign="top" class="text-left" height="200">
        ${vo.story }
        </td>
      </tr>
      <tr>
        <td class="text-right" colspan="3">
         <a href="/movie_list" class="btn btn-sm btn-danger">목록</a>
        </td>
      </tr>
    </table>
  </div>
</body>
</html>






