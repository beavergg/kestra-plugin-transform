package io.kestra.plugin.hackathon.model;

public class ConcatGetter implements Getter {
    private final AdaptContext context;
    private final Getter firGetter;
    private final Getter secGetter;

    public ConcatGetter(AdaptContext context, Getter firGetter, Getter secGetter) {
        this.context = context;
        this.firGetter = firGetter;
        this.secGetter = secGetter;
    }

    @Override
    public Object get(DynamicRow row) {
        String first = GetterUtils.getString(firGetter, row);
        String second = GetterUtils.getString(secGetter, row);

        if (first == null) return second;
        else if (second == null) return first;
        return first + second;
    }
}
