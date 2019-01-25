import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        streamExp();

    }

    public static void streamExp(){
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        streamFromValues.forEach(System.out::println);

        List<String> list = new ArrayList();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a4");

        list.stream().map(s -> s + "_1");
        List<String> newList =  list.stream().map(s -> s + "_1").collect(Collectors.toList());
        newList.forEach(System.out::println);

        List<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMAN),
                new People("Иван Иванович", 69, Sex.MAN));

        // Отбор
        List<People> sortedPeople = peoples.stream().filter( people ->
                people.getAge() >= 18 && people.getAge() < 27 && people.getSex() == Sex.MAN)
                .collect(Collectors.toList());
        sortedPeople.forEach(p -> System.out.println(p.getName()));

        // Средний возраст
        System.out.println(
        peoples.stream().filter((p) -> p.getSex() == Sex.MAN).
                mapToInt(People::getAge).average().getAsDouble()
        );

        // Двойной фильтр
        System.out.println(
        peoples.stream().filter((p) -> p.getAge() >= 18).filter(
                (p) -> (p.getSex() == Sex.WOMAN && p.getAge() < 55) || (p.getSex() == Sex.MAN && p.getAge() < 60)).count()
        );

        System.out.println(
          peoples.stream().anyMatch(people -> people.getName().equals("Петя"))
        );

        // Сортировка по имени в обратном порядке
        peoples.stream().sorted((o1, o2) -> - o1.getName().compareTo(o2.getName())).collect(Collectors.toList())
                .forEach( people -> System.out.println(people.getName()));

        // Сортировка по двум параметрам

        peoples.stream().sorted((o1, o2) -> o1.getSex() != o2.getSex()? o1.getSex().
                compareTo(o2.getSex()): o1.getAge().compareTo(o2.getAge())).collect(Collectors.toList())
                .forEach(people -> System.out.println(people.getName()));
    }
}
