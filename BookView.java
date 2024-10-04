package bookLibrary;

import java.util.Scanner;

public class MyLibrary {
	public static void main(String[] args) {
		// step 1: create the library using scanner; note that we can further
		// add to the library using both addBook and addBooks
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the name of the text file containing your library (e.g. -> file.txt)");
		System.out.println("Please enter 'exit' if you wish to close the program");
		String input = keyboard.nextLine();
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
			System.out.println();
			System.out.println("Please enter the command you wish to execute:");
			System.out.println("search -> Search for a book by 'title', 'author', or 'rating'.");
			System.out.println("addBook -> Add a book to the collection.");
			System.out.println("setToRead -> Set a book to 'read'.");
			System.out.println("rate -> Rate a book with a rating between 1 and 5 (inclusive)");
			System.out.println("getBooks -> Retrieve and display your books, sorted by 'title', "
					+ "'author', and whether or not they have been 'read'.");
			System.out.println("suggestRead -> Get a suggestion for a book to read.");
			System.out.println("addBooks -> Add multiple books to the library at once.");
			System.out.println();

			System.out.println("Please enter 'exit' if you wish to close the program");
			System.out.println();

			input = keyboard.nextLine();

			// Do actions based on inputs
			switch (input) {
			case "search":
				System.out.println(
						"Please enter how you wish to search for a book: -> " + "'title'; 'author'; " + "'rating'");
				String searchInput = keyboard.nextLine();
				switch (searchInput) {
				case "title":
					System.out.println("Please enter the title of the book you wish to find: ");
					String searchTitle = keyboard.nextLine();
					controller.searchLibrary(0, searchTitle.toUpperCase());
					break;
				case "author":
					System.out.println("Please enter the author of the books you wish to find: ");
					String searchAuthor = keyboard.nextLine();
					controller.searchLibrary(1, searchAuthor.toUpperCase());
					break;
				case "rating":
					System.out.println(
							"Please enter the rating of the books you wish to find (between 1 and 5 inclusive): ");
					String searchRating = keyboard.nextLine();
					controller.searchLibrary(2, searchRating);
					break;
				case "exit":
					System.out.println("Closing library");
					keyboard.close();
					return;
				default:
					System.out.println("Please enter a valid command");
				}
				break;
			case "addBook":
				// modifying addBook to add a single book.
				System.out.println("Please enter the book's title: ");
				String newTitle = keyboard.nextLine();
				System.out.println("Please enter the book's author: ");
				String newAuthor = keyboard.nextLine();
				Book newBook = new Book(newTitle.toUpperCase(), newAuthor.toUpperCase());
				controller.addBookToLibrary(newBook);
				break;
			case "setToRead":
				System.out.println("Please enter the book's title: ");
				String thisTitle = keyboard.nextLine();
				System.out.println("Please enter the book's author: ");
				String thisAuthor = keyboard.nextLine();
				Book newBook2 = new Book(thisTitle.toUpperCase(), thisAuthor.toUpperCase());
				controller.readBook(newBook2);
				break;
			case "rate":
				System.out.println("Please enter the title of the book you want to rate: ");
				String thisTitle2 = keyboard.nextLine();
				System.out.println("Please enter the author of the book you want to rate: ");
				String thisAuthor2 = keyboard.nextLine();
				Book newBook3 = new Book(thisTitle2.toUpperCase(), thisAuthor2.toUpperCase());
				System.out.println("Rate the book between 1 and 5 (inclusive");
				String rating = keyboard.nextLine();
				int myRating = Integer.parseInt(rating);
				controller.rateBook(newBook3, myRating);
				break;
			case "getBooks":
				System.out.println("Please enter whether you would like to get your books by 'author', 'title', 'read', or 'unread'");
				String getInput = keyboard.nextLine();
				switch (getInput) {
				case "title":
					System.out.println("Sorting books by title: ");
					controller.getBooksFromLibrary(0);
					break;
				case "author":
					System.out.println("Sorting books by author: ");
					controller.getBooksFromLibrary(1);
					break;
				case "read":
					System.out.println("Getting all read books");
					controller.getBooksFromLibrary(2);
					break;
				case "unread":
					System.out.println("Getting all unread books");
					controller.getBooksFromLibrary(3);
					break;
				case "exit":
					System.out.println("Closing library");
					keyboard.close();
					return;
				default:
					System.out.println("Please enter a valid command");
				}
				break;
			case "suggestRead":
				String[] bookInfo = controller.suggestBook();
				System.out.println("We have a book suggestion for you ! It is: " + bookInfo[0] + " by " + bookInfo[1]);
				break;
			case "addBooks":
				// modifying addBooks to give a file name.
				System.out.println("Please enter the name of a file with books to add. ");
				String fileName = keyboard.nextLine();
				controller.addListOfBooks(fileName);
				break;
			case "exit":
				System.out.println("Closing library");
				keyboard.close();
				return;
			default:
				System.out.println("Invalid command. Please enter a command to access the library.");
			}
		}

		System.out.println("Closing library");
		keyboard.close();
	}
}
