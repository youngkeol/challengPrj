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
					<div class="join_box">
						<h2 class="login_tit">회원가입</h2>
						<form class="join_form" action="join" method="post">
							<fieldset>
								<legend>회원가입</legend>
							</fieldset>	
							<div class="join_each id clearfix">
								<label for="" >아이디</label>
								<input type="text" name="memId" class="mem_id">
								<a href="#" class="id_check">중복확인</a>
							</div>
							<div class="join_each">
								<label for="" >비밀번호</label>
								<input type="password" name="memPw">
							</div>
							<div class="join_each">
								<label for="">비밀번호 확인</label>
								<input type="password"  name="memPw2">
							</div>
							<div class="join_each">
								<label for="">이름</label>
								<input type="text" name="memName">
							</div>
							<div class="join_each radio">
								<label for="">성별</label>
								<div class="radio_box">
									<input type="radio" id="m" name="gen" value="남" checked><label for="m"><span>남</span></label>
								</div>
								<div class="radio_box">
									<input type="radio" id="w" name="gen" value="여"><label for="w"><span>여</span></label>
								</div>
								
							</div>
							<div class="join_each email clearfix">
								<label for="">이메일</label>
								<input type="text" name="email">
								<span>@</span>
								<select name="email2" id="">
									<option value="naver.com">naver.com</option>
									<option value="gmail.com">gmail.com</option>
									<option value="hanmail.net">hanmail.net</option>
								</select>
								<a href="#" class="email_check">중복확인</a>
							</div>
							<a href="#" class="join_btn">회원가입</a>
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
		window.addEventListener('load',()=>{
			let joinForm = document.querySelector('.join_form');
			let idInput = joinForm.querySelector('input[name=memId]');
			let pwInput1 = joinForm.querySelector('input[name=memPw]');
			let pwInput2 = joinForm.querySelector('input[name=memPw2]');
			let emailInput1 = joinForm.querySelector('input[name=email]');
			let emailInput2 = joinForm.querySelector('select[name=email2]');
			let joinBtn = joinForm.querySelector('.join_btn');

			


			//중복확인
			let idBtn = joinForm.querySelector('.id_check');
			let emailBtn = joinForm.querySelector('.email_check');
			let idCheck = false;
			let eamilCheck = false;
			let pwCheck = false;

			//아이디 중복확인
			idBtn.addEventListener('click', ()=>{
				let idValue = idInput.value;
				let request = new XMLHttpRequest();

				console.log(idValue);
					request.onloadend = function(){
						let data = request.responseText;
						if(data == 1){
							alert(`${"${idValue}"} 는 사용할 수 있는 아이디입니다.`);
							idCheck = true;
						}else if(data == 0){
							alert(`${"${idValue}"} 사용할 수 없는 아이디입니다.`);
							idCheck = false;
						}
					}


				request.open("POST", "/challengPrj/api/idCheck", true); //(방식, 주소, 옵션(*비동기-true, 동기-false))
				request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				request.send(`idValue=${"${idValue}"}`);
				//console.log(`idValue=${"${idValue}"}`);
			});

			//이메일 중복확인
			emailBtn.addEventListener('click', (e)=>{
				
				//let emailValue = emailInput1.value + "@" + emailInput2.options[emailInput2.selectedIndex].value;
				let emailValue = emailInput1.value + "@" + emailInput2.value;
				console.log(emailValue);


				let request = new XMLHttpRequest();

				request.onloadend = function(){
						let data = request.responseText;
						if(data == 1){
							alert(`${"${emailValue}"} 는 사용할 수 있는 이메일입니다.`);
							eamilCheck = true;
						}else if(data == 0){
							alert(`${"emailValue}"} 사용할 수 없는 이메일입니다.`);
							eamilCheck = false;
						}
					}
		
					request.open("POST", "/challengPrj/api/emailCheck", true); //(방식, 주소, 옵션(*비동기-true, 동기-false))
					request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
					request.send(`emailValue=${"${emailValue}"}`);
			});



			// 값변경시 초기화
			idInput.addEventListener('change', ()=>{
				idCheck = false;
			});
			emailInput1.addEventListener('change', ()=>{
				console.log("aaa");
				eamilCheck = false;
			})
			emailInput2.addEventListener('change', ()=>{
				eamilCheck = false;
				console.log("bbb");
			})



			joinBtn.addEventListener('click', (e)=>{
				e.preventDefault();
				if(pwInput1.value == pwInput2.value){
					pwCheck =true;
				}else { 
					pwCheck = false;
				}


				if(!idCheck){
					alert("ID 중복확인을 해주세요.")
					return;
				}

				if(!pwCheck){
					alert("비밀번호가 같지 않습니다.")
					return;
				}

				if(!eamilCheck){
					alert("EMAIL 중복확인을 해주세요.");
					return;
				}


				joinForm.method ='POST';
				joinForm.submit();
			});


		});
	</script>
</body>
</html>