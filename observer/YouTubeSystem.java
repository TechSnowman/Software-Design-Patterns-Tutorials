package observer;

import java.util.ArrayList;
import java.util.List;

// Observer Interface (Subscribers)
interface Subscriber {
	void update (String videoTitle);
}

// Concrete Observer(Specific Subscriber)
class User implements Subscriber {
	private String name;
	
	public User(String name) {
		this.name = name;
	}

	@Override
	public void update(String videoTitle) {
		System.out.println(name + " received a notification: New video uploaded - " + videoTitle);
	}
	
}

// Subject Interface (YouTube Channel)
interface YouTubeChannel {
	void subscribe(Subscriber subscriber);
	void unsubscribe(Subscriber subscriber);
	void notifySubscibers(String videoTitle);
}

// Concrete Subject (Specific Youtube Channel)
class Channel implements YouTubeChannel {
	private List<Subscriber> subscribers = new ArrayList<>();
	private String channelName;
	
	public Channel(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public void subscribe(Subscriber subscriber) {
		subscribers.add(subscriber);
		System.out.println("New subscriber added to " + channelName);
	}

	@Override
	public void unsubscribe(Subscriber subscriber) {
		subscribers.remove(subscriber);
		System.out.println("Subscriber removed from " + channelName);
	}

	@Override
	public void notifySubscibers(String videoTitle) {
		System.out.println("\n" + channelName + " uploaded a new video: " + videoTitle);
		for (Subscriber subscriber : subscribers) {
			subscriber.update(videoTitle);
		}
	}
	
	
}



// Client Code(Main Class)
public class YouTubeSystem {

	public static void main(String[] args) {
		
		// Create a YouTube channel
		Channel techChannel = new Channel("TechSavvy");
		
		// Create subscribers
		Subscriber user1 = new User("Alice");
		Subscriber user2 = new User("Bob");
		Subscriber user3 = new User("Charlie");
		
		// Subscribers join the channel
		techChannel.subscribe(user1);
		techChannel.subscribe(user2);
		techChannel.subscribe(user3);
		
		// The channel uploads a new video
		techChannel.notifySubscibers("Observer Pattern in Java");
		
		// Unsubscribe one user and upload another video
		techChannel.unsubscribe(user2);
		techChannel.notifySubscibers("Understanding Flyweight Pattern");
	}

}
