package com.cmap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class cHashMap implements IMap{
    private Map<String, String> cartas;
    private Map<String, Integer> userCollection;

    public cHashMap(){
        cartas = new HashMap<>();
        userCollection = new HashMap<>();
    }

   @Override
    public void addCard(String name, String type) {
        cartas.put(name, type);
        userCollection.put(name, userCollection.getOrDefault(name, 0) + 1);
    }

    @Override
    public String getCardType(String name) {
        return cartas.get(name);
    }

    @Override
    public Map<String, Integer> getUserCollection() {
        return userCollection;
    }

    @Override
    public List<String> getAllCards() {
        return new ArrayList<>(cartas.keySet());
    }

    @Override
    public List<String> getAllCardsByType() {
        List<String> sortedCards = new ArrayList<>(cartas.keySet());
        sortedCards.sort(Comparator.comparing(cartas::get));
        return sortedCards;
    }
}

