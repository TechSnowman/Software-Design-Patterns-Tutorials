package factory;


interface SmartSpeaker {
	void playMusic();
	void getDetails();
}
interface SmartBulb {
	void turnOn();
	void turnOff();
	void getDetails();
}

class GoogleNest implements SmartSpeaker{

	@Override
	public void playMusic() {
		System.out.println("Google Nest currently playing music.");
	}
	@Override
	public void getDetails() {
		// TODO Auto-generated method stub
		System.out.println("Google Nest Speaker activated!");
	}	
}

class AmazonEcho implements SmartSpeaker{

	@Override
	public void playMusic() {
		System.out.println("Amazon Echo currently playing music.");
	}
	@Override
	public void getDetails() {
		// TODO Auto-generated method stub
		System.out.println("Amazon Echo Speaker activated!");
	}
}

class GoogleLight implements SmartBulb {
	private boolean lightON = false;
	@Override
	public void turnOn() {
		lightON = true;
	}

	@Override
	public void turnOff() {
		lightON = false;
	}

	@Override
	public void getDetails() {
		String temp = (lightON) ? "ON" : "OFF";
		System.out.println("Google Smart Light is now " + temp + "!");
	}
	
}

class AmazonLight implements SmartBulb {
	private boolean lightON = false;
	@Override
	public void turnOn() {
		lightON = true;
	}

	@Override
	public void turnOff() {
		lightON = false;
	}

	@Override
	public void getDetails() {
		String temp = (lightON) ? "ON" : "OFF";
		System.out.println("Amazon Smart Light is now " + temp + "!");
	}
}



interface SmartHomeFactory {
	SmartSpeaker createSpeaker();
	SmartBulb createBulb();
}

class GoogleSmartHomeFactory  implements SmartHomeFactory{

	@Override
	public SmartSpeaker createSpeaker() {
		// TODO Auto-generated method stub
		return new GoogleNest();
	}

	@Override
	public SmartBulb createBulb() {
		// TODO Auto-generated method stub
		return new GoogleLight();
	}
}

class AmazonSmartHomeFactory  implements SmartHomeFactory{

	@Override
	public SmartSpeaker createSpeaker() {
		// TODO Auto-generated method stub
		return new AmazonEcho();
	}

	@Override
	public SmartBulb createBulb() {
		// TODO Auto-generated method stub
		return new AmazonLight();
	}
	
}


class SmartHomeFactoryProducer {
	public static SmartHomeFactory getFactory(String type) {
		
		switch (type.toLowerCase()) {
		case "google": return new GoogleSmartHomeFactory();
		case "amazon": return new AmazonSmartHomeFactory();
		default: throw new IllegalArgumentException("Invalid Company type");
		}
	}
}









public class MainSmartHome {
	public static void main(String[] args) {
		SmartHomeFactory googleFactory = SmartHomeFactoryProducer.getFactory("Google");
		SmartSpeaker googleSpeaker = googleFactory.createSpeaker();
		googleSpeaker.getDetails(); // Output: "Google Nest Speaker activated!"

		SmartHomeFactory amazonFactory = SmartHomeFactoryProducer.getFactory("Amazon");
		SmartBulb amazonBulb = amazonFactory.createBulb();
		amazonBulb.turnOn();
		amazonBulb.getDetails(); // Output: "Amazon Smart Light is now ON!"

	}
}
