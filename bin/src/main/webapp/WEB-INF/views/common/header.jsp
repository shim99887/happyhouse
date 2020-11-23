<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	String root = request.getContextPath();
%>
<html>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">

	<!-- 시작: 상단 네비게이션 바 -->
	<div class="container">
		<div class="container">
			<a class="navbar-brand" href="<%=root%>/">HappyHouse</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link"
						href="<%=root%>/move.do?page=notice">공지사항</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=root%>/housedeal/">매물 검색</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=root%>/move.do?page=areainfo">동네 정보</a></li>
					<li class="nav-item"
						style="margin-right: 20px; margin-left: 20px; color: white"><a
						class="nav-link disabled">|</a></li>
					<c:choose>
						<c:when test="${sessionScope.userinfo eq null}">
							<!-- 로그인한 사용자가 없는 경우 -->
							<li class="nav-item"><a class="nav-link" data-toggle="modal"
								href="#loginModal">로그인</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="modal"
								href="#registerModal">회원가입</a></li>

						</c:when>
						<c:otherwise>
							<!-- 로그인한 사용자가 있는 경우 -->
							<li id="logoutBtn" class="nav-item" style="color: white;"><a
								class="nav-link disabled"><b>${sessionScope.userinfo.name}</b>님</a></li>
							<li id="logoutBtn" class="nav-item"><a class="nav-link"
								href="<%=root%>/logout">로그아웃</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<%=root%>/mypage">마이페이지</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
	<!-- 종료: 상단 네비게이션 바 -->
</nav>

<!-- Modal -->
<c:if test="${sessionScope.userinfo eq null}">
	<!-- 로그인한 사용자가 없는 경우 -->
	<!-- 시작: 로그인 모달 -->
	<div class="modal" id="loginModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">로그인</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form id="login">
						<div class="form-group">
							<label for="usr">아이디:</label> <input type="text"
								class="form-control" id="usr" name="id" required>
						</div>
						<div class="form-group">
							<label for="pwd">비밀번호:</label> <input type="password"
								class="form-control" id="pwd" name="pwd" required>
						</div>
						<button type="button" data-dismiss="modal" class="btn btn-primary"
							id="btn-login" onclick="javascript:login()">로그인</button>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button class="btn btn-secondary" id="btn-pwd" data-toggle="modal"
						href="#findPwdModal">비밀번호 찾기</button>
				</div>

			</div>
		</div>
	</div>
	<!-- 종료: 로그인 모달 -->
	<!-- 시작: 회원가입 모달 -->
	<div class="modal" id="registerModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">회원가입</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form id="register">
						<div class="form-group">
							<label for="registerId">아이디:</label> <input type="text"
								class="form-control" id="registerId" name="id" required>
						</div>
						<div class="form-group">
							<label for="registerPwd">비밀번호:</label> <input type="password"
								class="form-control" id="registerPwd" name="pwd" required>
						</div>
						<div class="form-group">
							<label for="registerName">이름:</label> <input type="text"
								class="form-control" id="registerName" name="name" required>
						</div>
						<div class="form-group">
							<label for="registerAddr">주소:</label> <input type="text"
								class="form-control" id="registerAddr" name="addr" required>
						</div>
						<div class="form-group">
							<label for="registerTel">전화번호:</label> <input type="tel"
								class="form-control" id="registerTel"
								placeholder="010-0000-0000" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
								name="tel" required>
						</div>
						<button type="button" class="btn btn-primary" id="btn-register"
							onclick="javascript:join()">회원가입</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 종료: 회원가입 모달창 -->
	<!-- 시작: 비밀번호 찾기 모달 -->
	<div class="modal" id="findPwdModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">비밀번호 찾기</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<h4>제공하신 이메일로 재발송 해드립니다.</h4>
					<form id="findPwd" method="post" action="<%=root%>/findpwd">
						<div class="form-group">
							<label for="findPwdId">아이디:</label> <input type="text"
								class="form-control" id="findPwdId" name="id" required>
						</div>
						<button type="submit" class="btn btn-primary" id="btn-findPwd">새로운
							비밀번호</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function login() {
			document.getElementById("login").action = "<%=root%>/login";
			document.getElementById("login").method = "post";
			document.getElementById("login").submit();
		}
		
		function join() {
			document.getElementById("register").action = "<%=root%>/join";
			document.getElementById("register").method = "post";
			document.getElementById("register").submit();
		}
	</script>
	<!-- 종료: 비밀번호찾기 모달창 -->
</c:if>
<script type="text/javascript">
	$(function() {
		let msg = "${requestScope.msg}";

		console.log("msg ===> ", msg);

		if (msg !== null && msg !== "") {
			alert(msg);
		}
	});
</script>
</html>
