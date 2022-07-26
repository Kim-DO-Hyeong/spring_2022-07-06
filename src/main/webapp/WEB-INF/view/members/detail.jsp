<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보를 사용한 회원 정보 조회 페이지</title>
</head>
<body>
	<p>아이디 : ${member.id }</p>
	<p>이메일 : ${member.email }</p>
	<p>이름 : ${member.name }</p>
	<p>가입일 : ${member.registerDateTime }</p>
	
</body>
</html>