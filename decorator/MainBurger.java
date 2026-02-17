package decorator;

interface Burger {
	String getDescription();
	double getPrice();
}
class BasicBurger implements Burger {

	@Override
	public String getDescription() {
		return "Basic Burger";
	}

	@Override
	public double getPrice() {
		return 4.00;
	}
}

abstract class BurgerDecorator implements Burger {
	protected Burger burger;
	public BurgerDecorator(Burger burger) {
		this.burger = burger;
	}
	@Override
	public String getDescription() {
		return burger.getDescription();
	}
	@Override
	public double getPrice() {
		return burger.getPrice();
	}
}

class Cheese extends BurgerDecorator {
	public Cheese(Burger burger) {
		super(burger);
	}
	@Override
	public String getDescription() {
		return super.getDescription() + ", Cheese";
	}
	@Override
	public double getPrice() {
		return super.getPrice() + 0.5;
	}
}

class Lettuce extends BurgerDecorator {
	public Lettuce(Burger burger) {
		super(burger);
	}
	@Override
	public String getDescription() {
		return super.getDescription() + ", Lettuce";
	}
	@Override
	public double getPrice() {
		return super.getPrice() + 0.5;
	}
}

class Tomato extends BurgerDecorator {
	public Tomato(Burger burger) {
		super(burger);
	}
	@Override
	public String getDescription() {
		return super.getDescription() + ", Tomato";
	}
	@Override
	public double getPrice() {
		return super.getPrice() + 0.5;
	}
}

class Bacon extends BurgerDecorator {
	public Bacon(Burger burger) {
		super(burger);
	}
	@Override
	public String getDescription() {
		return super.getDescription() + ", Bacon";
	}
	@Override
	public double getPrice() {
		return super.getPrice() + 1.00;
	}
}

class ExtraPatty extends BurgerDecorator {
	public ExtraPatty(Burger burger) {
		super(burger);
	}
	@Override
	public String getDescription() {
		return super.getDescription() + ", Extra Patty";
	}
	@Override
	public double getPrice() {
		return super.getPrice() + 2.00;
	}
}

public class MainBurger {
	public static void main(String[] args) {
		
		Burger basic = new BasicBurger();
		System.out.println(basic.getDescription() + " | Cost: $" + basic.getPrice());
	
		Burger withCheese = new Cheese(basic);
		System.out.println(withCheese.getDescription() + " | Cost: $" + withCheese.getPrice());
	
		Burger withLettuce = new Lettuce(withCheese);
		System.out.println(withLettuce.getDescription() + " | Cost: $" + withLettuce.getPrice());
	
		Burger withTomato = new Tomato(withLettuce);
		System.out.println(withTomato.getDescription() + " | Cost: $" + withTomato.getPrice());
	
		Burger withBacon= new Bacon(withTomato);
		System.out.println(withBacon.getDescription() + " | Cost: $" + withBacon.getPrice());
	
		Burger withExtraPatty = new ExtraPatty(withBacon);
		System.out.println(withExtraPatty.getDescription() + " | Cost: $" + withExtraPatty.getPrice());
	
		
	}
}
