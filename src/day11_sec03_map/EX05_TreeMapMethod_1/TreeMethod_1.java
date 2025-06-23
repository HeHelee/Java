package day11_sec03_map.EX05_TreeMapMethod_1;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMethod_1 {

	public static void main(String[] args) {
		TreeMap<Integer, String> treeMap = new TreeMap<Integer,String>();
		for (int i = 20; i > 0; i -= 2) {
			treeMap.put(i, i + " 번째 데이터");
		}
		System.out.println(treeMap.toString());
		//1. firstKey();
		System.out.println(treeMap.firstKey());
		//2. firstEntry();
		System.out.println(treeMap.firstEntry());
		//3. lastKey()
		System.out.println(treeMap.lastKey());
		//4. lastEntry()
		System.out.println(treeMap.lastEntry());
		//5. lowerKey()
	    System.out.println(treeMap.lowerKey(11));
	    System.out.println(treeMap.lowerKey(10));
	    //6. higherKey()
	    System.out.println(treeMap.higherKey(11));
	    System.out.println(treeMap.higherKey(10));
	    //7. pollFirstrtEntry()
	    System.out.println(treeMap.pollFirstEntry());
	    System.out.println(treeMap.toString());
	    //8. pollLastEntry()
	    System.out.println(treeMap.pollLastEntry());
	    System.out.println(treeMap.toString());
	    //9. SortedMap<K,V> headMap(K toKey)
	    SortedMap<Integer, String> sortedMap = treeMap.headMap(8, true);
	    System.out.println(sortedMap);
	    //10. NavigableMap<K, V> headMap(K toKey, boolean inclusive)
	    NavigableMap<Integer, String> navigableMap = treeMap.headMap(8,true);
	    System.out.println(navigableMap);
	    //11. SortedMap<K,V> headMap(K toKey, boolean inclusive)
	    sortedMap = treeMap.tailMap(14);
	    System.out.println(sortedMap);
	    //12. NavigableMap<K,V> headMap (K toKey, boolean inclusive)
	    navigableMap = treeMap.tailMap(14, false);
	    System.out.println(navigableMap);
	    //13. SortedMap<K, V> subMap(K fromKey, K toKey)
	    sortedMap = treeMap.subMap(6, 10);
	    System.out.println(sortedMap);
	    //14.Navigable<K,V> subMap (K toKey, boolean inclusive)
	    navigableMap = treeMap.subMap(6, false,10,true);
	    System.out.println(navigableMap);
	    //15.NavigableSet<K> descendingKeySet()
	    NavigableSet<Integer> navigableSet = treeMap.descendingKeySet();
	    System.out.println(navigableSet.toString());
	    System.out.println(navigableSet.descendingSet());
	    //16. NavigableMap<K,V> descendingMap()
	    navigableMap = treeMap.descendingMap();
	    System.out.println(navigableMap.toString());
	    System.out.println(navigableMap.descendingMap());

	}

}
