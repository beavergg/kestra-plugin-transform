package io.kestra.plugin.hackathon.model;

import org.slf4j.Logger;

public class RemoveMap extends AbstractMap {
    private final Getter fieldGetter;
    final AdaptContext context;
    boolean error = false;

    public RemoveMap(AdaptContext context, Getter fieldGetter) {
        this.fieldGetter = fieldGetter;
        this.context = context;
    }

    @Override
    public DynamicRow map(DynamicRow row) {
        Logger logger = context.getLogger();
        String field = getString(fieldGetter, row);
        if (field != null) {
            logger.debug("remove field " + field);
            row.remove(field);
        } else if (!error) {
            error = true;
            logger.warn("Cannot get field name for remove from rule " + context.getContext().getText());
        }
        return row;
    }
}
