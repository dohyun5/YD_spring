<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sec:csrfMetaTags/> <!-- meta에 정보 -->
<title>Insert title here</title>
</head>
<body>
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<sec:authorize access="hasAuthority('ROLE_ADMIN')">
			<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
		</sec:authorize>
	</ul>

	<sec:authorize access="isAuthenticated()">
		<form action="logout" method="post">
			<sec:csrfInput /> <!-- 태그를 집어 넣는것 -->
			<button>로그아웃</button>
		</form>
	</sec:authorize>
		<!-- <input type=“hidden” name=“${_csrf.parameterName}” vlue=“${_crf.token}”> -->
		<input type="hidden" name="csrf_name" value="${_csrf.parameterName }">
		<input type="hidden" name="csrf_val" value="${_csrf.token }"> <!-- 경우에따라 변동 가능. -->
</body>
</html>