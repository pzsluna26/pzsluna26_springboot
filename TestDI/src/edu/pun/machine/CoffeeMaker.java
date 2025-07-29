package edu.pun.machine;

public class CoffeeMaker {
	// espressomachine에서 객체가져옴
////	private EspressoMachine espressoMachine;
//		public CoffeeMaker() {
//		espressoMachine = new EspressoMachine();
//	}
	
	// coffeemachine 에서 객체 가져옴
	private CoffeeMachine coffeeMachine;
	
	
	public void setCoffeeMachine(CoffeeMachine coffeeMachine) {
		this.coffeeMachine = coffeeMachine;
	}

	
	public void makeCoffee() {
		System.out.println(coffeeMachine.brew());
	}
}
