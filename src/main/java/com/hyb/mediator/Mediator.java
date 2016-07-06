package com.hyb.mediator;

public abstract class Mediator {
	protected Person mRentor;
	protected Person mLandLord;
	
	public abstract void setRentor(Person person);
	
	public abstract void setLandLord(Person person);
	
	public abstract void send(final String message, Person person);
}
