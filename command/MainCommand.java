package command;

// Command Interface
interface Command {
	void execute();
}

// Receiver
class Light {
	public void turnOn() {
		System.out.println("The light is ON");
	}
	public void turnOff() {
		System.out.println("The light is OFF");
	}
}

// Concrete Commands
class TurnOnCommand implements Command{
	private Light light;
	public TurnOnCommand(Light light) {
		this.light = light;
	}
	@Override
	public void execute() {
		light.turnOn();
	}
	
}
class TurnOFFCommand implements Command{
	private Light light;
	public TurnOFFCommand(Light light) {
		this.light = light;
	}
	@Override
	public void execute() {
		light.turnOff();
	}
	
}

// Invoker
class RemoteControl {
	private Command command;
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void pressButton() {
		command.execute();
	}
}

// Client
public class MainCommand {

	public static void main(String[] args) {
		Light light = new Light();
		
		Command turnOn = new TurnOnCommand(light);
		Command turnOff = new TurnOFFCommand(light);
		
		RemoteControl remote = new RemoteControl();
		
		// Turn the light on
		remote.setCommand(turnOn);
		remote.pressButton();
		
		// Turn the light off
		remote.setCommand(turnOff);
		remote.pressButton();
		
	}

}
