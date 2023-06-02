package com.yedam.app;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {
	@Autowired
	EmpMapper empMapper; //인터페이스를 상속받은 구현 클래스를 주입받음.
	//class파일만 바꿔서 사용하기 위한 인터페이스
	
	@Ignore
	public void getEmpInfo() {
		EmpVO findEmp = empMapper.selectOne(100);
		assertEquals(findEmp.getFirstName(), "Steven"); //가져온게 같은지 아닌지 비교.
	}
		
	
	@Test
	public void 전체조회() {
		EmpVO param = new EmpVO();
		param.setDepartmentId("50,90");
//		param.setFirstName("e");
		param.setOrderColumn("department_id, first_name");
		List<EmpVO> list = empMapper.selectList(param);
		int cnt = empMapper.selectCount(param);
		System.out.println(cnt);
		for(EmpVO emp : list) {
			System.out.println(emp);
		}
//		System.out.println(list.get(0));
//		assertEquals(list.get(0).getEmployeeId(), "100");
	}
	@Ignore
	public void 등록() {
		EmpVO vo = new EmpVO();
		vo.setFirstName("ttest");
		vo.setLastName("test");
		vo.setEmail("1attst@email.com");
		vo.setJobId("IT_PROG");
		//int aa = empMapper.insertMember(vo);
		//assertEquals(aa,1);
		EmpVO findEmp = empMapper.selectOne(Integer.parseInt(vo.getEmployeeId()));
		assertEquals(findEmp.getLastName(),"test");
		
		
		System.out.println(vo);
		
	}
	
	
	
	
}





