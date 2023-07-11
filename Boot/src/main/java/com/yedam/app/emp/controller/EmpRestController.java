package com.yedam.app.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;


@RestController // responsebody 안써도됨.
public class EmpRestController {
	
	@Autowired
	EmpService empService;
	
//	@GetMapping("/ajax/empList")
	@GetMapping("employees")
	public List<EmpVO> empList() {
		return empService.getEmpList();
	}
	
	//단건조회
	@GetMapping("employees/{id}")
	public EmpVO empList(@PathVariable(name = "id") String employeeId, EmpVO vo){
		vo.setEmployeeId(employeeId);
		return empService.getEmpInfo(vo);
	}
	
	
	//등록
	@PostMapping("employees")
	public EmpVO empInsert(EmpVO vo) {
		empService.insertEmpInfo(vo);
		return vo;
	}
	
	//수정
	@PutMapping("employees")
	public EmpVO empUpdate(@RequestBody EmpVO vo) { //json string으로 보내준다면 RequestBody를 써줘야 받아줌. 배열이나 여러개의 값을 받을때 json이 편함.
		System.out.println(vo);
		//empService.updateEmpInfo(vo);
		return vo;
	}
	
	
	//삭제
	@DeleteMapping("employees/{id}")
	public String empDelete(@PathVariable(name = "id") String empId) {
		System.out.println(empId);
		//empService.deleteEmpInfo(id);
		return empId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
