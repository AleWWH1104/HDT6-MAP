package com.cmap;

public interface IMap <K, V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    boolean isEmpty();
    void clear();
    
}
