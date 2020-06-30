/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;



public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		if (movieRatings == null || movieRatings.size()==0)
			return new ArrayList<String>();
		Set<String> set = movieRatings.keySet();
		ArrayList<String> list = new ArrayList<>(set.size());
		for (String item:set) {
			//System.out.println(item);
			list.add(item);
		}
		return list;
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		if (movieRatings == null || movieRatings.size()==0)
			return new ArrayList<String>();
		Set<Map.Entry<String, PriorityQueue<Integer>>> set1 = movieRatings.entrySet();
		
		for (Iterator<Entry<String, PriorityQueue<Integer>>> iterator = set1.iterator(); iterator.hasNext();) {
			Map.Entry<String, PriorityQueue<Integer>> mapentry = iterator.next();
		    if (mapentry.getValue().peek() <= rating ) {
		        // Remove the current element from the iterator and the list.
		        iterator.remove();
		    }
		}
		
		Set<String> set = movieRatings.keySet();
		ArrayList<String> list = new ArrayList<>(set.size());
		for (String item:set) {
			//System.out.println(item);
			list.add(item);
		}
		return list;
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		if (movieRatings == null || movieRatings.size()==0)
			return new TreeMap<String, Integer>();
		Set<Map.Entry<String, PriorityQueue<Integer>>> set1 = movieRatings.entrySet();
		TreeMap<String,Integer> treemap = new TreeMap<>();
		for (Iterator<Entry<String, PriorityQueue<Integer>>> iterator1 = set1.iterator(); iterator1.hasNext();) {
			Map.Entry<String, PriorityQueue<Integer>> mapentry = iterator1.next();
			Integer count = 0;
		    for (Iterator<Integer> iterator2 = mapentry.getValue().iterator();  iterator2.hasNext(); ) {
		        // Remove the current element from the iterator and the list.
		        if(iterator2.next()<rating) {
		        	iterator2.remove();
		        	count++;
		        }
		        if (mapentry.getValue().size()==0) {
		        	iterator1.remove();
		        }
		    }
		    if (count>0) {
		    	treemap.put(mapentry.getKey(), count);
		    }
		}
		return treemap;
	}
}
