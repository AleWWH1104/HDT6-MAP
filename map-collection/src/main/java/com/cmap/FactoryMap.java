package com.cmap;

public class FactoryMap<K,V> {
    public IMap<K,V> createMap(String tipo){
        switch (tipo) {
            case "1":
                return new cHashMap<K,V>();
            case "2":
                return new cTreeMap<K,V>();
            case "3":
                return new LinkedHM<K,V>();
            default:
                return null;
        }
    }
}
