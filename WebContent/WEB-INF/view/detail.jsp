<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE HTML>
<html lang="ko">

<!-- head  -->
<jsp:include page="/inc/head.jsp" />
<!-- //head  -->


<body>
	<!-- wrapper -->
	<div class="wrapper">
		
		<!-- header -->
		<jsp:include page="/inc/header.jsp" />
		<!-- // header -->   
		
		<!-- contents -->
		<div id="real_contents" class="contents">

			<!-- container -->
			<div class="container clearfix">
				<!-- sub_con -->
				<div class="sub_con">
					
					<!-- read_box -->
					<div class="read_box">
						<div class="read_head">
							<div class="tit">${b.boardTit}</div>
							
							<ul class="read_info">
								<li>${b.memName}</li>
								<li><fmt:formatDate pattern="yyyy-MM-dd" value="${b.regdate}"/></li>
								<li><span class="read_cap">조회수 </span><fmt:formatNumber value="${b.boardHit}"/></li>
							</ul>

						</div>
						<div class="read_body">
							${b.boardContent}
						</div>
					</div>
					<!-- // read_box -->

					<!-- btn_box -->
					<div class="btn_box">
						<a href="../board" class="basic_btn">목록</a>
					</div>
					<!-- //btn_box -->

					<!-- comment_box -->
					<div class="comment_box">
						<ul class="comment_list">
							<c:forEach var="comList" items="${comList}">
								<li>
									<span class="reply_id">${comList.memName}</span>
									<span class="reply_date">${comList.comDate}</span>
									<c:if test="${comList.memName == sessionScope.sessionId}">
										<form method="" action="">
											<input type="hidden" name="">
											
										</form>
										<sapn class="reply_del"><a href="comment/delete">삭제</a></sapn>
									</c:if>
									<p class="reply">
										${comList.comContent}
									</p>
								</li>	
							</c:forEach>
						</ul>
						
						
					
						<%-- 	<c:if test="${(empty sessionScope.sessionId)}">
								<script>
									window.addEventListener('load', ()=>{
										let inputBtn = document.querySelector('.input_btn');
										
										inputBtn.click(function(e){
											e.preventDefault();
											alert("로그인이 필요한 서비스입니다.");
										});
									});
								</script>
							</c:if>
							<c:if test="${(not empty sessionScope.sessionId)}">
								<script>
									$(function(){
										$(".input_btn").click(function(e){
											e.preventDefault();
											$(".comment_form").method ="post";
											$(".comment_form").submit();
										});
									});
								</script>
							</c:if>	 --%>
							
							<div class="comment_form_box">
								<form action="comment" method="post" class="comment_form clearfix" >
									<input type="hidden" name="membernum" value=${sessionScope.sessionNum}>
									<input type="hidden" name="boardNum" value=${b.boardNum}>
									<textarea name="comcontent" id="" cols="30" rows="5" class="txt_area"></textarea>
									<a href="#" class="input_btn">입력</a>
								</form>
							</div>	
							
							
						
						
					</div>
					<!-- // comment_box -->
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
			
			let inputBtn = document.querySelector('.input_btn');
			let commentList = document.querySelector('.comment_list');
			let textArea = document.querySelector('.txt_area');
			let isSessionNum = false;
			
			
			//console.log(location.href);
			//console.log(location.pathname+ location.search);
			//console.log(location.search);
			
			inputBtn.addEventListener('click', (e)=>{
				e.preventDefault();
				console.log("${sessionScope.sessionNum}" != "" && "${sessionScope.sessionNum}" != null)
				
				if("${sessionScope.sessionNum}" != "" && "${sessionScope.sessionNum}" != null) {
					isSessionNum = true;				
				}else {
					alert("로그인이 필요한 서비스입니다.")
					let uri = location.pathname+ location.search;
					location= "../login?return-url=" + uri
				}
				console.log(isSessionNum)
 				if(textArea.value != "" && textArea.value !=null && isSessionNum){
 					console.log("ajax");
 					insert();
 					
				}
 				
 				
 				isSessionNum = false;
			})
			
			
			//데이터 보내기
			 function insert(){
				let request = new XMLHttpRequest();
				
				let data = {};
				data.boardNum = "${b.boardNum}";
				data.content = textArea.value;
				data.memNum = "${sessionScope.sessionNum}";
				console.log(data);	
				
				//objec -> json형변경
				let jsonData = JSON.stringify(data);
				console.log(jsonData);
				request.onreadystatechange = function() { // Call a function when the state changes.
				    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
				    	commentList.innerHTML=""
	 					load();
	 					textArea.value="";
				    }
				}
				
				
				request.open("POST", "/challengPrj/api/comment/list", true); //(방식, 주소, 옵션(*비동기-true, 동기-false))
				request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				//request.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
				request.send(`boardNum=${"${data.boardNum}"}&content=${"${data.content}"}&memNum=${"${data.memNum}"}`)
				//request.send(jsonData);
				
			}
 	
			//데이터 가져오기
		 	function load(){
				let request = new XMLHttpRequest();
				request.addEventListener('load', ()=>{
					
					let data = JSON.parse(request.responseText);
					
					//전체 댓글 가져오기 : 깜빡임
					data.forEach((item) =>{						
						let template = `<li>
								<span class="reply_id">${"${item.memName}"}</span>
								<span class="reply_date">${"${item.comDate}"}</span>
								<p class="reply">${"${item.comContent}"}</p>
							</li>`;
							
							commentList.insertAdjacentHTML('beforeEnd', template);
						console.log(template)
					})
					
					
					

				})
				request.open("GET", "/challengPrj/api/comment/list?boardNum=${b.boardNum}", true); //(방식, 주소, 옵션(*비동기-true, 동기-false))
    			request.send();
			}  
		})
	</script>
</body>
</html>