package factory;

interface Button {
	
}

class LightButton implements Button{
	public LightButton() {
		System.out.println("Light Button Created!");
	}
}
class DarkButton implements Button{
	public DarkButton() {
		System.out.println("Dark Button Created!");
	}
}


interface TextField {
	
}

class LightTextField implements TextField{
	public LightTextField() {
		System.out.println("Light TextField Created!");
	}
}
class DarkTextField implements TextField{
	public DarkTextField() {
		System.out.println("Dark TextField Created!");
	}
}

interface ThemeFactory {
	Button createButton();
	TextField createTextField();
}

class LightThemeFactory implements ThemeFactory {

	public LightThemeFactory() {
		System.out.println("Using Light Theme:");
	}

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new LightButton();
	}

	@Override
	public TextField createTextField() {
		// TODO Auto-generated method stub
		return new LightTextField();
	}
	
	
}

class DarkThemeFactory implements ThemeFactory {

	public DarkThemeFactory() {
		System.out.println("Using Dark Theme:");
		
	}

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new DarkButton();
	}

	@Override
	public TextField createTextField() {
		// TODO Auto-generated method stub
		return new DarkTextField();
	}
}


class ThemeFactoryProducer {
	public static ThemeFactory getThemeFactory(String type) {
		switch (type.toLowerCase()) {
		case "light": return new LightThemeFactory();
		case "dark" : return new DarkThemeFactory();
		default: throw new IllegalArgumentException("Invalid Theme Factory Type");
		}	
	}
}



public class MainUISystem {
	public static void main(String[] args) {
		
		ThemeFactory lightTheme = ThemeFactoryProducer.getThemeFactory("light");
		Button lightButton = lightTheme.createButton();
		TextField lightTextField = lightTheme.createTextField();
		
		System.out.println();
		ThemeFactory darkTheme = ThemeFactoryProducer.getThemeFactory("dark");
		Button darkButton = darkTheme.createButton();
		TextField darkTextField = darkTheme.createTextField();
	}
}
