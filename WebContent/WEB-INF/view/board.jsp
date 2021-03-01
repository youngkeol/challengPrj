<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
					<div class="search_box">
						<form method="get"  action="board" class="search_form">
							<select name="field" class="sc_sel">
								<option  value="boardTit" ${(param.field =="boardTit")?"selected":"" }>제목</option>
								<option value="memName" ${(param.field =="memName")?"selected":"" }>작성자</option>
								<option value="boardContent" ${(param.field =="boardContent")?"selected":"" }>내용</option>
							</select>
							<input type="text" class="sc_input" name="search">
							<a href="#" class="sc_btn">검색</a>
						</form>

					</div>
					<div class="basic_table_box">
						<table class="basic_table">
							<caption>글번호, 제목, 글쓴이, 작성일, 조회수 게시판</caption>
							<colgroup>
								<col>
								<col>
								<col>
								<col>
								<col>
							</colgroup>
							<thead>
								<tr>
									<td>글번호</td>
									<td class="tit">제목</td>
									<td>작성자</td>
									<td>작성일</td>
									<td>조회수</td>
								</tr>
							</thead>
							<tbody>
							<%-- 
								<%
								List<Board> list = (List<Board>)request.getAttribute("list");
								for(Board b : list){ 
									pageContext.setAttribute("b", b);
								%>
								
							--%>
								<c:forEach var="b" items="${list}" begin="0" end="7">
								<tr onClick="location.href='board/detail?boardNum=${b.boardNum}'">
									<td>${b.boardNum}</td>
									<td class="tit">${b.boardTit}</td>
									<td><span class="table_cap">작성자 :</span>${b.memName}</td>
									<td><span class="table_cap">작성일 :</span><fmt:formatDate pattern="yyyy-MM-dd" value="${b.regdate}"/></td>
									<td><span class="table_cap">조회수 :</span><fmt:formatNumber value="${b.boardHit}"/></td>
								</tr>
								</c:forEach>
								<%-- 
								<%} %>
								--%>
							</tbody>
						</table>
					</div>
					
					<div class="btn_box ta_r">
						<a href="write.jsp" class="basic_btn">글쓰기</a>	
						
						<%-- filter로 변경함	
						<c:if test="${(not empty sessionScope.sessionId)}">
							<a href="write.jsp" class="basic_btn">글쓰기</a>		
						</c:if>
						
								
						<c:if test="${(empty sessionScope.sessionId)}">
							<a href="login.jsp" class="basic_btn">글쓰기</a>
						</c:if>
						--%>
						
					</div>
					
					<c:set var="page" value="${(empty param.page)?1:param.page}" />
					<c:set var="startNum" value="${page-(page-1)%10}" />
					<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}" />
					
					<div class="pagination_box">
						<ul class="pagination">
							<c:if test="${startNum-1>0}">
								<li class="page_arrow.l1"><a href="?page=${startNum -1}&field=${param.field}&seach=${param.search}">&lt;&lt;</a></li>
							</c:if>
							<c:if test="${startNum-1 <=0}">
								<li class="page_arrow.l1"><a href="#" onclick="event.preventDefault(); alert('이전 페이지가 없습니다.')">&lt;&lt;</a></li>
							</c:if>
							
							
							<%-- StartNum = page(page-1)%5--%>
				
							<c:forEach var="i" begin="0" end="9">
								<c:if test="${(startNum+i)<=lastNum}">
									<li><a href="?page=${startNum+i}&field=${param.field}&search=${param.search}" class="${(page==(startNum+i))?'active':''}">${startNum+i}</a></li>
								</c:if>
							</c:forEach>
							
							<c:if test="${startNum+10 <= lastNum}">
								<li class="page_arrow.r1"><a href="?page=${startNum + 10}&field=${param.field}&seach=${param.search}">&gt;&gt;</a></li>
							</c:if>
							<c:if test="${startNum+10 >= lastNum}">
								<li class="page_arrow.r1"><a href="#" onclick="event.preventDefault(); alert('다음 페이지가 없습니다.')">&gt;&gt;</a></li>
							</c:if>
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
			let searchBtn = document.querySelector('.sc_btn');
			let searchForm = document.querySelector('.search_form');
			searchBtn.addEventListener('click', (e)=>{
				e.preventDefault();
				searchForm.method = 'GET';
				searchForm.submit();
			});

		})
	</script>
</body>
</html>