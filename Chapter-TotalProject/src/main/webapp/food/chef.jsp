<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</style>
</head>
<body>
   <div class="container">
    <div class="row">
     <table class="table">
       <tr>
        <td>
          <c:forEach var="vo" items="${list }">
            <table class="table">
             <tr>
              <td class="text-center" width=30% rowspan="2">
               <a href="chef_recipe_list.do?chef=${vo.chef }">
                <img src="${vo.poster }" style="width:200px;height:150px" class="img-circle">
               </a>
              </td>
              <td colspan="4">
                <h3 style="color:orange"><a href="chef_recipe_list.do?chef=${vo.chef }">${vo.chef }</a></h3>
              </td>
             </tr>
             <tr>
               <td class="text-center">
                <img src="mc1.png">${vo.mem_cont1 }
               </td>
               <td class="text-center">
                <img src="mc2.png">${vo.mem_cont2 }
               </td>
               <td class="text-center">
                <img src="mc7.png">${vo.mem_cont7 }
               </td>
               <td class="text-center">
                 <img src="mc3.png">${vo.mem_cont3 }
               </td>
             </tr>
            </table>
          </c:forEach>
        </td>
       </tr>
     </table>
    </div>
   </div>
</body>
</html>








