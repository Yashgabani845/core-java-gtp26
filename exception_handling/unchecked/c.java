package exception_handling.unchecked;

public class c {

    // throw unchecked exception
    static void throwNullException(){
        try {
            String str = null;
            throw new NullPointerException();
        }finally {
            System.out.println("finally block from unhandled unchecked exception");
        }
    }

    // handle unchecked exception
    static void handleNullException(){
        try {
            String str = null;
            throw new NullPointerException();
        }catch (NullPointerException e) {
            System.out.println("handled null pointer exception");
        } finally{
            System.out.println("finally block from handled unchecked exception");
        }
    }

    public static void main(String[] args) {
        try{
            int a = 10;
            int b = 0;

            handleNullException();
            throwNullException();
            int c = a/b;

            // After an exception occurs inside a try block, the remaining statements
            // inside that try block are skipped,

            System.out.println("after exception occurs");

        }catch(ArithmeticException e){
            System.out.println("Divide by zero is not possible");
        }catch (NullPointerException e){
            System.out.println("Null pointer exception");
        }finally{
            System.out.println("This block will always going to be executed");
        }
    }
}
