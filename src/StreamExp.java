import java.util.ArrayList;
import java.util.List;

public class StreamExp {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        strings.add("Hello");
        strings.add("World");
        strings.add("!");
        strings.add("We love");
        strings.add("Java 8");

        strings.stream()
                .filter(s -> s.startsWith("W"))
                .forEach(System.out::println);

        strings
                .stream()
                .sorted()
                //.filter(s -> s.startsWith("W"))
                .forEach(System.out::println);

        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integers.add((int)(Math.random()*10));
        }

        integers
                .parallelStream()
                .filter(i -> i % 2 == 0)
                .sorted()
                .forEachOrdered(System.out::println);
    }
}
