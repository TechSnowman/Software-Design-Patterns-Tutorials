package command;

interface SmartHomeCommand {
	void execute();
}
// Concrete Commands
class TVON implements SmartHomeCommand {
	private TV tv;
	public TVON (TV tv) {
		this.tv = tv;
	}
	
	@Override
	public void execute() {
		tv.TurnTVOn();
	}
}
class TVOff implements SmartHomeCommand {
	private TV tv;
	public TVOff (TV tv) {
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.TurnTVOff();
	}
}
class FanON implements SmartHomeCommand {
	private Fan fan;
	public FanON (Fan fan) {
		this.fan = fan;
	}
	@Override
	public void execute() {
		fan.TurnFanOn();
	}
}
class FanOff implements SmartHomeCommand {
	private Fan fan;
	public FanOff (Fan fan) {
		this.fan = fan;
	}
	@Override
	public void execute() {
		fan.TurnFanOff();
	}
}

class AirON implements SmartHomeCommand {
	private AirConditioner air;
	public AirON (AirConditioner air) {
		this.air = air;
	}
	@Override
	public void execute() {
		air.TurnAirOn();
	}
}
class AirOff implements SmartHomeCommand {
	private AirConditioner air;
	public AirOff (AirConditioner air) {
		this.air = air;
	}
	@Override
	public void execute() {
		air.TurnAirOff();
	}
}


//Recievers
class TV {
	public void TurnTVOn() {
		System.out.println("TV is On");
	}
	public void TurnTVOff() {
		System.out.println("TV is Off");
	}
}
class Fan {
	public void TurnFanOn() {
		System.out.println("Fan is On");
	}
	public void TurnFanOff() {
		System.out.println("Fan is Off");
	}
}
class AirConditioner {
	public void TurnAirOn() {
		System.out.println("Air Conditioner is On");
	}
	public void TurnAirOff() {
		System.out.println("Air Conditioner is Off");
	}
}

class SmartHomeRemoteControl {
	private SmartHomeCommand command;
	
	public void setSmartHomeCommand(SmartHomeCommand command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
	}
}


public class MainSmartHomeAutomation {

	public static void main(String[] args) {
		SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
		
		TV tv = new TV();
		SmartHomeCommand tvOn = new TVON(tv);
		SmartHomeCommand tvOff = new TVOff(tv);
		
		Fan fan = new Fan();
		SmartHomeCommand fanOn = new FanON(fan);
		SmartHomeCommand fanOff = new FanOff(fan);
		
		AirConditioner air = new AirConditioner();
		SmartHomeCommand airOn = new AirON(air);
		SmartHomeCommand airOff = new AirOff(air);
		
		
		remote.setSmartHomeCommand(tvOn);
		remote.pressButton();
		remote.setSmartHomeCommand(tvOff);
		remote.pressButton();

		remote.setSmartHomeCommand(fanOn);
		remote.pressButton();
		remote.setSmartHomeCommand(fanOff);
		remote.pressButton();
		
		remote.setSmartHomeCommand(airOn);
		remote.pressButton();
		remote.setSmartHomeCommand(airOff);
		remote.pressButton();
		
		
		
	}

}
