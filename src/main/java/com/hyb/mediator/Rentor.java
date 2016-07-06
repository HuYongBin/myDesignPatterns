package com.hyb.mediator;

public class Rentor extends Person {

	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		mMediator.send(message, this);
	}

	@Override
	public void getMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println("Rentor get message: " + message);
	}

}
