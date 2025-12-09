import java.io.*;
interface  Add{
    int add(int a , int b);
    default void display (int a , int b){
        System.out.println(a);
        System.out.println(b);
    }
}
interface  Sub{
    int sub(int a , int b);
}
class   Cal implements Add ,Sub {

    public int add(int a,int b){
        return a+b;
    }
    public int sub(int a,int b){
        return a-b;
    }
    public void print(int a , int b){
        display(a,b);
    }
}

public class Multiple_Inheritance {
    public static void main(String[] args) {
        Cal x = new Cal();
       x.print(5,10);
        System.out.println("Addition : " + x.add(2,1));
        System.out.println("Substraction : " + x.sub(2,1));
    }
}