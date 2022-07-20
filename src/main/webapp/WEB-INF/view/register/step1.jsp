<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스프링 메시지를 적용해서 문구들을 출력하고 있음 </h1>
	<h2><spring:message code="term" /></h2>
	<p>약관내용</p>
	<form action="http://localhost/2022-07-06/register/step2" method="POST">
		<label>
			<input type="checkbox" name="agree" value="true"><spring:message code="term.agree"/>
		</label>
		<input type="submit" value="<spring:message code="next.btn"/>">
	</form>
</body>
</html>