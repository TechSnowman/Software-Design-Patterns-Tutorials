package flyweight;

import java.util.HashMap;
import java.util.Map;

// Step 1: Flyweight interface
interface Car {
	void showCarDetails(String color, String plateNumber);
}

// Step 2: Concrete Flyweight (Shared Object)
class CarModel implements Car {
	private String brand;
	private String model;
	
	public CarModel(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	@Override
	public void showCarDetails(String color, String plateNumber) {
        System.out.println("Car: " + brand + " " + model + " | Color: " + color + " | Plate: " + plateNumber);
	}
}


// Step 3: Flyweight Factory
class CarFactory {
	private static Map<String, Car> carMap = new HashMap<>();
	
	public static Car getCar(String brand, String model) {
		String key = brand + "_" + model;
		if (!carMap.containsKey(key)) {
			carMap.put(key, new CarModel(brand, model));
			System.out.println("Creating new CarModel: " + brand + " " + model);
		}
		return carMap.get(key);
	}


}

// Step 4: Client Code
public class MainFlyweight {

	public static void main(String[] args) {

		Car car1 = CarFactory.getCar("Toyota", "Corolla");
		car1.showCarDetails("Red", "ABC123");
		
		Car car2 = CarFactory.getCar("Toyota", "Corolla");
		car2.showCarDetails("Blue", "XYZ987	");
		
		Car car3 = CarFactory.getCar("Toyota", "Corolla");
		car3.showCarDetails("Black", "LMN456");
	}

}
