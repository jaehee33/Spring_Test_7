package com.iu.aop.transfer;

import static org.hamcrest.CoreMatchers.theInstance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class CardCheck {
	
	@Around("execution(* com.iu.aop.transfer..Transport.*())")
	public Object check(ProceedingJoinPoint joinPoint){
		System.out.println("삑~ 탑승입니다.");
		Object object = null;
		try {
			object = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("삑~ 하차입니다.");
		return object;
	}
	@Before("execution(* com.iu.aop.transfer..Ticket.*())")
	public void fingerPrint(){
		
	}
}

