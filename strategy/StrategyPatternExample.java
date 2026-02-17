package strategy;


// Step 1: Define the Strategy Interface
interface PaymentStrategy {
	void pay(int amount);
}

// Step 2: Implement Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
	private String cardNumber;
	
	public CreditCardPayment(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
	}
	
}
class PayPalPayment implements PaymentStrategy {
	private String email;
	
	public PayPalPayment(String email) {
		this.email = email;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Paid $" + amount + " using PayPal: " + email);
	}
	
}
class BitcoinPayment implements PaymentStrategy {
	private String walletAddress;
	
	public BitcoinPayment(String walletAddress) {
		this.walletAddress = walletAddress;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Paid $" + amount + " using Bitcoin Wallet: " + walletAddress);
	}
	
}

// Step 3: Context Class (Shopping Cart)
class ShoppingCart {
	private PaymentStrategy paymentStrategy;
	
	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	public void checkout(int amount) {
		if (paymentStrategy == null) {
			System.out.println("Please select a payment method before checking out.");
		}
		else {
			paymentStrategy.pay(amount);
		}
	}
}

// Step 4: Client Code(Main Method)
public class StrategyPatternExample {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		

        // Paying with Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        cart.checkout(100);
        
        // Paying with PayPal
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(200);
        
        // Paying with Bitcoin
        cart.setPaymentStrategy(new BitcoinPayment("bc1qxyz..."));
        cart.checkout(500);
		
		
	}

}
