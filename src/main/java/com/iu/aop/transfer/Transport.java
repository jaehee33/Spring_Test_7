package com.iu.aop.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transport {

	public void bus(){
		System.out.println("======= bus =======");
		System.out.println("음악 듣기");

	}
	public void subway(){
		System.out.println("====== subway ======");
		System.out.println("옆사람 카톡 보기");
	}
}
