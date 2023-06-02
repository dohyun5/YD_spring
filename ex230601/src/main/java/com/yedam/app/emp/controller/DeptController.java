package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	DeptMapper deptMapper;
	
	//부서 목록
	@GetMapping("deptList")
	public String deptList(Model model, @ModelAttribute("dept") DeptVO vo) {
		model.addAttribute("deptList", deptMapper.deptList(vo));
		return "dept/deptList";
	}
	
	//부서 등록페이지 이동.
	public String DeptInsertForm(Model model) {
		
		return "dept/deptInsert";
	}
	
	
	
	
	
	
	
}