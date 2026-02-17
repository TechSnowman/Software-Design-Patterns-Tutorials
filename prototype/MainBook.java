package prototype;

import java.util.HashMap;
import java.util.Map;

abstract class Book implements Cloneable{
	protected String type;
	protected String title;
	protected String author;
	
	public abstract void read();
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Not Cloneable Type", e);
		}
	}	
}

class FictionBook extends Book{
	public FictionBook() {
		type = "Fiction Book";
		title = "The Hobbit"; 
		author = "J.R.R. Tolkien";
	}
	
	@Override
	public void read() {
		System.out.println("Fiction Book - Title:"+ title + ", Author: "+ author);
	}
	
}

class ScienceBook extends Book{
	public ScienceBook() {
		type = "Science Book";
		title = "A Brief History of Time"; 
		author = "Stephen Hawking";
	}
	
	@Override
	public void read() {
		System.out.println("Science Book - Title:"+ title + ", Author: "+ author);
	}
	
}

class BookRegistry {
	private static Map<String, Book> bookRegistry = new HashMap<>();

	static {
		bookRegistry.put("Science Book", new ScienceBook());
		bookRegistry.put("Fiction Book", new FictionBook());
	}
	
	public static Book getBook(String type) {
	    Book book = bookRegistry.get(type);
		if (book == null) {
	        throw new IllegalArgumentException("Book type not found: " + type);
	    }
		return (Book) bookRegistry.get(type).clone();
	}
	
}

	

public class MainBook {

	public static void main(String[] args) {
		
		Book frictionClone = BookRegistry.getBook("Fiction Book");
		frictionClone.read();
		Book scienceClone = BookRegistry.getBook("Science Book");
		scienceClone.read();
	}

}
