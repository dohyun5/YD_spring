<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
    <form name="insertForm" action="boardInsert" method="POST">
        <div>
            <h3>게시글 정보</h3>
        </div>
        <table>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="writer"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="contents"></textarea></td>
            </tr>
            <tr>
                <th>첨부이미지</th>
                <td><input type="text" name="image" ></td>
            </tr>
        </table>
        <button type="submit" id="btn">등록</button>
        <button type="button" onclick="location.href='boardList'">목록</button>
    </form>
    <script>
    	document.querySelector('form[name="insertForm"]').addEventListener('submit', function(e){
    		e.preventDefault();//기존에 등록되어있는 동작을 막는것.
    		let title = document.getElementsByName('title')[0]; //배열로 가져오기 때문에 하나를 가져오더라도 index를 추가하지 않으면 받아오지 못함.
    		let writer = document.getElementsByName('writer')[0];	
    		let contents = document.getElementsByName('contents')[0];
    		
    		if(title.value == ''){
    			alert("제목이 입력되지 않았습니다");
    			title.focus();
    			return;
    		}
    		
    		if(writer.value == ''){
    			alert("작성자가 입력되지 않았습니다");
    			writer.focus();
    			return;
    		}
    		
    		if(contents.value == ''){
    			alert("내용이 입력되지 않았습니다");
    			contents.focus();
    			return;
    		}
			
    		insertForm.submit();	
    	})
    	
    </script>
</body>
</html>