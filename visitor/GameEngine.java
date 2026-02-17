package visitor;

interface GameVisitors {
	void visit(Warrior warrior);
	void visit(Mage mage);
	void visit(Healer healer);
}

class AttackVisitor implements GameVisitors{

	@Override
	public void visit(Warrior warrior) {
		System.out.println("Warrior attacks with a sword.");
	}

	@Override
	public void visit(Mage mage) {
		System.out.println("Mage attacks with spells.");
		
	}

	@Override
	public void visit(Healer healer) {
		System.out.println("Healer cannot attack.");
	}
	
}

class HealVisitor implements GameVisitors {

	@Override
	public void visit(Warrior warrior) {
		System.out.println("Warrior cannot heal.");
	}

	@Override
	public void visit(Mage mage) {
		System.out.println("Mage uses healing spells.");		
	}

	@Override
	public void visit(Healer healer) {
		System.out.println("Healer restores full health.");
	}
	
}

interface Characters {
	void accept(GameVisitors visitor);
}
class Warrior implements Characters{

	@Override
	public void accept(GameVisitors visitor) {
		visitor.visit(this);
	}
	
}
class Mage implements Characters{

	@Override
	public void accept(GameVisitors visitor) {
		visitor.visit(this);
	}
	
}
class Healer implements Characters{

	@Override
	public void accept(GameVisitors visitor) {
		visitor.visit(this);
	}
	
}


public class GameEngine {

	public static void main(String[] args) {
			
		AttackVisitor attack = new AttackVisitor();
		HealVisitor heal = new HealVisitor();
		
		Warrior warrior = new Warrior();
		Mage mage = new Mage();
		Healer healer = new Healer();
		
		System.out.println("Warrior: ");
		warrior.accept(attack);
		warrior.accept(heal);
		
		System.out.println("Mage: ");
		mage.accept(attack);
		mage.accept(heal);
		
		System.out.println("Healer: ");
		healer.accept(attack);
		healer.accept(heal);
	}

}
