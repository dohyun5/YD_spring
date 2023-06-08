package com.yedam.app.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RestController
public class EmpRestController {
	@Autowired
	EmpMapper empMapper;
	
	//전체조회
	@GetMapping("emps")
	public List<EmpVO> getEmpList(){
		EmpVO empVO = new EmpVO();
		return empMapper.selectList(empVO);
	}
	
	//단건조회
	@GetMapping("emps/{employeeId}")
	public EmpVO getEmpInfo(@PathVariable int employeeId) { //pathvariable(name="employeeId") -> {}경로의 데이터를 받겠다 변수와 같이 받을경우 () 부분생략가능.
		return empMapper.selectOne(employeeId);
	}
	
	//등록
	@PostMapping("emps")
	public EmpVO insertEmpInfo(@RequestBody EmpVO empVO) { //requestBody 내부에 json으로 보내는것
		empMapper.insertEmp(empVO);
		return empVO;
	}
	
	//수정 - body에 때려박는 방법도 있음.
	@PutMapping("emps/{employeeId}")
	public EmpVO updateEmpInfo(@PathVariable String employeeId,
							   @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		empMapper.updateEmp(empVO);
		return empVO;
	}

	//삭제
	@DeleteMapping("emps/{employeeId}")
	public Map<String, Object> deleteEmpInfo(@PathVariable int employeeId) {
		boolean success = false;
		int result = empMapper.deleteEmp(employeeId);
		if(result > 0) {
			success = true;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("result", success);
		map.put("employeeId", employeeId);
		
		return map;
	}
//	public int deleteEmpInfo(@PathVariable int employeeId) {
//		empMapper.deleteEmp(employeeId);
//		return employeeId;
//	} 좀 더 정확하게 표시하고 싶다면 위와같이 작성할것. map이 활용도가 높으니 사용법은 숙지하도록 하자 :) 

	
	
	
	
}
