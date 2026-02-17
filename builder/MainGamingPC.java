package builder;

import java.util.List;

class GamingPC {
	
	private String processor;
	private int ramSize;
	private String graphicsCard;
	
	private String storageType;
	private int storageSize;
	private boolean coolingSystem;
	private boolean rgbLights;
	
	private GamingPC (GamingPCBuilder builder) {
		this.processor = builder.processor;
		this.ramSize = builder.ramSize;
		this.graphicsCard = builder.graphicsCard;
		this.storageType = builder.storageType;
		this.storageSize = builder.storageSize;
		this.coolingSystem = builder.coolingSystem;
		this.rgbLights = builder.rgbLights;
	}
	
	public void showSpecs() {
		System.out.println("Gaming PC Specifications:");
		System.out.println("Processor: " + processor);
		System.out.println("RAM: " + ramSize + "GB");
		System.out.println("Graphics Card: " + graphicsCard);
		System.out.println("Storage Type: " + storageType);
		System.out.println("Storage Size: " + storageSize + "GB");
		System.out.println("Cooling System: " + (coolingSystem ? "Enabled" : "Disabled"));
		System.out.println("RGB Lights: " + (rgbLights ? "Enabled" : "Disabled"));
	}
	
	public static class GamingPCBuilder {
		private String processor;
		private int ramSize;
		private String graphicsCard;
		
		private String storageType = "SSD";
		private int storageSize = 512;
		private boolean coolingSystem = false;
		private boolean rgbLights = false;
		
		public GamingPCBuilder(String processor, int ramSize, String graphicsCard) {
			this.processor = processor;
			this.ramSize = ramSize;
			this.graphicsCard = graphicsCard;
		}
		
		public GamingPCBuilder setStorageType(String storageType) {
			List<String> validStoragesType = List.of("HDD", "SSD", "NVMe");
			if (!validStoragesType.contains(storageType)) {
				throw new IllegalArgumentException("Invalid Storage Type! Choose either HDD, SSD, or NVMe");
			}
			this.storageType = storageType;
			return this;
		}
		
		public GamingPCBuilder setStorageSize(int storageSize) {
			this.storageSize = storageSize;
			return this;
		}
		
		public GamingPCBuilder setCoolingSystem(boolean coolingSystem) {
			this.coolingSystem = coolingSystem;
			return this;
		}
		
		public GamingPCBuilder setRgbLights(boolean RgbLights) {
			this.rgbLights = RgbLights;
			return this;
		}
		
		public GamingPC build() {
			return new GamingPC(this);
		}
	}
}





public class MainGamingPC {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GamingPC pc = new GamingPC.GamingPCBuilder("Intel i9", 32, "NVIDIA RTX 4090")
                .setStorageType("NVMe")
                .setStorageSize(2000)
                .setCoolingSystem(true)
                .setRgbLights(true)
                .build();
		
		pc.showSpecs();
	}
}
