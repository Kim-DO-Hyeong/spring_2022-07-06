<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입(3) - 가입완료</title>
</head>
<body>
	<p><strong style="color:blue;">${requestScope.registerRequest.name }</strong>회원 가입을 완료했습니다. </p>
	<p>
		<spring:message code="register.done" >
			<spring:argument value="${registerRequest.name }"/>
		</spring:message> 
	</p>
	
	<p>a<a href="http://localhost/2022-07-06/main">[<spring:message code="go.main"/>]</a></p>
</body>
</html>