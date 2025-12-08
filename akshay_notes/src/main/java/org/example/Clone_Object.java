package org.example;

public class Clone_Object {
    public static void main(String[] args) {
        System.out.println("calling without clone()...");
        withoutCloning();

        System.out.println("calling with clone()...");
        withCloning();
    }

    //shallow copy
    static void withCloning(){
        Book b1 = new Book();
        b1.bookName="f1";
        b1.price=25;

        Book b2=b1;

        b2.bookName="f2";

        System.out.println("b1.bookName:"+b1.bookName);

    }

    //deep copy
    static void withoutCloning(){
        Book b1 = new Book();
        b1.bookName="f1";
        b1.price=25;

        Book b2=b1.copy();

        b2.bookName="f2";

        System.out.println("b1.bookName:"+b1.bookName);

    }
}

class Book{
    public String bookName;
    public int price;
    public Book(){}
    public Book(String bookName, int price){
        this.bookName = bookName;
        this.price = price;

    }
    public Book copy(){
        return new Book(bookName, price);
    }
}


