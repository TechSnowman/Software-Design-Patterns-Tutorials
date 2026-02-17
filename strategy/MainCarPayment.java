package strategy;

interface CarPaymentStrategy {
	void pay(String Car, double amount);
}

class CreditCardCarPayment implements CarPaymentStrategy{

	private String cardNumber;
	
	public CreditCardCarPayment(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public void pay(String Car, double amount) {
		System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
		System.out.println("Successfully purchased a Car: " + Car);
		
	}
	
}
class PayPalCarPayment implements CarPaymentStrategy{

	private String email;
	
	public PayPalCarPayment(String email) {
		this.email = email;
	}

	@Override
	public void pay(String Car, double amount) {
		System.out.println("Paid $" + amount + " using PayPal: " + email);
		System.out.println("Successfully purchased a Car: " + Car);
		
	}
	
}
class BitcoinCarPayment implements CarPaymentStrategy{

	private String walletAddress;
	
	public BitcoinCarPayment(String walletAddress) {
		this.walletAddress = walletAddress;
	}

	@Override
	public void pay(String Car, double amount) {
		System.out.println("Paid $" + amount + " using Bitcoin Wallet: " + walletAddress);
		System.out.println("Successfully purchased a Car: " + Car);
		
	}
	
}

class CarPurchase {
	private CarPaymentStrategy  carPaymentStrategy;
	
	public void setCarPaymentStrategy(CarPaymentStrategy carPaymentStrategy) {
		this.carPaymentStrategy = carPaymentStrategy;
	}
	
	public void makePayment(String car, double amount) {
		if(carPaymentStrategy == null) {
			System.out.println("Select payment method!");
		}
		else {			
			carPaymentStrategy.pay(car, amount);
		}
	}
}

public class MainCarPayment {

	public static void main(String[] args) {
		 CarPurchase carSeller = new CarPurchase();
		 
			

	        // Paying with Credit Card
	        carSeller.setCarPaymentStrategy(new CreditCardCarPayment("1234-5678-9876-5432"));
	        carSeller.makePayment("Toyta",24000.0);
	        
	        // Paying with PayPal
	        carSeller.setCarPaymentStrategy(new PayPalCarPayment("user@example.com"));
	        carSeller.makePayment("Lamborghini",100000);
	        
	        // Paying with Bitcoin
	        carSeller.setCarPaymentStrategy(new BitcoinCarPayment("bc1qxyz..."));
	        carSeller.makePayment("DeLorean", 99999999999.9);
	}

}
