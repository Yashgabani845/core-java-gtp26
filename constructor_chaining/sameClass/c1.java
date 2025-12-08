package constructor_chaining.sameClass;

public class c1 {
    c1(int k){
        System.out.println(k);
    }

    c1(int j,int k){
        this(k);
        System.out.println(j);

    }

    c1(int i,int j,int k){
        this(j,k);
        System.out.println(i);

    }
    public static void main(String[] args) {
        c1 c = new c1(4,5,6);

    }
}
