class LRUCache {
    HashMap<Integer,Integer> map1;
    HashMap<Integer,Integer> map2;
    HashMap<Integer,Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        this.map1 = new HashMap<>();
        this.map2 = new HashMap<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            //update list
            int pre = map2.get(key);
            int next = map1.get(key);
            map1.put(pre,next);
            map2.put(next,pre);
            pre = map2.get(Integer.MAX_VALUE);
            map2.put(Integer.MAX_VALUE,key);
            map2.put(key,pre);
            map1.put(pre,key);
            map1.put(key,Integer.MAX_VALUE);
            return map.get(key);
        } else {
            return -1;
        }            
    }
    
    public void put(int key, int value) {
        int pre,next;
        if(map.size() < capacity) {
            if(map.size() == 0) {
                map1.put(Integer.MIN_VALUE,key);
                map1.put(key,Integer.MAX_VALUE);
                map2.put(key,Integer.MIN_VALUE);
                map2.put(Integer.MAX_VALUE,key);
                map.put(key,value);
            } else {
                if(map1.containsKey(key)) {
                    pre = map2.get(key);
                    next = map1.get(key);
                    map1.put(pre,next);
                    map2.put(next,pre);
                    pre = map2.get(Integer.MAX_VALUE);
                    map2.put(Integer.MAX_VALUE,key);
                    map2.put(key,pre);
                    map1.put(pre,key);
                    map1.put(key,Integer.MAX_VALUE);
                    map.put(key,value);
                } else {
                    pre = map2.get(Integer.MAX_VALUE);
                    map2.put(Integer.MAX_VALUE,key);
                    map2.put(key,pre);
                    map1.put(pre,key);
                    map1.put(key,Integer.MAX_VALUE);
                    map.put(key,value);
                }
            }
        } else {
            if(map1.containsKey(key)) {
                pre = map2.get(key);
                next = map1.get(key);
                map1.put(pre,next);
                map2.put(next,pre);
                pre = map2.get(Integer.MAX_VALUE);
                map2.put(Integer.MAX_VALUE,key);
                map2.put(key,pre);
                map1.put(pre,key);
                map1.put(key,Integer.MAX_VALUE);
                map.put(key,value);
            } else {
                next = map1.get(map1.get(Integer.MIN_VALUE));
                map1.put(Integer.MIN_VALUE,next);
                map2.put(next,Integer.MIN_VALUE);
                pre = map2.get(Integer.MAX_VALUE);
                map2.put(Integer.MAX_VALUE,key);
                map2.put(key,pre);
                map1.put(pre,key);
                map1.put(key,Integer.MAX_VALUE);
                map.put(key,value);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);When the cache is full, the algorithm must choose which items to discard to make room for the new ones.
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
