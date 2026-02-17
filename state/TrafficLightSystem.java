package state;

// Step 1: Define the State Interface
interface TrafficLightState {
	void handle(TrafficLight trafficLight);
}


// Step 2: Implement Concrete States
class RedLight implements TrafficLightState {

	@Override
	public void handle(TrafficLight trafficLight) {
		System.out.println("Red Light - STOP");
		trafficLight.setState(new GreenLight()); // Transition to Green
	}
	
}
class GreenLight implements TrafficLightState {

	@Override
	public void handle(TrafficLight trafficLight) {
		System.out.println("Green Light - GO");
		trafficLight.setState(new YellowLight()); // Transition to Yellow
	}
	
}
class YellowLight implements TrafficLightState {

	@Override
	public void handle(TrafficLight trafficLight) {
		System.out.println("Yellow Light - Slow down");
		trafficLight.setState(new RedLight()); // Transition back to Red
	}
	
}


// Step 3: Context Class
class TrafficLight {
	private TrafficLightState currentState;
	
	public TrafficLight() {
		this.currentState = new RedLight(); // Start with Red Light
	}
	
	public void setState(TrafficLightState state) {
		this.currentState = state;
	}
	
	public void change() {
		currentState.handle(this);
	}
	
}






public class TrafficLightSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrafficLight light = new TrafficLight();
		
		// Simulate traffic light changes
		for (int i = 0; i < 6; i++) {
			light.change();
		} 
	}

}
