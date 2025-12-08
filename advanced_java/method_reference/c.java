package advanced_java.method_reference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

class c1{
    int a = 10;
}

public class c {
    public static void print(int x){
        System.out.println(x);
    }

    public void printVal(int x){
        System.out.println(x);
    }

    public static void main(String[] args) {

        // 1. static method reference

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().forEach(c::print);

        System.out.println();

        // 2. instance method reference of a particular object
        c obj = new c();
        list.stream().forEach(obj::printVal);

        System.out.println();



        // Because Java automatically converts between wrapper and primitive types using a
        // feature called autoboxing/unboxing.
        // because have wrapper class and having int in parameter


        // 3. Constructor reference
        Supplier<c1> s = c1::new;
        c1 obj2 = s.get();
        System.out.println(obj2.a);


    }
}
