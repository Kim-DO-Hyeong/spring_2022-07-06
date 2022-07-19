<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입(2) - 회원 정보 입력</title>
</head>
<body>

	<form:form action="http://localhost/2022-07-06/register/step3" method="POST" modelAttribute="registerRequest">
		<p>
			<label>이메일 : <br>
				<form:input path="email" />
			</label>
		</p>
		<p>
			<label>이름 : <br>
				<form:input path="name" />
			</label>
		</p>
		
		<p>
			<label>비밀번호 : <br>
				<form:password path="password" />
			</label>
		</p>
		
		<p>
			<label>비밀번호 확인 : <br>
				<form:password path="confirmPassword" />
			</label>
		</p>
		<input type="submit" value="회원 가입"/>
	</form:form>

	
</body>
</html>