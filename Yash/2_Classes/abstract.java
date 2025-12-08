public class Classes {
    public static void main(String[] args) {
        Parent p = new Child("Yash");
        p.print();
        p.normal();
    }
}
abstract  class Parent{
    String name ;
    public Parent(String name){
        this.name = name;
    }
    abstract void print();
    void normal(){
        System.out.println("normal method");
    }
}

class Child extends Parent{

    public Child(String name ){
    super(name);
    }
    void print(){
        System.out.print("inside child class " );
        System.out.println(name);
    }
}

