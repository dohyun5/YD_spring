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
	<a href="empInsert">등록(페이지로 이동)</a>
	<!-- ${empVO } -->
	<form action="empList">
		부서<input name="departmentId" value=${emp.departmentId }>
		이름<input name="firstName" value=${emp.firstName }>
		<button>검색</button>
		<button type="reset">초기화</button>
	</form>
	<c:forEach items="${empList}" var="emp">
	<ul>
		<li style="list-style:none;">
			${emp.firstName } - ${emp.lastName } - ${emp.email } - ${emp.hireDate} - ${emp.departmentId } <a href="empUpdate?empId=${emp.employeeId}">수정</a>    <a href="empDelete?empId=${emp.employeeId}">삭제</a>
		</li>
	</ul>
	</c:forEach>
	
</body>
</html>

