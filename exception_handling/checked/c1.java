package exception_handling.checked;

// exception can be caught at compile time

class c{
    void print() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }
}
public class c1 {
    public static void main(String[] args) throws ClassNotFoundException{
         c obj = new c();
         obj.print();


//        try {
//            c obj = new c();
//            obj.print();
//        }catch (ClassNotFoundException e){
//            System.out.println("Handled checked exception");
//        }

        // compile time error handled and this will generate runtime error
        // if you don't want runtime error then catch it
    }
}
