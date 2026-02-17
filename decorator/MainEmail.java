package decorator;

interface Notification {
	void send(String message);
}

// Concrete component
class EmailNotification implements Notification {
	@Override
	public void send(String message) {
		System.out.println("Sending Email: " + message);
	}
}

// Decorator
abstract class NotificationDecorator implements Notification {
	protected Notification notification;
	
	public NotificationDecorator (Notification notification) {
		this.notification = notification;
	}

	@Override
	public void send(String message) {
		notification.send(message); // Calls the base method
	}
	
}

// Concrete Decorators
class SMSNotification extends NotificationDecorator {

	public SMSNotification(Notification notification) {
		super(notification);
	}
	
	@Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}
class PushNotification extends NotificationDecorator {
    public PushNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Push Notification: " + message);
    }
}





//Main Method
public class MainEmail {
 public static void main(String[] args) {
     Notification email = new EmailNotification();
     Notification emailWithSMS = new SMSNotification(email);
     Notification emailWithSMSAndPush = new PushNotification(emailWithSMS);

     System.out.println("---- Basic Email Notification ----");
     email.send("Hello, user!");

     System.out.println("\n---- Email + SMS Notification ----");
     emailWithSMS.send("Hello, user!");

     System.out.println("\n---- Email + SMS + Push Notification ----");
     emailWithSMSAndPush.send("Hello, user!");
 }
}
