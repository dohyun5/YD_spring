package com.yedam.app.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@Value("${file.upload.path}")  
	private String uploadPath;
	
	@GetMapping("upload")
	public void getUploadPath() {
		
	}
	
	@PostMapping("/uploadsAjax")
	@ResponseBody
	public void uploadFile(@RequestPart MultipartFile[] uploadFiles) { //첨부파일 처리
	    
	    for(MultipartFile uploadFile : uploadFiles){

	    	if(uploadFile.getContentType().startsWith("image") == false){
	    		System.err.println("this file is not image type");
	    		return;
	        }
	  
	        String originalName = uploadFile.getOriginalFilename();
	        String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
	        
	        System.out.println("fileName : " + fileName);
	    

	        //날짜 폴더 생성 (사용자가 보낸파일 이름 그대로 사용한다고 하면 안써도 상관 없지만 그대로 사용하면 문제가 많을수 있음.)
	        String folderPath = makeFolder();
	        //UUID //유니크값 크게 의미는 없음. 랜덤으로 id만들어서 사용자의 파일이름과 섞어서 충돌이 나지 않도록 하기 위함. 
	        String uuid = UUID.randomUUID().toString(); 
	        //저장할 파일 이름 중간에 "_"를 이용하여 구분
	        //String saveName = uploadPath + File.separator + folderPath +File.separator + uuid + "_" + fileName;
	        String uploadFileName = folderPath +File.separator + uuid + "_" + fileName;
	        
	        String saveName = uploadPath + File.separator + uploadFileName;
	        
	        Path savePath = Paths.get(saveName);
	        //Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
	        System.out.println("path : " + saveName);
	        try{
	        	uploadFile.transferTo(savePath);
	            //uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
	        } catch (IOException e) {
	             e.printStackTrace();	             
	        }
	        
	        //DB에 해당 경로로 저장. 1번과 2번은 같이 움직여야한다.
	        //1) 사용자가 업로드할 때 사용한 파일명
	        //2) 실제 서버에 업로드할 때 사용한 경로
	        String imagePath = uploadFileName.replace(File.separator, "/");
	        System.out.println(uploadFileName);
	        System.out.println(imagePath);
	        //imageList.add(setImagePath(uploadFileName));
	        
	     }
	    //return imageList;
	}

	private String makeFolder() {

		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// LocalDate를 문자열로 포멧
		String folderPath = str.replace("/", File.separator); //java가 알아들을수 있게 만드는 작업.

		File uploadPathFoler = new File(uploadPath, folderPath); //file = 단순히 문자 였던걸 파일형태로 변경 (파일 접근.)
		// File newFile= new File(dir,"파일명");


		if (uploadPathFoler.exists() == false) {
			uploadPathFoler.mkdirs();
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		return folderPath;
	}
//	private String setImagePath(String uploadFileName) {
//		return uploadFileName.replace(File.separator, "/");
//	}
}

