package decorator;

interface Coffee {
	String getDescription();
	double getPrice();
}

class SimpleCoffee implements Coffee {

	@Override
	public String getDescription() {
		return "Simple Coffee";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 2.00;
	}
}


abstract class CoffeeDecorator implements Coffee {
	protected Coffee coffee;
	public CoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}
	
	@Override
	public String getDescription() {
		return coffee.getDescription();
	}

	@Override
	public double getPrice() {
		return coffee.getPrice();
	}
	
}


class Milk extends CoffeeDecorator {

	public Milk(Coffee coffee) {
		super(coffee);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", Milk";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 0.50;
	}
}

class Sugar extends CoffeeDecorator {

	public Sugar(Coffee coffee) {
		super(coffee);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", Sugar";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 0.50;
	}
}

class Caramel extends CoffeeDecorator {

	public Caramel(Coffee coffee) {
		super(coffee);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", Caramel";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 1.00;
	}
}


public class MainCoffee {
	public static void main(String[] args) {
		
		Coffee simpleCoffee = new SimpleCoffee();
		System.out.println(simpleCoffee.getDescription() + " | Cost: $" + simpleCoffee.getPrice());
	
		Coffee withMilk = new Milk(simpleCoffee);
		System.out.println(withMilk.getDescription() + " | Cost: $" + withMilk.getPrice());
	
		Coffee withSugar = new Sugar(withMilk);
		System.out.println(withSugar.getDescription() + " | Cost: $" + withSugar.getPrice());
	
		Coffee withCaramel = new Caramel(withSugar);
		System.out.println(withCaramel.getDescription() + " | Cost: $" + withCaramel.getPrice());
	
	}
}
