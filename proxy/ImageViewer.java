package proxy;

// Step 1: Create the interface
interface Image {
	void display();
}

// Step 2: Create the real image class
class RealImage implements Image {
	private String filename;
	
	public RealImage(String filename) {
		this.filename = filename;
		loadImageFromDisk(); // Simulate expensive operation
	}
	
	private void loadImageFromDisk() {
		System.out.println("Loading image: "+ filename);
	}

	@Override
	public void display() {
		System.out.println("Displating image: " + filename);
	}
}


// Step 3: Create the proxy class
class ProxyImage implements Image {
	private RealImage realImage;
	private String filename;
	
	public ProxyImage(String filename) {
		this.filename = filename;
	}

	@Override
	public void display() {
		// Lazy loading: Load only when needed
		if (realImage == null) {
			realImage = new RealImage(filename);
		}
		realImage.display();
	}
	
	
}

// Step 4: Client code
public class ImageViewer {
	public static void main(String[] args) {
		Image image1 = new ProxyImage("HighResPhoto1.jpg");
		Image image2 = new ProxyImage("HighResPhoto1.jpg");

		// Display images (image is loaded only when displayed)
		System.out.println("First call to display:");
	    image1.display(); // Loads and displays

	    System.out.println("\nSecond call to display:");
	    image1.display(); // Reuses existing image, does not load again

	    System.out.println("\nDisplaying second image:");
	    image2.display(); // Loads and displays

	    System.out.println("\nDisplaying second image again:");
	    image2.display(); // Reuses existing image
	}
}
