import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}
	
	public String getfileName() {
		return fileName;
	}
	
	public List<Book> getAllBooks() throws IOException{
		List<Book> books= new ArrayList<>();
		RandomAccessFile rf = new RandomAccessFile(fileName, "rw");
		File file = new File(fileName);
		String line;
		Scanner scan = new Scanner(file);
        String[] split;

		while((line = rf.readLine()) != null) {
			split = scan.nextLine().split("\\t");
			
			String title = split[0];
			String author = split[1];
			int publicationYear = Integer.parseInt(split[2]);
			
			Book book = new Book(title, author, publicationYear);
			books.add(book);
		}
		return books;
	}

}
