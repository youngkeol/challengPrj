<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!DOCTYPE HTML>
 
<html lang="ko">

<!-- head  -->
<jsp:include page="inc/head.jsp" />
<!-- //head  -->

<body>
	<!-- wrapper -->
	<div class="wrapper">
	
		<!-- header -->
		<jsp:include page="inc/header.jsp" />
		<!-- // header -->   
		

		<!-- contents -->
		<div id="real_contents" class="contents">

			<!-- container -->
			<div class="container clearfix">
				<!-- sub_con -->
				<div class="sub_con">
					<div class="login_box">
						<h2 class="login_tit">로그인</h2>
						<form class="login_form" action="login" method="post">
							<fieldset>
								<legend>아이디 비밀번호 입력</legend>
							</fieldset>	
							<div class="input_box">
								<i class="xi-user-o xi-x"></i>
								<label for="">로그인</label>
								<input type="text" name="id">
							</div>
							<div class="input_box">
								<i class="xi-lock-o xi-x"></i>
								<label for="">비밀번호</label>
								<input type="password" name="pw">
							</div>
							<input type="hidden" name="return-url" value="${returnUrl}"/>
							<a href="#" class="login_btn">로그인</a>
							<ul class="login_sub">
								<li><a href="find.jsp">아이디 · 비밀번호 찾기</a></li>
								<li><a href="join.jsp">회원가입</a></li>
							</ul>
						</form>
					</div>
					
				</div>
				<!-- // sub_con -->
			</div>
			<!-- // container -->
		</div>
		<!-- // contents -->

		<!-- footer -->
		<jsp:include page="inc/footer.jsp" />
		<!-- // footer -->
	</div>
	<!-- // wrapper -->
	
	<script>
		window.addEventListener('load', (e)=>{
			let loginFrom = document.querySelector('.login_form');
			let loginBtn = document.querySelector('.login_btn');

			loginBtn.addEventListener('click', (e)=>{
				e.preventDefault();
				loginFrom.method="POST";
				loginFrom.submit();
			});
			
		});
	</script>
</body>
</html>