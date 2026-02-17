package facade;

class Lights {
	public void dimLights() {
		System.out.println("Dimming the lights...");
	}
	public void lightsOff() {
		System.out.println("Turning the lights off...");
	}
}

class TV {
	public void turnOn() {
		System.out.println("Turning on the TV...");
	}
	public void turnOff() {
		System.out.println("Turning off the TV...");
	}
	public void setTVSource(String source) {
		System.out.println("Setting TV source to "+ source+"...");
	}
}

class SoundSystem {
	public void turnOn() {
		System.out.println("Turning on the Sound System...");
	}
	public void turnOff() {
		System.out.println("Turning off the Sound System...");
	}
	public void setVolume(int level) {
		System.out.println("Setting sound system volume to "+ level+"...");
	}
}
class PopcornMachine {
	public void makeSnacks() {
		System.out.println("Starting the popcorn machine...");
	}
}



class SmartHomeFacade {
	private Lights lights;
	private TV tv;
	private SoundSystem soundSystem;
	private PopcornMachine popcornMachine;

	public SmartHomeFacade(Lights lights, TV tv, SoundSystem soundSystem, PopcornMachine popcornMachine) {
		this.lights = lights;
		this.tv = tv;
		this.soundSystem = soundSystem;
		this.popcornMachine = popcornMachine;
	}
	
	public void startMovieMode() {
		lights.dimLights();
		tv.turnOn();
		tv.setTVSource("HDMI 1");
		soundSystem.setVolume(50);
		popcornMachine.makeSnacks();
		System.out.println("Movie Mode is ready! Enjoy your movie 🍿🎬");
	}
}




public class MainMovieAutomation {

	public static void main(String[] args) {

		TV tv = new TV();
		Lights lights = new Lights();
		SoundSystem soundSystem = new SoundSystem();
		PopcornMachine machine = new PopcornMachine();
		
		SmartHomeFacade facade = new SmartHomeFacade(lights, tv, soundSystem, machine);
		facade.startMovieMode();
	}

}
