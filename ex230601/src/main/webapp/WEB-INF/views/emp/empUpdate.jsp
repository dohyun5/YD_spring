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
	<h3>사원수정</h3>
	<form action="empUpdate" method="post" name="frm">
		employeeId<input name="employeeId" readonly="readonly" value="${emp.employeeId }"><br>
		이름<input name="firstName" value="${emp.firstName }"><br>
		성*<input name="lastName" value="${emp.lastName }"><br>
		email*<input name="email" value="${emp.email }"><br>
		Hire_date*<input name="hireDate" value="${emp.hireDate }"><br>
		jobId*<select name="jobId" >
			<option>--선택--</option>
			<c:forEach items="${jobs}" var="job">
				<option value="${job.jobId }">${job.jobTitle }</option>
			</c:forEach>
		</select><br>
		부서 선택 :
			<c:forEach items="${departments}" var="dept">
				<input type="radio" name="departmentId" value="${dept.departmentId }" 
					<c:if test="${dept.departmentId==emp.departmentId}">checked</c:if> >${dept.departmentName }
			</c:forEach>
		<br>
		<!-- 부서<input name="departmentId"><br>
		jobId*<input name="jobId"><br> -->
		<button>저장</button>
	</form>
	<script>
		//frm.departmentId.value = "${emp.departmentId}"
		frm.jobId.value = "${emp.jobId}"
	</script>
</body>
</html>