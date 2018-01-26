package com.iu.aop.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


@Component
public class CardCheck {

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
}
