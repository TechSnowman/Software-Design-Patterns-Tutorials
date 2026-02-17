package facade;

//🖥️ Step 1: Create Subsystem Classes
class TV_temp {
	public void turnOn() {
		System.out.println("TV is ON");
	}
	public void turnOff() {
		System.out.println("TV is OFF");
	}
}
class SoundSystem_temp {
	public void setVolume(int level) {
		System.out.println("Setting volume to " + level);
	}
}
class BluRayPlayer {
	public void playMovie(String movie) {
		System.out.println("Playing movie: " + movie);
	}
}


// 🖥️ Step 2: Create the Facade (HomeTheaterFacade)
class HomeTheaterFacade {
	private TV tv;
	private SoundSystem soundSystem;
	private BluRayPlayer bluRayPlayer;
	
	public HomeTheaterFacade(TV tv, SoundSystem soundSystem, BluRayPlayer bluRayPlayer) {
		this.tv = tv;
		this.soundSystem = soundSystem;
		this.bluRayPlayer = bluRayPlayer;
	}
	public void watchMovie(String movie) {
		System.out.println("\nSetting up Home Theater...");
		tv.turnOn();
		soundSystem.setVolume(10);
		bluRayPlayer.playMovie(movie);
		System.out.println("Enjoy your movie!\n");
	}
	public void endMovie() {
		System.out.println("\nShutting down Home Theater...");
		tv.turnOff();
		System.out.println("Goodbye!\n");
	}
	
}




// 🖥️ Step 3: Use the Facade in Main
public class MainFacade {

	public static void main(String[] args) {
		TV tv = new TV();
		SoundSystem soundSystem = new SoundSystem();
		BluRayPlayer blurayPlayer = new BluRayPlayer();
		
		HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, soundSystem, blurayPlayer);
	
		homeTheater.watchMovie("Inception");
		homeTheater.endMovie();
	}

}
