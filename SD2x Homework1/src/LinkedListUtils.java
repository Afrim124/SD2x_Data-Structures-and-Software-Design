

import java.util.LinkedList;
import java.util.Arrays;
import java.lang.String;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	public static void insertSorted(LinkedList<Integer> list, int value) {
		if( list == null) {
			return;
		}
		if (list.size()==0)
			list.addFirst(value);
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i)<value)
				continue;
			if(list.get(i)>=value) {
				list.add(i, value);
				break;
			}
		}
		return;
	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {
		if(list == null || list.size()==0 |  N <= 0) {
			return;
		}
		try {
			if (N >= list.size()) {
				list.clear();
				return;
			}
			Object[] alist = list.toArray();
			String alist2[]= new String[alist.length]; 
			for(int i=0;i<alist.length;i++)
				alist2[i]= (String)alist[i];
			Arrays.sort(alist2, null);
			String maxList[]= new String[N];
			for(int i=alist2.length-1, k=0;;i--) {
				if (Arrays.binarySearch(maxList, alist2[i]) <= 0){
					maxList[k]= alist2[i];
					k++;
					if(k>=N)
						break;
				}
			}
			
			for(int i=0;i<N;i++) {
				boolean value_present = false;
				do {
					value_present = list.remove(maxList[i]);
				} while (value_present);
			}
		} catch (NullPointerException e) {
				
		}
	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
		if (one == null || two == null || one.size()==0 | two.size()==0 ) {
			return false;
			}
		int startNr1 = two.get(0);
		int startNr2;
outer:
		for (int i=0;i<one.size()-two.size()+1;i++) {
			startNr2 = one.get(i);
			if (startNr2 != startNr1)
				continue outer;
			else {
				boolean match=false;
				for (int j=0;j<two.size();j++) {
					if (one.get(i+j)!=two.get(j))
						continue outer;
					else 
						match = true;
				}
				if(match==true)
					return true;
			}
		}
		return false;
	}

}
