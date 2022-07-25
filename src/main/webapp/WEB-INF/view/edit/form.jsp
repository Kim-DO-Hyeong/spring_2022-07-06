<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 페이지</title>
</head>
<body>
	<form action="/2022-07-06/edit/changePassword" method="POST">
		<p>
			<label>현재 비밀번호 : <br>
				<input type="password" name = "currentPassword">
				<form:errors path="curentPassword"/>
			</label>
		</p>
		
		<p>
			<label>새 비밀번호 : <br>
				<input type="password" name = "newPassword">
				<form:errors path="newPassword"/>
			</label>
		</p>
		
		<p>
			<label>새 비밀번호 확인 : <br>
				<input type="password" name = "confirmNewPassword">
				<form:errors path="confirmNewPassword"/>
			</label>
		</p>
		<input type="submit" value="비밀번호 변경"> 
	</form>
</body>
</html>