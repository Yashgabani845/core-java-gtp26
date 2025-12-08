package multiple_main_method.same_class;

public class C1 {
    public static void main(String[] args) {
        System.out.println("From 1st");

        main(new int[]{1, 2, 3});
        main("hello");
    }

    public static void main(int[] args) {
        System.out.println("From 2nd");
    }

    public static void main(String args) {
        System.out.println("From 3rd");

    }

    // exact match will run automatically

    // duplicate method will give error
}
