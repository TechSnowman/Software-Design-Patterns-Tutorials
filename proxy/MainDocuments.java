package proxy;

interface Document {
	void print();
}

class RealDocument implements Document {
	private String document;
	
	public RealDocument(String document) {
		this.document = document;
		loadDocument();
	}
	
	
	private void loadDocument() {
		System.out.println("Loading document: " + document);
	}


	@Override
	public void print() {
		System.out.println("Print document: " + document);
	}
	
}



class DocumentProxy implements Document {
	private RealDocument realDocument;
	private String document;
	
	public DocumentProxy(String document) {
		this.document = document;
	}

	@Override
	public void print() {
		if (realDocument == null) {
			realDocument = new RealDocument(document);
		}
		realDocument.print();
	}
	
	
	
}

public class MainDocuments {
	public static void main(String[] args) {
		Document doc1 = new DocumentProxy("Secrets.pdf");
		Document doc2 = new DocumentProxy("Information.pdf");
		
		// first call
		System.out.println("First Call:");
		doc1.print();
		
		// second call
		System.out.println("Second Call:");
		doc1.print();
		
		System.out.println();
		
		// first call
		System.out.println("First Call:");
		doc2.print();
		
		// second call
		System.out.println("Second Call:");
		doc2.print();
	}
}
