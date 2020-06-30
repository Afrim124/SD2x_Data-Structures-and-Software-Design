import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
	     if( filename == null) {
				return new LinkedList<>();
	     }
	     File file = new File(filename);
	     LinkedList<Sentence> list =new LinkedList<>();
	     
	     try (Scanner scanner = new Scanner(file)) {
		      Sentence temp;
		      boolean hasNextLine = false;
		      while(hasNextLine = scanner.hasNextLine()) {
		    	  if (scanner.hasNextInt()) {
		    		  int score = scanner.nextInt();
		    		  if (score>2||score<-2)
		    			  continue;
		    	  	String line = scanner.nextLine().trim();
		    	  	if (line.equals(""))
		    	  		continue;

		    	  	temp= new Sentence(score, line);
		    	  	list.add(temp);
		      	}
		    	  else if ( scanner.nextLine().equals("") ) {
		    		  	break;
		    	  }
			  	  
		      }
		      scanner.close();
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new LinkedList<>();
		 } 
	     return list;
	}
	
	/*public static void main(String[] args) {
		List<Sentence> sentences = Analyzer.readFile("test6.txt");
		System.out.println(sentences);
	}*/


	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
		if (sentences == null ||sentences.size()==0) 
			return new HashSet<>();
		Set<Word> wSet=new HashSet<>();
		HashMap<Word, Word> map= new HashMap<>();
		for(Sentence sentence:sentences) {
			if (sentence == null)
				continue;
			String[] result = sentence.text.toLowerCase().split("\\s");
		     for (int x=0; x<result.length; x++) {
		    	if (result[x].matches("[a-z]*")) {
			    	Word word= new Word(result[x]);  
			    	Word word1 = word;
		    		word.increaseTotal(sentence.score);
		    	if (map.containsKey(word1)) {
		    		Word word2= map.get(word1);
		    		word2.increaseTotal(sentence.score);
		    		 map.put(word1, word2);
 		    	 }
		    	 else {
		    		 map.put(word1, word);
		    	 }
	     		 
		    	 }
		    	Object[] arrayValues= map.values().toArray();
		    	for(int i =0;i<arrayValues.length;i++)
		    		if (arrayValues[i] instanceof Word)
		    			wSet.add((Word)arrayValues[i]);
		     }
		}
	     
	     return wSet;  
	}
	/*
	public static void main(String[] args) {
		List<Sentence> sentences = Analyzer.readFile("test6.txt");
		Set<Word> words = Analyzer.allWords(sentences);
		System.out.println(words);
	}*/
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		if (words==null)
			return new HashMap<String, Double>();
		Map<String, Double> map = new HashMap<>();
		for(Word word:words) {
			if (word==null)
				continue;
			map.put(word.getText(), word.calculateScore());
		}
		return map;

	}
	/*
	public static void main(String[] args) {
		List<Sentence> sentences = Analyzer.readFile("reviews2.txt");
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		System.out.println(wordScores);
	}*/
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		if (wordScores == null || wordScores.size() == 0 || sentence == null) {
			return 0.0d;
		}
		String[] words = sentence.toLowerCase().split("\\s");
		if ( words.length == 0) {
			return 0.0d;
		}
		int i = 0;
		double score = 0.0d;
		for(String word:words) {
			if (word.matches("[a-z]*")) {
				score+= wordScores.getOrDefault(word, 0.0d);
			} else {
				i= i+1;
			} 
		}
		if (words.length == i) {
			return 0.0d;
		} 
		return score;
	}
	
	public static void main(String[] args) {
		List<Sentence> sentences = Analyzer.readFile("reviews2.txt");
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, "I am an unhappy person don 't you know it .");
		System.out.println("The sentiment score is " + score);
	}
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	/*public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
		
	*/
}
