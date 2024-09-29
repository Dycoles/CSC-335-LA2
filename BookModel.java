package bookLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookModel {
	private ArrayList<String> bookList = new ArrayList<>();
	public BookModel(String fileName) {
		// add books from text list into the library
		bookList = addBooks(fileName);
	}
	
	public ArrayList<String> addBooks(String fileName) {
		// create a list of strings
		ArrayList<String> thisList = new ArrayList<>();
				// represents curString
		String curString;
		// read file line by line
		Scanner input;
		try {
			input = new Scanner (new File (fileName));
			while (input.hasNextLine()) {
				curString = input.nextLine();
						// add current line to list
				thisList.add(curString.toUpperCase());

			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thisList;
	}
	
	public void search() {
		
	}
	
	public void addBook() {
		
	}
	
	public void setToRead() {
		
	}
	
	public void rate() {
		
	}
	
	public void getBooks() {
		
	}
	
	public void suggestRead() {
		
	}
}
