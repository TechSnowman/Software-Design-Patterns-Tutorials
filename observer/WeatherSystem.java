package observer;

import java.util.ArrayList;
import java.util.List;

interface WeatherStation {
	void currentTemp();
	void setTemp(int newTemp);
	void registerUser(WeatherSubscriber subscriber);
	void unregisterUser(WeatherSubscriber subscriber);
	void notifyWeatherUsers();
}
class ConcreteWeatherStation implements WeatherStation{
	private int temperature = 10; // random default
	private String name;
	
	private List<WeatherSubscriber> subscribers = new ArrayList<>();
	public ConcreteWeatherStation(String name) {
		this.name = name;
	}
	@Override
	public void currentTemp() {
		System.out.println("Current Temperature: " + temperature +"°C");
	}
	@Override
	public void setTemp(int newTemp) {
		this.temperature = newTemp;
		notifyWeatherUsers();
	}
	@Override
	public void registerUser(WeatherSubscriber subscriber) {
		subscribers.add(subscriber);
		System.out.println(subscriber.getName() + " has subscribed to the "+ name +" Weather Station");
	}
	@Override
	public void unregisterUser(WeatherSubscriber subscriber) {
		subscribers.remove(subscriber);
		System.out.println(subscriber.getName() + " has unsubscribed from "+ name +" Weather Station");
		
	}
	@Override
	public void notifyWeatherUsers() {
		for (WeatherSubscriber weatherSubscriber : subscribers) {
			weatherSubscriber.update(temperature);
		}
	}
	
}

interface WeatherSubscriber {
	String getName();
	void update(int temperature);
}
class ConcreteSubscriber implements WeatherSubscriber{
	private String name;
	public ConcreteSubscriber(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public void update(int temp) {
		System.out.println(name + " has received update: Current Temperature: "+ temp+"°C");
	}
}


public class WeatherSystem {

	public static void main(String[] args) {
		WeatherStation weatherNetwork = new ConcreteWeatherStation("Weather Network");
		
		WeatherSubscriber sub1 = new ConcreteSubscriber("Thor");
		WeatherSubscriber sub2 = new ConcreteSubscriber("Avatar Aang");
		WeatherSubscriber sub3 = new ConcreteSubscriber("Storm");

		weatherNetwork.registerUser(sub1);
		weatherNetwork.registerUser(sub2);
		weatherNetwork.registerUser(sub3);
		System.out.println();

		weatherNetwork.currentTemp();
		weatherNetwork.setTemp(20);
		System.out.println();
		
		weatherNetwork.setTemp(-2);
		System.out.println();

		weatherNetwork.unregisterUser(sub1);
		weatherNetwork.setTemp(30);
		System.out.println();

	}

}
