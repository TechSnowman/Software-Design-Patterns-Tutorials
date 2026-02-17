package bridge;

interface Device {
	void turnOn();
	void turnOff();
	void setVolume(int volume);
}
class TV implements Device{

	@Override
	public void turnOn() {
		System.out.println("Turning ON the TV");
	}

	@Override
	public void turnOff() {
		System.out.println("Turning Off the TV");
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("Setting TV volume to "+ volume);		
	}
}
class Radio implements Device{

	@Override
	public void turnOn() {
		System.out.println("Turning ON the Radio");
	}

	@Override
	public void turnOff() {
		System.out.println("Turning Off the Radio");
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("Setting Radio volume to "+ volume);		
	}	
}

abstract class RemoteControl {
	protected Device device;
	public RemoteControl (Device device) {
		this.device = device;
	}
	private boolean powered = false;
	public void togglePower() {
		if (powered) {
			device.turnOff();
			powered = false;
		}else {
			device.turnOn();
			powered = true;
		}
	}
	abstract void changeVolume(int volume);
}

class BasicRemote extends RemoteControl {

	public BasicRemote(Device device) {
		super(device);
	}

	@Override
	void changeVolume(int volume) {
		System.out.println("Basic Remote Cannot Control Volume!");
	}
}

class AdvancedRemote extends RemoteControl {

	public AdvancedRemote(Device device) {
		super(device);
	}

	@Override
	void changeVolume(int volume) {
		device.setVolume(volume);
	}
}



public class MainControl {

	public static void main(String[] args) {

		RemoteControl base = new BasicRemote(new TV());
		RemoteControl advanced = new AdvancedRemote(new Radio());
		
		base.togglePower();
		base.togglePower();
		advanced.togglePower();
		advanced.changeVolume(50);
	}

}
