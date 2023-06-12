<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="login_ok">
		<table width="500" border="1">
			<tr>
				<td>사용자 ID</td>
				<td>
					<input type="text" name="mem_uid" maxlength="15">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="mem_pwd" maxlength="15">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로 그 인">
					&nbsp;&nbsp;&nbsp;&nbsp;
<!-- 					 controller에 register찾아감 -->
					<a href="register">회원가입</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>