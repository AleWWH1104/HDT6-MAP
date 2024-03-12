package com.cmap;

public class FactoryMap  {
    public IMap createMap(String tipo){
        switch (tipo) {
            case "1":
                return new cHashMap();
            case "2":
                return new cTreeMap();
            case "3":
                return new LinkedHM();
            default:
                return null;
        }
    }
}
