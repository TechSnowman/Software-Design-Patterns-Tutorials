package proxy;

// Step 1: Define an Interface(Subject)
interface FileAccess {
	void accessFile();
}

// Step 2: Implement the Real Object(RealFile)
class RealFile implements FileAccess {
	private String filename;
	
	public RealFile(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void accessFile() {
		System.out.println("Accessing file: " + filename);
	}
	
}


// Step 3: Implement the Proxy (ProxyFile)
class ProxyFile implements FileAccess {
	private RealFile realFile;
	private String filename;
	private String userRole; // To check if the user is an admin
	
	public ProxyFile(String filename, String userRole) {
		this.filename = filename;
		this.userRole = userRole;
	}

	@Override
	public void accessFile() {
		if (userRole.equalsIgnoreCase("admin")) {
			if (realFile == null) {
				realFile = new RealFile(filename); // Lazy initialization
			}
			System.out.println("Access granted.");
			realFile.accessFile();
		} else {
			System.out.println("Access denied! Only admins can access this file.");
		}
		
	}
	
}



public class MainProxy {

	public static void main(String[] args) {

		FileAccess file1 = new ProxyFile("ConfidentialData.txt", "admin");
		file1.accessFile(); // ✅ Allowed
		
		FileAccess file2 = new ProxyFile("ConfidentialData.txt", "guest");
		file2.accessFile(); // ❌ Denied
	}
}
