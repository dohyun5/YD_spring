<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 정보</title>
</head>
<body>
	<table>
        <tr>
            <th>번호</th>
            <td>${board.bno}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${board.title}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${board.writer}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea rows="3" cols="2" style="width: 100px;" readonly>${board.contents}</textarea></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <c:choose>
            <c:when test="${not empty board.image}">
	            <td><img style="width:200px;" src='<c:url value="/resources/image/${board.image}"/>'></td> <!-- 이미지는 보통 C태그로 왼쪽과 같이 사용 contextPath자동으로 붙여줌. -->
            </c:when>
            <c:otherwise>
            	<td>파일없음</td>
            </c:otherwise>
            </c:choose>
            <!-- <td><img src="${pageContext.request.contextPath}/resources/image/${board.image}"></td>  --> <!-- 절대경로 contextpath 사용방법 - el태그 혹은 c태그 -->
        </tr>
        <tr>
            <th>작성일자</th>
            <td><fmt:formatDate value="${board.updatedate }" type="date" pattern="YYYY년MM월dd일"/></td>
        </tr>
    </table>
    <button type="button" onclick="location.href='boardUpdate?bno=${board.bno}'">수정</button>
    <button type="button" onclick="location.href='boardDelete?bno=${board.bno}'">삭제</button>
    <button type="button" onclick="location.href='boardList'">목록</button>
</body>
</html>