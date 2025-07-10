package llds;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Student implements  Comparable<Student> {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
public class ComparableTest {
    public static void main(String[] args) {
        Comparator<String> c4 = (a,b) -> Integer.parseInt(a) - Integer.parseInt(b);
       // Comparator<String> comparator = Comparator.comparing(Integer::parseInt);
        TreeMap<String,Student> treeMap1 = new TreeMap<>(c4);
        treeMap1.put("100",new Student(1,"ram"));
        treeMap1.put("50",new Student(2,"shyam"));
        treeMap1.put("150",new Student(20,"tiger"));
        treeMap1.put("20",new Student(4,"lion"));
        for(Map.Entry<String,Student> entry:treeMap1.entrySet()) {
            System.out.println(entry.getKey() + " :: value ::" + entry.getValue());
        }
    }
}
