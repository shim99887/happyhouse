<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  123, 166 Google API Key 입력후 테스트 -->
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

	<!-- 시작: 상단 배너 -->
	<header>
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<!-- Slide One - Set the background image for this slide in the line below -->
				<div class="carousel-item active"
					style="background-image: url('./img/아파트.jpg')">
					<div style="background-color: #EFDA97"
						class="carousel-caption d-none d-md-block">
						<h2 style="color: #DD7A5D">아파트 정보</h2>
					</div>
				</div>
				<!-- Slide Two - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('./img/연립다세대.jpg')">
					<div style="background-color: #EFDA97"
						class="carousel-caption d-none d-md-block">
						<h2 style="color: #DD7A5D">연립다세대 정보</h2>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</header>
	<!-- 종료: 상단 배너 -->

	<!-- Page Content -->
	<div class="container mt-5">
		<!-- 시작: 기사 목록 -->
		<h1 class="my-4">뉴스 기사</h1>

		<!-- Marketing Icons Section -->
		<div class="row">
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">연합 뉴스</h4>
					<div class="card-body">
						<p class="card-text">지난달 서울 아파트 매매 6천880건으로 전달보다 57% 감소 30대 구매
							비중 36.9%로 역대 최고…강서·성북·동작구 등 8개구 40% 넘겨 지난달 서울 아파트 매매거래가 60%...</p>
					</div>
					<div class="card-footer">
						<a
							href="https://www.yna.co.kr/view/AKR20200921019000003?input=1195m"
							class="btn btn-primary">더 보기</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">땅집고</h4>
					<div class="card-body">
						<p class="card-text">21일 한국감정원에 따르면 지난 8월 수도권(서울·경기·인천) 아파트 매매
							건수는 총 2만7688건으로 전달(5만2472건) 대비 47.2% 줄었다.</p>
					</div>
					<div class="card-footer">
						<a
							href="http://realty.chosun.com/site/data/html_dir/2020/09/21/2020092100935.html"
							class="btn btn-primary">더 보기</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">뉴스 1</h4>
					<div class="card-body">
						<p class="card-text">문재인 정부 출범 이후 3년간 서울 강남구 초고가 아파트 매매 비율이
							50%포인트(p) 이상 급증한 것으로 나타났다.</p>
					</div>
					<div class="card-footer">
						<a href="https://www.news1.kr/articles/?4064639"
							class="btn btn-primary">더 보기</a>
					</div>
				</div>
			</div>
			<!-- 종료: 기사 목록 -->
		</div>
		<!-- /.row -->

		<!-- 시작: 대표 거래 목록 -->
		<h2>대표 매매 건</h2>
		<br>

		<div class="row">
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top" src="./img/아파트.jpg"
						alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">아파트 매매</a>
						</h4>
						<p class="card-text">12억</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top" src="./img/연립다세대.jpg"
						alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">연립다세대 매매</a>
						</h4>
						<p class="card-text">20억</p>
					</div>
				</div>
			</div>
		</div>
		<!-- 종료: 대표 거래 목록 -->
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<%@ include file="/WEB-INF/views/common/footer.html"%>


	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
