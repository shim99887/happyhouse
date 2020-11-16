<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String root = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div id="searchApt">
		<label for="searchApt">아파트검색:</label>
		<form action="searchApt">
			<input type="text" id="aptName" placeholder="아파트 검색" name="aptName">
			<input type="submit" value="검색"></input>
		</form>
	</div>
	<div id="searchRent">
		<button type="button" id="searchAptTradeBtn" class="btn btn-primary"><a href = "<%=root%>/housedeal/searchType?type=1" >아파트 매매</a></button>
		<button type="button" id="searchHouseTradeBtn" class="btn btn-primary"><a href = "<%=root%>/housedeal/searchType?type=2" >다세대 매매</a></button>
		<button type="button" id="searchAptRentBtn" class="btn btn-primary"><a href = "<%=root%>/housedeal/searchType?type=3" >아파트 대여</a></button>
		<button type="button" id="searchHouseRentBtn" class="btn btn-primary"><a href = "<%=root%>/housedeal/searchType?type=4" >다세대 대여</a></button>
	</div>
	<div>
		시도 : <select id="sido">
		<c:forEach var="sido" items="${sidos}">
			<option value="${sido.sidoCode}">${sido.sidoName}</option>
		</c:forEach>
		</select>
		구군 : <select id="gugun">
 
		</select>
		읍면동 : <select id="dong">

		</select>
	</div>
	
	<table	align="center">
		<c:choose>
			<c:when test="${empty detail}">
				<caption> 집 목록 </caption>
				<thead>	
					<tr><td width="100">번호</td>
						<td width="100">동</td>
						<td width="200">아파트 이름</td>
						<td width="100">지번</td>
						<td width="100">지역 코드</td>
					</tr>
				</thead>
				<tbody id="houseList">
						<c:forEach  var="housedeal"		items="${list}">
							<tr>
								<td width="100">${housedeal.no}</td>
								<td width="100">${housedeal.dong}</td>
								<td width="200"><a href = "<%=root%>/housedeal/searchDetail?no=${housedeal.no}">${housedeal.aptName}</a></td>
								<td width="100">${housedeal.jibun}</td>
								<td width="100">${housedeal.code}</td>
							</tr>	
						</c:forEach>
				</tbody>
			</c:when>
			<c:otherwise>
				<caption> 세부 사항 </caption>
				<thead>	
					<tr><td width="100">번호</td>
						<td width="100">동</td>
						<td width="200">아파트 이름</td>
						<td width="100">지역코드</td>
						<td width="100">가격</td>
						<td width="100">건축 연도</td>
						<td width="100">거래 연도</td>
						<td width="100">면적</td>
						<td width="100">층수</td>
						<td width="100">지번</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="100">${detail.no}</td>
						<td width="100">${detail.dong}</td>
						<td width="200">${detail.aptName}</td>
						<td width="100">${detail.code}</td>
						<td width="100">${detail.dealAmount}</td>
						<td width="100">${detail.buildYear}</td>
						<td width="100">${detail.dealYear}</td>
						<td width="100">${detail.area}</td>
						<td width="100">${detail.floor}</td>
						<td width="100">${detail.jibun}</td>
					</tr>	
				</tbody>
			</c:otherwise>
		</c:choose>
	</table>
	<script>
	$(document).ready(function(){
	    $("#sido").change(function(){
	    $("#gugun").empty();
	        $.get("http://localhost:8000/happyhouse/api/map/goon",{
	            sido : $("#sido").val()
	        }, function(data, status) {
	            $.each(data, function(index, vo) {
	                $("#gugun").append("<option value='"+vo.gugunCode+"'>" + vo.gugunName + "</option>");
	            });//each
	        }//function)
	        );
	    });
	    $("#gugun").change(function(){
            $("#dong").empty();
            $.get("http://localhost:8000/happyhouse/api/map/dong",{
                gugun : $("#gugun").val()
            }, function(data, status) {
                $.each(data, function(index, vo) {
                    $("#dong").append("<option value='"+vo+"'>" + vo + "</option>");
                });//each
            }//function)
            );
        });
	    $("#dong").change(function(){
	    	$("#houseList").empty();
	    	console.log($("#dong").text());
	    	document.location.href = "http://localhost:8000/happyhouse/housedeal/searchDong?dong=" + $("#dong").children("option:selected").val();
/* 	        $.get("http://localhost:8000/happyhouse/housedeal/searchDong",{
	            dong : $("#dong").val()
	        }, function(data, status) {
	            $.each(data, function(index, vo) {
	                $("#houseList").append("<td width='100'>" + vo.no + "</td>" +
					"<td width='100'>" + vo.dong + "</td>" +
					"<td width='200'> " + vo.aptName + "</td>" +
					"<td width='100'>" + vo.jibun + "</td>" +
					"<td width='100'>" + vo.code + "</td>)"";
	            });//each
	        }//function)
	        ); */
	    });
	})
	</script>
</body>
</html>