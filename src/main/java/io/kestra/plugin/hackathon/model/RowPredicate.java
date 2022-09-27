package io.kestra.plugin.hackathon.model;

import java.util.function.Predicate;

public interface RowPredicate {
    boolean test(Predicate<DynamicRow> predicate);
}
