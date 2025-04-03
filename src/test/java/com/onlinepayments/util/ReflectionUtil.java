package com.onlinepayments.util;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.lang.reflect.Field;

public final class ReflectionUtil {

    private ReflectionUtil() {
    }

    public static <T> T getField(Object object, String fieldName, Class<T> fieldType) {
        Class<?> clazz = object.getClass();
        while (clazz != Object.class) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                Object fieldValue = field.get(object);
                return assertInstanceOf(fieldType, fieldValue);
            } catch (@SuppressWarnings("unused") NoSuchFieldException e) {
                // try next class
            } catch (IllegalAccessException e) {
                // should no longer occur
                throw new IllegalStateException(e);
            }

            clazz = clazz.getSuperclass();
        }

        return null;
    }
}
