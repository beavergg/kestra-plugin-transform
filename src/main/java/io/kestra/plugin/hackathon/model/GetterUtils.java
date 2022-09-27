package io.kestra.plugin.hackathon.model;

public class GetterUtils {
    public static String getString(Getter getter, DynamicRow row) {
        String value = null;
        if (getter != null) {
            Object obj = getter.get(row);
            if (obj != null) {
                if (obj instanceof String) value = (String) obj;
                else value = obj.toString();
            }
        }
        return value;
    }

    public static Object getObject(Getter getter, DynamicRow row) {
        if (getter != null) return getter.get(row);
        return null;
    }
}
