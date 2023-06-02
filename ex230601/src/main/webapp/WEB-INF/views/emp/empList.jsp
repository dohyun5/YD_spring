<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사원조회</h2>
	<c:forEach items="${empList}" var="emp">
	<ul>
		<li style="list-style:none;">${emp.firstName } - ${emp.lastName } - ${emp.email } - ${emp.departmentId }</li>
	</ul>
	</c:forEach>
	
</body>
</html>