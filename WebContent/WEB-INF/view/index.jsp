<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE HTML>
<html lang="ko">  

	<!-- head  -->
	<jsp:include page="/inc/head.jsp" />
	
	<!-- //head  -->
	
<body class="main_body">
	<!-- wrapper -->
	<div class="wrapper main_wrapper">
	
		<!-- header -->
		<jsp:include page="/inc/header.jsp" />
		<!-- // header -->        
		   
		<!-- contents -->
		<div id="real_contents" class="contents">

			<!-- container -->
			<div class="container clearfix">
				<!-- sub_con -->
				<div class="sub_con main_con">
					
					<div class="main_text_box">
						<ul>
							<li>
								<i class="xi-group"></i>
								<span>총 회원수 </span>
								<span class="num num1" data-target="<%= request.getAttribute("memCount") %>">0</span>
							</li>
							<li>
								<i class="xi-library-books"></i>
								<span>총 게시글</span>
								<span class="num num2" data-target="<%= request.getAttribute("boardCount") %>">0</span>
							</li>
							<li>
								<i class="xi-forum"></i>
								<span>총 댓글수</span>
								<span class="num num3" data-target="<%= request.getAttribute("commentCount") %>">0</span>
							</li>
							<li class="link_btn">
								<a href="board" >게시판<br>바로가기<i class="xi-external-link"></i></a>
							</li>
						</ul>
					</div>
					
					
				</div>
				<!-- // sub_con -->
			</div>
			<!-- // container -->
		</div>
		<!-- // contents -->

		<!-- footer -->
		<jsp:include page="/inc/footer.jsp" />
		<!-- // footer -->
	</div>
	<!-- // wrapper -->
	
	
	<script>
		window.addEventListener('load', ()=>{
			let num1 = document.querySelector('.num1');
			let num2 = document.querySelector('.num2');
			let num3 = document.querySelector('.num3');
			
			let num1_ = 0;
			let num2_ = 0;
			let num3_ = 0;
			
			let timer1 = setInterval(function(){	
				if(num1_ < num1.getAttribute('data-target')){
					++num1_;
					num1.innerHTML = num1_;
				}else{
					clearInterval(timer1);
				}
			} ,30);
			
			
			let timer2 = setInterval(function(){	
				if(num2_ < num2.getAttribute('data-target')){
					++num2_;
					num2.innerHTML = num2_;
				}else{
					clearInterval(timer2);
				}
			} ,30);

			
			let timer3 = setInterval(function(){	
				if(num3_ < num3.getAttribute('data-target')){
					++num3_;
					num3.innerHTML = num3_;
				}else{
					clearInterval(timer3);
				}
			} ,30);


		})
	</script>
</body>
</html>