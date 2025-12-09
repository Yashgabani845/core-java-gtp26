import java.util.*;
public class executor  {

    public static void main(String[] args) {
        List<Callable<Integer>> tasks = Arrays.asList(
                () -> 1,
                () -> 2,
                () -> 3
        );

        ExecutorService ex = Executors.newFixedThreadPool(3);

        List<Future<Integer>> results = ex.invokeAll(tasks);

        for (Future<Integer> f : results) {
            System.out.println(f.get());
        }

    }
}