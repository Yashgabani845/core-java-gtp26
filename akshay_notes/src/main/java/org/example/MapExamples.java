package org.example;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MapExamples - demonstrates HashMap, LinkedHashMap, TreeMap, Hashtable,
 * ConcurrentHashMap, WeakHashMap, IdentityHashMap and common/special methods.
 *
 * Each demo method prints comments and results so you can study behavior.
 */
public class MapExamples {

    public static void main(String[] args) {
        System.out.println("=== HashMap demo ===");
        hashMapDemo();

        System.out.println("\n=== LinkedHashMap demo (insertion & LRU) ===");
        linkedHashMapDemo();

        System.out.println("\n=== TreeMap demo (sorted / NavigableMap) ===");
        treeMapDemo();

        System.out.println("\n=== Hashtable demo (legacy, synchronized) ===");
        hashtableDemo();

        System.out.println("\n=== ConcurrentHashMap demo (thread-safe methods) ===");
        concurrentHashMapDemo();

        System.out.println("\n=== WeakHashMap demo (weak keys) ===");
        weakHashMapDemo();

        System.out.println("\n=== IdentityHashMap demo (reference-equality keys) ===");
        identityMapDemo();

        System.out.println("\n=== Common Map bulk & utility methods demo ===");
        commonMapMethodsDemo();
    }

    // -----------------------
    // 1) HashMap: default general-purpose map
    // -----------------------
    static void hashMapDemo() {
        // HashMap: average O(1) get/put/remove, allows null key and null values
        Map<String, Integer> map = new HashMap<>();

        // put, get
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);

        System.out.println("map = " + map);

        // getOrDefault -> returns default if key not present
        System.out.println("getOrDefault(mango, -1) = " + map.getOrDefault("mango", -1));

        // putIfAbsent -> only set if absent
        map.putIfAbsent("banana", 99); // banana exists -> not replaced
        map.putIfAbsent("mango", 40);  // mango absent -> inserted
        System.out.println("after putIfAbsent: " + map);

        // computeIfAbsent -> compute and insert if absent
        map.computeIfAbsent("pear", k -> 50); // pear added with 50
        System.out.println("after computeIfAbsent: " + map);

        // compute -> remap based on old value (null allowed)
        map.compute("apple", (k, v) -> v == null ? 0 : v + 5); // apple becomes 15
        System.out.println("after compute on apple: " + map);

        // remove(key, value) -> conditional remove; returns boolean
        boolean removed = map.remove("banana", 20);
        System.out.println("removed banana=20 ? " + removed + ", map: " + map);

        // replace(key, value) and replace(key, oldVal, newVal)
        map.replace("orange", 300);
        map.replace("pear", 50, 55);
        System.out.println("after replace: " + map);

        // entrySet iteration (fastest way to iterate keys+values)
        System.out.println("Iterate entrySet:");
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // keySet and values views
        System.out.println("keys: " + map.keySet());
        System.out.println("values: " + map.values());
    }

    // -----------------------
    // 2) LinkedHashMap: preserves insertion order or access order; handy for LRU caches
    // -----------------------
    static void linkedHashMapDemo() {
        // LinkedHashMap default preserves insertion order
        LinkedHashMap<String, Integer> linked = new LinkedHashMap<>();
        linked.put("A", 1);
        linked.put("B", 2);
        linked.put("C", 3);
        System.out.println("insertion-order iteration: " + linked);

        // Access-order LinkedHashMap (useful for LRU caches)
        LinkedHashMap<String, Integer> lru = new LinkedHashMap<>(16, 0.75f, true);
        lru.put("A", 1);
        lru.put("B", 2);
        lru.put("C", 3);

        // access some entries to update order
        lru.get("A"); // now order B, C, A (A becomes most-recently accessed)
        lru.get("B");
        System.out.println("access-order iteration: " + lru);

        // Example: overriding removeEldestEntry to make a small LRU cache (max size 2)
        LinkedHashMap<String, Integer> lruCache = new LinkedHashMap<>(4, 0.75f, true) {
            private static final int MAX = 2;
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                // when size exceeds MAX, eldest entry is removed automatically
                return size() > MAX;
            }
        };

        lruCache.put("X", 100);
        lruCache.put("Y", 200);
        lruCache.put("Z", 300); // this will evict "X"
        System.out.println("LRU cache after 3 inserts (max 2): " + lruCache);
        lruCache.get("Y"); // access Y
        lruCache.put("W", 400); // will evict least recently used ("Z")
        System.out.println("LRU cache after more ops: " + lruCache);
    }

    // -----------------------
    // 3) TreeMap: sorted map (implements NavigableMap)
    // -----------------------
    static void treeMapDemo() {
        // TreeMap: keys are sorted (natural order or via Comparator), O(log n) operations
        TreeMap<String, Integer> tree = new TreeMap<>();
        tree.put("delta", 4);
        tree.put("alpha", 1);
        tree.put("charlie", 3);
        tree.put("bravo", 2);

        System.out.println("TreeMap (sorted by key): " + tree);

        // NavigableMap-specific operations
        System.out.println("firstKey: " + tree.firstKey());
        System.out.println("lastKey: " + tree.lastKey());
        System.out.println("lowerKey('charlie'): " + tree.lowerKey("charlie")); // greatest < key
        System.out.println("higherKey('charlie'): " + tree.higherKey("charlie")); // least > key

        // subMap/headMap/tailMap → useful for range queries
        System.out.println("subMap from 'alpha' (inclusive) to 'delta' (exclusive): " + tree.subMap("alpha", true, "delta", false));

        // descendingMap
        System.out.println("descendingMap view: " + tree.descendingMap());
    }

    // -----------------------
    // 4) Hashtable: legacy synchronized map (doesn't allow null keys/values)
    // -----------------------
    static void hashtableDemo() {
        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put("one", 1);
        ht.put("two", 2);
        // ht.put(null, 3); // throws NullPointerException - Hashtable does not allow nulls
        System.out.println("Hashtable contents: " + ht);

        // Synchronized semantics: methods of Hashtable are synchronized (coarse-grained)
        // Modern alternative: ConcurrentHashMap for scalable thread-safety
    }

    // -----------------------
    // 5) ConcurrentHashMap: thread-safe high-concurrency map
    // -----------------------
    static void concurrentHashMapDemo() {
        // ConcurrentHashMap: thread-safe, does NOT allow null keys/values
        ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<>();
        chm.put("k1", 10);
        chm.putIfAbsent("k2", 20);
        chm.computeIfAbsent("k3", k -> 30);

        // atomic compute methods are very useful in concurrent code:
        chm.merge("k1", 5, Integer::sum); // k1 becomes 15
        System.out.println("ConcurrentHashMap after merge: " + chm);

        // forEach with parallelismThreshold in JDK streams-like API (example, but we use simple forEach)
        chm.forEach((k, v) -> System.out.println("chm entry: " + k + " -> " + v));
    }

    // -----------------------
    // 6) WeakHashMap: keys are weakly referenced; when key is GC'd the entry disappears
    // -----------------------
    static void weakHashMapDemo() {
        Map<Object, String> weak = new WeakHashMap<>();
        Object key = new Object();           // strong reference
        Object key2 = new Object();

        weak.put(key, "value-for-key");
        weak.put(key2, "value-for-key2");
        System.out.println("weak before GC: " + weak);

        // remove strong reference to one key
        key = null;

        // request GC; entries with keys only referenced weakly can be removed
        System.gc();

        // Pause briefly to give GC a chance (not guaranteed); in real app GC is non-deterministic
        try { Thread.sleep(100); } catch (InterruptedException ignored) { }

        System.out.println("weak after GC (key may be collected): " + weak);
        // Note: you may still see both entries depending on GC; WeakHashMap shows the idea.
    }

    // -----------------------
    // 7) IdentityHashMap: keys compared by reference (==) not equals()
    // -----------------------
    static void identityMapDemo() {
        Map<String, String> idMap = new IdentityHashMap<>();
        String a = new String("hello");
        String b = new String("hello"); // different object, equals() true but reference different

        idMap.put(a, "value1");
        idMap.put(b, "value2");

        // Because IdentityHashMap uses reference equality, both entries exist
        System.out.println("IdentityHashMap size (expect 2): " + idMap.size() + ", entries: " + idMap);
    }

    // -----------------------
    // 8) Common bulk/utility methods used across Maps
    // -----------------------
    static void commonMapMethodsDemo() {
        Map<String, Integer> a = new HashMap<>();
        a.put("A", 1);
        a.put("B", 2);

        Map<String, Integer> b = new HashMap<>();
        b.put("B", 20);
        b.put("C", 3);

        // putAll -> copy all entries
        Map<String, Integer> copy = new HashMap<>(a);
        copy.putAll(b);
        System.out.println("putAll result: " + copy);

        // containsKey / containsValue
        System.out.println("containsKey B? " + copy.containsKey("B"));
        System.out.println("containsValue 3? " + copy.containsValue(3));

        // remove returns previous value
        Integer old = copy.remove("B");
        System.out.println("remove('B') returned: " + old + ", map now: " + copy);

        // replaceAll (applies a BiFunction to every entry)
        copy.replaceAll((k, v) -> v * 10);
        System.out.println("after replaceAll *10: " + copy);

        // computeIfPresent
        copy.computeIfPresent("C", (k, v) -> v + 100);
        System.out.println("after computeIfPresent on C: " + copy);

        // merge example (useful for counting or combining)
        Map<String, Integer> counts = new HashMap<>();
        counts.merge("apple", 1, Integer::sum);
        counts.merge("apple", 2, Integer::sum); // apple becomes 3
        System.out.println("merge-based counts: " + counts);

        // entrySet removeIf - remove entries while iterating safely
        copy.entrySet().removeIf(e -> e.getKey().equals("A"));
        System.out.println("after entrySet().removeIf(A): " + copy);
    }
}
