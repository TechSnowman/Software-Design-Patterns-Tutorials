package factory;

interface Pizza {
	void prepare();
}

class MargheritaPizza implements Pizza{
	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		System.out.println("Preparing Margherita Pizza 🍕");
	}
}

class PepperoniPizza implements Pizza{
	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		System.out.println("Preparing Pepperoni Pizza 🍕");
	}
}

class PizzaFactory {
	public static Pizza getPizza(String type) {
		
		if (type.equalsIgnoreCase("Margherita")) {
			return new MargheritaPizza();
		}
		else if (type.equalsIgnoreCase("Pepperoni")) {
			return new PepperoniPizza();
		} 
		else {
			return null;
		}
	}
}


class MainPizza {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza pizza1 = PizzaFactory.getPizza("Margherita");
		pizza1.prepare();
		
		Pizza pizza2 = PizzaFactory.getPizza("Pepperoni");
		pizza2.prepare();
	}

}
