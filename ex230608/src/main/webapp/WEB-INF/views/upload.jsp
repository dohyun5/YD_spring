<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 업로드</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<div>
		<input name="uploadFiles" type="file" multiple>
		<button class="uploadBtn">Upload</button>
	</div>

	<!-- <form enctype="multipart/form-data">
		<input name="uploadFiles" type="file" multiple>
		<button class="uploadBtn">Upload</button>
	</form> -->


</body>
<script>
	$('.uploadBtn').click(function(){
		var formData = new FormData();
		var inputFile = $("input[type='file']");
		//input태그의 type이 file인것을 찾아서inputFile이라는 변수로 지정
		var files = inputFile[0].files;
		//files : 선택한 모든 파일을 나열하는 filrList객체입니다.
		//multiple 특성을 지정하지 않았다면 두 개 이상의 파일을 포함하지 않습니다.
		for(var i=0;i<files.length;i++){
			console.log(files[i]);
			formData.append("uploadFiles",files[i]);//key,value 방식으로 append
		}
		//실제 업로드 부분
		//fetch
		/* fetch('uploadsAjax',{
			method:'POST',
			body : formData
		})
		.then(response => response.text())
		.then(data => console.log(data))
		.catch(err => console.log(err)); */
		
		//jQuery.ajax
		$.ajax({
			url:'uploadsAjax',//기본값은 ture, ajax통신을 통해 데이터를 전송할때, 기본적으로 key와 value값을 QueryString으로 
			type: 'POST',	//multipart/form-data 타입을 사용하기위해false로 지정합니다
			processData: false,
			contentType: false,
			data:formData,
			success:function(result){
				console.log(result);
				
			},
			error:function(reject){
				console.log(reject)
			}
		})
		
		
	})
	
</script>
</html>