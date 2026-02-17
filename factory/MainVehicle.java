package factory;

interface Vehicle {
	void drive();
}

class Car implements Vehicle {
	int speed;
	String fuelType;
	public Car (int speed, String fuelType) {
		this.speed = speed;
		this.fuelType = fuelType;
	}
	@Override
	public void drive() {
		System.out.println("Driving a car 🚗");
	}
}

class Bike implements Vehicle {
	int speed;
	String fuelType;
	public Bike (int speed, String fuelType) {
		this.speed = speed;
		this.fuelType = fuelType;
	}
	@Override
	public void drive() {
		System.out.println("Riding a bike 🚴");
	}
}

class Truck implements Vehicle {
	int speed;
	String fuelType;
	public Truck (int speed, String fuelType) {
		this.speed = speed;
		this.fuelType = fuelType;
	}
	@Override
	public void drive() {
		System.out.println("Driving a truck 🚛");
	}
}

class VehicleFactory {
	public static Vehicle getVehicle(String type, int speed, String fuelType) {
		if (type.equalsIgnoreCase("car")) {
			return new Car(speed, fuelType);
		}
		else if (type.equalsIgnoreCase("bike")) {
			return new Bike(speed, fuelType);
		} 
		else if (type.equalsIgnoreCase("truck")){
			return new Truck(speed, fuelType);
		}
		throw new IllegalArgumentException("Invalid Vehicle Type :(");
	}
}




public class MainVehicle {
	public static void main(String[] args) {
		Vehicle car = VehicleFactory.getVehicle("car", 50, "gasoline");
		car.drive(); // Output: Driving a car 🚗

		Vehicle truck = VehicleFactory.getVehicle("truck", 60, "diesel");
		truck.drive(); // Output: Driving a truck 🚛
	}
}
