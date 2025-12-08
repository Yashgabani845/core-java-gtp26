package advanced_java.streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class c {
    public static void main(String[] args) {
        // 1. From a collection
        List<Integer> list = Arrays.asList(5,1,6,2,7,5,4,2,3,4);
        Stream<Integer>stream1 = list.stream();

        // set doesn't keep ordering that's why sorted part faded
        Set<Integer> set = stream1
                .filter(n -> n>=2)
                .map(n->n*2)
                .sorted()
                .collect(Collectors.toSet());

        System.out.println(set);

        System.out.println();

        // 2. From an Array
        String[] arr = {"A", "B", "C"};
        Stream<String> stream2 = Arrays.stream(arr);
        stream2.forEach(System.out::println);
        System.out.println();

        // 3. Using Stream.of()
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
        stream3.forEach(System.out::println);
        System.out.println();

        // 4. Infinite Stream (limit to avoid infinite loop)
        Stream<Integer> stream4 = Stream.iterate(1, n -> n + 1).limit(5);
        stream4.forEach(System.out::println);
    }
}
