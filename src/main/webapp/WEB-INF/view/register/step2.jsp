<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입(2) - 회원 정보 입력</title>
</head>
<body>
	<form action="http://localhost/2022-07-06/register/step3" method="POST">
		<p>
			<label>
				이메일 : <br>
				<input type="text" name="email" id="email">
			</label>
		</p>
		
		<p>
			<label>
				이름 : <br>
				<input type="text" name="name" id="name">
			</label>
		</p>
		
		<p>
			<label>
				비밀번호 : <br>
				<input type="password" name="password" id="password">
			</label>
		</p>
		
		<p>
			<label>
				비밀번호 확인 : <br>
				<input type="password" name="confirmPassword" id="confirmPassword">
			</label>
		</p>
		<input type="submit" value="회원 가입">
		
	</form>
</body>
</html>