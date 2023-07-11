<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>loginForm~!</h1>
	<form method="post" action="j_spring_security_check">
		security id:<input type="text" name="j_username"><br>
		security pw:<input type="text" name="j_password"><br>
					<input type="submit" value="S login">
	</form>
</body>
</html>