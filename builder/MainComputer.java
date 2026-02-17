package builder;


// Step 1: Create the Product (Computer)
class Computer {
	private String CPU;
	private int RAM;
	private String storage;
	private boolean hasGraphicsCard;
	
	// Private constructor to force object creation through the Builder
	private Computer(ComputerBuilder builder) {
		this.CPU = builder.CPU;
		this.RAM = builder.RAM;
		this.storage = builder.storage;
		this.hasGraphicsCard = builder.hasGraphicsCard;
		
	}
	
   public void showSpecs() {
        System.out.println("Computer Specifications:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM + "GB");
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + (hasGraphicsCard ? "Yes" : "No"));
    }
   
   // Step 2: Create the Builder Class (Nested Static Class)
   public static class ComputerBuilder { 
	   private String CPU;
	   private int RAM;
	   private String storage;
	   private boolean hasGraphicsCard;
	   
	   public ComputerBuilder (String CPU, int RAM) { // Mandatory parameters
		   this.CPU = CPU;
		   this.RAM = RAM;
	   }
	   
	   public ComputerBuilder setStorage(String storage) { // Optional parameter
           this.storage = storage;
           return this;
       }

       public ComputerBuilder setGraphicsCard(boolean hasGraphicsCard) { // Optional parameter
           this.hasGraphicsCard = hasGraphicsCard;
           return this;
       }
       
       public Computer build() {
           return new Computer(this);
       }
   }
   
   
   
}


	
// Step 3: use the Builder in the Main Method
public class MainComputer {
	public static void main(String[] args) {

		Computer gamingPC = new Computer.ComputerBuilder("Intel i9", 32)
				.setStorage("1TB SDD")
				.setGraphicsCard(true)
				.build();
		
		Computer officePC = new Computer.ComputerBuilder("Intel i5", 16)
				.setStorage("512GB SDD")
				.build();
		
		gamingPC.showSpecs();
		System.out.println();
		officePC.showSpecs();
		
	}

}
