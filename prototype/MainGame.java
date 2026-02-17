package prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class GameCharacter implements Cloneable{
	
	protected String name, Class;
	protected int health, attackPower;
	protected List<String> skills;
	
	public void characterOverview() {
		System.out.println("Character Overview:");
		System.out.println("Name: "+ name);
		System.out.println("Class: "+ Class);
		System.out.println("Base Health: "+ health);
		System.out.println("Attack Power : "+ attackPower);
		StringBuilder temp = new StringBuilder("Skills : [");
		for (String skill : skills) {
			temp.append(skill);
			temp.append(", ");
		}
		temp.delete(temp.length()-2, temp.length());
		temp.append("]");
		System.out.println(temp.toString());
	};
	
	@Override
	public Object clone() {
		try {
			GameCharacter temp = (GameCharacter) super.clone();
			temp.skills = new ArrayList<String>(this.skills);
			return (Object)temp;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Object is not cloneable!", e);
		}
	}
	
	public void skillChange(List<String> skills) {
		this.skills = new ArrayList<String>(skills);
	}
}


class Warrior extends GameCharacter{
	public Warrior () {
		name = "Zoro";
		health = 20;
		Class = "Warrior";
		attackPower = 8;
		skills = new ArrayList<String>();
		skills.add("Three Sword Style: Purgatory Onigiri");
		skills.add("One Sword Style: 36 Pound Phoenix");
	}
}

class Mage extends GameCharacter{
	public Mage() {
		name = "Usopp";
		health = 10;
		Class = "Mage";
		attackPower = 2;
		skills = new ArrayList<String>();
		skills.add("God Usopp");
		skills.add("Usopp Spell: Nail under your Fingernails");
		skills.add("Sniper King! From Sniper Island");
	}
}

class CharacterRegistry {
	private static Map<String, GameCharacter> CharacterRegistry = new HashMap<>();
	static {
		CharacterRegistry.put("Warrior", new Warrior());
		CharacterRegistry.put("Mage", new Mage());
	}
	
	public static GameCharacter getCharacter(String classType) {
		GameCharacter character = CharacterRegistry.get(classType);
		if (character == null) {
			throw new IllegalArgumentException("Class Type Does Not Exist!");
		}
		return (GameCharacter) character.clone();
	}
}

public class MainGame {

	public static void main(String[] args) {

		GameCharacter warriorClone = CharacterRegistry.getCharacter("Warrior");
		
		GameCharacter warriorClone2 = CharacterRegistry.getCharacter("Warrior");
		warriorClone2.name = "Sanji";
		ArrayList<String> skills = new ArrayList<String>(Arrays.asList("Diable Jambe Ifrit"));
		warriorClone2.skillChange(skills);
		
		warriorClone.characterOverview();
		System.out.println();
		warriorClone2.characterOverview();
		
		System.out.println();
		GameCharacter mageClone = CharacterRegistry.getCharacter("Mage");
		mageClone.characterOverview();
	}

}
