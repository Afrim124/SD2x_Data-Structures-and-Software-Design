/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		if (allUsersRatings==null || allUsersRatings.size()==0)
			return new TreeMap<String, PriorityQueue<Integer>>();
		TreeMap<String, PriorityQueue<Integer>> map = new TreeMap<String, PriorityQueue<Integer>>();
		for (UserMovieRating umr : allUsersRatings) {
			if (umr == null || umr.movie == null || umr.movie.length()==0 || umr.userRating <= 0 ) {
				continue;
			}
			if(map.get(umr.movie.toLowerCase())==null) {
				PriorityQueue<Integer> minHeap = new PriorityQueue<>();
				minHeap.add(umr.getUserRating());
				map.put(umr.movie.toLowerCase(), minHeap);
			}
			else {
				PriorityQueue<Integer> minHeap = map.get(umr.movie.toLowerCase());
				minHeap.add(umr.getUserRating());
				map.put(umr.movie.toLowerCase(), minHeap);
			}
	}
		return map;
	}

}
