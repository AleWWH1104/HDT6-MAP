package com.cmap;
import java.util.List;
import java.util.Map;

public interface IMap {
    void addCard(String name, String type);
    String getCardType(String name);
    Map<String, Integer> getUserCollection();
    List<String> getAllCards();
    List<String> getAllCardsByType();
}
