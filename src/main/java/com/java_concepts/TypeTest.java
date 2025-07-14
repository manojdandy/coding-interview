package com.java_concepts;

public class TypeTest {
    public static void main(String[] args) {
        System.out.println(get("hello"));
    }

    public static <T> T get(T t) {
        return t;
    }

    public <T> void set(T t) {

    }
}
