package io.kestra.plugin.hackathon.model;

public abstract class AbstractMap implements RowMap {

    protected String getString(Getter getter, DynamicRow row) {
        return GetterUtils.getString(getter, row);
    }

    protected Object getObject(Getter getter, DynamicRow row) {
        return GetterUtils.getObject(getter, row);
    }
}
