<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>HappyHouse</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/modern-business.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>

	<!-- header 네비게이션 바 -->
	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<!-- Page Content -->
	<div class="container" style="margin-top:40px">

		<!-- Page Heading/Breadcrumbs -->

		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
			<li class="breadcrumb-item active">마이페이지</li>
		</ol>

		<!-- Content Row -->
		<div class="row">
			<!-- 왼쪽 사이드바 -->
			<%@ include file="/WEB-INF/views/common/sidebar.jsp"%>

			<!-- Content Column -->
			<div class="col-lg-9 mb-4">
				<h2>회원 정보 수정</h2>
				<form id="register">
					<div class="form-group">
						<label for="registerId">아이디:</label> <input type="text"
							class="form-control" name="id" value="${sessionScope.userinfo.id}" readonly>
					</div>
					<div class="form-group">
						<label for="registerPwd">비밀번호 확인:</label> <input type="password"
							class="form-control" id="registerPwd" name="pwd"
							value="${sessionScope.userinfo.pwd}" required>
					</div>
					<div class="form-group">
						<div id="pwd-warn" style="color:red"></div>
					</div>
					<div class="form-group">
						<label for="registerName">이름:</label> <input type="text"
							class="form-control" id="registerName" name="name"
							value="${sessionScope.userinfo.name}" required>
					</div>
					<div class="form-group">
						<label for="registerAddr">주소:</label> <input type="text"
							class="form-control" id="registerAddr" name="addr"
							value="${sessionScope.userinfo.addr}" required>
					</div>
					<div class="form-group">
						<label for="registerTel">전화번호:</label> <input type="tel"
							class="form-control" id="registerTel"
							value="${sessionScope.userinfo.tel}" name="tel"
							pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required>
					</div>
					<div>
						<button type="button" class="btn btn-primary" id="btn-modify"
							onclick="javascript:update()">정보 수정</button>
					</div>
				</form>
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<%@ include file="/WEB-INF/views/common/footer.html"%>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
<script type="text/javascript">
	function update() {
		
		if ($("#registerPwd").val() == null || $("#registerPwd").val() == "") {
			$("#pwd-warn").html("*현재 비밀번호를 입력해주세요");
		} else {
			document.getElementById("register").action = "<%=root%>/update";
			document.getElementById("register").method = "post";
			document.getElementById("register").submit();
		}
	}
</script>

</html>
