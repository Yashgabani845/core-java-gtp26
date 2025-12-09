import java.util.HashMap;

public class map {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("Apple", 100);
        map.put("Banana", 40);
        map.put("Mango", 80);

        System.out.println("Price of Mango: " + map.get("Mango"));

        map.remove("Banana");

        System.out.println(map);
    }
}
