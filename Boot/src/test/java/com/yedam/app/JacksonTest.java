package com.yedam.app;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.app.emp.service.EmpVO;

public class JacksonTest {
	
	@Test
	public void toObject() throws JsonMappingException, JsonProcessingException {
		String str = "{\"employeeId\":\"1000\",\"firstName\":\"yoasobi\",\"lastName\":\"asu\",\"hireDate\":\"2023-07-07\",\"jobId\":null,\"departmentId\":0,\"sal\":null}";
		ObjectMapper ob = new ObjectMapper();
		EmpVO vo = ob.readValue(str, EmpVO.class);
		System.out.println(vo);
	}
	
	
	
	//@Test
	public void tojson() throws JsonProcessingException {
		EmpVO vo = EmpVO.builder()
						.firstName("yoasobi")
						.lastName("asu")
						.employeeId("1000")
						.hireDate(new Date())
						.build();
		ObjectMapper ob = new ObjectMapper();
		String str = ob.writeValueAsString(vo);
		System.out.println(str);
		
		
	}
	
	
	
}
