import java.util.Scanner;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {
	
	private static LogicTier logicTier; // link to the Logic Tier
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	public void start() {
	
		//System.out.println(logicTier.getBooks().toString());
		showNumberOfBooksInYear();
	}
	
	public void showBookTitlesByAuthor() {
		final Scanner sis = new Scanner(System.in);
		System.out.println("Please enter the author you would like to get books from, exit to exit: ");
        while (sis.hasNext()) {
        	String next = sis.next();
        	if (next.equalsIgnoreCase("exit"))
        		break;
        	System.out.println(logicTier.findBookTitlesByAuthor(next));
         }

	}

	public void showNumberOfBooksInYear() {
		final Scanner sis = new Scanner(System.in);
		System.out.println("Please enter the year you would like to get books from, exit to exit: ");
        while (sis.hasNext()) {
        	int nextint=0;
        	if (sis.hasNextInt()) {
        		nextint = sis.nextInt();
        	}
        	else {
        		String next = sis.next();
        		if (next.equalsIgnoreCase("exit"))
        		break;
        		}
        	System.out.println(logicTier.findNumberOfBooksInYear(nextint));
         }
	}
	
	public static void main(String[] args) {
		DataTier dataTier = new DataTier("books.txt");
		LogicTier logicTier = new LogicTier(dataTier);
		PresentationTier presentationTier = new PresentationTier(logicTier);
		presentationTier.start();
	}
}
