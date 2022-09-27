package io.kestra.plugin.hackathon.model;

import org.slf4j.Logger;

public class RenameMap extends AbstractMap {
    private final AdaptContext context;
    private final Getter oldFieldGetter;
    private final Getter newFieldGetter;
    private volatile boolean error = false;

    public RenameMap(AdaptContext context, Getter oldFieldGetter, Getter newFieldGetter) {
        this.context = context;
        this.oldFieldGetter = oldFieldGetter;
        this.newFieldGetter = newFieldGetter;
    }

    @Override
    public DynamicRow map(DynamicRow row) {
        Logger logger = context.getLogger();
        String oldField = getString(oldFieldGetter, row);
        String newField = getString(newFieldGetter, row);

        if (oldField != null && newField != null) {
            row.rename(oldField, newField);
            logger.debug("rename field " + oldField + " to " + newField + " from rule: " + context.getContext().getText());
        } else if (!error) {
            error = true; // only log warn one time for all rows.
            logger.warn("Cannot get field name for put from rule " + context.getContext().getText());
        }

        return row;
    }
}
