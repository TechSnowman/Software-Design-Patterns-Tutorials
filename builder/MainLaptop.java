package builder;

class Laptop {
	
	// required
	private String brand;
	private String processor;
	private int ramSize;
	
	//optional
	private String graphicsCard;
	private int storageSize;
	
	private Laptop(LaptopBuilder builder) {
		this.brand = builder.brand;
		this.processor = builder.processor;
		this.ramSize = builder.ramSize;
		this.graphicsCard = builder.graphicsCard;
		this.storageSize = builder.storageSize;
	}
	public void showSpecs() {
	       System.out.println("Laptop Specifications:");
	       System.out.println("Brand: " + brand);
	       System.out.println("processor: " + processor );
	       System.out.println("Ram Size: " + ramSize);
	       System.out.println("Graphics Card: " + graphicsCard);
	       System.out.println("Storage Size: " + storageSize);
	}
	
	public static class LaptopBuilder {
		private String brand;
		private String processor;
		private int ramSize;
		private String graphicsCard;
		private int storageSize;
		
		public LaptopBuilder(String brand, String processor, int ramSize) {
			this.brand = brand;
			this.processor = processor;
			this.ramSize = ramSize;
		}
		
		public LaptopBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}
		public LaptopBuilder setStorageSize(int storageSize) {
			this.storageSize = storageSize;
			return this;
		}
		public Laptop build() {
			return new Laptop(this);
		}
		
	}
	
}























public class MainLaptop {

	public static void main(String[] args) {
		Laptop laptop = new Laptop.LaptopBuilder("Dell", "Intel i7", 16)
                .setGraphicsCard("NVIDIA RTX 3060")
                .setStorageSize(512)
                .build();
		laptop.showSpecs();
	}
	
	

}
