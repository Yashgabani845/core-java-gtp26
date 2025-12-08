package oops.abstraction;

abstract class Subject{
    int a = 10;
    Subject(){
         System.out.println("Learning Subject");
    }

    abstract void syllabus();

    final void learn(){
        System.out.println("Learning");
    }

    static void show(){
        System.out.println("show subject name");
    }

}

class Computer extends Subject{
    @Override
    void syllabus() {
        System.out.println("Computer Subject");
    }

    int b = 10;
}
public class study{
    public static void main(String[] args) {
        Computer c1 = new Computer();
        // if you create object like this Subject s1 = new Computer() then you won't be able to access b variable
        c1.syllabus();
        c1.a = 15;
        System.out.println(c1.b);
        Subject.show();

        // c1.show() also works fine

//        ✔ Static method called using object → allowed
//           But object is ignored
//
//        ✔ Static method is NOT polymorphic
//          It does NOT depend on object type
//          No runtime binding → only compile-time binding.
//
//        ❌ Static method cannot use this
//          There is no object, so this is invalid.

        c1.learn();
    }


}
