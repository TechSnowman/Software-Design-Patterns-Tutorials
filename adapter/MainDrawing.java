package adapter;

interface Shape {
	void draw();
}
class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Drawing a Rectangle. Width = 5, Length = 10");
	}
}

class ModernGraphics {
    void renderRectangle(int x, int y, int width, int height) {
        System.out.println("Rendering rectangle at (" + x + "," + y + ") with width=" + width + " and height=" + height);
    }
}

class ModernGraphicsAdapter implements Shape {
	private ModernGraphics modGraphics;
	private int x=0, y=0, width=2, height=5; // default
	
	public ModernGraphicsAdapter(ModernGraphics modGraphics) {
		this.modGraphics = modGraphics;
	}
	public void setRenderingParameters(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	@Override
	public void draw() {
		modGraphics.renderRectangle(x, y, width, height);
	}
	
	
}




public class MainDrawing {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		rectangle.draw();
		ModernGraphics modGraphics = new ModernGraphics();
		ModernGraphicsAdapter adapt = new ModernGraphicsAdapter(modGraphics);
		adapt.setRenderingParameters(10, 10, 50, 100);
		adapt.draw();
	}
}
