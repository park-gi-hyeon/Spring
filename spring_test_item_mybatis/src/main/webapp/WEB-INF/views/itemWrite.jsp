<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" >
		<form method="post" action="writeResult">
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="name" size="50">
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name="price" size="50">
				</td>
			</tr>
			<tr>
				<td>설명</td>
				<td>
					<input type="text" name="description" size="50">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="전송">&nbsp;
					<input type="reset" value="취소">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>