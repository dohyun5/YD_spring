<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서목록</title>
</head>
<body>
	<h1>도서조회 / 수정</h1>
	<table border="1">
		<thead>
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>표지</th>
			<th>출판일자</th>
			<th>금액</th>
			<th>출판사</th>
			<th>도서소개</th>
		</tr>
		
		</thead>
		<tbody>
			<c:forEach items="${bookList}" var="book">
		<tr>
			<td>${book.bookNo }</td>
			<td>${book.bookName }</td>
			<td><img src="${pageContext.request.contextPath}/resources/images/${book.bookCoverimg}" style="width:50px;"></td>
			<td><fmt:formatDate value="${book.bookDate }" type="date" pattern="yyyy/MM/dd"/></td>
			<td>${book.bookPrice }</td>
			<td>${book.bookPublisher }</td>
			<td>${book.bookInfo }</td>
		</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>