<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width:960px;
}
.images:hover{
  cursor: pointer;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      Search:<input type=text size=20 class="input-sm" v-model="ss"
             :value="ss">
             <input type=button class="btn btn-sm btn-danger"
              value="검색" v-on:click="find()">
    </div>
    <div class="row">
      <div class="col-sm-8">
        <div class="col-md-4" v-for="vo in find_list">
		    <div class="thumbnail">
		        <img :src="vo.poster" alt="Lights" style="width:300px;height:220px" 
		        class="images" v-on:click="food_detail(vo.no)">
		        <div class="caption">
		          <p style="font-size: 8px">{{vo.name }}</p>
		        </div>
		    </div>
		  </div>
		  <div>
		   <div class="text-center">
		     <span class="btn btn-sm btn-info" v-on:click="prev()">이전</span>
		     {{curpage}} page / {{totalpage}} pages
		     <span class="btn btn-sm btn-success" v-on:click="next()">다음</span>
		   </div>
		  </div>
      </div>
      <div class="col-sm-4" v-show="isShow">
         <table class="table">
           <tr>
             <td class="text-center" v-for="img in images">
              <img :src="img" style="width:100%">
             </td>
           </tr>
         </table>
         <table class="table">
           <tr>
            <td colspan="2">{{detail.name}}<span style="color:orange">{{detail.score}}</span></td>
           </tr>
           <tr>
             <td width=30%>주소</td>
             <td width=70%>{{detail.address}}</td>
           </tr>
           <tr>
             <td width=30%>전화</td>
             <td width=70%>{{detail.tel}}</td>
           </tr>
           <tr>
             <td width=30%>음식종류</td>
             <td width=70%>{{detail.type}}</td>
           </tr>
           <tr>
             <td width=30%>영업시간</td>
             <td width=70%>{{detail.time}}</td>
           </tr>
           <tr>
             <td width=30%>주차</td>
             <td width=70%>{{detail.parking}}</td>
           </tr>
           <tr>
             <td width=30%>메뉴</td>
             <td width=70%>{{detail.menu}}</td>
           </tr>
         </table>
      </div>
    </div>
  </div>
  <script>
    new Vue({
    	el:'.container',
    	data:{
    		find_list:[],
    		ss:'강남',
    		curpage:1,
    		totalpage:0,
    		detail:{},
    		images:[],
    		isShow:false
    	},
    	// 시작과 동시에 처리 => window.onload
    	// find_vue.do?page=1&ss=강남
        // data:{"page":1,"ss":'강남'}
    	mounted:function(){
    		let _this=this;
    		axios.get("http://localhost:8080/web/food/find_vue.do",{
    			params:{
    				page:_this.curpage,
        			ss:_this.ss
    			}
    			// success:function(res) => JSON 
    			// 자바  != 자바스크립트
    			// 자바 => List => [{},{},{}...]
    			// 자바 => VO   => {} (JSON) 자바스크립트 객체 표현법 
    			// Rest / JSONP
    		}).then(function(res){
    			_this.find_list=res.data;
    			_this.curpage=res.data[0].curpage;
    			_this.totalpage=res.data[0].totalpage;
    		})
    	},
    	methods:{
    		find:function(){
    			this.curpage=1;
    			axios.get("http://localhost:8080/web/food/find_vue.do",{
        			params:{
        				page:this.curpage,
            			ss:this.ss
        			}
        			// success:function(res) => JSON 
        			// 자바  != 자바스크립트
        			// 자바 => List => [{},{},{}...]
        			// 자바 => VO   => {} (JSON) 자바스크립트 객체 표현법 
        			// Rest / JSONP
        		}).then(res=>{
        			this.find_list=res.data;
        			this.curpage=res.data[0].curpage;
        			this.totalpage=res.data[0].totalpage;
        		})
    		},
    		prev:function(){
    			this.curpage=this.curpage>1?this.curpage-1:this.curpage;
    			axios.get("http://localhost:8080/web/food/find_vue.do",{
        			params:{
        				page:this.curpage,
            			ss:this.ss
        			}
        			// success:function(res) => JSON 
        			// 자바  != 자바스크립트
        			// 자바 => List => [{},{},{}...]
        			// 자바 => VO   => {} (JSON) 자바스크립트 객체 표현법 
        			// Rest / JSONP
        		}).then(res=>{
        			this.find_list=res.data;
        			this.curpage=res.data[0].curpage;
        			this.totalpage=res.data[0].totalpage;
        		})
    		},
    		next:function(){
    			this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
    			axios.get("http://localhost:8080/web/food/find_vue.do",{
        			params:{
        				page:this.curpage,
            			ss:this.ss
        			}
        			// success:function(res) => JSON 
        			// 자바  != 자바스크립트
        			// 자바 => List => [{},{},{}...]
        			// 자바 => VO   => {} (JSON) 자바스크립트 객체 표현법 
        			// Rest / JSONP
    			}).then(res=>{
        			this.find_list=res.data;
        			this.curpage=res.data[0].curpage;
        			this.totalpage=res.data[0].totalpage;
        		})
    		},
    		// ?no=1
    		food_detail:function(no){
    			//alert("no="+no)
    			axios.get("http://localhost:8080/web/food/detail_vue.do",{
        			params:{
        				no:no
        			}
        			// success:function(res) => JSON 
        			// 자바  != 자바스크립트
        			// 자바 => List => [{},{},{}...]
        			// 자바 => VO   => {} (JSON) 자바스크립트 객체 표현법 
        			// Rest / JSONP
        		}).then(res=>{
        			this.detail=res.data;
        			this.isShow=true;
        			this.images=res.data.poster.split("^");
        		})
    		}
    	}
    })
  </script>
</body>
</html>









