package builder;

import java.util.ArrayList;
import java.util.List;

class Pizza {
	
	private String size; //(small/medium/large)
	private String cheeseType; 
	private String crustType;
	private List<String> toppings; //(list of toppings)
	private boolean extraCheese = false;
	private String sauceType = "tomato sauce";
	
	private Pizza(PizzaBuilder builder) {
		this.size = builder.size;
		this.cheeseType= builder.cheeseType;
		this.crustType = builder.crustType;
		this.toppings = builder.toppings;
		this.extraCheese = builder.extraCheese;
		this.sauceType = builder.sauceType;
		
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		StringBuilder temp = new StringBuilder("[");
		for (String topping : toppings) {
			temp.append(topping);
			temp.append(", ");
		}
		temp.delete(temp.length()-2, temp.length());
		temp.append("]");
		
		return("Pizza Order: Size=" + size +
				", Cheese=" + cheeseType + 
				", Crust=" + crustType +
				", Toppings=" + temp +
				", Extracheese=" + extraCheese + 
				", Sauce=" + sauceType);
	}

	public static class PizzaBuilder {
		private String size; //(small/medium/large)
		private String cheeseType; 
		private String crustType;
		private List<String> toppings = new ArrayList<>(); //(list of toppings)
		private boolean extraCheese = false;
		private String sauceType = "tomato sauce";
		
		public PizzaBuilder(String size, String cheeseType, String crustType) {
			this.size = size;
			this.cheeseType= cheeseType;
			this.crustType = crustType;
		}
		
		public PizzaBuilder addTopping(String topping) {
			toppings.add(topping);
			return this;
		}
		public PizzaBuilder setExtraCheese(boolean extraCheese) {
			this.extraCheese = extraCheese;
			return this;
		}
		public PizzaBuilder setSauceType(String sauceType) {
			this.sauceType = sauceType;
			return this;
		}
		
		public Pizza build() {
			
			return new Pizza(this);
		}
		
	}
	
	
}







public class MainPizza {

	public static void main(String[] args) {
				
		Pizza pizza = new Pizza.PizzaBuilder("Large", "Mozzarella", "Thin Crust")
                .addTopping("Pepperoni")
                .addTopping("Olives")
                .setExtraCheese(true)
                .setSauceType("Marinara")
                .build();
		
		System.err.println(pizza);
	}
}
