<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	
	<form:form action="/2022-07-06/login" method="POST" modelAttribute="loginCommand">
		<form:input path="email"/>
		<form:errors path="email"/>
		
		<form:password path="password"/>
		<form:errors path="password"/>

		<input type="submit" value="로그인">				
	</form:form>
</body>
</html>

