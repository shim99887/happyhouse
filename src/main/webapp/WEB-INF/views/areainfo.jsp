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
	<%@ include file="/common/header.jsp"%>

	<!-- Page Content -->
	<div class="container" style="margin-top: 40px">

		<!-- Page Heading/Breadcrumbs -->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
			<li class="breadcrumb-item active">동네 정보</li>
		</ol>

		<!-- Content Row -->
		<div class="row">
			<!-- 왼쪽 사이드바 -->
			<%@ include file="/independent/fav-area.jsp"%>

			<!-- Content Column -->
			<div class="col-lg-9 mb-4">
				<h2>동네 정보 검색</h2>
				<div class="row" style="margin-top: 10px">
					시도 : <select id="sido">
						<option value="0">선택</option>
					</select> 구군 : <select id="gugun">
						<option value="0">선택</option>
					</select> 읍면동 : <select id="dong">
						<option value="0">선택</option>
					</select>

					<button type="button" style="margin-left: 40px">관심지역으로 설정</button>
				</div>

				<div class="row" style="margin-top: 10px">
					<div class="btn-group" style="margin-left: 15px">
						<button type="button" class="btn btn-primary" id="btnComm">상권</button>
						<button type="button" class="btn btn-primary" id="btnEnv">환경</button>
						<button type="button" class="btn btn-primary" id="btnCovidScreen">코로나
							선별진료소</button>
						<button type="button" class="btn btn-primary" id="btnSafeHospital">국민
							안심병원</button>
					</div>
				</div>
				<table class="table mt-2">
					<tbody id="searchResult">
					</tbody>
				</table>
				
				<div id="map"
					style="width: 100%; height: 500px; margin: auto; margin-top: 20px;"></div>
				<script
					src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
				<script defer
					src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCLMaS6LoAJex9_R7-lqa1_EswqT-fqDj4&callback=initMap"></script>
				<script>
					var multi = {
						lat : 37.5665734,
						lng : 126.978179
					};
					var map;
					function initMap() {
						map = new google.maps.Map(document
								.getElementById('map'), {
							center : multi,
							zoom : 12
						});
						var marker = new google.maps.Marker({
							position : multi,
							map : map
						});
					}
					function addMarker(tmpLat, tmpLng, vo) {
						var marker = new google.maps.Marker({
							position : new google.maps.LatLng(
									parseFloat(tmpLat), parseFloat(tmpLng)),
							label : vo.aptName,
							title : vo.aptName
						});
						marker.addListener('click', function() {
							$.get("${pageContext.request.contextPath}/map", {
								act : "getDealAmount",
								apt : vo.aptName
							}, function(data, status) {
								$.each(data, function(index, vo) {

									$("#searchResult2").empty();
									let str = "<tr class="+colorArr[0]+">"
											+ "<td>" + vo.no + "</td>";
									$("#searchResult2").append(str);
								});//each
							}//function
							, "json");//get

							map.setZoom(17);
							map.setCenter(marker.getPosition());
							callHouseDealInfo(tmpLat, tmpLng, vo);
						});
						marker.setMap(map);
					}
				</script>
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<%@ include file="/common/footer.html"%>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
<script type="text/javascript">
	let colorArr = [ 'table-primary', 'table-success', 'table-danger' ];
	/* 	$(document).ready(function() {	// 전체 마커 띄우는 코드
	 $.get("${pageContext.request.contextPath}/map", {
	 act : "all"
	 }, function(data, status) {
	 geocode(data);
	 }, "json");
	 }) */
	$(function() {
		// 시도 select items
		$.get("${pageContext.request.contextPath}/map", {
			act : "sido"
		}, function(data, status) {
			$.each(data, function(index, vo) {
				$("#sido").append(
						"<option value='"+vo.sido_code+"'>" + vo.sido_name
								+ "</option>");
			});
		}, "json");
	});
	$(function() {
		// 시도 -> 구군  select items
		$("#sido").change(
				function() {
					$.get("${pageContext.request.contextPath}/map", {
						act : "gugun",
						sido : $("#sido").val()
					}, function(data, status) {
						$("#gugun").empty();
						$("#gugun").append('<option value="0">선택</option>');
						$.each(data, function(index, vo) {
							$("#gugun").append(
									"<option value='"+vo.gugun_code+"'>"
											+ vo.gugun_name + "</option>");
						});
					}, "json");
				});
		// 구군 -> 읍면동  select items
		$("#gugun").change(
				function() {
					$.get("${pageContext.request.contextPath}/map", {
						act : "dong",
						gugun : $("#gugun").val()
					}, function(data, status) {
						$("#dong").empty();
						$("#dong").append('<option value="0">선택</option>');
						$.each(data, function(index, vo) {
							$("#dong").append(
									"<option value='"+vo.dong+"'>" + vo.dong
											+ "</option>");
						});
					}, "json");
				});
		// 동 -> action
		$("#dong").change(function() {
			$.get("${pageContext.request.contextPath}/map",
				{
					act : "comm",
					sido : $("#sido").val(),
					gugun : $("#gugun").val(),
					dong : $("#dong").val()
				}, function(data, status) {
					$("#searchResult").empty();
					$("#searchResult2").empty();
					initMap();
					$.each(data, function(index, comm) {
						let str = "<tr class="+ colorArr[index % 3]+ ">"+ "<td>"+ comm.id+ "</td>"+ "<td>"+ comm.shopname+ "</td>"+ "<td>"+ comm.codename + "</td>"+ "<td>"+ comm.address+ "</td>"+ "<td>"+ comm.code+ "</td><td id='lat_"+comm.lat+"'></td><td id='lng_"+comm.lng+"'></td></tr>";
						$("#searchResult").append(str);
						//$("#searchResult").append(vo.dong+" "+vo.aptName+" "+vo.jibun+"<br>");
					});//each
					geocode(data);
				}, "json"
			);//get
		});//change
		$("#btnComm").click(function() {
			$.get("${pageContext.request.contextPath}/area", {
				act : "comm",
				sido : $("#sido").val(),
				gugun : $("#gugun").val(),
				dong : $("#dong").val()
			}, function(data, status) {
				$("#searchResult").empty();
				initMap();
				console.log(data);
				
				$.each(data, function(index, comm) {
					console.log("index:", index, "comm:", comm);
					let str = "<tr class=" + colorArr[index % 3] + ">" + "<td>" + comm.id + "</td>" + "<td>" + comm.shopname + "</td>" + "<td>" + comm.address + "</td>" + "<td>" + comm.codename + "</td><td id='lat_"+index+"'>" + comm.lat + "</td><td id='lng_"+index+"'>" + comm.lng + "</td></tr>";
					$("#searchResult").append(str);
					addMarker(comm.lat, comm.lng, comm);
				});//each
			}//function
			, "json");//get
		});//ready
	});//ready
	function geocode(jsonData) {
		let idx = 0;
		$.each(jsonData, function(index, vo) {
			let tmpLat;
			let tmpLng;
			$.get("https://maps.googleapis.com/maps/api/geocode/json", {
				key : 'AIzaSyCLMaS6LoAJex9_R7-lqa1_EswqT-fqDj4',
				address : vo.dong + "+" + vo.aptName + "+" + vo.jibun
			}, function(data, status) {
				//alert(data.results[0].geometry.location.lat);
				tmpLat = data.results[0].geometry.location.lat;
				tmpLng = data.results[0].geometry.location.lng;
				$("#lat_" + index).text(tmpLat);
				$("#lng_" + index).text(tmpLng);
				addMarker(tmpLat, tmpLng, vo);
			}, "json");//get
		});//each
	}
	
</script>
</html>