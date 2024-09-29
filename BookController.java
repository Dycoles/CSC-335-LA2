package bookLibrary;

public class BookController {
	
	private BookModel myModel;
	
	public BookController(BookModel model) {
		myModel = model;
	}
	
	public void searchLibrary() {
		myModel.search();
	}
	
	public void addBookToLibrary() {
		myModel.addBook();
	}
	
	public void readBook() {
		myModel.setToRead();
	}
	
	public void rateBook() {
		myModel.rate();
	}
	
	public void getBooksFromLibrary() {
		myModel.getBooks();
	}
	
	public void suggestBook() {
		myModel.suggestRead();
	}
	
	public void addListOfBooks() {
		myModel.addBooks(null);
	}
}
