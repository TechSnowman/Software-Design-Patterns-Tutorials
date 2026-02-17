package bridge;

interface ManufacturingProcess {
	void manufacturing(String vehicle);
}
class AutomaticFactory implements ManufacturingProcess{
	@Override
	public void manufacturing(String vehicle) {
		System.out.println("Manufacturing a "+ vehicle +" using Automatic Factory.");
	}
}
class ManualFactory implements ManufacturingProcess{
	@Override
	public void manufacturing(String vehicle) {
		System.out.println("Manufacturing a "+ vehicle +" using Manual Factory.");
	}
}

abstract class Vehicle {
	protected ManufacturingProcess process;
	public Vehicle(ManufacturingProcess process) {
		this.process = process;
	}
	abstract void create();
}
class Car extends Vehicle {

	public Car(ManufacturingProcess process) {
		super(process);
	}

	@Override
	void create() {
		process.manufacturing("Car");
	}
	
}

class Bike extends Vehicle {

	public Bike(ManufacturingProcess process) {
		super(process);
	}

	@Override
	void create() {
		process.manufacturing("Bike");
	}
	
}




public class MainManufacturing {
	public static void main(String[] args) {
		
		Vehicle car = new Car(new AutomaticFactory());
		car.create();
	
		
		Vehicle bike = new Bike(new ManualFactory());
		bike.create();
	}
}
