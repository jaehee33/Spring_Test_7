package com.iu.aop.transfer;

import org.springframework.stereotype.Component;

@Component
public class Ticket {
	
	public void getTicket(){
		System.out.println("==========");
		System.out.println("buy ticket");
	}

}
