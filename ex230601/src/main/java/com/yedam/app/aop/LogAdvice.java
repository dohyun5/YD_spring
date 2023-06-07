package com.yedam.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
	
	//포인트컷 : 조인포인트(비지니스 로직과 관련된 메소드) 중에서 Advice(공통코드)가 적용될 메소드
	@Pointcut("within(com.yedam.app.aop.*)") //지정된 패키지 아래 모든 패키지 포함.
	public void allPointCut() {
		
	}
	
	//위빙(Weaving) : 포인트컷 + Advice + 동작시점. 
	@Around("allPointCut()") 
	public Object logger(ProceedingJoinPoint joinpoint) throws Throwable {
		//AOP가 적용되는 메소드의 이름
		String signatureStr = joinpoint.getSignature().toString();
		System.out.println("시작 : "+signatureStr);
		//공통기능
		System.out.println("핵심 기능 전 실행 - 공통기능 : " + System.currentTimeMillis());
		try {
			Object obj = joinpoint.proceed(); //실제 동작하는 시점. 
			return obj; //최상위 클래스를 이용해서 리턴.
		}finally {
			//다시한번 공통기능
			System.out.println("핵심 기능 후 실행 - 공통기능 : " + System.currentTimeMillis());
		}
		//
	}

	
	
	
}
