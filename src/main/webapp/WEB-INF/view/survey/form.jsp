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
	<h2>설문조사</h2>
	<form action="/2022-07-06/survey" method="POST">
		<c:forEach var="question" items="${questions}" varStatus="status">
			<p>
				<h3>${status.count}. ${question.title }</h3>
				
				<c:if test="${empty question.options }">
					<input type="text" name="responses[${status.index }]">
				</c:if>
				
				<c:if test="${not empty question.options }">
					<c:forEach items="${question.options }" var="option">
						<label><input type="radio" name="responses[${status.index }]" value="${option }">${option} </label>
					</c:forEach>
				</c:if>
			</p>
		</c:forEach>
		
		
		<p>
			<label>응답자의 지역 : <input type="text" name="res.location"> </label>
		</p>
		
		<p>
			<label>응답자의 나이 : <input type="text" name="res.age"> </label>
		</p>
	
		<input type="submit" value="전송">
	</form>
</body>
</html>