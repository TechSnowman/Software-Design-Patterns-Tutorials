package decorator;

// Step 1: Create the Base Interface (Component)
interface Pizza {
	String getDescription();
	double getCost();
}

// Step 2: Create the Concrete Component(Base Class)
class PlainPizza implements Pizza {
	@Override
	public String getDescription() {
		return "Plain Pizza";
	}

	@Override
	public double getCost() {
		return 5.00;
	}
}

// Step 3: Create the Abstract Decorator
abstract class PizzaDecorator implements Pizza {
	protected Pizza pizza; // Reference to the component being decorated
	
	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String getDescription() {
		return pizza.getDescription(); // Calls the base method
	}

	@Override
	public double getCost() {
		return pizza.getCost(); // Calls the base method
	}	
}

// Step 4: Create Concrete Decorators

// Adding Cheese
class Cheeze extends PizzaDecorator {
	
	public Cheeze(Pizza pizza) {
		super(pizza);
	}	
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", Cheese" ; // Adds new behavior
	}
	
	@Override
	public double getCost() {
		return super.getCost() + 1.50; // Adds extra cost
	}
	
}

//Adding Pepperoni
class Pepperoni extends PizzaDecorator {
	
	public Pepperoni(Pizza pizza) {
		super(pizza);
	}	
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", Pepperoni" ; // Adds new behavior
	}
	
	@Override
	public double getCost() {
		return super.getCost() + 1.50; // Adds extra cost
	}
	
}

// Step 5: Use the Decorators in the Main Method
public class MainPizza {

	public static void main(String[] args) {
		
		// Base pizza
		Pizza plainPizza = new PlainPizza();
        System.out.println(plainPizza.getDescription() + " | Cost: $" + plainPizza.getCost());
		
        // Add Cheese
        Pizza cheesePizza = new Cheeze(plainPizza);
        System.out.println(cheesePizza.getDescription() + " | Cost: $" + cheesePizza.getCost());

        // Add Cheese + Pepperoni
        Pizza deluxePizza = new Pepperoni(cheesePizza);
        System.out.println(deluxePizza.getDescription() + " | Cost: $" + deluxePizza.getCost());

	}

}
