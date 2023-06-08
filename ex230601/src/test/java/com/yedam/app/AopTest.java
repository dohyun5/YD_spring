package com.yedam.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.AaaService;
import com.yedam.app.aop.Cats;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class AopTest {
	
	@Autowired
	Cats myCat;
	
	@Autowired
	AaaService aService;
	
	@Test
	public void aopTest() {
		Cats cat = new Cats();//스프링이 관여하지 않음.
		cat.printInfo();//class기반으로 만듦. 
		System.out.println();
		myCat.printInfo();//pointcut에 걸려있는 어드바이스랑 같이 연결
	}
	
	
	@Test
	public void txTest() {
		aService.insert();
	}
	
	
	
}
