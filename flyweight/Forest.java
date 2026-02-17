package flyweight;

import java.util.HashMap;
import java.util.Map;

interface Tree {
	void draw(int x, int y);
}

class TreeFlyweight implements Tree{
	private String type;
	private String colour;
	
	public TreeFlyweight(String type, String colour) {
		this.type = type;
		this.colour = colour;
	}

	@Override
	public void draw(int x, int y) {
		System.out.println("Drawing "+ type + " tree at (" + x + ", " + y + ")");
	}
}

class TreeFactory {
	private static Map<String, Tree> treeMap = new HashMap<>();
	
	public static Tree getTree(String type, String colour) {
		String key = type + "_" + colour;
		if (!treeMap.containsKey(key)) {
			treeMap.put(key, new TreeFlyweight(type, colour));
			System.out.println("Creating new tree: " + type + ", " + colour);
		} else {
			System.out.println("Reusing existing tree: " + type + ", " + colour);
		}
		return treeMap.get(key);
	}

}

public class Forest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tree oak = TreeFactory.getTree("Oak", "Green");
		oak.draw(10, 20);
		
		Tree pine = TreeFactory.getTree("Pine", "Dark Green");
		pine.draw(50, 70);
		
		Tree pine2 = TreeFactory.getTree("Pine", "Dark Green");
		pine2.draw(100, 150);
		
		Tree oak2 = TreeFactory.getTree("Oak", "Green");
		oak2.draw(200, 300);
		
		
	}

}
