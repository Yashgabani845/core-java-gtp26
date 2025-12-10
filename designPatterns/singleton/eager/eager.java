package designPatterns.singleton.eager;

class Singleton implements Cloneable{
    private static Singleton s = new Singleton();

    private Singleton(){
        System.out.println("Constructor called");
    }

    public static Singleton getInstance(){
        return s;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        return s;
    }
}

public class eager {
    public static void main(String[] args) throws CloneNotSupportedException {

        // thread safe because object created during class loading
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1.hashCode()==s2.hashCode());
        System.out.println(s1==s2);

        // if you do clone then Singleton pattern will break
        Singleton s3 = (Singleton) s1.clone();

        System.out.println(s1.hashCode()==s3.hashCode());
        System.out.println(s1==s3);

        // that's why need to return existing object instead of calling super.clone()

    }
}
