package com.housingbuddy.housingbuddyapi.utils;

import org.springframework.data.mongodb.core.convert.LazyLoadingProxy;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.InvocationTargetException;

final public class MongoUtils {
    private static final char[] SPECIAL_REGEX_CHARS = "\\[{}()[].+*?^$|]".toCharArray();

    public static String escapeForRegex(String string) {
        for (char c : SPECIAL_REGEX_CHARS) {
            string = string.replace("" + c, "\\" + c);
        }
        return string;
    }

    /**
     * If a field is annotated with {@link org.springframework.data.mongodb.core.mapping.DBRef} with `lazy=true`,
     * the field loaded by Spring will be a proxy object. This method returns the real object hidden by the proxy.
     */
    public static <T> T resolveLazyRef(Object ref, Class<T> type) {
        if (ref == null) {
            return null;
        } else if (ref.getClass().equals(type)) {
            return (T) ref;
        } else if (ref instanceof LazyLoadingProxy) {
            return (T) ((LazyLoadingProxy) ref).getTarget();
        } else {
            throw new IllegalArgumentException("Unexpected arg " + ref + " (" + ref.getClass() + "); cannot convert to " + type);
        }
    }

    public static <T> T getId(Object document, Class<T> idType) {
        try {
            return (T) document.getClass().getMethod("getId").invoke(document);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> String getCollectionName(Class<T> klass) {
        return klass.getAnnotation(Document.class).collection();
    }
}
