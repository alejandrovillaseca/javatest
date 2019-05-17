package com.aledev.javatest.utils;

public class StringUtil {
    public static String repeat(String str, int times) {
        if (times < 0)
            throw new IllegalArgumentException("No se permiten números negativos");
        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }

        return result;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() <= 0;
    }
}