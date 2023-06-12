package com.yedam.app.emp.service;

import lombok.Data;

@Data
public class EmpVO {
	String employeeId;
	String firstName;
	String lastName;
	String email;
	String jobId;
	String hireDate;
	String departmentId;
	String orderColumn;
	
	String[] getDeptArr() {
		return departmentId.split(",");
	}
	 //필요할때마다 만들어 내야해서 bean으로 만들지 않는다.
	
}
