package io.kestra.plugin.hackathon.model;

import java.util.function.Function;

public interface RowMap {
    DynamicRow map(DynamicRow row, Function<DynamicRow, DynamicRow> func);
}
