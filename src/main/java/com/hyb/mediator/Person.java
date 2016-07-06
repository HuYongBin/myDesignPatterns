package com.hyb.mediator;

public abstract class Person {
	protected Mediator mMediator;
	
	public void setMediator(Mediator mediator){
		mMediator = mediator;
	}
	
	public abstract void sendMessage(final String message);
	
	public abstract void getMessage(final String message);
}
