package com.hyb.mediator;

public class HouseMediator extends Mediator {

	@Override
	public void setRentor(Person person) {
		// TODO Auto-generated method stub
		mRentor = person;
	}

	@Override
	public void setLandLord(Person person) {
		// TODO Auto-generated method stub
		mLandLord = person;
	}

	@Override
	public void send(String message, Person person) {
		if(person == mRentor){
			mLandLord.getMessage(message);
		}else if(person == mLandLord){
			mRentor.getMessage(message);
		}else{
			System.out.println("Unknown person");
		}
	}
}
