package bookLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class BookModel {

	// dictionary of unread books
	// we know status is going to be unread; no need for the key: value since every
	// value is UNREAD
	private ArrayList<Book> thisLibraryUnread = new ArrayList<Book>();
	// dictionary of all books (read/unread) and their rating
	private HashMap<Book, Integer> thisLibraryRating = new HashMap<Book, Integer>();
	// all values will be READ, so no need for a dictionary, we can use a list
	private ArrayList<Book> thisLibraryRead = new ArrayList<Book>();

	public BookModel(String fileName) {
		// add books from text list into the library
		addBooks(fileName);
	}

	public void addBooks(String fileName) {
		String curString;
		// read file line by line
		Scanner input;
		try {
			input = new Scanner(new File(fileName));
			while (input.hasNextLine()) {
				curString = input.nextLine();
				String[] bookArray = curString.split(";");
				// title:author
				// both are upper case so its easier to search when needed
				String title = bookArray[0].toUpperCase();
				String author = bookArray[1].toUpperCase();
				Book book = new Book(title, author);
				// add to unread books
				thisLibraryUnread.add(book);
				// add to book Hash map
				thisLibraryRating.put(book, 0);
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void search(int searchBy, String search) {
		// searchBy==0 specifies search by title
		if (searchBy == 0) {
			for (Entry<Book, Integer> mapElement : thisLibraryRating.entrySet()) {
				Book key = mapElement.getKey();
				if (key.getTitle().equals(search)) {
					System.out.println(key.getTitle() + ";" + key.getAuthor());
					break;
				}
			}
		}
		// searchBy==1 specifies search by author
		else if (searchBy == 1) {
			for (Entry<Book, Integer> mapElement : thisLibraryRating.entrySet()) {
				Book key = mapElement.getKey();
				if (key.getAuthor().equals(search)) {
					System.out.println(key.getTitle() + ";" + key.getAuthor());
					break;
				}
			}
		}
		// searchBy==2 specifies search by rating
		else {
			for (Entry<Book, Integer> mapElement : thisLibraryRating.entrySet()) {
				Book key = mapElement.getKey();
				int rating = mapElement.getValue();
				if (rating == Integer.valueOf(search)) {
					System.out.println(key.getTitle() + ";" + key.getAuthor());
					break;
				}
			}
		}

	}

	public void addBook(Book book) {
		thisLibraryUnread.add(book);
		thisLibraryRating.put(book, 0);
	}

	public void setToRead(Book book) {
		// add book to read list
		boolean bookInReadList = false;
		for (int i = 0; i < thisLibraryRead.size(); i++) {
			if (thisLibraryRead.get(i) == book) {
				bookInReadList = true;
			}
		}
		// check if the book has been set to "read"
		if (!bookInReadList) {
			// if not, add it to "read" list and remove from "unread" list
			thisLibraryRead.add(book);
			thisLibraryUnread.remove(book);
		}
	}

	public void rate(Book book, int rating) {
		// set rating; can be changed multiple times
		thisLibraryRating.replace(book, rating);
	}

	/*
	 * Overloading for getBooks seems like the best idea
	 * 
	 */
	
	public void getBooks(int searchBy) {
		// searchBy==0 specifies search by title
		if (searchBy == 0) {
			// create title list
			ArrayList<String> sortedTitles = new ArrayList<String>();
			for (Entry<Book, Integer> mapElement : thisLibraryRating.entrySet()) {
				Book key = mapElement.getKey();
				sortedTitles.add(key.getTitle());
			}
			// sort the title list
			Collections.sort(sortedTitles);
			// print out each title in sorted order
			for (int i = 0; i < sortedTitles.size(); i++) {
				System.out.println(sortedTitles.get(i));
			}
		}
		// searchBy==1 specifies search by author
		else if (searchBy == 1) {
			// create author list
			ArrayList<String> sortedAuthors = new ArrayList<String>();
			for (Entry<Book, Integer> mapElement : thisLibraryRating.entrySet()) {
				Book key = mapElement.getKey();
				sortedAuthors.add(key.getTitle());
			}
			// sort the author list
			Collections.sort(sortedAuthors);
			// print out each author in sorted order
			for (int i = 0; i < sortedAuthors.size(); i++) {
				System.out.println(sortedAuthors.get(i));
			}
		}
		// searchBy==2 specifies search by read
		else if (searchBy == 2) {
			// print out all the read titles
			for (int i = 0; i < thisLibraryRead.size(); i++) {
				System.out.println(thisLibraryRead.get(i).toString());
			}
		}
		// searchBy==3 specifies search by unread
		else {
			for (int i = 0; i < thisLibraryUnread.size(); i++) {
				System.out.println(thisLibraryUnread.get(i).toString());
			}
		}
	}

	public Book suggestRead() {
		Collections.shuffle(thisLibraryUnread);
		return thisLibraryUnread.get(0);
	}
}
