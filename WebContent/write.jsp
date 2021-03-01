<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
					
					<!-- write_box -->
					<form action="write" method="post" class="write_form">	
						<div class="wirte_box">
							<table class="wirte_table">
								<colgroup>
									<col>
									<col>
								</colgroup>
								<tbody>
									<tr>
										<th>제목</th>
										<td><input type="text" class="tit_input" name="boardTit"></td>
									</tr>
									<tr>
										<th>작성자</th>
										<td><input type="text" class="writer_input" name="memberId" value="${sessionScope.sessionId}" disabled ></td>
									</tr>
									<tr>
										<th>내용</th>
										<td>
											<textarea name="boardContent" id="" cols="30" rows="10" class="contents_area"></textarea>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</form>
					<!-- // write_box -->

					<!-- btn_box -->
					<div class="btn_box">
						<a href="#" class="basic_btn write_btn">확인</a>
						<a href="#" class="basic_btn cancel_btn" onclick="history.go(-1);">취소</a>
					</div>
					<!-- //btn_box -->

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
			let writeForm = document.querySelector('.write_form');
			let writeBtn = document.querySelector('.write_btn');

			writeBtn.addEventListener('click', (e)=>{
				e.preventDefault();
				writeForm.method="POST";
				writeForm.submit();
			});
			
		});
	</script>
</body>
</html>