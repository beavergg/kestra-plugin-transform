package io.kestra.plugin.hackathon.model;

import org.slf4j.Logger;

public class PutRowMap extends AbstractMap {
    private final Getter fieldGetter;
    private final Getter valueGetter;
    private final AdaptContext context;
    private boolean error = false;

    public PutRowMap(AdaptContext context, Getter fieldGetter, Getter valueGetter) {
        this.fieldGetter = fieldGetter;
        this.valueGetter = valueGetter;
        this.context = context;
    }

    @Override
    public DynamicRow map(DynamicRow row) {
        Logger logger = context.getLogger();
        String field = getString(fieldGetter, row);
        Object value = getObject(valueGetter, row);

        if (field != null) {
            row.appendCell(field, value);
            logger.debug("put field " + field + " with value " + value + " from rule: " + context.getContext().getText());
        } else if (!error) {
            error = true; // only log warn one time for all rows.
            logger.warn("Cannot get field name for put from rule " + context.getContext().getText());
        }

        return row;
    }
}
