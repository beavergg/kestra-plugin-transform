package io.kestra.plugin.hackathon.model;

import org.slf4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DynamicTable {
    private final Logger logger;

    private final List<DynamicRow> rows = new LinkedList<>();
    private final Map<String, Integer> indexMap = new HashMap<>();

    private int maxSize = 0;
    private DynamicRow currentRow = null;

    public DynamicTable(Logger logger) {
        this.logger = logger;
    }

    public void appendRow() {
        currentRow = new DynamicRow(maxSize, indexMap);
        rows.add(currentRow);
    }

    public void appendCell(String column, Object value) {
        maxSize = currentRow.appendCell(column, value);
    }

}
