package com.cmap;
import java.util.Map;
import java.util.HashMap;

public class cHashMap <K, V> implements IMap<K, V> {
    private Map<K, V> map;

    public cHashMap(){
        map = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        map.put(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public void remove(K key) {
        map.remove(key);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public void clear() {
        map.clear();    
    }
    
}
