package iterator;

import java.util.List;
import java.util.ArrayList;

// 1. Iterator interface
interface BookIterator {
	boolean hasNext();
	Book next();
}

// 2. Concrete Iterator
class LibraryIterator implements BookIterator {
	private List<Book> books;
	private int position = 0;

	public LibraryIterator(List<Book> books) {
		this.books = books;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return position < books.size();
	}

	@Override
	public Book next() {
		// TODO Auto-generated method stub
		return hasNext() ? books.get(position++) : null;
	}
	
}

// 3. Aggregate (Collection) Interface
interface BookCollection {
	BookIterator createIterator();
}

// 4. Concrete Collection
class Library implements BookCollection {
	private List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		books.add(book);
	}

	@Override
	public BookIterator createIterator() {
		// TODO Auto-generated method stub
		return new LibraryIterator(books);
	}

}

// Book class (Element stored in collection)
class Book {
	private String title;
	
	public Book(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}


// Client Code
public class MainLibrary {

	public static void main(String[] args) {

		Library library = new Library();
        library.addBook(new Book("The Hobbit"));
        library.addBook(new Book("1984"));
        library.addBook(new Book("Harry Potter"));
        library.addBook(new Book("The Great Gatsby"));

        BookIterator iterator = library.createIterator();

        System.out.println("Iterating through the library collection:");
        while (iterator.hasNext()) {
            System.out.println("Book: " + iterator.next().getTitle());
        }
    
	}

}
