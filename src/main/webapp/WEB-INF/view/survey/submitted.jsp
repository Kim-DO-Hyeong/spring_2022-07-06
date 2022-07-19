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
	<p>응답내용 : </p>
	
	<ul>
		<li>1번 문항 ${ansData.responses[0] }</li>
		<li>2번 문항 ${ansData.responses[1] }</li>
		<li>3번 문항 ${ansData.responses[2] }</li>
	</ul>
	
	<p>응답자의 위치 : ${ansData.res.location } </p>
	<p>응답자의 나이 : ${ansData.res.age } </p>
</body>
</html>