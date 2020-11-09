<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
</head>
<body>
	<!-- header 네비게이션 바 -->
	<%@ include file="/common/header.jsp"%>
	<!-- Page Content -->
	<div class="container" style="margin-top: 5%">

		<section id="index_section">
			<div class="card col-sm-12 mt-1" style="min-height: 850px;">
				<div class="card-body">
					<script>
						let colorArr = [ 'table-primary', 'table-success', 'table-danger' ];
						$(document).ready(function() {
							$.get("${pageContext.request.contextPath}/map", {
								act : "all"
							}, function(data, status) {
								geocode(data);
							}, "json");
						})
						$(document).ready(function() {
							$.get("${pageContext.request.contextPath}/map", {
								act : "sido"
							}, function(data, status) {
								$.each(data, function(index, vo) {
									$("#sido").append("<option value='"+vo.sido_code+"'>" + vo.sido_name + "</option>");
								});//each
							}//function
							, "json");//get
						});//ready
						$(document).ready(function() {
							$("#sido").change(function() {
								$.get("${pageContext.request.contextPath}/map", {
									act : "gugun",
									sido : $("#sido").val()
								}, function(data, status) {
									$("#gugun").empty();
									$("#gugun").append('<option value="0">선택</option>');
									$.each(data, function(index, vo) {
										$("#gugun").append("<option value='"+vo.gugun_code+"'>" + vo.gugun_name + "</option>");
									});//each
								}//function
								, "json");//get
							});//change
							$("#gugun").change(function() {
								$.get("${pageContext.request.contextPath}/map", {
									act : "dong",
									gugun : $("#gugun").val()
								}, function(data, status) {
									$("#dong").empty();
									$("#dong").append('<option value="0">선택</option>');
									$.each(data, function(index, vo) {
										$("#dong").append("<option value='"+vo.dong+"'>" + vo.dong + "</option>");
									});//each
								}//function
								, "json");//get
							});//change
							$("#dong").change(function() {
								$.get("${pageContext.request.contextPath}/map", {
									act : "apt",
									dong : $("#dong").val()
								}, function(data, status) {
									$("#searchResult").empty();
									$("#searchResult2").empty();
									initMap();
									$.each(data, function(index, vo) {
										let str = "<tr class=" + colorArr[index % 3] + ">" + "<td>" + vo.no + "</td>" + "<td>" + vo.dong + "</td>" + "<td>" + vo.aptName + "</td>" + "<td>" + vo.jibun + "</td>" + "<td>" + vo.code + "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
										$("#searchResult").append(str);
										//$("#searchResult").append(vo.dong+" "+vo.aptName+" "+vo.jibun+"<br>");
									});//each
									geocode(data);
								}//function
								, "json");//get
							});//change
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
					<div id="searchApt">
						<label for="searchApt">아파트검색:</label>
						<input type="text" id="aptName" placeholder="아파트 검색"
							name="searchApt">
						<button type="button" id="searchAptBtn" class="btn btn-primary">검색</button>
					</div>
					<div id="searchRent">
						<button type="button" id="searchAptTradeBtn" class="btn btn-primary">아파트 매매</button>
						<button type="button" id="searchHouseTradeBtn" class="btn btn-primary">다세대 매매</button>
						<button type="button" id="searchAptRentBtn" class="btn btn-primary">아파트 대여</button>
						<button type="button" id="searchHouseRentBtn" class="btn btn-primary">다세대 대여</button>
					</div>
					시도 : <select id="sido">
						<option value="0">선택</option>
					</select> 구군 : <select id="gugun">
						<option value="0">선택</option>
					</select> 읍면동 : <select id="dong">
						<option value="0">선택</option>
					</select>
					<table class="table mt-2">
						<thead>
							<tr>
								<th>번호</th>
								<th>동</th>
								<th>아파트이름</th>
								<th>지번</th>
								<th>지역코드</th>
								<th>위도</th>
								<th>경도</th>
							</tr>
						</thead>
						<tbody id='searchResult'>
						</tbody>
					</table>
					<table class="table mt-2">
						<thead>
							<tr id="searchTr">
								<th>실거래  가격</th>
							</tr>
						</thead>
						<tbody id='searchResult2'>
						</tbody>
					</table>

					<div id="map" style="width: 100%; height: 500px; margin: auto;"></div>
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
							map = new google.maps.Map(document.getElementById('map'), {
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
								position : new google.maps.LatLng(parseFloat(tmpLat), parseFloat(tmpLng)),
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
										let str = "<tr class="+colorArr[0]+">" + "<td>" + vo.no + "</td>";
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
						function callHouseDealInfo(lat, lng, vo) {
							$("#searchResult").empty();
							let str = "<tr class="+colorArr[0]+">" + "<td>" + vo.no + "</td>" + "<td>" + vo.dong + "</td>" + "<td>" + vo.aptName + "</td>" + "<td>" + vo.jibun + "</td>" + "<td>" + vo.code + "</td><td>" + lat + "</td><td>" + lng + "</td></tr>";
							$("#searchResult").append(str);
						}

						$("#searchAptBtn").click(function() {
							$.get("${pageContext.request.contextPath}/map", {
								act : "searchApt",
								apt : $("#aptName").val()
							}, function(data, status) {
								$("#searchResult").empty();
								initMap();
								$.each(data, function(index, vo) {
									$("#searchResult2").empty();
									let str = "<tr class=" + colorArr[index % 3] + ">" + "<td>" + vo.no + "</td>" + "<td>" + vo.dong + "</td>" + "<td>" + vo.aptName + "</td>" + "<td>" + vo.jibun + "</td>" + "<td>" + vo.code + "</td><td id='lat_"+index+"'>" + vo.lat + "</td><td id='lng_"+index+"'>" + vo.lng + "</td></tr>";
									$("#searchResult").append(str);
									addMarker(vo.lat, vo.lng, vo);
								});//each
							}//function
							, "json");//get
						});//ready
						$("#searchAptTradeBtn").click(function(){
							$.get("${pageContext.request.contextPath}/map", {
								act : "aptTrade",
							}, function(data, status) {
								$("#searchResult").empty();
								initMap();
								console.log(data);
								$.each(data, function(index, vo) {
									$("#searchResult2").empty();
									let str = "<tr class=" + colorArr[index % 3] + ">" + "<td>" + vo.no + "</td>" + "<td>" + vo.dong + "</td>" + "<td>" + vo.aptName + "</td>" + "<td>" + vo.jibun + "</td>" + "<td>" + vo.code + "</td></tr>";
									$("#searchResult").append(str);
								});//each
							}//function
							, "json");//get
						});
						$("#searchHouseTradeBtn").click(function(){
							$.get("${pageContext.request.contextPath}/map", {
								act : "houseTrade",
							}, function(data, status) {
								$("#searchResult").empty();
								initMap();
								console.log(data);
								$.each(data, function(index, vo) {
									$("#searchResult2").empty();
									let str = "<tr class=" + colorArr[index % 3] + ">" + "<td>" + vo.no + "</td>" + "<td>" + vo.dong + "</td>" + "<td>" + vo.aptName + "</td>" + "<td>" + vo.jibun + "</td>" + "<td>" + vo.code + "</td></tr>";
									$("#searchResult").append(str);
								});//each
							}//function
							, "json");//get
						});
						$("#searchAptRentBtn").click(function(){
							$.get("${pageContext.request.contextPath}/map", {
								act : "aptRent",
							}, function(data, status) {
								$("#searchResult").empty();
								initMap();
								console.log(data);
								$.each(data, function(index, vo) {
									$("#searchResult2").empty();
									let str = "<tr class=" + colorArr[index % 3] + ">" + "<td>" + vo.no + "</td>" + "<td>" + vo.dong + "</td>" + "<td>" + vo.aptName + "</td>" + "<td>" + vo.jibun + "</td>" + "<td>" + vo.code + "</td></tr>";
									$("#searchResult").append(str);
								});//each
							}//function
							, "json");//get
						});
						$("#searchHouseRentBtn").click(function(){
							$.get("${pageContext.request.contextPath}/map", {
								act : "houseRent",
							}, function(data, status) {
								$("#searchResult").empty();
								initMap();
								console.log(data);
								$.each(data, function(index, vo) {
									$("#searchResult2").empty();
									let str = "<tr class=" + colorArr[index % 3] + ">" + "<td>" + vo.no + "</td>" + "<td>" + vo.dong + "</td>" + "<td>" + vo.aptName + "</td>" + "<td>" + vo.jibun + "</td>" + "<td>" + vo.code + "</td></tr>";
									$("#searchResult").append(str);
								});//each
							}//function
							, "json");//get
						});
					</script>
				</div>
			</div>
		</section>
	</div>

	<!-- Footer -->
	<%@ include file="/common/footer.html"%>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
