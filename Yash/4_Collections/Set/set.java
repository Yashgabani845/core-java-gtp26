import java.util.HashSet;
import java.util.Set;
import java.util.*;
public class set    {
    public static void main(String[] args) {
    Set <Integer> s = new HashSet<>();
        System.out.println("Set Elements: " + s);
        s.add(5);
        s.add(10);
        s.add(5);
        System.out.println(s);
        s.remove(5);
        System.out.println(s.contains(10));

    }
}