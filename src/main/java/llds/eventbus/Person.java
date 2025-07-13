package llds.eventbus;

import java.util.function.Function;

public class Person {
    public static void main(String[] args) {
       Function<String,St> s = St::new;
        System.out.println();
    }
}
class St {
    String name;

    public St(String name) {
        this.name = name;
    }
}