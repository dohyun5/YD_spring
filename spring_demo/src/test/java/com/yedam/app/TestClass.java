package com.yedam.app;

import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.junit.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class TestClass {
	
	@Autowired
	Restaurant res;
	
	@Test
	public void creatBeanTest() {
		res.open(); 
	}
	
	@Ignore
	public void test() {
		System.out.println("간단한 테스트");
		assertNull(null);
	}
}
