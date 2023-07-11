package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	//전체조회 페이지
	@GetMapping("empList")
	public String empList(Model model) {
		model.addAttribute("empList",empService.getEmpList());
		return "emp/empList";
	}

	//단건조회 페이지
	@GetMapping({"empInfo/{empId}","empInfo"})
	public String empInfo(EmpVO empVO, Model model, @PathVariable(required = false) String empId) {
		if(empId !=null) 
			empVO.setEmployeeId(empId);
		model.addAttribute("empInfo", empService.getEmpInfo(empVO));
		return "emp/empInfo";
	}

	//등록 페이지
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("empVO", new EmpVO());
		return "emp/empInsert";
	}
	
	//등록 기능
	@PostMapping("empInsert") //넘겨주는 empVO(등록페이지)와 받는 empVO(기능부분)와 object의 ${empVO}는 이름이 같아야함.
	public String empInsert(EmpVO empVO) { 
		empService.insertEmpInfo(empVO);
		return "redirect:empList";
	}

	//수정페이지
	@GetMapping("empUpdate")
	public String empUpdateForm(Model model, EmpVO vo) {
		model.addAttribute("empVO", empService.getEmpInfo(vo));
		return "emp/empUpdate";
	}
	
	
	
	
	
	
	
	
}
