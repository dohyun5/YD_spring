<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
</head>
<body>
	<form name="insertForm" action="bookInsert" method="POST">
		<div>
			<h3>도서 등록</h3>
		</div>
		<table>
			<tr>
				<th>도서번호</th>
				<td><input type="number" name="bookNo" value="${bookNo}" readonly></td> <!-- 모델에 담아둔게 value값(컨트롤러에서 넘어옴) -->
			</tr>
			<tr>
				<th>도서명</th>
				<td><input type="text" name="bookName"></td>
			</tr>
			<tr>
				<th>도서표지</th>
				<td><input type="text" name="bookCoverimg"></td>
			</tr>
			<tr>
				<th>출판일자</th>
				<td><input type="text" name="bookDate"></td>
			</tr>
			<tr>
				<th>금액</th>
				<td><input type="text" name="bookPrice"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td><input type="text" name="bookPublisher"></td>
			</tr>
			<tr>
				<th>도서설명</th>
				<td><textarea name="bookInfo"></textarea></td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='bookList'">조회</button>
	</form>
	<script>
		document.querySelector('form[name="insertForm"]')
			.addEventListener('submit',function(event){
				event.preventDefault();
				let name = document.getElementsByName('bookName')[0];
				if(name.value == ''){
					alert('도서명을 입력해주세요')
					name.focus();
					return;
				}
				
				alert('도서등록이 완료되었습니다.');
				insertForm.submit();
		});
		
		
		
	</script>
</body>
</html>