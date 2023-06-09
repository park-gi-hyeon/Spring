<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#checkJson").click(function(){
				var member = {id:"park",pw:"1234",name:"박지성",email:"park@test.com"};
				$.ajax({
					type:"post"
				   ,url: "${contextPath}/sample/info"
				   ,contentType:"application/json"
				   ,data:JSON.stringify(member)
				   ,success:function(data){}
				   ,error:function(){
					   alert("오류가 발생하였습니다.");
				   }
				}); //end ajax
			});//end click function
		});//end function
	</script>
</head>
<body>
<!-- 	ticket_test.jsp -->
	<input type="button" id="checkJson" value="회원 정보 보내기"><br>
</body>
</html>