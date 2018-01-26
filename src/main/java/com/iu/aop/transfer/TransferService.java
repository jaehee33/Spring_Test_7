package com.iu.aop.transfer;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class TransferService {

	@Inject
	private Transport transport;
	@Inject
	private CardCheck cardCheck;
	@Inject
	private  Ticket ticket;
	@Inject
	private Trip trip1;

	public void start(){

		transport.subway();
		transport.bus();
		
		trip1.trip();

	}
}
