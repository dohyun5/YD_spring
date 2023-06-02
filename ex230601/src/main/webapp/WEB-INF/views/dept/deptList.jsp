<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서목록</h1>
	
	<c:forEach items="${deptList}" var="dept">
		<ul>
			<li style="list-style:none;">${dept.departmentId} - ${dept.departmentName } - ${dept.managerId } - ${dept.locationId }</li>
		</ul>
	</c:forEach>
	
	
	
	
	
</body>
</html>