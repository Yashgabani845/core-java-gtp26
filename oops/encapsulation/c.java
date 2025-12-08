package oops.encapsulation;

class b{
    private int a = 10;
    protected int b = 12;

    public int c = 14;

    int d = 34;
}
public class c extends b{
    public static void main(String[] args) {

        c obj = new c();

        System.out.println(obj.b);
        System.out.println(obj.c);
        System.out.println(obj.d);
    }

}
