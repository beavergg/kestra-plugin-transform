package io.kestra.plugin.hackathon.model;

import org.antlr.v4.runtime.ParserRuleContext;
import org.slf4j.Logger;

public class BeanFactory {

    public static AdaptContext getAdaptContext(Logger logger, ParserRuleContext ctx) {
        return new AdaptContext(logger, ctx);
    }

    public static Getter convertToGetter(AdaptContext ctx, Object obj) {
        if (obj instanceof ConstanceGetter) return (ConstanceGetter) obj;

        return new ConstanceGetter(ctx, obj);
    }

    public static Getter getFieldGetter(AdaptContext context, Getter getter) {
        return new FieldGetter(context, getter);
    }

    public static RowMap getPutRowMap(AdaptContext context, Getter field, Getter value) {
        return new PutRowMap(context, field, value);
    }

    public static RowMap getRemoveRowMap(AdaptContext context, Getter field) {
        return new RemoveMap(context, field);
    }

    public static RowMap getRenameMap(AdaptContext context, Getter oldField, Getter newField) {
        return new RenameMap(context, oldField, newField);
    }
}
