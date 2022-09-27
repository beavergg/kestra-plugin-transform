package io.kestra.plugin.hackathon.model;

public class ConstanceGetter implements Getter {
    private final Object obj;
    private final AdaptContext context;


    public ConstanceGetter(AdaptContext context, Object obj) {
        this.obj = obj;
        this.context = context;
    }

    @Override
    public Object get(DynamicRow row) {
        return obj;
    }
}
