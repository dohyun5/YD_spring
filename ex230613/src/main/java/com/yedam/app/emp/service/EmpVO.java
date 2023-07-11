package com.yedam.app.emp.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	private BigDecimal salary; //bigDecimal -> long 값을 넘어서는 범위 표시
	private int departmentId;
	
	
}
