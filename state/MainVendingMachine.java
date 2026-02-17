package state;

interface VendingMachineState {
	void handle(VendingMachine vendingMachine);
}

class WaitingForMoney implements VendingMachineState {

	@Override
	public void handle(VendingMachine vendingMachine) {
		System.out.println("Waiting for Money");
		vendingMachine.setState(new HasMoney());
	}
	
}

class HasMoney implements VendingMachineState {

	@Override
	public void handle(VendingMachine vendingMachine) {
		System.out.println("Has Money");
		vendingMachine.setState(new DispensingProduct());
	}
	
}

class DispensingProduct implements VendingMachineState {

	@Override
	public void handle(VendingMachine vendingMachine) {
		System.out.println("Dispensing Product");
		vendingMachine.setState(new WaitingForMoney());
	}
	
}


class VendingMachine {
	private VendingMachineState currentState;
	
	public VendingMachine() {
		this.currentState = new WaitingForMoney();
	}
	
	public void setState(VendingMachineState machineState) {
		this.currentState = machineState; 
	}
	
	public void change() {
		currentState.handle(this);
	}
	
}


public class MainVendingMachine {

	public static void main(String[] args) {

		VendingMachine machine = new VendingMachine();
		
		// Simulate vending machine changes
		for (int i = 0; i < 6; i++) {
			machine.change();
		} 
	}

}
