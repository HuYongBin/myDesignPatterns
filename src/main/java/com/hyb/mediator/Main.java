package com.hyb.mediator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mediator mediator = new HouseMediator();
		Person rentor = new Rentor();
		Person landlord = new LandLord();
		
		mediator.setRentor(rentor);
		mediator.setLandLord(landlord);
		
		rentor.setMediator(mediator);
		
		landlord.setMediator(mediator);
		
		rentor.sendMessage("I would like to rent a house");
		
		landlord.sendMessage("I would like to land a house");
	}

}
