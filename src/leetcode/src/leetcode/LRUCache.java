package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Integer> cacheMap;
    CacheEntity[] cacheHeap;
    
    public LRUCache(int capacity) {
        cacheMap = new HashMap<>();
        cacheHeap = new CacheEntity[capacity];
    }
    
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache(1);
    	cache.set(2, 1);
    	System.out.println(cache.get(2));
    	cache.set(3, 2);
    	System.out.println(cache.get(2));
    	System.out.println(cache.get(3));
    }
    
    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        int index = cacheMap.get(key);
        CacheEntity cacheEntity = cacheHeap[index];
        cacheEntity.count = cacheEntity.count + 1;
        shiftDown(index);
        return cacheEntity.value;
    }
    
    public void set(int key, int value) {
    	if (cacheMap.containsKey(key)) {
            return;
        }
        if (cacheMap.size() == cacheHeap.length) {
            cacheMap.remove(cacheHeap[0].key);
            cacheHeap[0] = new CacheEntity(key, value);
            cacheMap.put(key, 0);
            shiftDown(0);
        } else {
        	int insertIndex = cacheMap.size();
            cacheHeap[insertIndex] = new CacheEntity(key, value);
            cacheMap.put(key, insertIndex);
            shiftUp(insertIndex);
        }
    }
    
    private void shiftUp(int index) {
        while(index > 0) {
            int parent = index / 2;
            if (cacheHeap[parent].count > cacheHeap[index].count) {
                swapCache(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }
    
    private void shiftDown(int index) {
        int length = cacheMap.size();
        if (index >= length / 2) {
            return;
        }
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int targetIndex;
        if (right < length) {
            targetIndex = cacheHeap[left].count < cacheHeap[right].count ? left : right;
        } else {
            targetIndex = left;
        }
        if (cacheHeap[index].count > cacheHeap[targetIndex].count) {
            swapCache(index, targetIndex);
        }
    }
    
    private void swapCache(int source, int target) {
        CacheEntity tmp = cacheHeap[source];
        cacheHeap[source] = cacheHeap[target];
        cacheHeap[source] = tmp;
        cacheMap.put(cacheHeap[source].key, source);
        cacheMap.put(cacheHeap[target].key, target);
    }
}

class CacheEntity {
    public int key;
    public int value;
    public int count;
    
    public CacheEntity(int key, int value) {
        this.key = key;
        this.value = value;
        this.count = 0;
    }
}
