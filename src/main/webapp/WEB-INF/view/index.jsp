<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${empty authInfo }">
		<p><a href="/2022-07-06/register/step1">[회원 가입하기]</a></p>
		<p><a href="/2022-07-06/login">[로그인]</a></p>
	</c:if>
	
	<c:if test="${not empty authInfo }">
		<p>${authInfo.name }님 환영합니다!</p>
		<p><a href="/2022-07-06/edit/changePassword">[비밀번호 변경]</a></p>
		<p><a href="/2022-07-06/logout">[로그아웃]</a></p>
	</c:if>

</body>
</html>