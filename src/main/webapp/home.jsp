<%@ page import="wifi.WiFiDate" %>
<%@ page import="wifi.DbWIFI" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�������� ���� ���ϱ�</title>
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
	<h1>�������� ���� ���ϱ�</h1>
	<p>
		<a href= "home.jsp">Ȩ |</a>
		<a href= "history.jsp">��ġ �����丮 ��� |</a>
		<a href="">Open API �������� ���� ��������</a>
	</p>
	<form action="homewifi.jsp" method="post">	
	<div>
		<a>LAT: <input type="text" name="lat" value=0.0></a>
		<a>LAT: <input type="text" name="lnt" value=0.0></a>
		<a><input type="button" value="�� ��ġ ��������"></a>
		<a><input type="submit" name="search" value="��ó WiFi���� ����"></a>
	</div>
	</form>
	<div>
	<table>
		<tr>
			<th>�Ÿ�</th>
			<th>������ȣ</th>
			<th>��ġ��</th>
			<th>�������̸�</th>
			<th>���θ��ּ�</th>
			<th>���ּ�</th>
			<th>��ġ��ġ(��)</th>
			<th>��ġ����</th>
			<th>���񽺱���</th>
			<th>������</th>
			<th>��ġ�⵵</th>
			<th>�ǳ��ܱ���</th>
			<th>WIFI����ȯ��</th>
			<th>X��ǥ</th>
			<th>Y��ǥ</th>
			<th>�۾�����</th>
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