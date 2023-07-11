package com.yedam.app.emp.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor //빈생성자
@AllArgsConstructor //모든생성자
public class EmpVO {
	private String employeeId;
	private String firstName;
	private String lastName;
	@JsonIgnore
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	//@JsonProperty("sal")
	private	BigDecimal salary;//bigDecimal -> long 값을 넘어서는 범위 표시
	private int departmentId;
	
	
}



