package io.kestra.plugin.hackathon.model;

import org.slf4j.Logger;

public class FieldGetter implements Getter {
    private final Getter fieldNameGetter;
    private final AdaptContext context;
    private boolean error = false;

    public FieldGetter(AdaptContext context, Getter fieldNameGetter) {
        this.fieldNameGetter = fieldNameGetter;
        this.context = context;
    }

    @Override
    public Object get(DynamicRow row) {
        Logger logger = context.getLogger();
        String field = null;
        if (fieldNameGetter != null) {
            Object obj = fieldNameGetter.get(row);
            if (obj != null) {
                if (obj instanceof String) field = (String) obj;
                else field = obj.toString();
            }
        }

        Object value = null;
        if (field != null) {
            value = row.get(field);
            logger.debug("Get field " + field + " with value " + value + " from rule: " + context.getContext().getText());
        } else if (!error) {
            error = true; // only log warn one time for all rows.
            logger.warn("Cannot get field name for field getter from rule " + context.getContext().getText());
        }

        return value;
    }
}
