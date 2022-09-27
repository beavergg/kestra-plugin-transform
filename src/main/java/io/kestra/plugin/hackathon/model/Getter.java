package io.kestra.plugin.hackathon.model;

@FunctionalInterface
public interface Getter {
    Object get(DynamicRow row);
}
