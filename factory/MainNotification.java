package factory;

interface Notification {
	void send();
}

class EmailNotification implements Notification{
	@Override
	public void send() {
		System.out.println("Sending Email Notification");
	}
}

class SMSNotification implements Notification{
	@Override
	public void send() {
		System.out.println("Sending SMS Notification");
	}
}

class PushNotification implements Notification{
	@Override
	public void send() {
		System.out.println("Sending Push Notification");
	}
}


class NotificationFactory {
	public static Notification getNotification(String type) {
		
		if (type.equalsIgnoreCase("email")) {
			return new EmailNotification();
		}
		else if (type.equalsIgnoreCase("sms")) {
			return new SMSNotification();
		} 
		else if (type.equalsIgnoreCase("push")) {
			return new PushNotification();
		}
		throw new IllegalArgumentException("Invalid notification type");
	}
}



public class MainNotification {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Notification email = NotificationFactory.getNotification("email");
		email.send(); // Output: Sending Email Notification...

		Notification sms = NotificationFactory.getNotification("sms");
		sms.send(); // Output: Sending SMS Notification...
	}

}
