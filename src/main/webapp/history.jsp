<%@page import="wifi.WiFiDate" %>
<%@page import="wifi.DbHistory" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>와이파이 정보 구하기</title>
<style>
table {
	border_collapse: collapse;
	width: 100%;
	height: 40px;
}
tr:nth-child(even) {
	background_color: #f2f2f2;
}
th {
	background-color: #04AA6D;
	color: white;
}
td {
	text-align: left;
}
</style>
</head>
<body>
	<h1>위치 히스토리 목록</h1>
	<p>
		<a href="home.jsp">홈 |</a>
		<a href="history.jsp">위치 히스토리 목록 |</a>
		<a href="">Open API 와이파이 정보 가져오기</a>
	</p>
	<table>
		<tr>
			<th>ID</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>조회일자</th>
			<th>비고</th>
		</tr>
		<%
			WiFiDate d = new WiFiDate();
			for(DbHistory h : d.historySelect()) {
		%>
		<tr>
			<th><%h.getId(); %></th>
			<th><%h.getMyLat(); %></th>
			<th><%h.getMyLnt(); %></th>
			<th><%h.getDate(); %></th>
			<form action="history.jsp">
			<th><input type="submit" value="삭제"></th>
			</form>
		</tr>
		<%} %>
	</table>
</body>
</html>