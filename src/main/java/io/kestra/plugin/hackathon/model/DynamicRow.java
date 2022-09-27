package io.kestra.plugin.hackathon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DynamicRow {
    private final List<Object> values = new ArrayList<>();
    private final Map<String, Integer> indexMap;
    private int maxSize;

    DynamicRow(int maxSize, Map<String, Integer> indexMap) {
        for (int i = 0; i < maxSize; i++) {
            values.add(null);
        }
        this.indexMap = indexMap;
    }

    int appendCell(String column, Object value) {
        Integer index = indexMap.get(column);
        if (index == null) {
            index = maxSize++;
            indexMap.put(column, index);
            add(value);
        } else {
            set(index, value);
        }
        return maxSize;
    }

    private void add(Object value) {
        values.add(value);
    }

    private void set(int index, Object value) {
        values.set(index, value);
    }
}
