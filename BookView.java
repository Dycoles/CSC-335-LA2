package bookLibrary;

import java.util.Scanner;

public class BookView {
	public static void main(String[] args) {
		// step 1: create the library using scanner; note that we can further
		// add to the library using both addBook and addBooks
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the name of the text file containing your library (e.g. -> file.txt)");
		System.out.println("Please enter 'exit' if you wish to close the program");
		String input = keyboard.next();
		// close the program if exit is input
		if (input.equals("exit")) {
			System.out.println("Closing library");
			keyboard.close();
			return;
		}
		// create the library model and controller
		BookModel model = new BookModel(input);
		BookController controller = new BookController(model);
		
		// prompt the user for various commands to interact with the library
		while (!input.equals("exit")) {
			System.out.println("Please enter the command you wish to execute:");
			System.out.println("search -> Search for a book by 'title', 'author', or 'rating'.");
			System.out.println("addBook -> Add a book to the collection.");
			System.out.println("setToRead -> Set a book to 'read'.");
			System.out.println("rate -> Rate a book with a rating between 1 and 5 (inclusive)");
			System.out.println("getBooks -> Retrieve and display your books, sorted by 'title', "
					+ "'author', and whether or not they have been 'read'.");
			System.out.println("suggestRead -> Get a suggestion for a book to read.");
			System.out.println("addBooks -> Add multiple books to the library at once.");

			System.out.println("Please enter 'exit' if you wish to close the program");
			input = keyboard.next();
			
			// Do actions based on inputs
			switch(input) {
			case "search":
				System.out.println("Please enter how you wish to search for a book: -> 'title'; 'author'; "
						+ "'rating'");
				String searchInput = keyboard.next();
				
				switch(searchInput) {
				case "title":
					controller.searchLibrary();
					break;
				case "author":
					controller.searchLibrary();
					break;
				case "rating":
					controller.searchLibrary();
					break;
				case "exit":
					break;
				default:
					System.out.println("Please enter a valid command");
				}
				break;
			case "addBook":
				// modifying addBook to add a single book.
				System.out.println("Please enter the book's title: ");
				String newTitle= keyboard.next();
				String newAuthor=keyboard.next();
				Book newBook= new Book(newTitle, newAuthor);
				controller.addBookToLibrary(newBook);
				break;
			case "setToRead":
				break;
			case "rate":
				break;
			case "getBooks":
				break;
			case "suggestRead":
				String[] bookInfo= controller.suggestBook();
				System.out.println("We have a book suggestion for you ! It is: "+bookInfo[0]+" by "
						+ bookInfo[1]);
			
				break;
			case "addBooks":
				// modifying addBooks to give a file name.
				System.out.println("Please enter the name of a file with books to add. ");
				String fileName= keyboard.next();
				controller.addListOfBooks(fileName);
				break;
				
			case "exit":
				break;
			default:
				System.out.println("Invalid command. Please enter a command to access the library.");
			}
		}
		
		System.out.println("Closing library");
		keyboard.close();
	}
}
