package com.yedam.app;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex230613ApplicationTests {
	
	@Autowired
	StringEncryptor jasyptStringEncryptor; //다른 이름으로 가져오려면 별도의 추가 작업이 필요하다. 
	
	@Test
	void propertiesEncrypt() {
		String[] strArray = {"oracle.jdbc.driver.OracleDriver",
							 "jdbc:oracle:thin:@127.0.0.1:1521/xe",
							 "hr",
							 "hr"};
		for(String str : strArray) {
			String enyStr = jasyptStringEncryptor.encrypt(str);
			System.out.println(enyStr);
		}
	}

	
}
