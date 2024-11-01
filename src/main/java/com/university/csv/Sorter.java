package com.university.csv;

import java.util.*;

public class Sorter {

    public static List<Map.Entry<String, Integer>> sortByName(Map<String, Integer> data) {
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(data.entrySet());
        sortedEntries.sort(Map.Entry.comparingByKey());
        return sortedEntries;
    }
}

