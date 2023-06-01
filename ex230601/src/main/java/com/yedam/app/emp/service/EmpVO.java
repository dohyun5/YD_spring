package com.yedam.app.emp.service;

import lombok.Data;

@Data
public class EmpVO {
	String employee_id;
	String first_name;
	String last_name;
	 //필요할때마다 만들어 내야해서 bean으로 만들지 않는다.
}
