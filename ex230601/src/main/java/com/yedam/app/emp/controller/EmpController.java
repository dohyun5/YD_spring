package com.yedam.app.emp.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

/*
 * command
 * Pojo : 상속필요없음.
 * */
@Controller 
//객체생성해서 컨테이너에 빈등록하고 
//스프링 디스패처서블릿에서 호출할 수 있도록 커맨드 타입으로 만들어줌 
//@Component상속 
public class EmpController {
	
	@Autowired
	EmpMapper empMapper;
	
	
	//조회 get 등록 수정 post
	
	@GetMapping("empList") 
	public String empList(Model model, @ModelAttribute("emp") EmpVO vo) { //(핸들러 , 커맨드객체)
		//empvo는 커맨드객체 VO에 있는 필드명과 같아야함. 
		//modelAttribute로 사용하지 않는다면 empVO(첫글자소문자)로 사용하는 규칙이 있음.
//		new EmpVO();
//		vo.setDepartmentId(request.getParameter("dee"));
		System.out.println(vo);
		//model.addAttribute("emp", vo);
		model.addAttribute("empList", empMapper.selectList(vo));
		return "emp/empList";
	}
	
	//사원등록 페이지로 이동.
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("jobs", empMapper.selectJobs());
		model.addAttribute("departments", empMapper.selectDept());
		return "emp/empInsert";
	}
	
	//사원등록 처리
	@PostMapping("empInsert")
	public String empInsert(EmpVO vo) {
		empMapper.insertEmp(vo);
		return "redirect:empList";
		//return에 기본적으로 아무것도 안적으면 forward
		//forward 
		//redirect 
	}
	
	//사원 삭제 
	@GetMapping("empDelete")
	public String empDelete(@RequestParam int empId) {
		//int empid = request.getParameter("empId");
		empMapper.deleteEmp(empId);
		return "redirect:empList";
	}
	
	//사원 수정
	@GetMapping("empUpdate") //RequestParam 생략가능 
	public String empUpdateForm(Model model, int empId) {
		model.addAttribute("emp", empMapper.selectOne(empId));
		model.addAttribute("jobs", empMapper.selectJobs());
		model.addAttribute("departments", empMapper.selectDept());
		return "emp/empUpdate";
	}
	
	//사원수정 처리
	@PostMapping("empUpdate")
	public String empUpdate(EmpVO vo) {
		empMapper.updateEmp(vo);
		return "redirect:empList";
		//return에 기본적으로 아무것도 안적으면 forward
		//forward 
		//redirect 
	}
	
	
	
	
	
}
