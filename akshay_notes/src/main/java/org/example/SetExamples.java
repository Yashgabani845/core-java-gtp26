package org.example;

import java.util.*;

/**
 * Demonstrates HashSet, LinkedHashSet, TreeSet and most-popular Set methods.
 */
public class SetExamples {

    public static void main(String[] args) {
        hashSetDemo();
        linkedHashSetDemo();
        treeSetDemoWithStrings();
        treeSetDemoWithCustomObjects();
        commonBulkOperationsDemo();
    }

    // -------------------
    // HashSet demo
    // -------------------
    static void hashSetDemo() {
        System.out.println("\n--- HashSet Demo ---");

        // HashSet: no guaranteed order, fast O(1) average for add/remove/contains
        Set<String> hs = new HashSet<>();

        hs.add("apple");
        hs.add("banana");
        hs.add("cherry");
        hs.add("banana"); // duplicate ignored

        System.out.println("HashSet contents (order unpredictable): " + hs);
        System.out.println("Contains 'apple'? " + hs.contains("apple"));

        hs.remove("cherry");
        System.out.println("After remove('cherry'): " + hs);

        // allows one null
        hs.add(null);
        System.out.println("After add(null): " + hs);

        System.out.println("Size: " + hs.size());
    }

    // -------------------
    // LinkedHashSet demo
    // -------------------
    static void linkedHashSetDemo() {
        System.out.println("\n--- LinkedHashSet Demo ---");

        // LinkedHashSet: preserves insertion order
        Set<String> lhs = new LinkedHashSet<>();
        lhs.add("first");
        lhs.add("second");
        lhs.add("third");
        lhs.add("second"); // duplicate ignored

        System.out.println("LinkedHashSet iteration (insertion order): ");
        lhs.forEach(System.out::println); // prints first, second, third in order

        // Useful when you want deterministic iteration order but still unique elements
        System.out.println("LinkedHashSet as list: " + lhs);
    }

    // -------------------
    // TreeSet demo with Strings (natural order)
    // -------------------
    static void treeSetDemoWithStrings() {
        System.out.println("\n--- TreeSet Demo (Strings, natural order) ---");

        // TreeSet: sorted order (natural ordering for strings)
        Set<String> ts = new TreeSet<>();
        ts.add("zebra");
        ts.add("apple");
        ts.add("monkey");

        System.out.println("TreeSet (sorted): " + ts); // [apple, monkey, zebra]

        // TreeSet methods (only on NavigableSet / SortedSet view)
        if (ts instanceof NavigableSet) {
            NavigableSet<String> nav = (NavigableSet<String>) ts;
            System.out.println("first(): " + nav.first());
            System.out.println("last(): " + nav.last());
            System.out.println("floor('m'): " + nav.floor("m")); // greatest <= "m"
            System.out.println("ceiling('m'): " + nav.ceiling("m")); // least >= "m"
        }
    }

    // -------------------
    // TreeSet demo with custom objects using Comparator
    // -------------------
    static void treeSetDemoWithCustomObjects() {
        System.out.println("\n--- TreeSet Demo (Custom objects with Comparator) ---");

        // Custom class
        record Person(String name, int age) {}

        // TreeSet needs ordering: provide Comparator<Person> (by age, then name)
        Comparator<Person> byAgeThenName = Comparator.comparingInt(Person::age)
                .thenComparing(Person::name);

        Set<Person> people = new TreeSet<>(byAgeThenName);
        people.add(new Person("Akshay", 25));
        people.add(new Person("Rahul", 30));
        people.add(new Person("Neha", 22));
        people.add(new Person("Zara", 25)); // same age as Akshay, sorted by name next

        System.out.println("People sorted by age then name:");
        people.forEach(p -> System.out.println(p.name() + " - " + p.age()));
        // demonstrates TreeSet sorting with Comparator
    }

    // -------------------
    // Common bulk operations and useful methods across Set implementations
    // -------------------
    static void commonBulkOperationsDemo() {
        System.out.println("\n--- Common Set Methods / Bulk Operations Demo ---");

        Set<String> a = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        Set<String> b = new HashSet<>(Arrays.asList("C", "D", "E", "F"));

        System.out.println("A: " + a);
        System.out.println("B: " + b);

        // addAll -> union
        Set<String> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("A ∪ B (addAll): " + union);

        // retainAll -> intersection (keeps only elements present in both)
        Set<String> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("A ∩ B (retainAll): " + intersection);

        // removeAll -> difference
        Set<String> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.println("A \\ B (removeAll): " + difference);

        // containsAll -> subset check
        System.out.println("A contains C and B? " + a.containsAll(Arrays.asList("C", "B")));

        // toArray
        Object[] arr = a.toArray();
        System.out.println("toArray() -> " + Arrays.toString(arr));

        // iteration examples
        System.out.println("Iterator iteration:");
        Iterator<String> it = a.iterator();
        while (it.hasNext()) System.out.println(it.next());

        // clear and isEmpty
        a.clear();
        System.out.println("After clear, isEmpty? " + a.isEmpty());
    }
}
