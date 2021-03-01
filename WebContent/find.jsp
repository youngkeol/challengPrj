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
					
					<!-- tab_cover -->
					<div class="tab_cover find_info_box">
						<div class="tab_nav_box tab_2th">
							<ul>
								<li class="active"><a href="#">아이디 찾기</a></li>
								<li><a href="#">비밀번호 찾기</a></li>
							</ul>
						</div>
						<div class="tab_con_box">
							<div class="tab_con show">
								<h3 class="find_txt">가입하실 때 사용하신 <span>이메일</span>을 입력해 주세요.</h3>
								<form action="" class="fine_id_form">
									<fieldset>
										<legend>아이디 찾기</legend>
										<div class="input_each">
											<input class="email_input_box1" type="text" placeholder="이메일" title="이메일">
										</div>
										<a href="#" class="find_btn find_btn_id" value="idBtn">아이디 찾기</a>
									</fieldset>
								</form>
							</div>
							<div class="tab_con">
								<h3 class="find_txt">가입하실 때 사용하신 <span>아이디</span> 와 <span>이메일</span>을 입력해 주세요.</h3>
								<form action="" class="fine_pw_form">
									<fieldset>
										<legend>비밀번호 찾기</legend>
										<div class="input_each">
											<input class="id_input_box2" type="text" placeholder="아이디" title="아이디">
										</div>
										<div class="input_each">
											<input class="email_input_box2" type="text" placeholder="이메일" title="이메일">
										</div>
										<a href="#" class="find_btn find_btn_pw" value="pwBtn">비밀번호 찾기</a>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
					<!-- //tab_cover -->
					
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
		window.addEventListener('load', ()=>{
			let tabBox = document.querySelector('.tab_nav_box');
			let lis = tabBox.querySelectorAll('li');
			let tabCon = document.querySelectorAll('.tab_con');
				
			tabBox.addEventListener('click',(e)=>{				
				if( e.target.tagName = 'A'&& e.target.innerText =='아이디 찾기'){
					e.target.parentElement.nextElementSibling.classList.remove('active');
					e.target.parentElement.classList.add('active');
					tabCon[1].classList.remove('show');
					tabCon[0].classList.add('show');
					
				}else if(e.target.tagName = 'A' && e.target.innerText =='비밀번호 찾기'){
					e.target.parentElement.previousElementSibling.classList.remove('active');
					e.target.parentElement.classList.add('active');
					tabCon[0].classList.remove('show');
					tabCon[1].classList.add('show');
					
				} 
			})
			
			
			
			//ajax\
			//아이디 찾기
			let findBtnId = document.querySelector('.find_btn_id');
			let findIdForm = document.querySelector('.fine_id_form')
			
			findBtnId.addEventListener('click', (e)=>{
				e.preventDefault();
				let email = findIdForm.querySelector('.email_input_box1').value;
			
				
				let request = new XMLHttpRequest();
		
				request.onloadend = function(){
					let data = JSON.parse(request.responseText);
					console.log(data)
					if(data == null){
						alert("이메일을 정확하게 입력해주세요.")
					}else {
						alert("찾는 아이디는 " +  data + "입니다.");
						//alert(`찾는 아이디는 ${data} 입니다.`);
					}
				}
			
				request.open("GET", "api/findId?email=" + email ,true);
				request.send();
			});
			
			//비밀번호 찾기
			let findPwForm = document.querySelector('.fine_pw_form')
			let findBtnPw = document.querySelector('.find_btn_pw');
			
			findBtnPw.addEventListener('click', (e)=>{
				e.preventDefault();
				let id = findPwForm.querySelector('.id_input_box2').value;
				let email = findPwForm.querySelector('.email_input_box2').value;
				
				

				let request = new XMLHttpRequest();
		
				request.onloadend = function(){
					let data = JSON.parse(request.responseText);
					console.log(data)
					if(data == null){
						alert("아이디와 이메일을 정확하게 입력해주세요.")
					}else {
						alert("찾는 비밀번호는 " +  data + " 입니다.");
					}
				}
			
				request.open("GET", "api/findPw?id="+id + "&email=" + email ,true);
				request.send();
			});
			
		})
	</script>	

</body>
</html>