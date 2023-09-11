package PartII;
//import java.util.HashSet;
//import java.util.Set;

import java.util.*;

public class MathSet<E> extends HashSet<E> {
    
    public MathSet() {
        super();
    }
    
    public MathSet(Collection<? extends E> c) {
        super(c);
    }
    
    public Set<E> intersection(Set<E> s2) {
        Set<E> result = new HashSet<E>(this);
        result.retainAll(s2);
        return result;
    }
    
    public Set<E> union(Set<E> s2) {
        Set<E> result = new HashSet<E>(this);
        result.addAll(s2);
        return result;
    }
    
    public <T> Set<Pair<E, T>> cartesianProduct(Set<T> s2) {
        Set<Pair<E, T>> result = new HashSet<Pair<E, T>>();
        for (E element1 : this) {
            for (T element2 : s2) {
                result.add(new Pair<E, T>(element1, element2));
            }
        }
        return result;
    }
    
	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		
		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
		MathSet<Integer> s1 = new MathSet<Integer>();
		s1.add(5);
		s1.add(7);
		s1.add(9);
		MathSet<Integer> s2 = new MathSet<Integer>();
		s2.add(5);
		s2.add(7);
		s2.add(4);
		s2.add(6);
		s2.add(8);
		System.out.println(s1.intersection(s2));
		System.out.println(s1.union(s2));
		System.out.println(s1.cartesianProduct(s2));
		
		MathSet<String> s3 = new MathSet<String>();
		s3.add("H");
		s3.add("F");
		s3.add("G");
		System.out.println(s1.cartesianProduct(s3));

		}
		
}
