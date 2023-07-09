<%@ page import="wifi.WiFiDate" %>
<%@ page import="wifi.DbWIFI" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	<h1>와이파이 정보 구하기</h1>
	<p>
		<a href= "home.jsp">홈 |</a>
		<a href= "history.jsp">위치 히스토리 목록 |</a>
		<a href="">Open API 와이파이 정보 가져오기</a>
	</p>
	<form action="homewifi.jsp" method="post">	
	<div>
		<a>LAT: <input type="text" name="lat" value=0.0></a>
		<a>LAT: <input type="text" name="lnt" value=0.0></a>
		<a><input type="button" value="내 위치 가져오기"></a>
		<a><input type="submit" name="search" value="근처 WiFi정보 보기"></a>
	</div>
	</form>
	<div>
	<table>
		<tr>
			<th>거리</th>
			<th>관리번호</th>
			<th>자치구</th>
			<th>와이파이명</th>
			<th>도로명주소</th>
			<th>상세주소</th>
			<th>설치위치(층)</th>
			<th>설치유형</th>
			<th>서비스구분</th>
			<th>망종류</th>
			<th>설치년도</th>
			<th>실내외구분</th>
			<th>WIFI접속환경</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>작업일자</th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	</div>

</body>
</html>