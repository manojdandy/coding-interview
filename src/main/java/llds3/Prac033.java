package llds3;

import java.util.*;

class A {
    int id;
    String name;

    public A(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Prac033 {
   static Comparator<A> comparator = (a,b) -> {
        if(a !=b ) {
            return Integer.compare(b.id,a.id);
        }else {
            return a.name.compareTo(b.name);
        }
    };

    public static void main(String[] args) {
        Map<Integer,TreeSet<A>> map = new HashMap<>();
        TreeSet<A> treeSet = new TreeSet<>(comparator);
        treeSet.add(new A(1,"A"));
        treeSet.add(new A(1,"CC"));
        treeSet.add(new A(10,"B"));
        treeSet.add(new A(10,"aa"));
        map.put(1,treeSet);
        System.out.println(map);
    }

}
