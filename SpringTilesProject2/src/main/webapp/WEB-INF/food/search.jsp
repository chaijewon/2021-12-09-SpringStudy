<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading">
           <input type=text size=20 class="input-sm">
          </header>
          <ul class="nospace clear">
            <li class="one_quarter first"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter first"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter first"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
          </ul>
          
        </figure>
      </div>
      <!-- ################################################################################################ --> 
      <!-- ################################################################################################ -->
      <nav class="pagination">
        <ul>
          <li><a href="#">&laquo; 이전</a></li>
          <li></li>
          <li><a href="#">다음 &raquo;</a></li>
        </ul>
      </nav>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
  <script>
   new Vue({
	   el:'.container',
	   data:{
		   food:[],
		   address:'',
		   curpage:1,
		   totalpage:0
	   },
	   mounted:function(){
		   // $(function(){}) window.onload=function()
		   // find_vue.do?page=1&addr=강남
		   // data:{page: , addr:}
		   axios.get("http://localhost:8080/web/food/find_vue.do",{
			   params:{
				   page:this.curpage,
				   addr:this.address
			   }
		   }).then(res=>{
			   
		   })
	   }
   })
  </script>
</body>
</html>