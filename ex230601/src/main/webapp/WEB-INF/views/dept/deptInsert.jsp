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
	<h1>부서등록</h1>
	
	<form action="deptInsert" method="post">
		부서명<input name="departmentName"><br>
		관리자 번호<input name="managerId"><br>
		지역 번호<input name="locationId">
	</form>
	
	
	
	
</body>
</html>