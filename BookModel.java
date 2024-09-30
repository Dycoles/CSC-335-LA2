package bookLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookModel {
	
	// dictionary of unread books
	private HashMap<Book, Status> thisLibraryUnread = new HashMap<Book, Status>();
	// dictionary of all books (read/unread) and their rating
	private HashMap<Book, Integer> thisLibraryRating = new HashMap<Book, Integer>();
	// dictionary of all read books
	private HashMap<Book, Status> thisLibraryRead = new HashMap<Book, Status>();
	
	public BookModel(String fileName) {
		// add books from text list into the library
		addBooks(fileName);
	}
	
	public void addBooks(String fileName) {
		String curString;
		// read file line by line
		Scanner input;
		try {
			input = new Scanner (new File (fileName));
			while (input.hasNextLine()) {
				curString = input.nextLine();
				String[] bookArray = curString.split(";");
				// title:author
				String title = bookArray[0];
				String author = bookArray[1];
				Book book = new Book(title, author);
				thisLibraryUnread.put(book, Status.UNREAD);
				thisLibraryRating.put(book, 0);
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void search() {
		// if search is by read/unread
	}
	
	public void addBook() {
		
	}
	
	public void setToRead(Book book) {
		// add book to read list
		thisLibraryRead.put(book, Status.READ);
		// remove book from unread list -> BE SURE TO CHECK IF BOOK HAS ALREADY BEEN REMOVED FROM UNREAD LIST
		thisLibraryUnread.remove(book);
	}
	
	public void rate(Book book, int rating) {
		// set rating; can be changed multiple times
		thisLibraryRating.replace(book, rating);
	}
	
	public void getBooks() {
		// if get title
		// if get author
		// if get read
		// if get unread
	}
	
	public void suggestRead() {
		
	}
}
