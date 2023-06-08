package com.yedam.app.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.user.service.UserVO;

//@Controller //페이지 반환이 기본 
@RestController //해당 컨트롤러의 모든 메서드는 데이터를 반환한다. 라는 의미.
public class UserRestController {
	
	@PostMapping("insertUser")
	//@ResponseBody // 페이지 반환이 기본이지만 데이터(객체,)를 반환하는 메서드. RestController로 데이터만 받아온다고 정의 한다면 사용필요없음.
	public UserVO insertUser(UserVO userVO) {
		System.out.println("name : "+userVO.getName());
		System.out.println("age : "+userVO.getAge());
		return userVO;
		
	}
	@GetMapping("getHome")
	public String gethome() {
		return "home";
	}
	
	
	
	
	
}









