package adapter;

// old interface (step 1)
interface PaymentProcessor {
	void processPayment(double amount);
}

class PayPalProcessor implements PaymentProcessor{
	@Override
	public void processPayment(double amount) {
		System.out.println("Processing PayPal payment of $" + amount);	
	}
}

class StripePayment {
	void makePayment(double amount) {
		System.out.println("Processing Stripe payment of $" + amount);
	}
}


class StripeAdapter implements PaymentProcessor {
	private StripePayment stripePayment;
	public StripeAdapter(StripePayment stripePayment) {
		this.stripePayment = stripePayment;
	}
	@Override
	public void processPayment(double amount) {
		stripePayment.makePayment(amount);
	}
	
	
}



public class MainPayment {
	public static void main(String[] args) {
		//Using paypal directly
		PaymentProcessor paypal = new PayPalProcessor();
		paypal.processPayment(100.0);
		
		// Using Stripe through the adapter
		StripePayment stripe = new StripePayment();
		PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
		stripeAdapter.processPayment(50.0);
	}
}
