<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날짜를 사용한 회원 정보 조회 페이지</title>
</head>
<body>
	
	<form:form action="/2022-07-06/members" method="GET" modelAttribute="cmd">
		<p>
			<label>from: <form:input path="from"/> <form:errors path="from"/> </label>
			
			~
			
			<label>to: <form:input path="to"/> <form:errors path="to"/> </label>
			
			<input type="submit" value="조회"> 
		</p>
	</form:form>
		
	<c:if test="${not empty members }">
		<table>
			<tr>
				<th>아이디</th>
				<th>이메일</th>
				<th>이름</th>
				<th>가입일</th>
			</tr>
			<c:forEach var="member" items="${members }" >
				<tr>
					<td>${member.id }</td>
					<td>${member.email }</td>
					<td>${member.name }</td>
					<td>${member.registerDateTime }</td>
				</tr>
			</c:forEach>
			
		</table>
	
	</c:if>
	
	
</body>
</html>