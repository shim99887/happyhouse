<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table	align="center">
		<caption> 책 목록 </caption>
		<thead>	
			<tr><td width="150">번호</td>
				<td width="150">동</td>
				<td width="100">아파트 이름</td>
				<td width="100">지번</td>
				<td width="100">지역 코드</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach  var="housedeal"		items="${list}">
				<tr>
					<td width="150">${housedeal.no}</td>
					<td width="150">${housedeal.dong}</td>
					<td width="100">${housedeal.aptName}</td>
					<td width="100">${housedeal.jibun}</td>
					<td width="100">${housedeal.code}</td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
</body>
</html>