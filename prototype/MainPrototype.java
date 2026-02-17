package prototype;

import java.util.HashMap;
import java.util.Map;

// Step 1: Implement
abstract class Animal implements Cloneable {
	protected String type;
	
	abstract void makeSound();
	
	@Override
	public Object clone() {
		try {
			return super.clone(); //Performs a shallow copy
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
			throw new RuntimeException("Cloning not supported");
		}
	}
}

// Step 2: Concrete classes implementing cloneable
class Dog extends Animal {
	public Dog() {
		this.type = "Dog";
	}

	@Override
	void makeSound() {
		System.out.println("Woof!");
	}
}

class Cat extends Animal {
	public Cat () {
		this.type = "Cat";
	}

	@Override
	void makeSound() {
		System.out.println("Meow!");
	}
}

// Step 3: Prototype Registry (Optional)
class AnimalRegistry {
	private static Map<String, Animal> animalMap = new HashMap<>();

	static {
		animalMap.put("Dog", new Dog());
		animalMap.put("Cat", new Cat());
	}
	
	public static Animal getClone(String type) {
		return (Animal) animalMap.get(type).clone();
	}
}



// Step 4: Client Code
public class MainPrototype {

	public static void main(String[] args) {
		Animal clonedDog = AnimalRegistry.getClone("Dog");
		clonedDog.makeSound(); // Woof!
		
		Animal clonedCat = AnimalRegistry.getClone("Cat");
		clonedCat.makeSound(); // Meow!
		
		
	}

}
