package flyweight;

import java.util.HashMap;
import java.util.Map;

interface Character{
	void doStuff();
}

class CharacterFlyweight implements Character{
	private String name;
	public CharacterFlyweight(String name) {
		this.name = name;
	}
	
	@Override
	public void doStuff() {
		System.out.println("Using existing character: " + name);
	}
	
}

class CharacterFactory {
	private static Map<String, Character> charMap = new HashMap<>();
	
	public static Character getCharacter(String name) {
		String key = name;
		if (!charMap.containsKey(key)) {
			charMap.put(key, new CharacterFlyweight(name));
			System.out.println("Craeting new character object: "+ name);
		}
		return charMap.get(key);
	}
	
}



public class TextEditor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character charA = CharacterFactory.getCharacter("A");
		Character charB = CharacterFactory.getCharacter("B");
		charA.doStuff();
		charB.doStuff();
	}

}
