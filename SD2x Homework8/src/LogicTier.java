import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	private List<Book> books;
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
		books = readFile(dataTier.getfileName());
	}
	
	public List<Book> getBooks(){
		return books;
	}
	
	public List<Book> readFile(String fileName){
		List<Book> books = new ArrayList<>();
		try {
		books = dataTier.getAllBooks();
		return books;
		}
		catch (IOException e) {
			return books;
		}
	}
	public List<String> findBookTitlesByAuthor(String author) {
		List<Book> books2= new ArrayList<Book>();
		for (Book book: books)
			if (book.getAuthor().toLowerCase().contains(author.toLowerCase()))
				books2.add(book);
		Collections.sort(books2); 
		List<String> bookTitles = new ArrayList<String>();
		for (Book book: books2)
			bookTitles.add(book.getTitle());
		return bookTitles;
	}
	
	public int findNumberOfBooksInYear(int publicationyear) {
		int count = 0;
		for (Book book: books)
			if (book.getPublicationYear() == publicationyear)
				count++;
		return count;
	}
	
	public static void main(String[] args) {
		DataTier dt = new DataTier("books.txt");
		LogicTier lt = new LogicTier(dt);
		System.out.println(lt.findBookTitlesByAuthor("Monica"));
		System.out.println("Number of books in 2006: " + lt.findNumberOfBooksInYear(2006));
	}
}
