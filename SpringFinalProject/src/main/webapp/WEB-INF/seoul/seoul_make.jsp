<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.img{
    position: relative;
    background-image: url(../images/demo/cos.png);                                                               
    height: 100vh;
    background-size: cover;
  }

  .img-cover{
     position: absolute;
     height: 100%;
     width: 100%;
     background-color: rgba(0, 0, 0, 0.7);                                                                 
     z-index:1;
  }

  .img .content{
     position: absolute;
     top:55%;
     left:45%;
     transform: translate(-50%, -50%);                                                                   
     font-size:5rem;
     color: white;
     z-index: 2;
     text-align: center;
  }
  .img .content1{
     position: absolute;
     top:25%;
     left:70%;
     transform: translate(-50%, -50%);                                                                   
     font-size:5rem;
     color: white;
     z-index: 2;
     text-align: center;
  }
  .img .content2{
     position: absolute;
     top:85%;
     left:50%;
     transform: translate(-50%, -50%);                                                                   
     font-size:5rem;
     color: white;
     z-index: 2;
     text-align: center;
  }
  .img .content3{
     position: absolute;
     top:85%;
     left:85%;
     transform: translate(-50%, -50%);                                                                   
     font-size:5rem;
     color: white;
     z-index: 2;
     text-align: center;
  }
</style>
</head>
<body>
<div class="wrapper row2">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">코스만들기</a></li>
    </ul>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <div class="row">
	    <div class="img">
	        <div class="content1">
	            <h1>Hello!</h1>
	            <h2>My name is nunu</h2>
	        </div>
	        <div class="content2">
	            <h1>Hello!</h1>
	            <h2>My name is nunu</h2>
	        </div>
	        <div class="content3">
	            <h1>Hello!</h1>
	            <h2>My name is nunu</h2>
	        </div>
	        <div class="content">
	            <h1>Hello!</h1>
	            <h2>My name is nunu</h2>
	        </div>
	        <div class="img-cover"></div>
	    </div>
    </div>
  </main>
</div>
</body>
</html>