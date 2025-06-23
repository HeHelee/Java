package day11_sec02_set.EX04_TreeSetMethod_1;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetMethod_1 {

	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		for(int i = 50; i > 0; i-=2) {
			treeSet.add(i);
		}
		System.out.println(treeSet.toString());
		//first
		System.out.println(treeSet.first());
		//last
		System.out.println(treeSet.last());
		//lower(E element)
		System.out.println(treeSet.lower(26));
		//higher(E element)
		System.out.println(treeSet.higher(26));
		//floor(E element)
		System.out.println(treeSet.floor(25));
		System.out.println(treeSet.floor(26));
		//ceiling(E element)
		System.out.println(treeSet.ceiling(25));
		System.out.println(treeSet.ceiling(26));
		System.out.println();
		//pollFirst()
		int treeSetSize = treeSet.size();
		System.out.println(treeSetSize);
		for(int i = 0; i < treeSetSize; i++) {
			System.out.print(treeSet.pollFirst() + " ");
		}
		System.out.println();
		System.out.println(treeSet.size());
		//pollLast()
		for (int i = 50; i > 0; i-=2) {
			treeSet.add(i);
		}
		treeSetSize = treeSet.size();
		for (int i = 0; i < treeSetSize; i++) {
			System.out.println(+treeSet.pollLast() + " ");
		}
		System.out.println();
		System.out.println(treeSet.size());
		//SortedSet<E> HashSet(E element)
		for (int i = 50; i > 0; i-=2) {
			treeSet.add(i);
		}
		SortedSet<Integer> sSet = treeSet.headSet(20,true);
		System.out.println(sSet.toString());
		//NavigableSet<E> headSet(E element, boolean inclusive)
		NavigableSet<Integer> nSet = treeSet.headSet(20,true);
		System.out.println(nSet.toString());
		//SortedSet<E> tailSet(E element)
		sSet = treeSet.tailSet(20,true);
		System.out.println(sSet.toString());
		nSet = treeSet.tailSet(20, false);
		System.out.println(nSet.toString());
		//SortedSet<E> subSet(E element, E element)
		sSet = treeSet.subSet(10, 20);
		System.out.println(sSet.toString());
		//NavigableSet<E> subSet(E element, boolean inclusve, E element, boolean inclusive)
		nSet = treeSet.subSet(10, true, 20, false);
		System.out.println(nSet.toString());
		nSet = treeSet.subSet(10, false, 20, true);
		System.out.println(nSet.toString());
		//NavigableSet<E> descendingSet()
		System.out.println(treeSet);
		NavigableSet<Integer> descendingSet = treeSet.descendingSet();
		System.out.println(descendingSet);
		descendingSet = descendingSet.descendingSet();
		System.out.println(descendingSet);
		
		 

	}

}
