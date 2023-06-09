<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서 등록</h1>
	<form name="insertForm" action="bookInsert" method="POST">
		<table>
			<tr>
				<th>도서번호</th>
				<td><input type="text" name="bookNo" value="${bno}"></td>
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
				<th>도서소개</th>
				<td><input type="text" name="bookInfo"></td>
			</tr>
		</table>
	<button type="submit">등록</button>
	<button type="button" onclick="location.href='bookList'">조회</button>
	</form>
	<script>
    	document.querySelector('form[name="insertForm"]').addEventListener('submit', function(e){
    		e.preventDefault();
    		let bookNo = document.getElementsByName('bookNo')[0]; 
    		let bookName = document.getElementsByName('bookName')[0];	
    		let bookCoverimg = document.getElementsByName('bookCoverimg')[0];
    		let bookDate = document.getElementsByName('bookDate')[0];
    		let bookPrice = document.getElementsByName('bookPrice')[0];
    		let bookPublisher = document.getElementsByName('bookPublisher')[0];
    		let bookInfo = document.getElementsByName('bookInfo')[0];
    		if(bookNo.value == ''){
    			alert("도서번호가 입력되지 않았습니다");
    			bookNo.focus();
    			return;
    		}
    		if(bookName.value == ''){
    			alert("도서명이 입력되지 않았습니다");
    			bookName.focus();
    			return;
    		}
    		if(bookCoverimg.value == ''){
    			alert("이미지가 입력되지 않았습니다");
    			bookCoverimg.focus();
    			return;
    		}
    		if(bookDate.value == ''){
    			alert("날짜가 입력되지 않았습니다");
    			bookDate.focus();
    			return;
    		}
    		if(bookPrice.value == ''){
    			alert("가격이 입력되지 않았습니다");
    			bookPrice.focus();
    			return;
    		}
    		if(bookPublisher.value == ''){
    			alert("출판사가 입력되지 않았습니다");
    			bookPublisher.focus();
    			return;
    		}
    		if(bookInfo.value == ''){
    			alert("도서소개가 입력되지 않았습니다");
    			bookInfo.focus();
    			return;
    		}
			
    		insertForm.submit();	
    	})
    	
    </script>
</body>
</html>