package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:applicationContext.xml"); //classpath:xxxxx.xml <- 경로이기 때문에 띄어쓰면 안됨.
		
		TV tv = (TV)ctx.getBean("tv");
		tv.on();
		
	}

}

