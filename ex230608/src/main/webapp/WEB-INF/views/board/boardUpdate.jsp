<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<form name="updateForm" action="boardUpdate" method="POST" onsubmit="return false;"> <!--  -->
		<div>
			<h3>게시글 수정</h3>
		</div>
		<table>
			<tr>
				<th>번호</th>
				<td><input type="number" name="bno" value="${board.bno}" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${board.title}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${board.writer}" readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${board.contents}</textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="text" name="image" value="${board.image}"></td>
			</tr>
			<tr>
				<th>수정날짜</th>
				<td><input type="date" name="updatedate" value="<fmt:formatDate value="${board.updatedate}" type="date" pattern="yyyy-MM-dd"/>"></td> 
				<!-- input이 인정하는 형태로 가져와야함. -으로 가져와야 제대로 인식함. -->
				<!-- 통신할때는 string으로 주고받음 -->
			</tr>
		</table>
		<button type="submit">수정완료</button>
		<button type="button" onclick="location.href='boardInfo?bno=${board.bno}'">취소</button>
	</form>
	<script>
		function updateAjax(e){
			let boardData = new FormData(document.querySelector("[name='updateForm']"));
			
			fetch(updateForm.action, {
				method : 'POST',
				body : boardData
			})
			.then(response => response.json())
			.then(data => {
				let message = '결과 : ' + data.result + '게시글 번호 : ' + data['board_no']; //board_no controller의 update쪽 참고
				alert(message);
			})
			.catch(err => console.log(err));
		}
		document.querySelector('button[type="submit"]').addEventListener('click',updateAjax);
	</script>
</body>
</html>