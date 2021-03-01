<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
    
<!-- header -->
	<div class="header">
		<!-- skip_navi -->
		<dl class="skip_navi">
			<dt class="hide"><strong>바로가기 메뉴</strong></dt>
			<dd><a href="#real_contents">본문 바로가기</a></dd>
			<dd><a href="#gnb">주메뉴 바로가기</a></dd>
		</dl>
		<!-- // skip_navi -->

		<!-- container -->
		<div class="container clearfix">
			<h1 class="head_logo"><a href="/challengPrj/index">이름 없는 게시판</a></h1>
			

			<!-- util_hd_menu_box -->
			<div class="util_hd_menu_box">
				<ul class="util_hd_menu">
					<c:if test="${(not empty sessionScope.sessionId)}">
						<li class="logout"><a href="/challengPrj/logout"><i class="xi-log-out xi-x"></i>로그아웃</a></li>
						<!--  <li class="mpage"><a href="#"><i class="xi-user xi-x"></i>마의페이지</a></li>-->
					</c:if>
					
					<c:if test="${(empty sessionScope.sessionId)}">
						<li class="login"><a href="/challengPrj/login"><i class="xi-log-in xi-x"></i>로그인</a></li>
						<li class="join"><a href="/challengPrj/join.jsp"><i class="xi-user-plus xi-x"></i>회원가입</a></li>
					</c:if>
				</ul>
			</div>
			<!-- util_hd_menu_box -->
		</div>
		<!-- // container -->
		
	</div>
<!-- // header -->   