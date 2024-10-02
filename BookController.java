package bookLibrary;

public class BookController {
	
	private BookModel myModel;
	
	public BookController(BookModel model) {
		myModel = model;
	}
	
	public void searchLibrary() {
		//myModel.search();
	}
	
	public void addBookToLibrary(Book book) {
		myModel.addBook(book);
	}
	
	public void readBook(Book book) {
		myModel.setToRead(book);
	}
	
	public void rateBook(Book book, int rating) {
		myModel.rate(book, rating);
	}
	
	public void getBooksFromLibrary() {
		myModel.getBooks();
	}
	
	public String[] suggestBook() {
		
		Book suggestion=myModel.suggestRead();
		String [] bookInfo= {suggestion.getTitle(), suggestion.getAuthor()};
		return bookInfo;
	}
	
	
	public void addListOfBooks(String fileName) {
		myModel.addBooks(fileName);
	}
}
