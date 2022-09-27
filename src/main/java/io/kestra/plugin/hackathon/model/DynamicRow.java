package io.kestra.plugin.hackathon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DynamicRow {
    private final List<Object> values = new ArrayList<>();
    private final Map<String, Integer> indexMap;
    private final Set<Integer> removedIndex;
    private int maxSize;

    DynamicRow(int maxSize, Map<String, Integer> indexMap, Set<Integer> removedIndex) {
        for (int i = 0; i < maxSize; i++) {
            values.add(null);
        }
        this.indexMap = indexMap;
        this.removedIndex = removedIndex;
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

    void remove(String field) {
        Integer index = indexMap.get(field);
        if (index != null) {
            removedIndex.add(index);
        }
    }

    public Object get(String field) {
        Integer index = indexMap.get(field);
        if (index != null && index < values.size()) {
            return values.get(index);
        }
        return null;
    }

    public void rename(String oldField, String newField) {
        Integer index = indexMap.get(oldField);
        if (index != null) {
            indexMap.put(newField, index);
            indexMap.remove(oldField);
        }

    }
}
