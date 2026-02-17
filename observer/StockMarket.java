package observer;

import java.util.ArrayList;
import java.util.List;

// Subject Interface
interface Stock {
	void setPrice(double price);
	void registerInvestor(Investor investor);
	void removeInvestor(Investor investor);
	void notifyInvestors();
	void getStockPrice();
}
// Concrete Subject
class ConcreteStock implements Stock{
	private String name;
	private double value;
	private List<Investor> investors = new ArrayList<>();
	public ConcreteStock(String name, double value) {
		this.name = name;
		this.value = value;
	}
	@Override
	public void setPrice(double price) {
		this.value = price;
		System.out.println(name + " stock price changed to: $" + value);
		notifyInvestors();
	}
	@Override
	public void registerInvestor(Investor investor) {
		investors.add(investor);
		System.out.println(investor.getName() + " has subscribed to "+ name + " stock updates.");
	}
	@Override
	public void removeInvestor(Investor investor) {
		investors.remove(investor);
		System.out.println(investor.getName() + " has unsubscribed from " + name +" stock updates.");
	}
	@Override
	public void notifyInvestors() {
		for (Investor investor : investors) {
			System.out.println(investor.getName() + " received update: " + name + " is now $" + value);
		}
	}
	@Override
	public void getStockPrice() {
		System.out.println(name +" stock price is: $" + value);
	}
	
	
}

// Observer interface
interface Investor {
	String getName();
	void update(Stock stock);
}
//
class ConcreteInvestor implements Investor {
	private String name;
	public ConcreteInvestor(String name) {
		this.name = name;
	}
	@Override
	public void update(Stock stock) {
		stock.getStockPrice();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
}




public class StockMarket {

	public static void main(String[] args) {
		Stock tesla = new ConcreteStock("Tesla", 900.00);
		Investor alice = new ConcreteInvestor("Alice");
		Investor bob = new ConcreteInvestor("Bob");

		tesla.registerInvestor(alice);
		tesla.registerInvestor(bob);

		tesla.setPrice(910.50);
		tesla.setPrice(920.75);
		tesla.removeInvestor(alice);
		tesla.setPrice(915.00);

	}

}
