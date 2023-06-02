package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.emp.mapper.EmpMapper;

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
	
	@RequestMapping("empList")
	public String empList(Model model) {
		model.addAttribute("empList", empMapper.selectList(null));
		return "emp/empList";
	}
}
