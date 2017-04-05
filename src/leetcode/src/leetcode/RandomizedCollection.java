package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedCollection {
    
    private static final Random r = new Random();
    List<Integer> list;
    Map<Integer, Set<Integer>> map;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> indexList = map.get(val);
        boolean contained = false;
        if (indexList == null) {
            indexList = new HashSet<>();
            contained = true;
        }
        indexList.add(list.size() - 1);
        map.put(val, indexList);
        return contained;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> indexList = map.get(val);
        if (indexList == null || indexList.size() == 0) {
            return false;
        }
        int index = indexList.iterator().next();
        indexList.remove(index);
        if (index < list.size() - 1) {
        	int last = list.get(list.size() - 1);
        	list.set(index, last);
        	map.get(last).remove(list.size() - 1);
        	map.get(last).add(index);
        }
        list.remove(list.size() - 1);
        if (indexList.size() == 0) {
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
    
    public static void main(String[] args) {
    	//["RandomizedCollection","insert","insert","insert","insert","insert",
    	// "insert","remove","remove","remove","insert","remove"]
    	//[[],[9],[9],[1],[1],[2],[1],[2],[1],[1],[9],[1]]
        int i = '1' - '0';
        System.out.println(i);
        char s = 1 + '0';
        System.out.println(s);
    	RandomizedCollection c = new RandomizedCollection();
    	c.insert(0);
    	c.insert(1);
    	c.insert(2);
    	c.insert(3);
    	c.insert(3);
    	c.remove(2);
    	c.remove(3);
    	c.remove(0);
    	c.getRandom();
    	c.getRandom();
    	c.getRandom();
    }
}
