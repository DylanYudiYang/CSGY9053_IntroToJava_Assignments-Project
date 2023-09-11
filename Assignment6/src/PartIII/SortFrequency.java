package PartIII;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortFrequency {
	//Fix the problem by comparing both the frequency and the value of the elements
	public static void sortByFrequency(ArrayList<Integer> ar) {
	    Map<Integer, Integer> freqmap = new HashMap<>();
	    for (int i : ar) {
	        freqmap.put(i, freqmap.getOrDefault(i, 0) + 1);
	    }

	    Comparator<Integer> comparator = (a, b) -> {
	        int freqCompare = freqmap.get(a).compareTo(freqmap.get(b));
	        return freqCompare != 0 ? freqCompare : a.compareTo(b);
	    };

	    ar.sort(comparator);
	}
   
    public static void main(String[] args) {
            ArrayList<Integer> ar = new ArrayList<Integer>();
            for (int i=0;i<100;i++) {
                    ar.add((int)(Math.random()*10));                        
            }
            System.out.println(ar.toString());
            sortByFrequency(ar);
            System.out.println(ar.toString());
    }
}
