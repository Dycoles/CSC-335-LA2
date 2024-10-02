package bookLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class BookModel {
	
	// dictionary of unread books
	// we know status is going to be unread; no need for the key: value since every value is UNREAD
	private ArrayList<Book> thisLibraryUnread = new ArrayList<Book>();
	// dictionary of all books (read/unread) and their rating
	private HashMap<Book, Integer> thisLibraryRating = new HashMap<Book, Integer>();
	// all values will be READ, so no need for a dictionary, we can use a list
	private ArrayList <Book >thisLibraryRead = new ArrayList <Book>();
	
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
				// both are uppercase so its easier to search when needed
				String title = bookArray[0].toUpperCase();
				String author = bookArray[1].toUpperCase(null);
				Book book = new Book(title, author);
				thisLibraryUnread.add(book);
				thisLibraryRating.put(book, 0);
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void search(int searchBy) {
		// by title, author or rating. 
		
		// searchBy==1 specifies search by title
		
			
		}
		
	
	
	public void addBook(Book book) {
		
		thisLibraryUnread.add(book);
		thisLibraryRating.put(book, 0);
		
		
	}
	
	public void setToRead(Book book) {
		// add book to read list
		thisLibraryRead.add(book);
		// remove book from unread list -> BE SURE TO CHECK IF BOOK HAS ALREADY BEEN REMOVED FROM UNREAD LIST
		thisLibraryUnread.remove(book);
	}
	
	public void rate(Book book, int rating) {
		// set rating; can be changed multiple times
		thisLibraryRating.replace(book, rating);
	}
	/*
	 * Overloading for getBooks seems like the best idea
	 * 
	 */
	public void getBooks() {
		
		// if get title
		// if get author
		// if get read
		
		// if get unread
	}
	
	public Book suggestRead() {
		Collections.shuffle(thisLibraryUnread);
		return thisLibraryUnread.get(0);
	 
		
	}
}
