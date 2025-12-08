import java.util.*;
public class list {

    public static void main(String[] args) {
List<String> li = new ArrayList<>();

li.add("Yash");
li.set(0 , "Gabani");
        String name = li.get(0);
        System.out.println(li);
        li.remove(0);
    }
}