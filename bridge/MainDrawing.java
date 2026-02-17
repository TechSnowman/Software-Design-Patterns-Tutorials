package bridge;

// Bridge Interface (Renderer)
interface Renderer {
	void renderShape(String shape);
}


// Concrete Implementations of Renderer
class VectorRenderer implements Renderer{
	@Override
	public void renderShape(String shape) {
		System.out.println("Rendering a " + shape + " as a vector.");;
	}
}
class RasterRenderer implements Renderer{
	@Override
	public void renderShape(String shape) {
		System.out.println("Rendering a " + shape + " as pixels.");
	}
}


// Abstraction (Shape)
abstract class Shape {
	protected Renderer renderer;
	
	public Shape(Renderer renderer) {
		this.renderer = renderer;
	}
	
	abstract void draw();
}

// Concrete Shapes
class Circle extends Shape {
	public Circle(Renderer renderer) {
		super(renderer);
	}

	@Override
	void draw() {
		renderer.renderShape("Circle");
	}
}

class Square extends Shape {
    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    void draw() {
        renderer.renderShape("Square");
    }
}

// Main Class
public class MainDrawing {
	public static void main(String[] args) {
		
		// Drawing a Circle using Vector Renderer
		Shape vectorCircle = new Circle(new VectorRenderer());
		vectorCircle.draw();
		
		// Drawing a Square using Raster Renderer
		Shape rasterSquare = new Square(new RasterRenderer());
		rasterSquare.draw();
	}
}
