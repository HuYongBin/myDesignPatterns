package com.hyb.mediator;

public class LandLord extends Person {

	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		mMediator.send(message, this);
	}

	@Override
	public void getMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println("LandLord get message: " + message);
	}

}
