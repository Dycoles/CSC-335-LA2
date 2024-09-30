package bookLibrary;

public class Book {
	String myTitle;
	String myAuthor;
	
	public Book(String title, String author) {
		myTitle = title;
		myAuthor = author;
	}
	
	public String getTitle() {
		return myTitle;
	}
	
	public String getAuthor() {
		return myAuthor;
	}
}
